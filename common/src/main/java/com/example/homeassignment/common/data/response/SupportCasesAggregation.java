package com.example.homeassignment.common.data.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SupportCasesAggregation {
  Integer numberOfCases;
  Integer errorCode;
  Provider provider;
  List<String> products;
  List<Long> supportCases;
}
