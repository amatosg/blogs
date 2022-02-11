package com.amatos.blogs.service;

import com.amatos.blogs.service.dto.CommentDTO;
import java.util.List;
import java.util.Optional;

public interface CommentService {

  CommentDTO save(CommentDTO authorDTO);

  List<CommentDTO> findAll();

  Optional<CommentDTO> findOne(Long id);

  void delete(Long id);

  void deleteByPostId(Long id);

  List<CommentDTO> findAllByPostId(Long id);
}
