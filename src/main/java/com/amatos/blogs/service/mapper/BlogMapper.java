package com.amatos.blogs.service.mapper;

import com.amatos.blogs.domain.Blog;
import com.amatos.blogs.service.dto.BlogDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {PostMapper.class, AuthorMapper.class})
public interface BlogMapper extends EntityMapper<BlogDTO, Blog> {

  @Mapping(source = "author.id", target = "authorId")
  @Mapping(source = "status", target = "status")
  BlogDTO toDto(Blog blog);

  @Mapping(source = "authorId", target = "author")
  Blog toEntity(BlogDTO blog);

  default Blog fromId(Long id) {
    if (id == null) {
      return null;
    }
    Blog blog = new Blog();
    blog.setId(id);
    return blog;
  }

}
