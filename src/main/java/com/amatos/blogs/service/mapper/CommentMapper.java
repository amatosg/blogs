package com.amatos.blogs.service.mapper;

import com.amatos.blogs.domain.Comment;
import com.amatos.blogs.service.dto.CommentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {PostMapper.class, AuthorMapper.class})
public interface CommentMapper extends EntityMapper<CommentDTO, Comment> {

  @Mapping(source = "post.id", target = "postId")
  CommentDTO toDto(Comment comment);

  Comment toEntity(CommentDTO author);

  default Comment fromId(Long id) {
    if (id == null) {
      return null;
    }
    Comment comment = new Comment();
    comment.setId(id);
    return comment;
  }

}
