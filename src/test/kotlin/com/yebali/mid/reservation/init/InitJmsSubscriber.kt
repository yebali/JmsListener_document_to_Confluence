package com.yebali.mid.reservation.init

import com.yebali.mid.reservation.CONSUMER
import com.yebali.mid.reservation.VIRTUAL_TOPIC
import org.springframework.jms.annotation.JmsListener
import javax.jms.Message

class InitJmsSubscriber {
    @JmsListener(destination = "$CONSUMER.\${service-name}.$VIRTUAL_TOPIC.GLOBALAWS.INITIALIZE_SHADOW_DEVICE")
    fun initializeDeviceShadow(jmsMessage: Message) {
    }

    @JmsListener(destination = "$CONSUMER.\${service-name}.$VIRTUAL_TOPIC.GLOBALAWS.INITIALIZE_SHADOW_ACCESS_CONTROL")
    fun initializeAccessControlShadow(jmsMessage: Message) {
    }

    @JmsListener(destination = "$CONSUMER.\${service-name}.$VIRTUAL_TOPIC.GLOBALAWS.RAUTH_INIT")
    fun initializeRauth(jmsMessage: Message) {
    }

    @JmsListener(destination = "$CONSUMER.\${service-name}.$VIRTUAL_TOPIC.GLOBALAWS.INITIALIZE_FACILITY")
    fun initializeFacility(jmsMessage: Message) {
    }

    @JmsListener(destination = "$CONSUMER.\${service-name}.$VIRTUAL_TOPIC.GLOBALAWS.INITIALIZE_TARGET")
    fun initializeTarget(jmsMessage: Message) {
    }
}
