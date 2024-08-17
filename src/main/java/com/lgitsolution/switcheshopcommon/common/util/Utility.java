
package com.lgitsolution.switcheshopcommon.common.util;



import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lgitsolution.switcheshopcommon.common.dto.Multimedia;
import com.lgitsolution.switcheshopcommon.common.dto.ResponseWrapper;
import com.lgitsolution.switcheshopcommon.common.logger.SelfKartLogger;
import com.lgitsolution.switcheshopcommon.filter.dto.SearchOptionsDto;

import io.micrometer.common.util.StringUtils;

/**
 * The Class Utility.
 */
public class Utility {

  static SelfKartLogger logger = new SelfKartLogger(Utility.class);

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
  public static Long getLocalDateTimeMillis(LocalDateTime localDateTime) {
    Long localDateTimrMillis = null;
    if (localDateTime != null) {
      localDateTimrMillis = localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
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
   * Gets the json string of SearchOptionsDto object.
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
}