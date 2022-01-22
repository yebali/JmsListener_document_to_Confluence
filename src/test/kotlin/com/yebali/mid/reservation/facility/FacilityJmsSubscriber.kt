package com.yebali.mid.reservation.facility

import com.yebali.mid.reservation.CONSUMER
import com.yebali.mid.reservation.VIRTUAL_TOPIC
import org.springframework.jms.annotation.JmsListener

class FacilityJmsSubscriber {
    @JmsListener(destination = "$CONSUMER.\${service-name}.$VIRTUAL_TOPIC.GLOBALAWS.FACILITY_CREATED")
    fun receiveFacilityCreatedEvent(message: String) {
    }

    @JmsListener(destination = "$CONSUMER.\${service-name}.$VIRTUAL_TOPIC.GLOBALAWS.FACILITY_UPDATED")
    fun receiveFacilityUpdatedEvent(message: String) {
    }

    @JmsListener(destination = "$CONSUMER.\${service-name}.$VIRTUAL_TOPIC.GLOBALAWS.FACILITY_DELETED")
    fun receiveFacilitiesDeletedEvent(message: String) {
    }
}
