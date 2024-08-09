
package com.lgitsolution.switcheshopcommon.common.dto;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Multimedia
{
	String mainImage = "";
	
	String banner_Image = "";
	
	List<String> otherImages = new ArrayList<String>();;
	
	String mainVideo = "";
	
	List<String> otherVideos = new ArrayList<String>();

	HashMap<String, String> altTagMap = new HashMap<String, String>();

}
