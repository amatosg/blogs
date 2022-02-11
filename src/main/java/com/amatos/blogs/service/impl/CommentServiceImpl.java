package com.amatos.blogs.service.impl;

import com.amatos.blogs.repository.CommentRepository;
import com.amatos.blogs.service.CommentService;
import com.amatos.blogs.service.dto.CommentDTO;
import com.amatos.blogs.service.mapper.CommentMapper;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommentServiceImpl implements CommentService {

  private final CommentRepository repository;
  private final CommentMapper mapper;

  public CommentServiceImpl(CommentRepository repository,
      CommentMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  @Override
  public CommentDTO save(CommentDTO commentDTO) {
    var entity = mapper.toEntity(commentDTO);
    entity = repository.save(entity);
    return mapper.toDto(entity);
  }

  @Override
  public List<CommentDTO> findAll() {
    return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
  }

  @Override
  public Optional<CommentDTO> findOne(Long id) {
    return repository.findById(id).map(mapper::toDto);
  }

  @Override
  public void delete(Long id) {
    repository.deleteById(id);
  }

  @Override
  @Transactional
  public void deleteByPostId(Long id) {
    repository.deleteAllByPostId(id);
  }

  @Override
  public List<CommentDTO> findAllByPostId(Long id) {
    return repository.findAllByPostId(id).stream().map(mapper::toDto).collect(Collectors.toList());
  }
}
