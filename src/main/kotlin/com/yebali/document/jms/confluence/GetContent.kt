package com.yebali.document.jms.confluence

import com.mashape.unirest.http.HttpResponse
import com.mashape.unirest.http.JsonNode
import com.mashape.unirest.http.Unirest
import com.yebali.document.jms.confluence.ConfluenceBasicAuthRESTAPI.Companion.BASIC_AUTH_REQUEST_URI
import com.yebali.document.jms.confluence.ConfluenceBasicAuthRESTAPI.Companion.BASIC_AUTH_TOKEN

class GetContent(
    override val contentId: String,
) : ConfluenceBasicAuthRESTAPI {
    fun request(): HttpResponse<JsonNode> {
        return Unirest.get("$BASIC_AUTH_REQUEST_URI/$contentId?expand=body.storage,version")
            .header("Accept", "application/json")
            .header("Authorization", "Basic $BASIC_AUTH_TOKEN")
            .asJson()
    }
}
