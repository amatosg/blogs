package com.amatos.blogs.service.mapper;

import com.amatos.blogs.domain.Author;
import com.amatos.blogs.service.dto.AuthorDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface AuthorMapper extends EntityMapper<AuthorDTO, Author> {

  Author toEntity(AuthorDTO author);

  default Author fromId(Long id) {
    if (id == null) {
      return null;
    }
    Author author = new Author();
    author.setId(id);
    return author;
  }

}
