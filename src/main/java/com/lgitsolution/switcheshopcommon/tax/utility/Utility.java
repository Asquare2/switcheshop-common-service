
package com.lgitsolution.switcheshopcommon.tax.utility;

import java.util.ArrayList;
import java.util.List;

import com.lgitsolution.switcheshopcommon.tax.dto.TaxDto;
import com.lgitsolution.switcheshopcommon.tax.model.Tax;



/**
 * The utility class for the tax.
 */
public class Utility {

  /**
   * Converts the dto object to model object.
   * 
   * @param taxDto the dto object of tax
   * @return the model object of tax
   */
  public static Tax convertDtoToModel(TaxDto taxDto) {
    Tax tax = new Tax();
    tax.setPercentage(taxDto.getPercentage());
    tax.setTitle(taxDto.getTitle());
    tax.setMinPrice(taxDto.getMinPrice());
    tax.setMaxPrice(taxDto.getMaxPrice());
    return tax;
  }

  /**
   * Converts the model object to dto object.
   * 
   * @param tax the model object of tax
   * @return the dto object of tax
   */
  public static TaxDto convertModeToDto(Tax tax) {
    TaxDto taxDto = new TaxDto();
    taxDto.setId(tax.getId());
    taxDto.setTitle(tax.getTitle());
    taxDto.setPercentage(tax.getPercentage());
    taxDto.setMinPrice(tax.getMinPrice());
    taxDto.setMaxPrice(tax.getMaxPrice());
    return taxDto;
  }

  /**
   * Converts the list of model class objects to list of dto class object.
   * 
   * @param taxList the list of model class
   * @return the list of dto class
   */
  public static List<TaxDto> convertModelToDto(List<Tax> taxList) {
    List<TaxDto> taxDtoList = new ArrayList<>();
    for (Tax tax : taxList) {
      taxDtoList.add(convertModeToDto(tax));
    }
    return taxDtoList;
  }

}
