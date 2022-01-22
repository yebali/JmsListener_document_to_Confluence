package com.yebali.document.util

import com.fasterxml.jackson.databind.ObjectMapper

class JacksonCompanionObject {
    companion object {
        private val jacksonObjectMapper = ObjectMapper()

        fun getObjectMapper(): ObjectMapper {
            return jacksonObjectMapper
        }
    }
}
