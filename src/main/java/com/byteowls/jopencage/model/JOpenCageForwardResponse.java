package com.byteowls.jopencage.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collections;
import java.util.List;

@JsonInclude(Include.NON_NULL)
public class JOpenCageForwardResponse extends JOpenCageResponse {
  
  private JOpenCageForwardRequest request;

  public JOpenCageForwardRequest getRequest() {
    return request;
  }

}
