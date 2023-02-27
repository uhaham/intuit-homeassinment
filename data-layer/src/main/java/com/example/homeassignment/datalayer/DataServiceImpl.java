package com.example.homeassignment.datalayer;

import com.example.homeassignment.common.data.crm.CrmTicket;
import com.example.homeassignment.common.data.crm.CrmTicketStatus;
import com.example.homeassignment.common.data.crm.CrmTickets;
import com.example.homeassignment.common.data.response.SupportCasesAggregation;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataServiceImpl implements DataService {

  @Override
  public void upsert(final CrmTickets crmTickets) {
    // TODO implement
  }

  @Override
  public List<SupportCasesAggregation> getAggregation(final Long providerId, final Integer errorCode, final CrmTicketStatus crmTicketStatus) {
    // TODO implement
    return null;
  }

  @Override
  public List<CrmTicket> getCrmTickets(final List<Long> caseIds) {
    // TODO implement
    return null;
  }

}
