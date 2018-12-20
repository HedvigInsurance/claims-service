package com.hedvig.claims.events.upcast;

import com.hedvig.claims.events.ClaimCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.serialization.SimpleSerializedType;
import org.axonframework.serialization.upcasting.event.IntermediateEventRepresentation;
import org.axonframework.serialization.upcasting.event.SingleEventUpcaster;
import org.dom4j.Element;

import java.time.LocalDateTime;

import static com.hedvig.claims.util.TzHelper.UTC;

@Slf4j
public class ClaimCreatedEvent_v1 extends SingleEventUpcaster {

  private static SimpleSerializedType targetType = new SimpleSerializedType(ClaimCreatedEvent.class.getTypeName(), null);

  @Override
  protected boolean canUpcast(IntermediateEventRepresentation intermediateRepresentation) {
    return intermediateRepresentation.getType().equals(targetType);
  }

  @Override
  protected IntermediateEventRepresentation doUpcast(IntermediateEventRepresentation intermediateRepresentation) {
    return intermediateRepresentation.upcastPayload(
      new SimpleSerializedType(targetType.getName(), "1.0"),
      org.dom4j.Document.class,
      document -> {
        final Element rootElement = document.getRootElement();

        final Element regDate = rootElement.element("registrationDate");

        if (regDate.getText() != null && !regDate.getText().isEmpty()){
          LocalDateTime date = LocalDateTime.parse(regDate.getText());
          regDate.setText(date.atZone(UTC).toInstant().toString());
        }

        return document;
      }
    );
  }
}
