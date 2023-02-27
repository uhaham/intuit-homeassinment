package com.example.homeassignment.dataingestion.service;

import com.example.homeassignment.common.data.crm.CrmTickets;
import com.example.homeassignment.dataingestion.consumer.CrmConsumer;
import com.example.homeassignment.datalayer.DataService;
import org.springframework.stereotype.Component;

@Component
public class DataIngestionImpl implements DataIngestion {
  private final CrmConsumer crmConsumer;
  private final DataService dataService;

  public DataIngestionImpl(final CrmConsumer crmConsumer, final DataService dataService) {
    this.crmConsumer = crmConsumer;
    this.dataService = dataService;
  }

  /**
   * Starting point for ingestion process. If source system is valid,
   * get CRM delta by source system and save it to storage
   * @param sourceSystem - source system
   */
  @Override
  public void Ingest(final String sourceSystem) {
    if (sourceSystems.contains(sourceSystem)) {
      final CrmTickets crmTickets = crmConsumer.getCrmTickets(sourceSystem);
      dataService.upsert(crmTickets);
    } else {
      throw new IllegalArgumentException(String.format("Source system \"%s\" not configured", sourceSystem));
    }
  }
}
