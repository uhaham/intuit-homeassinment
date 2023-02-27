package com.example.homeassignment.dataingestion.service;

import java.util.Set;

public interface DataIngestion {
  Set<String> sourceSystems = Set.of("banana", "strawberry");

  void Ingest(String sourceSystem);
}
