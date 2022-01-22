package com.yebali.document.jms.confluence.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class ConfluenceContent(
    val id: String,
    val type: String,
    val title: String,
    val version: Version,
    val body: Body,
) {
    constructor() : this(
        id = "",
        type = "",
        title = "",
        version = Version(),
        body = Body(),
    )

    @JsonIgnoreProperties(ignoreUnknown = true)
    data class Version(
        val number: Int,
    ) {
        constructor() : this(
            number = 0
        )
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    data class Body(
        val storage: Storage,
    ) {
        constructor() : this(
            storage = Storage(),
        )
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    data class Storage(
        val value: String,
    ) {
        constructor() : this(
            value = "",
        )
    }
}
