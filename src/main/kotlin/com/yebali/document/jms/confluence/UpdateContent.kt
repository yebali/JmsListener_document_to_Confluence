package com.yebali.document.jms.confluence

import com.mashape.unirest.http.Unirest
import com.yebali.document.jms.confluence.ConfluenceBasicAuthRESTAPI.Companion.BASIC_AUTH_REQUEST_URI
import com.yebali.document.jms.confluence.ConfluenceBasicAuthRESTAPI.Companion.BASIC_AUTH_TOKEN
import com.yebali.document.jms.confluence.dto.ConfluenceContent

class UpdateContent(
    override val contentId: String,
) : ConfluenceBasicAuthRESTAPI {
    fun request(body: String) {
        Unirest.put("$BASIC_AUTH_REQUEST_URI/$contentId")
            .header("Accept", "application/json")
            .header("Content-type", "application/json")
            .header("Authorization", "Basic $BASIC_AUTH_TOKEN")
            .body(body)
            .asJson()
    }

    data class RequestBody(
        val version: Version,
        val type: String,
        val title: String,
        val body: Body,
    ) {
        companion object {
            fun createRequestBody(content: ConfluenceContent, body: String): RequestBody {
                return RequestBody(
                    version = Version(
                        number = content.version.number + 1,
                    ),
                    type = content.type,
                    title = content.title,
                    body = Body(
                        storage = Storage(
                            value = body,
                        ),
                    ),
                )
            }
        }
    }

    data class Version(
        val number: Int,
    )

    data class Body(
        val storage: Storage
    )

    data class Storage(
        val value: String, // content 내용
        val representation: String = "storage" // API spec에 고정된 값
    )
}
