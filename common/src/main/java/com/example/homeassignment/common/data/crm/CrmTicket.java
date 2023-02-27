package com.example.homeassignment.common.data.crm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CrmTicket {
  Long caseId;

  Long customerId;

  Long providerId;

  Integer cratedErrorCode;

  CrmTicketStatus status;

  LocalDateTime created;

  LocalDateTime lastModified;

  String productName;
}

