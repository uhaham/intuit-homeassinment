package com.example.homeassignment.dataingestion.controller;

import com.example.homeassignment.dataingestion.service.DataIngestion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("homeassignment")
public class IngestController {

  private final DataIngestion dataIngestion;

  public IngestController(final DataIngestion dataIngestion) {
    this.dataIngestion = dataIngestion;
  }

  @GetMapping("/ingest")
  public void ingest(@PathVariable String sourceSystem) {
    dataIngestion.Ingest(sourceSystem);
  }

}