package com.example.homeassignment.crm;

import com.example.homeassignment.common.data.crm.CrmTicket;
import com.example.homeassignment.common.data.crm.CrmTicketStatus;
import com.example.homeassignment.common.data.crm.CrmTickets;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("homeassignment")
public class CrmController {

  @GetMapping("/banana")
  public CrmTickets banana() {
    return CrmTickets.builder()
        .data(List.of(CrmTicket.builder()
                .caseId(1L)
                .customerId(818591L)
                .providerId(6111L)
                .cratedErrorCode(324)
                .status(CrmTicketStatus.open)
                .created(LocalDateTime.parse("2019-03-14T16:30:00"))
                .lastModified(LocalDateTime.parse("2019-03-17T03:41:00"))
                .productName("BLUE")
                .build(),
            CrmTicket.builder()
                .caseId(2L)
                .customerId(790521L)
                .providerId(26241L)
                .cratedErrorCode(0)
                .status(CrmTicketStatus.closed)
                .created(LocalDateTime.parse("2019-03-04T09:30:00"))
                .lastModified(LocalDateTime.parse("2019-03-05T02:47:00"))
                .productName("BLUE")
                .build(),
            CrmTicket.builder()
                .caseId(3L)
                .customerId(738081L)
                .providerId(1211L)
                .cratedErrorCode(101)
                .status(CrmTicketStatus.closed)
                .created(LocalDateTime.parse("2019-02-05T00:30:00"))
                .lastModified(LocalDateTime.parse("2019-02-10T01:52:00"))
                .productName("BLUE")
                .build()))
        .build();
  }

  @GetMapping("/strawberry")
  public CrmTickets strawberry() {
    return CrmTickets.builder()
        .data(
            List.of(CrmTicket.builder()
                    .caseId(1L)
                    .customerId(818591L)
                    .providerId(10001121L)
                    .cratedErrorCode(101)
                    .status(CrmTicketStatus.closed)
                    .created(LocalDateTime.parse("2019-04-01T17:25:00"))
                    .lastModified(LocalDateTime.parse("2019-04-02T08:00:00"))
                    .productName("RED")
                    .build(),
                CrmTicket.builder()
                    .caseId(2L)
                    .customerId(790521L)
                    .providerId(11196L)
                    .cratedErrorCode(108)
                    .status(CrmTicketStatus.open)
                    .created(LocalDateTime.parse("2019-03-22T14:33:00"))
                    .lastModified(LocalDateTime.parse("2019-03-23T23:00:00"))
                    .productName("GREEN")
                    .build(),
                CrmTicket.builder()
                    .caseId(3L)
                    .customerId(738081L)
                    .providerId(6111L)
                    .cratedErrorCode(324)
                    .status(CrmTicketStatus.open)
                    .created(LocalDateTime.parse("2019-03-14T16:30:00"))
                    .lastModified(LocalDateTime.parse("2019-03-17T03:41:00"))
                    .productName("ORANGE")
                    .build(),
                CrmTicket.builder()
                    .caseId(4L)
                    .customerId(729841L)
                    .providerId(11181L)
                    .cratedErrorCode(122)
                    .status(CrmTicketStatus.closed)
                    .created(LocalDateTime.parse("2019-02-05T17:32:00"))
                    .lastModified(LocalDateTime.parse("2019-02-06T01:06:00"))
                    .productName("GREEN")
                    .build()))
        .build();
  }
}