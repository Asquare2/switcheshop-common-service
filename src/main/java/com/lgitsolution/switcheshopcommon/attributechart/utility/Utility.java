
package com.lgitsolution.switcheshopcommon.attributechart.utility;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.lgitsolution.switcheshopcommon.attributechart.dto.AttributeChartDto;
import com.lgitsolution.switcheshopcommon.attributechart.model.AttributeChart;

public class Utility {

  private static com.lgitsolution.switcheshopcommon.common.util.Utility Utility =
          new com.lgitsolution.switcheshopcommon.common.util.Utility();

  public static AttributeChart convertDtoToModel(AttributeChartDto dto) {
    AttributeChart model = new AttributeChart();
    model.setMultiMedia(Utility.getMultiMediaJsonString(dto.getMultiMedia()));
    model.setTemplateName(dto.getTemplateName());
    model.setId(dto.getId());
    model.setChartData(Utility.ConvertObjectToJsonString(dto.getChartData()));
    return model;
  }

  public static AttributeChartDto convertModelToDto(AttributeChart model) {
    AttributeChartDto dto = new AttributeChartDto();
    dto.setMultiMedia(Utility.getMultiMediaObject(model.getMultiMedia()));
    dto.setTemplateName(model.getTemplateName());
    dto.setId(model.getId());
    dto.setChartData(Utility.convertJsonToObject(model.getChartData(),
            new LinkedHashMap<String, Map<String, String>>()));
    return dto;
  }

  public static List<AttributeChartDto> convertModelToDto(List<AttributeChart> modelList) {
    return modelList.stream().map(model -> convertModelToDto(model)).collect(Collectors.toList());
  }

}
