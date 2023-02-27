package com.example.homeassignment.application.service;

import com.example.homeassignment.common.data.crm.CrmTicketStatus;
import com.example.homeassignment.common.data.response.Provider;
import com.example.homeassignment.common.data.response.SupportCasesAggregation;
import com.example.homeassignment.datalayer.DataService;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.when;

class ServingServiceImplTest {

  private static final String OPEN = "Open";
  private static final String NOT_OPENED = "NotOpen";
  private static final String PROVIDER_NAME = "my favorite provider";
  private static final Long PROVIDER_ID = 123L;
  private static final Integer ERROR_CODE_1 = 100;
  private static final Integer ERROR_CODE_2 = 200;
  private static final SupportCasesAggregation LINE1 = SupportCasesAggregation.builder()
      .numberOfCases(3)
      .errorCode(ERROR_CODE_1)
      .provider(Provider.builder().id(PROVIDER_ID).name(PROVIDER_NAME).build())
      .products(List.of("Red", "Green"))
      .supportCases(List.of(1L, 2L, 3L))
      .build();
  private static final SupportCasesAggregation LINE2 = SupportCasesAggregation.builder()
      .numberOfCases(2)
      .errorCode(ERROR_CODE_2)
      .provider(Provider.builder().id(PROVIDER_ID).name(PROVIDER_NAME).build())
      .products(List.of("Yellow"))
      .supportCases(List.of(4L, 5L))
      .build();


  private final ProviderService providerService;

  private final DataService dataService;

  private final ServingService service;

  ServingServiceImplTest() {
    this.providerService = Mockito.mock(ProviderService.class);
    when(providerService.getProviderIdByName(PROVIDER_NAME)).thenReturn(PROVIDER_ID);
    when(providerService.getProviderIdByName(null)).thenReturn(null);
    this.dataService = Mockito.mock(DataService.class);
    when(dataService.getAggregation(PROVIDER_ID, ERROR_CODE_1, CrmTicketStatus.open)).thenReturn(List.of(LINE1));
    when(dataService.getAggregation(null, null, null)).thenReturn(List.of(LINE1, LINE2));
    this.service = new ServingServiceImpl(providerService, dataService);
  }

  @Test
  void getAggregationWithFilter() {
    final List<SupportCasesAggregation> result = service.getAggregation(PROVIDER_NAME, ERROR_CODE_1, OPEN);
    assertEquals(List.of(LINE1), result);
  }

  @Test
  void getAggregationNoFilter() {
    final List<SupportCasesAggregation> result = service.getAggregation(null, null, null);
    assertEquals(List.of(LINE1, LINE2), result);
  }

  @Test
  void getAggregationStatusNotCorrect() {
    final IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
        ()-> service.getAggregation(PROVIDER_NAME, ERROR_CODE_1, NOT_OPENED));
    assertTrue(exception.getMessage().startsWith("No enum constant"));
    assertTrue(exception.getMessage().endsWith(NOT_OPENED.toLowerCase()));
  }

}