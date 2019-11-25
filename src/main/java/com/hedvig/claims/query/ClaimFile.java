package com.hedvig.claims.query;

import java.time.Instant;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import org.springframework.lang.Nullable;

@Entity
@Data
@Table(name = "claim_file")
public class ClaimFile {
  @Id
  private UUID id;

  private String fileName;

  private String contentType;

  private Instant uploadedAt;

  private String bucket;

  private String key;

  private Boolean markedAsDeleted = false;

  @Nullable
  private String markedAsDeletedBy;

  @Nullable
  private Instant markedAsDeletedAt;

  @Nullable
  private String category;
}
