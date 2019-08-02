package com.hedvig.claims.serviceIntegration.ticketService.dto;

import com.hedvig.claims.serviceIntegration.ticketService.TicketStatus;
import com.hedvig.claims.serviceIntegration.ticketService.TicketType;
import lombok.Value;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.time.LocalTime;



@Value
public class TicketDto {
  private String memberId;
  private String createdBy;
  private String assignedTo;
  private String referenceId;
  @Min(0)
  @Max(1)
  private Float priority;
  private TicketType type;
  private LocalDate remindNotificationDate;
  private LocalTime remindNotificationTime;
  private String remindMessage;
  private String description;
  private TicketStatus status;
}
