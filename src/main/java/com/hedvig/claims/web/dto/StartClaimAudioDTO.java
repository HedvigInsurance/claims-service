package com.hedvig.claims.web.dto;

import java.time.LocalDateTime;
import lombok.Value;

@Value
public class StartClaimAudioDTO {

  String userId;
  LocalDateTime registrationDate;
  String audioURL;
}
