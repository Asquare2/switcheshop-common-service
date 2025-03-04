
package com.lgitsolution.switcheshopcommon.dm.utility;

import com.lgitsolution.switcheshopcommon.dm.dto.ThirdPartyDmConstant;
import com.lgitsolution.switcheshopcommon.dm.dto.ThirdPartyDmDto;
import com.lgitsolution.switcheshopcommon.dm.model.ThirdPartyDm;

public class Utility {

  private static com.lgitsolution.switcheshopcommon.common.util.Utility CommonUtility =
          new com.lgitsolution.switcheshopcommon.common.util.Utility();

  public static ThirdPartyDm convertThiredPartyDmDtoToModel(ThirdPartyDmDto dto) {

    ThirdPartyDm model = new ThirdPartyDm();
    model.setId(dto.getId());
    model.setDefaultScript(dto.getDefaultScript());
    model.setValue(dto.getValue());
    model.setKey(dto.getKey());
    return model;
  }

  public static ThirdPartyDmDto convertThiredPartyDMModelToDto(ThirdPartyDm model) {

    ThirdPartyDmDto dto = new ThirdPartyDmDto();
    dto.setId(model.getId());
    dto.setDefaultScript(model.getDefaultScript());
    dto.setValue(model.getValue());
    dto.setKey(model.getKey());

    if (model.getKey().equals(ThirdPartyDmConstant.GOOGLE_ANALYTICES) || model.getKey().equals(
            ThirdPartyDmConstant.META_ANALYTICES)) {
      if (model.getValue() != null && !model.getValue().isEmpty()) {
        String defltString = model.getDefaultScript();
        defltString = defltString.replace(ThirdPartyDmConstant.THIRED_PARTY_DM_CODE_PLACE_HOLDER,
                model.getValue());
        dto.setFinalScript(defltString);
      }
    }
    return dto;
  }

}
