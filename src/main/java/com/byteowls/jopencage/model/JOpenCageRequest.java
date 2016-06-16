package com.byteowls.jopencage.model;

import java.util.HashMap;
import java.util.Map;


public abstract class JOpenCageRequest {
  
  /**
   * If set the api will provide much better results
   */
  private JOpenCageBounds bounds;
  /**
   * If set the api will provide much better results
   */
  private String restrictToCountryCode;
  private String language; // defaults to en
  private Integer limit;
  private Integer minConfidence;
  private boolean noAnnotations;
  private boolean noDedupe;
  private boolean pretty;
  private String subkey;
  private boolean addRequest;
  
  public Map<String,String> getParameter() {
    Map<String, String> parameter = new HashMap<>();
    if (subkey != null) {
      parameter.put("subkey", subkey);
    }
    if (addRequest) {
      parameter.put("add_request", "1");
    }
    if (bounds != null) {
      String boundsSTr = bounds.getSouthwest().getLat()
          + "," + bounds.getSouthwest().getLng()
          + "," + bounds.getNortheast().getLat()
          + "," + bounds.getNortheast().getLng();
      parameter.put("bounds", boundsSTr);
    }

    parameter.put("countrycode", restrictToCountryCode);
    parameter.put("language", language);
    if (limit != null) {
      parameter.put("limit", String.valueOf(limit));
    }
    if (minConfidence != null) {
      parameter.put("min_confidence", String.valueOf(minConfidence));
    }

    if (noAnnotations) {
      parameter.put("no_annotations", "1");
    }
    if (noDedupe) {
      parameter.put("no_dedupe", "1");
    }
    if (pretty) {
      parameter.put("pretty", "1");
    }
    return parameter;
  }
  
  public String getSubkey() {
    return subkey;
  }

  /**
   * A unique id of your choosing (can contain only A-Za-z0-9 and with a maximum length of 20 characters). 
   * The subkey is ignored by the geocoder but can be used for reporting. Not currently in use, but coming soon.
   * @param subkey
   */
  public void setSubkey(String subkey) {
    this.subkey = subkey;
  }


  public boolean isAddRequest() {
    return addRequest;
  }

  /**
   * Adds the various request parameters to the response for ease of debugging.
   * @param addRequest True if the request parameters should added to the response
   */
  public void setAddRequest(boolean addRequest) {
    this.addRequest = addRequest;
  }

  public JOpenCageBounds getBounds() {
    return bounds;
  }


  public void setBounds(JOpenCageBounds bounds) {
    this.bounds = bounds;
  }


  public String getRestrictToCountryCode() {
    return restrictToCountryCode;
  }

  /**
   * Restricts the results to the given country.
   * @param restrictToCountryCode 2 character code as defined by the ISO 3166-1 Alpha 2 standard. E.g. 'gb' for the United Kingdom, fr for France
   */
  public void setRestrictToCountryCode(String restrictToCountryCode) {
    this.restrictToCountryCode = restrictToCountryCode;
  }


  public String getLanguage() {
    return language;
  }


  /**
   * An IETF format language code (such as es for Spanish or pt-BR for Brazilian Portuguese); if this is omitted a code of en (English) will be assumed
   * @param language the language code
   */
  public void setLanguage(String language) {
    this.language = language;
  }


  public Integer getLimit() {
    return limit;
  }


  /**
   * How many results should be returned. Default is 10.
   * @param limit maximum number of results.
   */
  public void setLimit(Integer limit) {
    this.limit = limit;
  }


  public Integer getMinConfidence() {
    return minConfidence;
  }


  /**
   * An integer from 1-10 only results with at least this confidence will be returned.
   * @param minConfidence minimum confidence that the result matches
   */
  public void setMinConfidence(Integer minConfidence) {
    this.minConfidence = minConfidence;
  }


  public boolean isNoAnnotations() {
    return noAnnotations;
  }


  /**
   * If set to true the results will not contain annotations.
   * @param noAnnotations If true no annotations are included. Defaults to false.
   */
  public void setNoAnnotations(boolean noAnnotations) {
    this.noAnnotations = noAnnotations;
  }


  public boolean isNoDedupe() {
    return noDedupe;
  }

  /**
   * If set to true the results will not be deduplicated.
   * @param noDedupe If true the result will not be deduplicated. Defaults to false.
   */
  public void setNoDedupe(boolean noDedupe) {
    this.noDedupe = noDedupe;
  }


  public boolean isPretty() {
    return pretty;
  }


  /**
   * If set to true pretty printing of the response payload is enabled.
   * @param pretty If true the response will be pretty formatted.
   */
  public void setPretty(boolean pretty) {
    this.pretty = pretty;
  }


  /**
   * Provides the geocoder with a hint to the region that the query resides in. This value will help the geocoder but will not restrict the possible results to the supplied region.
   * @param northEastLat north east latitude
   * @param northEastLng north east longitude
   * @param southWestLat south west latitude
   * @param southWestLng south west longitude
   */
  public void setBounds(Double northEastLat, Double northEastLng, Double southWestLat, Double southWestLng) {
    bounds = new JOpenCageBounds();

    JOpenCageLatLng ne = new JOpenCageLatLng();
    ne.setLat(northEastLat);
    ne.setLng(northEastLng);
    bounds.setNortheast(ne);

    JOpenCageLatLng sw = new JOpenCageLatLng();
    sw.setLat(southWestLat);
    sw.setLng(southWestLng);
    bounds.setSouthwest(sw);
  }

}
