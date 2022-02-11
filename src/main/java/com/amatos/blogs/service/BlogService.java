package com.amatos.blogs.service;

import com.amatos.blogs.service.dto.BlogDTO;
import java.util.List;
import java.util.Optional;

public interface BlogService {

  BlogDTO save(BlogDTO authorDTO);

  List<BlogDTO> findAll();

  Optional<BlogDTO> findOne(Long id);

  void delete(Long id);

  void deleteByAuthorId(Long id);

  Integer countByAuthorId(Long id);

  boolean isBlogInactive(Long blogId);

  List<BlogDTO> findByAuthorId(Long id);
}
