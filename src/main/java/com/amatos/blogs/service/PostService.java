package com.amatos.blogs.service;

import com.amatos.blogs.service.dto.PostDTO;
import java.util.List;
import java.util.Optional;

public interface PostService {

  PostDTO save(PostDTO authorDTO);

  List<PostDTO> findAll();

  Optional<PostDTO> findOne(Long id);

  void delete(Long id);

  List<PostDTO> findAllByBlogId(Long id);

  void deleteByBlogId(Long id);

  boolean isPostPublished(Long postId);
}
