package com.amatos.blogs.service.mapper;

import com.amatos.blogs.domain.Post;
import com.amatos.blogs.service.dto.PostDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CommentMapper.class, BlogMapper.class})
public interface PostMapper extends EntityMapper<PostDTO, Post> {

  @Mapping(source = "blog.id", target = "blogId")
  PostDTO toDto(Post post);

  @Mapping(source = "blogId", target = "blog")
  Post toEntity(PostDTO author);

  default Post fromId(Long id) {
    if (id == null) {
      return null;
    }
    Post comment = new Post();
    comment.setId(id);
    return comment;
  }

}
