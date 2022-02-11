package com.amatos.blogs.service;

import com.amatos.blogs.service.dto.AuthorDTO;
import java.util.List;
import java.util.Optional;

public interface AuthorService {

  AuthorDTO save(AuthorDTO authorDTO);

  List<AuthorDTO> findAll();

  Optional<AuthorDTO> findOne(Long id);

  void delete(Long id);

  Boolean isAuthorAllowedToCreateBlog(Long id);
}
