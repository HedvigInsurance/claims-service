package com.hedvig.claims.web.dto;

import java.time.LocalDateTime;

public class PaymentDTO extends HedvigBackofficeDTO {

  public Double amount;
  public String note;
  public LocalDateTime payoutDate;
  public Boolean exGratia;
  public PaymentType type;
  public String handlerReference;

  public PaymentDTO(
    String paymentId,
    String claimsId,
    LocalDateTime registrationDate,
    String userId,
    Double amount,
    String note,
    LocalDateTime payoutDate,
    Boolean exGratia,
    PaymentType type,
    String handlerReference) {
    this.id = paymentId;
    this.claimID = claimsId;
    this.date = registrationDate;
    this.userId = userId;
    this.amount = amount;
    this.note = note;
    this.payoutDate = payoutDate;
    this.exGratia = exGratia;
    this.type = type;
    this.handlerReference = handlerReference;
  }
}
