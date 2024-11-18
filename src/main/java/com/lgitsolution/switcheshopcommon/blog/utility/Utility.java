
package com.lgitsolution.switcheshopcommon.blog.utility;

import java.util.ArrayList;
import java.util.List;

import com.lgitsolution.switcheshopcommon.blog.dto.BlogDto;
import com.lgitsolution.switcheshopcommon.blog.model.Blog;



public class Utility {

  private static com.lgitsolution.switcheshopcommon.common.util.Utility Utility =
          new com.lgitsolution.switcheshopcommon.common.util.Utility();

  public static Blog convertDtoToModel(BlogDto blogDto) {
    Blog blog = new Blog();
    blog.setMultiMedia(Utility.getMultiMediaJsonString(blogDto.getMultiMedia()));
    blog.setContent(blogDto.getContent());
    blog.setSlug(blogDto.getSlug());
    blog.setTitle(blogDto.getTitle());
    blog.setCreatedAt(Utility.getLocalDateTime(blogDto.getCreatedAt()));
    blog.setStatus(blogDto.getStatus());
    return blog;
  }
	public static BlogDto convertModelToDto(Blog blog) {
		BlogDto blogDto = new BlogDto();
		blogDto.setId(blog.getId());
		blogDto.setMultiMedia(Utility.getMultiMediaObject(blog.getMultiMedia()));
		blogDto.setTitle(blog.getTitle());
		blogDto.setContent(blog.getContent());
		blogDto.setSlug(blog.getSlug());
		blogDto.setDmContent(blog.getDmContent());
		blogDto.setCreatedAt(Utility.getLocalDateTimeMillis(blog.getCreatedAt()));
		blogDto.setStatus(blog.getStatus());
		return blogDto;
	}
  public static List<BlogDto> convertModelToDto(List<Blog> blogList) {
    List<BlogDto> blogDtoList = new ArrayList<>();
    for (Blog blog : blogList) {
      BlogDto blogDto = convertModelToDto(blog);
      blogDtoList.add(blogDto);
    }
    return blogDtoList;
  }
}
