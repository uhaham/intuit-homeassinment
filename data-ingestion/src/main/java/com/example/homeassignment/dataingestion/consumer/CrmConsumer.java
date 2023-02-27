package com.example.homeassignment.dataingestion.consumer;

import com.example.homeassignment.common.data.crm.CrmTickets;

public interface CrmConsumer {
  CrmTickets getCrmTickets(String sourceSystem);
}
