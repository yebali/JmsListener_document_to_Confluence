package com.yebali.document.jms.confluence

interface ConfluenceBasicAuthRESTAPI {
    val contentId: String

    companion object {
        /**
         *  Confluence BASIC_TOKEN
         *  BASIC_TOKEN = Base64.encode(ATLASSIAN_ACCOUNT + ":" + API_TOKEN).
         */
        const val BASIC_AUTH_TOKEN = ""
        const val BASIC_AUTH_REQUEST_URI = "https://htbeyond.atlassian.net/wiki/rest/api/content"
    }
}
