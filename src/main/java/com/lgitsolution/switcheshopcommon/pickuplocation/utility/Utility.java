
package com.lgitsolution.switcheshopcommon.pickuplocation.utility;

import java.util.ArrayList;
import java.util.List;

import com.lgitsolution.switcheshopcommon.pickuplocation.dto.PickupLocationDto;
import com.lgitsolution.switcheshopcommon.pickuplocation.model.PickupLocation;
import com.lgitsolution.switcheshopcommon.shippingpartner.shiprocket.dto.pickuplocation.DeliveryData;
import com.lgitsolution.switcheshopcommon.shippingpartner.shiprocket.dto.pickuplocation.ShippingAddressDTO;
import com.lgitsolution.switcheshopcommon.shippingpartner.shiprocket.dto.pickuplocation.ShippingDataDTO;

public class Utility {

  /**
   * Converts the dto to model object.
   * 
   * @param pickupLocationDto the pickup location dto object
   * @return the pickup location model object
   */
  public static PickupLocation convertDtoToModel(PickupLocationDto pickupLocationDto) {
    PickupLocation pickupLocation = new PickupLocation();
    pickupLocation.setPickupLocation(pickupLocationDto.getPickupLocation());
    pickupLocation.setName(pickupLocationDto.getName());
    pickupLocation.setEmail(pickupLocationDto.getEmail());
    pickupLocation.setPhone(pickupLocationDto.getPhone());
    pickupLocation.setCity(pickupLocationDto.getCity());
    pickupLocation.setState(pickupLocationDto.getState());
    pickupLocation.setCountry(pickupLocationDto.getCountry());
    pickupLocation.setPincode(pickupLocationDto.getPincode());
    pickupLocation.setAddress(pickupLocationDto.getAddress());
    pickupLocation.setAddress2(pickupLocationDto.getAddress2());
    pickupLocation.setIsVerified(pickupLocationDto.getIsVerified());
    pickupLocation.setIsPrimary(pickupLocationDto.getIsPrimary());
    pickupLocation.setId(pickupLocationDto.getId());
    return pickupLocation;
  }

  /**
   * Converts the model to dto object.
   * 
   * @param pickupLocation the pickup location model object
   * @return the pickup location dto object
   */
  public static PickupLocationDto convertModelToDto(PickupLocation pickupLocation) {
    PickupLocationDto pickupLocationDto = new PickupLocationDto();
    pickupLocationDto.setId(pickupLocation.getId());
    pickupLocationDto.setPickupLocation(pickupLocation.getPickupLocation());
    pickupLocationDto.setName(pickupLocation.getName());
    pickupLocationDto.setEmail(pickupLocation.getEmail());
    pickupLocationDto.setPhone(pickupLocation.getPhone());
    pickupLocationDto.setCity(pickupLocation.getCity());
    pickupLocationDto.setState(pickupLocation.getState());
    pickupLocationDto.setCountry(pickupLocation.getCountry());
    pickupLocationDto.setPincode(pickupLocation.getPincode());
    pickupLocationDto.setAddress(pickupLocation.getAddress());
    pickupLocationDto.setAddress2(pickupLocation.getAddress2());
    pickupLocationDto.setIsVerified(pickupLocation.getIsVerified());
    pickupLocationDto.setIsPrimary(pickupLocation.getIsPrimary());
    return pickupLocationDto;
  }

  /**
   * Converts the list of model to dto object.
   * 
   * @param pickupLocationList the list of pickup location model object
   * @return the list of pickup location dto object
   */
  public static List<PickupLocationDto> convertModelToDto(List<PickupLocation> pickupLocationList) {
    List<PickupLocationDto> pickupLocationDtoList = new ArrayList<>();
    for (PickupLocation pickupLocation : pickupLocationList) {
      PickupLocationDto pickupLocationDto = convertModelToDto(pickupLocation);
      pickupLocationDtoList.add(pickupLocationDto);
    }
    return pickupLocationDtoList;
  }

  public static List<PickupLocationDto> getPickupLocationList(DeliveryData deliveryData) {
    ShippingDataDTO data = deliveryData.getData();
    ArrayList<PickupLocationDto> pickupLocationList = new ArrayList<PickupLocationDto>();
    if (data != null) {
      List<ShippingAddressDTO> shipping_address = data.getShipping_address();
      if (shipping_address != null && !shipping_address.isEmpty()) {
        PickupLocationDto pickupLocationDto = null;
        for (ShippingAddressDTO shippingAddressDTO : shipping_address) {
          pickupLocationDto = new PickupLocationDto();
          pickupLocationDto.setPickupLocation(shippingAddressDTO.getPickup_location());
          pickupLocationDto.setAddress(shippingAddressDTO.getAddress());
          pickupLocationDto.setAddress2(shippingAddressDTO.getAddress_2());
          pickupLocationDto.setCity(shippingAddressDTO.getCity());
          pickupLocationDto.setPhone(shippingAddressDTO.getPhone());
          pickupLocationDto.setEmail(shippingAddressDTO.getEmail());
          pickupLocationDto.setIsVerified(shippingAddressDTO.getPhone_verified());
          pickupLocationDto.setName(shippingAddressDTO.getName());
          pickupLocationDto.setCountry(shippingAddressDTO.getCountry());
          pickupLocationDto.setState(shippingAddressDTO.getState());
          // on ship rocket side , if status is 2 then its a primary address
          pickupLocationDto.setIsPrimary(shippingAddressDTO.getStatus() == 2 ? 1 : 0);
          pickupLocationDto.setId(shippingAddressDTO.getId());
          pickupLocationDto.setPincode(shippingAddressDTO.getPin_code());
          pickupLocationList.add(pickupLocationDto);
        }
      }
    }
    return pickupLocationList;
  }

}
