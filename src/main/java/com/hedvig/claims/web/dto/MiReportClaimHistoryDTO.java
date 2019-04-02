package com.hedvig.claims.web.dto;

import com.hedvig.claims.query.ClaimReportHistoryEntity;
import lombok.Value;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Value
public class MiReportClaimHistoryDTO {
  private UUID historyId;
  private String claimId;
  private String memberId;
  private BigDecimal grossPaid;
  private BigDecimal reserved;
  private LocalDate dateOfLoss;
  private String claimStatus;
  private Instant timeOfKnowledge;

  public static MiReportClaimHistoryDTO from(ClaimReportHistoryEntity e) {
    return new MiReportClaimHistoryDTO(
      e.getClaimHistoryId(),
      e.getClaimId(),
      e.getMemberId(),
      e.getGrossPaid(),
      e.getReserved(),
      e.getDateOfLoss(),
      e.getClaimStatus(),
      e.getTimeOfKnowledge());
  }
}
