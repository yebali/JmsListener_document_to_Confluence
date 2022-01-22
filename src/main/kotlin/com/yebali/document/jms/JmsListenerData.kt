package com.yebali.document.jms

data class JmsListenerData(
    val serviceName: String,
    val methodName: String,
    val paramTypes: List<String>,
    val subscribingEventName: String,
)
