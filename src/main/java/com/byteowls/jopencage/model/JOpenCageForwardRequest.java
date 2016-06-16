package com.byteowls.jopencage.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;


public class JOpenCageForwardRequest extends JOpenCageRequest {

  private List<String> queryParts = new ArrayList<>();
  private String queryPartSeparator = ",";

  public JOpenCageForwardRequest() {}
  
  public JOpenCageForwardRequest(String query) {
    if (query == null) {
      throw new IllegalArgumentException("Query must not null!");
    }
    this.queryParts.add(query);
  }
  
  public JOpenCageForwardRequest(String... queryParts) {
    if (queryParts == null || queryParts.length <= 0) {
      throw new IllegalArgumentException("queryParts must not null!");
    }
    Collections.addAll(this.queryParts, queryParts);
  }
  
  public Map<String,String> getParameter() {
    Map<String, String> parameter = super.getParameter();
    StringBuilder sb = new StringBuilder();
    for (String p : this.queryParts) {
      if (p != null) {
        if (sb.length() > 0) {
          sb.append(this.queryPartSeparator);
        }
        sb.append(p);
      }
    }
    parameter.put("query", sb.toString());
    return parameter;
  }

  /**
   * If you use the query part constructor this String separates the query parts from each other. Defaults to a colon.
   * @param queryPartSeparator the query part separator. Defaults to a colon.
   */
  public void setQueryPartSeparator(String queryPartSeparator) {
    this.queryPartSeparator = queryPartSeparator;
  }
  
}
