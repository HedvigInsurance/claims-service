package com.hedvig.claims.events;

import lombok.Value;
import org.apache.tomcat.jni.Local;
import org.axonframework.commandhandling.model.AggregateIdentifier;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Value
public class ClaimCreatedEvent {

	@AggregateIdentifier
    private String id;
	private String userId;
    private LocalDateTime registrationDate;
    private String audioURL;

}