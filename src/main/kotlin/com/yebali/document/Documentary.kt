package com.yebali.document

import com.yebali.document.jms.JmsListenerData

interface Documentary {
    val jmsListenerData: List<JmsListenerData>

    fun document()
}
