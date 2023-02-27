package com.example.homeassignment.dataingestion.consumer;

import com.example.homeassignment.common.data.crm.CrmTickets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CrmConsumerImpl implements CrmConsumer {

  private static final String baseUrl = "http://localhost:8080/homeassinment/";
  private final RestTemplate restTemplate;

  @Autowired
  public CrmConsumerImpl(final RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @Override
  public CrmTickets getCrmTickets(String sourceSystem) {
      return restTemplate.getForObject(baseUrl + sourceSystem, CrmTickets.class);
  }

}
