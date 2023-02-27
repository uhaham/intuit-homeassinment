package com.example.homeassignment.datalayer;

import com.example.homeassignment.common.data.crm.CrmTicket;
import com.example.homeassignment.common.data.crm.CrmTicketStatus;
import com.example.homeassignment.common.data.crm.CrmTickets;
import com.example.homeassignment.common.data.response.SupportCasesAggregation;

import java.util.List;

public interface DataService {
  void upsert(CrmTickets crmTickets);

  List<SupportCasesAggregation> getAggregation(Long providerId, Integer errorCode, CrmTicketStatus crmTicketStatus);

  List<CrmTicket> getCrmTickets(List<Long> caseIds);
}
