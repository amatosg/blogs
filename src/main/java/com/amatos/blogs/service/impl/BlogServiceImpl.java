package com.amatos.blogs.service.impl;

import com.amatos.blogs.repository.BlogRepository;
import com.amatos.blogs.service.BlogService;
import com.amatos.blogs.service.PostService;
import com.amatos.blogs.service.dto.BlogDTO;
import com.amatos.blogs.service.mapper.BlogMapper;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService {

  private static final String ACTIVE = "activo";
  private static final String INACTIVE = "inactivo";

  private final BlogRepository repository;
  private final BlogMapper mapper;
  private final PostService postService;

  public BlogServiceImpl(BlogRepository repository,
      BlogMapper mapper, PostService postService) {
    this.repository = repository;
    this.mapper = mapper;
    this.postService = postService;
  }


  @Override
  public BlogDTO save(BlogDTO blogDTO) {
    var entity = mapper.toEntity(blogDTO);
    if (null == entity.getStatus()) {
      entity.setStatus(ACTIVE);
    }
    entity = repository.save(entity);
    return mapper.toDto(entity);
  }

  @Override
  public List<BlogDTO> findAll() {
    return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
  }

  @Override
  public Optional<BlogDTO> findOne(Long id) {
    return repository.findById(id).map(mapper::toDto);
  }

  @Override
  public void delete(Long id) {
    repository.deleteById(id);
  }

  @Override
  public void deleteByAuthorId(Long id) {
    var blogsToDelete = repository.getAllByAuthorId(id);
    blogsToDelete.forEach(blog -> {
      postService.deleteByBlogId(blog.getId());
      this.delete(blog.getId());
    });
  }

  @Override
  public Integer countByAuthorId(Long id) {
    return repository.countAllByAuthorId(id);
  }

  @Override
  public boolean isBlogInactive(Long blogId) {
    var blog = findOne(blogId);
    return blog.map(blogDTO -> blogDTO.getStatus().equalsIgnoreCase(INACTIVE)).orElse(false);
  }

  @Override
  public List<BlogDTO> findByAuthorId(Long id) {
    return repository.getAllByAuthorId(id).stream().map(mapper::toDto).collect(Collectors.toList());
  }
}
