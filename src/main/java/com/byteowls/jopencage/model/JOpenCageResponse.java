package com.byteowls.jopencage.model;

import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class JOpenCageResponse {
  
  private String documentation;
  
  private List<JOpenCageLicence> licenses;
  private JOpenCageRate rate;
//  private JOpenCageRequest request;
  private List<JOpenCageResult> results;
  private JOpenCageStatus status;
  
  @JsonProperty("stay_informed")
  private JOpenCageStayInformed stayInformed;
  
  private String thanks;
  private JOpenCageTimestamp timestamp;
  @JsonProperty("total_results")
  private int totalResults;
  
  public String getDocumentation() {
    return documentation;
  }

  public List<JOpenCageLicence> getLicenses() {
    return licenses;
  }
  
  public JOpenCageRate getRate() {
    return rate;
  }

//  public JOpenCageRequest getRequest() {
//    return request;
//  }
  
  public List<JOpenCageResult> getResults() {
    return results;
  }
  
  public JOpenCageStatus getStatus() {
    return status;
  }

  public JOpenCageStayInformed getStayInformed() {
    return stayInformed;
  }
  
  public String getThanks() {
    return thanks;
  }
  
  public JOpenCageTimestamp getTimestamp() {
    return timestamp;
  }
  
  public int getTotalResults() {
    return totalResults;
  }
  
  public void orderResultByConfidence() {
    Collections.sort(this.results);
    Collections.reverse(this.results);
  }
  
  public JOpenCageLatLng getFirstPosition() {
    if (this.results != null) {
      orderResultByConfidence();
      for (JOpenCageResult r : this.results) {
        return r.getGeometry();
      }
    }
    return null;
  }
  
  public JOpenCageComponents getFirstComponents() {
    if (this.results != null) {
      orderResultByConfidence();
      for (JOpenCageResult r : this.results) {
        return r.getComponents();
      }
    }
    return null;
  }
  
  
}
