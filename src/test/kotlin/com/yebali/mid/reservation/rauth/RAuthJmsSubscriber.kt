package com.yebali.mid.reservation.rauth

import com.yebali.mid.reservation.CONSUMER
import com.yebali.mid.reservation.VIRTUAL_TOPIC
import org.springframework.jms.annotation.JmsListener
import javax.jms.Message

class RAuthJmsSubscriber {
    @JmsListener(destination = "$CONSUMER.\${service-name}.$VIRTUAL_TOPIC.GLOBALAWS.RAUTH_CREATED")
    fun receiveRAuthCreatedEvent(jmsMessage: Message) {
    }

    @JmsListener(destination = "$CONSUMER.\${service-name}.$VIRTUAL_TOPIC.GLOBALAWS.RAUTH_DELETED")
    fun receiveRauthDeletedEvent(jmsMessage: Message) {
    }

    @JmsListener(destination = "$CONSUMER.\${service-name}.$VIRTUAL_TOPIC.GLOBALAWS.RAUTH_MOVE_OUT")
    fun receiveRauthMoveOutEvent(jmsMessage: Message) {
    }
}
