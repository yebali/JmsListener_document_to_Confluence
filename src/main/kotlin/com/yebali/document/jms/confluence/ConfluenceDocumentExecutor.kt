package com.yebali.document.jms.confluence

import com.yebali.document.Documentary
import com.yebali.document.jms.JmsListenerData
import com.yebali.document.jms.confluence.UpdateContent.RequestBody
import com.yebali.document.jms.confluence.dto.ConfluenceContent
import com.yebali.document.util.JacksonCompanionObject

class ConfluenceDocumentExecutor(
    private val contentId: String,
    override val jmsListenerData: List<JmsListenerData>,
) : Documentary {

    private val objectMapper = JacksonCompanionObject.getObjectMapper()

    override fun document() {
        val existingContent = getContent()
        val requestBodyString = createRequestBody(existingContent)
        updateContent(requestBodyString)
    }

    private fun getContent(): ConfluenceContent {
        val getContent = GetContent(contentId)
        val httpResponse = getContent.request()

        return objectMapper.readValue(httpResponse.body.toString(), ConfluenceContent::class.java)
    }

    private fun updateContent(requestBodyString: String) {
        val updateContent = UpdateContent(contentId)
        updateContent.request(requestBodyString)
    }

    private fun createRequestBody(content: ConfluenceContent): String {
        val existingContentBody = content.body.storage.value
        val existingListenerDocuments = existingContentBody
            .replace("<p />", "")
            .split("<hr />")

        val exceptThisServerListenerDocument = existingListenerDocuments.filter {
            !it.contains(jmsListenerData.first().serviceName) && it.isNotEmpty()
        }

        val thisServerListenerDocument = createContentBody()
        val otherServerListenerDocuments = exceptThisServerListenerDocument.joinToString("<hr/>")

        val requestString =
            if (thisServerListenerDocument.isEmpty())
                otherServerListenerDocuments
            else
                "$thisServerListenerDocument<hr/>$otherServerListenerDocuments"

        val body = RequestBody.createRequestBody(content, requestString)
        return objectMapper.writeValueAsString(body)
    }

    private fun createContentBody(): String {
        if (jmsListenerData.isEmpty())
            return ""

        val htmlGenerator = HTMLGenerator()

        htmlGenerator.putH1("서비스 : " + jmsListenerData.first().serviceName)
        htmlGenerator.putH3("구독중인 이벤트")

        jmsListenerData.forEach {
            htmlGenerator.putH4(it.subscribingEventName)
            htmlGenerator.putLi("Method : ${it.methodName}")
            htmlGenerator.putLi("Params : ${it.paramTypes.joinToString(", ")}")
        }

        return htmlGenerator.context
    }
}
