
package com.lgitsolution.switcheshopcommon.common.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.SplittableRandom;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.lgitsolution.switcheshopcommon.common.dto.ModuleAccess;
import com.lgitsolution.switcheshopcommon.common.dto.Multimedia;
import com.lgitsolution.switcheshopcommon.common.dto.ResponseWrapper;
import com.lgitsolution.switcheshopcommon.common.logger.SwitcheShopLogger;
import com.lgitsolution.switcheshopcommon.filter.dto.SearchOptionsDto;
import com.lgitsolution.switcheshopcommon.user.model.SystemUser;

import feign.Feign;
import io.micrometer.common.util.StringUtils;

/**
 * The Class Utility.
 */
public class Utility {

  static SwitcheShopLogger logger = new SwitcheShopLogger(Utility.class);

  /**
   * Wrap response.
   *
   * @param <T> the generic type
   * @param output the output
   * @param description the description
   * @param errors the errors
   * @return the response wrapper
   */
  public static <T> ResponseEntity<ResponseWrapper<T>> wrapResponse(T output, String description,
          List<String> errors, HttpStatus httpStatus) {
    boolean status = errors == null || errors.isEmpty() ? true : false;
    return new ResponseEntity<ResponseWrapper<T>>(new ResponseWrapper(output, status, description,
            errors), httpStatus);
  }

  /**
   * Gets the json string of multimedia object.
   * 
   * @param multiMedia
   * @return the json string of multimedia object.
   */
  public static String getMultiMediaJsonString(Multimedia multiMedia) {
    String jsonString = "";
    if (multiMedia != null) {
      ObjectMapper obj = new ObjectMapper();
      try {
        jsonString = obj.writeValueAsString(multiMedia);
      } catch (JsonProcessingException e) {
        e.printStackTrace();
      }
    }
    return jsonString;
  }

  /**
   * Gets the multimedia object from json string
   * 
   * @param jsonString
   * @return the multimedia object from json string.
   */
  public static Multimedia getMultiMediaObject(String jsonString) {
    Multimedia multimedia = null;
    try {
      if (jsonString != null && StringUtils.isNotEmpty(jsonString)) {
        ObjectMapper obj = new ObjectMapper();
        multimedia = obj.readValue(jsonString, Multimedia.class);
      }
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return multimedia;
  }

  @SuppressWarnings("finally")
  public static boolean copyFiles(List<String> sourceList, List<String> destinationList) {
    boolean isCompleted = true;
    try {

      for (int i = 0; i < sourceList.size(); i++) {
        File sourceFile = new File(sourceList.get(i));
        File destinationFile = new File(destinationList.get(i));
        copyFiles(sourceFile, destinationFile);
      }
    } catch (IOException e) {
      logger.error("File not copied", e);
      isCompleted = false;
    } finally {
      return isCompleted;
    }
  }

  /**
   * Copy file from source path to destination path.
   * 
   * @param source the source path
   * @param dest the destination path
   * @throws IOException
   */
  public static void copyFiles(File source, File dest) throws IOException {
    Path sourcePath = Paths.get(source.getAbsolutePath());
    Path destPath = Paths.get(dest.getAbsolutePath());
    if (Files.notExists(destPath)) {
      Files.copy(sourcePath, destPath);
    } else {
      Files.delete(destPath);
      Files.copy(sourcePath, destPath);
    }
  }

  /**
   * Get all the path of the multi media (like images and videos).
   * 
   * @param multimedia the multi media object
   * @return the list of path
   */
  private static List<String> getMultiMediaPathList(Multimedia multimedia) {
    List<String> multiMediaPathList = new ArrayList<>();
    String path = multimedia.getMainImage();
    if (path != null && !path.isEmpty()) {
      multiMediaPathList.add(path);
    }
    path = multimedia.getBanner_Image();
    if (path != null && !path.isEmpty()) {
      multiMediaPathList.add(path);
    }
    List<String> pathList = multimedia.getOtherImages();
    for (String pathL : pathList) {
      multiMediaPathList.add(pathL);
    }
    path = multimedia.getMainVideo();
    if (path != null && !path.isEmpty()) {
      multiMediaPathList.add(path);
    }
    pathList = multimedia.getOtherVideos();
    for (String pathL : pathList) {
      multiMediaPathList.add(pathL);
    }
    return multiMediaPathList;
  }

  /**
   * Delete the files that is given in multimedia object
   * 
   * @param multimedia
   */
  public static boolean deleteFiles(String path) {
    boolean isDeleted = true;
    // Delete the file
    try {
      Files.delete(Paths.get(path));
      logger.info("Deleted file: " + path);
    } catch (IOException e) {
      logger.error("Error processing file: " + path, e);
      isDeleted = false;
    }
    return isDeleted;
  }

  /**
   * Gets the object of local date time from the long millisecond value.
   * 
   * @param dateTime the millisecond value in long
   * @return the local date time object
   */
  public static LocalDateTime getLocalDateTime(Long dateTime) {
    LocalDateTime localDateTime = null;
    if (dateTime != null) {
      Date dateInstant = new Date(dateTime);
      localDateTime = dateInstant.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
    return localDateTime;
  }

  /**
   * Gets the object of local date from the long millisecond value.
   * 
   * @param dateTime the millisecond value in long
   * @return the local date object
   */
  public static LocalDate getLocalDate(Long dateTime) {
    LocalDate localDate = null;
    if (dateTime != null) {
      Date dateInstant = new Date(dateTime);
      localDate = dateInstant.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
    return localDate;
  }

  /**
   * Gets the object of local date.
   * 
   * @param dateTime the date time in string
   * @return the local date object
   */
  public static LocalDate getLocalDate(String dateTime) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    LocalDate localDate = null;
    try {
      if (dateTime != null && !dateTime.isBlank()) {
        localDate = LocalDate.parse(dateTime, formatter);
      }
    } catch (Exception e) {
      logger.error("Unable to parse date: " + e);
    }
    return localDate;
  }

  /**
   * Gets the date and time object as per the given format.
   * 
   * @param localDateTime the local date time object
   * @param format the format in which the object will get formatted
   * @return the formatted date time as string
   */
  public static String getFormattedDateTime(LocalDateTime localDateTime, String format) {
    return DateTimeFormatter.ofPattern(format).format(localDateTime);
  }

  /**
   * Gets the local date time object value in millisecond.
   * 
   * @param localDateTime the local date time object
   * @return the local date time object in the millisecond
   */
  public Long getLocalDateTimeMillis(LocalDateTime localDateTime) {
    Long localDateTimrMillis = null;
    if (localDateTime != null) {
      localDateTimrMillis = localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }
    return localDateTimrMillis;
  }

  /**
   * Gets the local date object value in millisecond.
   * 
   * @param localDateTime the local date time object
   * @return the local date time object in the millisecond
   */
  public static Long getLocalDateMillis(LocalDate localDateTime) {
    Long localDateTimrMillis = null;
    if (localDateTime != null) {
      localDateTimrMillis = localDateTime.atStartOfDay(ZoneId.systemDefault()).toInstant()
              .toEpochMilli();
    }
    return localDateTimrMillis;
  }

  /**
   * Gets the id list from multimedia object.
   * 
   * @param multimedia the multimedia object
   * @return the id list from multimedia object.
   */
  public static List<Integer> getMediaIdByMultiMedia(Multimedia multimedia) {
    if (multimedia == null) {
      return null;
    }
    List<String> pathList = getMultiMediaPathList(multimedia);
    List<Integer> mediaIdList = new ArrayList<Integer>();
    pathList.stream().forEach(o -> {
      String idStr = o.substring(o.lastIndexOf(File.separator) + 1, o.lastIndexOf("."));
      mediaIdList.add(Integer.parseInt(idStr));
    });
    return mediaIdList;
  }

  /**
   * Gets the media id that is deleted from multimedia object.
   * 
   * @param oldMultimedia the old multimedia object
   * @param newMultimedia the new multimedia object
   * @return the media id that is deleted from multimedia object.
   */
  public static List<Integer> getDeleteMediaIdByMultiMedia(Multimedia oldMultimedia,
          Multimedia newMultimedia) {
    if ((newMultimedia == null && oldMultimedia == null) || oldMultimedia == null) {
      return null;
    }
    List<Integer> deleteMediaIdList = new ArrayList<Integer>();
    List<String> oldPathList = getMultiMediaPathList(oldMultimedia);
    List<Integer> oldMediaIdList = new ArrayList<Integer>();
    oldPathList.stream().forEach(o -> {
      String idStr = o.substring(o.lastIndexOf(File.separator) + 1, o.lastIndexOf("."));
      oldMediaIdList.add(Integer.parseInt(idStr));
    });
    List<String> newPathList = getMultiMediaPathList(newMultimedia);
    List<Integer> newMediaIdList = new ArrayList<Integer>();
    newPathList.stream().forEach(o -> {
      String idStr = o.substring(o.lastIndexOf(File.separator) + 1, o.lastIndexOf("."));
      newMediaIdList.add(Integer.parseInt(idStr));
    });
    oldMediaIdList.stream().forEach(o -> {
      if (!newMediaIdList.contains(o)) {
        deleteMediaIdList.add(o);
      }
    });
    return deleteMediaIdList;
  }

  /**
   * Gets the media id that is deleted from multimedia object.
   * 
   * @param oldMultimedia the old multimedia object
   * @param newMultimedia the new multimedia object
   * @return the media id that is deleted from multimedia object.
   */
  public static List<Integer> getAddedMediaIdByMultiMedia(Multimedia oldMultimedia,
          Multimedia newMultimedia) {
    if ((newMultimedia == null && oldMultimedia == null) || newMultimedia == null) {
      return null;
    }
    List<Integer> addedMediaIdList = new ArrayList<Integer>();
    List<String> oldPathList = getMultiMediaPathList(oldMultimedia);
    List<Integer> oldMediaIdList = new ArrayList<Integer>();
    oldPathList.stream().forEach(o -> {
      String idStr = o.substring(o.lastIndexOf(File.separator) + 1, o.lastIndexOf("."));
      oldMediaIdList.add(Integer.parseInt(idStr));
    });
    List<String> newPathList = getMultiMediaPathList(newMultimedia);
    List<Integer> newMediaIdList = new ArrayList<Integer>();
    newPathList.stream().forEach(o -> {
      String idStr = o.substring(o.lastIndexOf(File.separator) + 1, o.lastIndexOf("."));
      newMediaIdList.add(Integer.parseInt(idStr));
    });
    newMediaIdList.stream().forEach(o -> {
      if (!oldMediaIdList.contains(o)) {
        addedMediaIdList.add(o);
      }
    });
    return addedMediaIdList;
  }

  public static String convertMapToJsonString(Map<String, String> map) {
    String jsonString = "";
    if (map != null) {
      ObjectMapper obj = new ObjectMapper();
      try {
        jsonString = obj.writeValueAsString(map);
      } catch (JsonProcessingException e) {
        e.printStackTrace();
      }
    }
    return jsonString;
  }

  public static String convertMapOfListToJsonString(Map<String, List<String>> map) {
    String jsonString = "";
    if (map != null) {
      ObjectMapper obj = new ObjectMapper();
      try {
        jsonString = obj.writeValueAsString(map);
      } catch (JsonProcessingException e) {
        e.printStackTrace();
      }
    }
    return jsonString;
  }

  public static LinkedHashMap<String, List<String>> convertJsonStringToMapOfList(
          String jsonString) {
    LinkedHashMap<String, List<String>> map = null;
    try {
      if (jsonString != null && StringUtils.isNotEmpty(jsonString)) {
        ObjectMapper obj = new ObjectMapper();
        map = obj.readValue(jsonString, LinkedHashMap.class);
      }
    } catch (Exception exception) {
      logger.error("Failed to get the map object.", exception);
    }
    return map;
  }

  public static LinkedHashMap<String, String> convertJsonStringToMap(String jsonString) {
    LinkedHashMap<String, String> map = null;
    try {
      if (jsonString != null && StringUtils.isNotEmpty(jsonString)) {
        ObjectMapper obj = new ObjectMapper();
        map = obj.readValue(jsonString, LinkedHashMap.class);
      }
    } catch (Exception exception) {
      logger.error("Failed to get the map object.", exception);
    }
    return map;
  }

  /**
   * Converts the json string to object.
   * 
   * @param multiMedia
   * @return the json string to object.
   */
  public static String ConvertObjectToJsonString(Object object) {
    String jsonString = "";
    if (object != null) {
      ObjectMapper obj = new ObjectMapper();
      try {
        jsonString = obj.writeValueAsString(object);
      } catch (JsonProcessingException e) {
        e.printStackTrace();
      }
    }
    return jsonString;
  }

  /**
   * Converts the object from json string
   * 
   * @param <T> generic type for object
   * @param jsonString the json string which need to convert into object
   * @param object the object in which we need to convert the json
   * @return the object from json string.
   */
  public static <T> T convertJsonToObject(String jsonString, T object) {
    try {
      if (jsonString != null && StringUtils.isNotEmpty(jsonString)) {
        ObjectMapper obj = new ObjectMapper();
        object = (T) obj.readValue(jsonString, object.getClass());
      }
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return object;
  }

  /**
   * Gets the json string of object.
   * 
   * @param SearchOptionsDto
   * @return the json string of SearchOptionsDto object.
   */
  public static String getSearchOptionsDtoJsonString(SearchOptionsDto searchOptionsDto) {
    String jsonString = "";
    if (searchOptionsDto != null) {
      ObjectMapper obj = new ObjectMapper();
      try {
        jsonString = obj.writeValueAsString(searchOptionsDto);
      } catch (JsonProcessingException e) {
        e.printStackTrace();
      }
    }
    return jsonString;
  }

  /**
   * Gets the SearchOptionsDto object from json string
   * 
   * @param jsonString
   * @return the SearchOptionsDto object from json string.
   */
  public static SearchOptionsDto getSearchOptionsDtoObject(String jsonString) {
    SearchOptionsDto searchOptionsDto = null;
    try {
      if (jsonString != null && StringUtils.isNotEmpty(jsonString)) {
        ObjectMapper obj = new ObjectMapper();
        searchOptionsDto = obj.readValue(jsonString, SearchOptionsDto.class);
      }
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return searchOptionsDto;
  }

  /**
   * Check that given string is number or not
   * 
   * @param str the value
   * @return true if number, false otherwise.
   */
  public static boolean isNumeric(String str) {
    try {
      Long.parseLong(str);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  /**
   * Generates the qr code image as per the given text.
   * 
   * @param barcodeText the text for which qr code will be generates
   * @param width The preferred width in pixels
   * @param height The preferred height in pixels
   * @return the generated qr code image for the given text
   */
  public static BufferedImage generateQRCodeImage(String barcodeText, int width, int height) {
    BitMatrix bitMatrix = null;
    try {
      bitMatrix = new QRCodeWriter().encode(barcodeText, BarcodeFormat.QR_CODE, width, height);
    } catch (Exception e) {
      logger.error("Unable to generate barcode: " + e);
    }
    return MatrixToImageWriter.toBufferedImage(bitMatrix);
  }

  // Generate a barcode image (1D or 2D)
  public static BufferedImage generateBarcode(String data, BarcodeFormat format, int width,
          int height) throws WriterException {
    Map<EncodeHintType, Object> hints = new HashMap<>();
    if (format == BarcodeFormat.QR_CODE) {
      hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
    }
    hints.put(EncodeHintType.MARGIN, 1);

    BitMatrix matrix = new MultiFormatWriter().encode(data, format, width, height, hints);
    return MatrixToImageWriter.toBufferedImage(matrix);
  }

  /**
   * Generate random number.
   * 
   * @param the maximum number
   * 
   * @return the random number.
   */
  public static int generateRandomNumber(int maxNumber) {
    SplittableRandom splittableRandom = new SplittableRandom();
    int randomWithSplittableRandom = splittableRandom.nextInt(1, maxNumber);
    return randomWithSplittableRandom;
  }

  /**
   * Gets the random alpha numeric word.
   * 
   * @param length the length of number
   * @return the random alpha numeric word.
   */
  public static String generateRandomAlphanumeric(int length) {
    String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    Random random = new Random();
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < length; i++) {
      int index = random.nextInt(characters.length());
      result.append(characters.charAt(index));
    }

    return result.toString();
  }

  /**
   * Gets the slug by title
   * 
   * @param title the title of product.
   * 
   * @return the slug
   */
  public static String getSlugByTitle(String title) {

    String slug = title.replaceAll("[^a-zA-Z0-9\\s]", "");

    // Step 2: Replace multiple spaces with a single hyphen
    slug = slug.trim().replaceAll("\\s+", "-");

    // Step 3: Convert to lower case
    slug = slug.toLowerCase();

    // Step 4: Append random alphanumeric string
    String randomNumber = generateRandomAlphanumeric(10);
    slug = slug + "-" + randomNumber;

    return slug;
  }

  public static void main(String[] args) {
    System.out.println(getSlugByTitle("Aa#$as ^&*     !@| asj aj bn"));
  }

  /**
   * Gets the json string of module access object.
   * 
   * @param moduleAccess
   * @return the json string of module access object.
   */
  public static String getModuleAccessJsonString(Map<String, ModuleAccess> moduleAccess) {
    String jsonString = "";
    if (moduleAccess != null) {
      ObjectMapper obj = new ObjectMapper();
      try {
        jsonString = obj.writeValueAsString(moduleAccess);
      } catch (JsonProcessingException e) {
        e.printStackTrace();
      }
    }
    return jsonString;
  }

  /**
   * Gets the module access object from json string
   * 
   * @param jsonString
   * @return the module access object from json string.
   */
  public static Map<String, ModuleAccess> getModuleAccessObject(String jsonString) {
    Map<String, ModuleAccess> moduleAccess = null;
    try {
      if (jsonString != null && StringUtils.isNotEmpty(jsonString)) {
        ObjectMapper obj = new ObjectMapper();
        moduleAccess = obj.readValue(jsonString, Map.class);
      }
    } catch (Exception exception) {
      logger.error("Failed to get the module object.", exception);
    }
    return moduleAccess;
  }

  public static SystemUser getLoggedInCustomerDetail() {
    SystemUser systemUser = null;
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    if (auth.getPrincipal() != null && !auth.getPrincipal().toString().equals("anonymousUser")) {
      systemUser = (SystemUser) auth.getPrincipal();
    }
    return systemUser;
  }

  public static String getNewAddedDate(int addDays) {
    String DATE_FORMAT = "dd/MM/yyyy";
    DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
    DateTimeFormatter dateFormat8 = DateTimeFormatter.ofPattern(DATE_FORMAT);
    // Get current date
    Date currentDate = new Date();

    // convert date to localdatetime
    LocalDateTime localDateTime = currentDate.toInstant().atZone(ZoneId.systemDefault())
            .toLocalDateTime();

    // plus one
    localDateTime = localDateTime.plusDays(addDays);

    // convert LocalDateTime to date
    Date currentDatePlusOneDay = Date.from(localDateTime.atZone(ZoneId.systemDefault())
            .toInstant());

    return dateFormat.format(currentDatePlusOneDay);
  }

  /**
   * Gets new date time with time zone format.
   * 
   * @param addedTime added minutes
   * @param zoneId
   * @return
   */
  public static String addMinutesToCurrentTime(int minutes, ZoneId zoneId) {
    // Get the current time in IST
    OffsetDateTime dateTime = OffsetDateTime.now(zoneId).plusMinutes(minutes);

    // Format to ISO 8601
    DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

    // Return formatted date string
    return dateTime.format(formatter);
  }

  public static int roundFloat(float value) {
    int intValue = (int) value; // Get the integer part
    float decimalPart = value - intValue; // Get the decimal part

    if (decimalPart > 0.5) {
      return intValue + 1; // Round up
    } else {
      return intValue; // Round down
    }
  }

  /**
   * Generated the string of the random numbers as per the given criteria. e.g. if 6 digit random
   * number is required then pass "000000" as pattern and the range like 999999.
   * 
   * @param pattern the pattern to format the random number
   * @param range the range between the random number will be generating
   * @return the random number string
   */
  public static String generateRandomNumberStr(String pattern, int range) {
    return new DecimalFormat(pattern).format(new Random().nextInt(range));
  }

  /**
   * 
   * @param timeInMillis
   * @return
   */
  public static Long getDifferenceInMillisFromCurrentTime(Long timeInMillis) {
    return (Long) System.currentTimeMillis() - timeInMillis;
  }

  public static String convertyyyyMmDdToDdMmYyyyDateFormate(String date) {
    DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    DateTimeFormatter outputDateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    LocalDate localDate = LocalDate.parse(date, inputFormatter);
    return localDate.format(outputDateFormatter);
  }

  /**
   * Creates the feign client object.
   * 
   * @param clientClass the name of the class or interface with .class extension
   * @return
   */
  public static <T> T createFeignClient(Class<T> clientClass, String url,
          ObjectFactory<HttpMessageConverters> messageConverters) {
    return Feign.builder().encoder(new SpringEncoder(messageConverters)).decoder(new SpringDecoder(
            messageConverters)).contract(new SpringMvcContract()).target(clientClass, url);
  }

}
