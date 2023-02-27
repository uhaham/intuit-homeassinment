package com.example.homeassignment.application.service;

import com.example.homeassignment.common.data.crm.CrmTicket;
import com.example.homeassignment.common.data.response.SupportCasesAggregation;

import java.util.List;

public interface ServingService {
  List<SupportCasesAggregation> getAggregation(final String providerName, final Integer errorCode, final String status);
  List<CrmTicket> getCrmTickets(List<Long> caseIds);
}
