package com.hedvig.claims.events.upcast

import com.hedvig.claims.events.ClaimFileUploadedEvent
import com.hedvig.claims.query.UploadSource
import org.axonframework.serialization.SimpleSerializedType
import org.axonframework.serialization.upcasting.event.IntermediateEventRepresentation
import org.axonframework.serialization.upcasting.event.SingleEventUpcaster

class ClaimFileUploadedEventUpcaster_v1 : SingleEventUpcaster() {

    override fun canUpcast(intermediateRepresentation: IntermediateEventRepresentation): Boolean {
        return intermediateRepresentation.type == targetType
    }

    override fun doUpcast(intermediateRepresentation: IntermediateEventRepresentation): IntermediateEventRepresentation {

        return intermediateRepresentation.upcastPayload(
            outputType,
            org.dom4j.Document::class.java
        ) { document ->
            val rootElement = document.rootElement
            rootElement.addElement("uploadSource").text = UploadSource.MANUAL.name
            document
        }
    }

    companion object {
        private val targetType = SimpleSerializedType(
            ClaimFileUploadedEvent::class.java.typeName, null
        )

        private val outputType = SimpleSerializedType(
            ClaimFileUploadedEvent::class.java.typeName, "1.0"
        )
    }
}
