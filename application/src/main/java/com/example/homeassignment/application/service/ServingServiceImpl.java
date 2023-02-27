package com.example.homeassignment.application.service;

import com.example.homeassignment.common.data.crm.CrmTicket;
import com.example.homeassignment.common.data.crm.CrmTicketStatus;
import com.example.homeassignment.common.data.response.SupportCasesAggregation;
import com.example.homeassignment.datalayer.DataService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServingServiceImpl implements ServingService {
  private final ProviderService providerService;
  private final DataService dataService;

  public ServingServiceImpl(final ProviderService providerService, final DataService dataService) {
    this.providerService = providerService;
    this.dataService = dataService;
  }

  /**
   * Retrieve aggregation about support cases based on optional filters
   * Aggregation are done by error code, provider name.
   * in addition we represent distinct affected product list and number of support cases.
   * If optional parameters exist we use them as a filter.
   * @param providerName - provider name (optional filter)
   * @param errorCode - error code (optional filter)
   * @param status - Open / closed (optional filter)
   * @return list of SupportCasesAggregation
   */
  @Override
  public List<SupportCasesAggregation> getAggregation(final String providerName, final Integer errorCode, final String status) {
    final CrmTicketStatus crmTicketStatus = status != null ? CrmTicketStatus.valueOf(status.toLowerCase()) : null;
    final Long providerId = providerService.getProviderIdByName(providerName);
    return dataService.getAggregation(providerId, errorCode, crmTicketStatus);
  }

  /**
   * Retrieve Crm tickets by ids.
   * @param caseIds - List of ids
   * @return List of CrmTicket
   */
  @Override
  public List<CrmTicket> getCrmTickets(final List<Long> caseIds) {
    return dataService.getCrmTickets(caseIds);
  }

}
