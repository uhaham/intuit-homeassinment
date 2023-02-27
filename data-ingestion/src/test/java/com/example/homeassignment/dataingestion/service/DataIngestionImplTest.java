package com.example.homeassignment.dataingestion.service;

import com.example.homeassignment.common.data.crm.CrmTickets;
import com.example.homeassignment.dataingestion.consumer.CrmConsumer;
import com.example.homeassignment.datalayer.DataService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class DataIngestionImplTest {

  private static final String VALID_SOURCE_SYSTEM = "banana";
  private static final String INVALID_SOURCE_SYSTEM = "invalid source";

  private final CrmTickets crmTickets;
  private final CrmConsumer crmConsumer;
  private final DataService dataService;
  private final DataIngestion dataIngestion;

  DataIngestionImplTest() {
    crmTickets = Mockito.mock(CrmTickets.class);
    crmConsumer = Mockito.mock(CrmConsumer.class);
    when(crmConsumer.getCrmTickets(VALID_SOURCE_SYSTEM)).thenReturn(crmTickets);
    dataService = Mockito.mock(DataService.class);
    dataIngestion = new DataIngestionImpl(crmConsumer, dataService);
  }

  @Test
  void ingestValidInput() {
    dataIngestion.Ingest(VALID_SOURCE_SYSTEM);
    verify(crmConsumer, times(1)).getCrmTickets(VALID_SOURCE_SYSTEM);
    verify(dataService, times(1)).upsert(crmTickets);
  }

  @Test
  void ingestInvalidInput() {
    final IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
        () -> dataIngestion.Ingest(INVALID_SOURCE_SYSTEM));
    assertEquals("Source system \"invalid source\" not configured", exception.getMessage());
  }
}