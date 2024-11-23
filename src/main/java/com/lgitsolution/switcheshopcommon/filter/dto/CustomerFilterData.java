
package com.lgitsolution.switcheshopcommon.filter.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerFilterData {

  String name;
  List<CustomerFilterMetaData> filter = new ArrayList<CustomerFilterMetaData>();

}
