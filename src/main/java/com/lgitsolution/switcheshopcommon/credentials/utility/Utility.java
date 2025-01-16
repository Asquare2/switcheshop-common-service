
package com.lgitsolution.switcheshopcommon.credentials.utility;

import com.lgitsolution.switcheshopcommon.credentials.dto.CredentialsDto;
import com.lgitsolution.switcheshopcommon.credentials.model.Credentials;

public class Utility {

  private static com.lgitsolution.switcheshopcommon.common.util.Utility Utility =
          new com.lgitsolution.switcheshopcommon.common.util.Utility();

  /**
   * Converts the dto object into model object.
   * 
   * @param credentialsDto the credentials dto
   * @return the converted object
   */
  public static Credentials convertDtoToModel(CredentialsDto credentialsDto) {
    Credentials credentials = new Credentials();
    credentials.setServiceName(credentialsDto.getServiceName());
    credentials.setEmailId(credentialsDto.getEmailId());
    credentials.setPassword(credentialsDto.getPassword());
    credentials.setClientId(credentialsDto.getClientId());
    credentials.setClientSecret(credentialsDto.getClientSecret());
    credentials.setConfig(com.lgitsolution.switcheshopcommon.common.util.Utility
            .convertMapToJsonString(credentialsDto.getConfig()));
    credentials.setModifiedAt(Utility.getLocalDate(credentialsDto.getModifiedAt()));
    return credentials;
  }

  /**
   * Converts the model object to dto.
   * 
   * @param credentials the credentials object
   * @return the converted dto object
   */
  public static CredentialsDto convertModelToDto(Credentials credentials) {
    CredentialsDto credentialsDto = new CredentialsDto();
    credentialsDto.setId(credentials.getId());
    credentialsDto.setServiceName(credentials.getServiceName());
    credentialsDto.setEmailId(credentials.getEmailId());
    credentialsDto.setPassword(credentials.getPassword());
    credentialsDto.setClientId(credentials.getClientId());
    credentialsDto.setClientSecret(credentials.getClientSecret());
    credentialsDto.setConfig(com.lgitsolution.switcheshopcommon.common.util.Utility
            .convertJsonStringToMap(credentials.getConfig()));
    credentialsDto.setModifiedAt(Utility.getLocalDateMillis(credentials.getModifiedAt()));
    return credentialsDto;
  }

}
