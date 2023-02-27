package com.example.homeassignment.application.controller;

import com.example.homeassignment.application.service.ServingService;
import com.example.homeassignment.common.data.crm.CrmTicket;
import com.example.homeassignment.common.data.response.SupportCasesAggregation;
import com.example.homeassignment.dataingestion.service.DataIngestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("homeassignment/ticket")
public class RetrivalController {

  private final ServingService service;

  @Autowired
  public RetrivalController(final ServingService service) {
    this.service = service;
  }

  @GetMapping("/aggregation")
  public List<SupportCasesAggregation> aggregation(
      @PathVariable String providerName,
      @PathVariable Integer errorCode,
      @PathVariable String Status) {
    return service.getAggregation(providerName, errorCode, Status);
  }

  @PostMapping("/get-support-cases")
  public List<CrmTicket> aggregation(
      final List<Long> caseIds) {
    return service.getCrmTickets(caseIds);
  }

}