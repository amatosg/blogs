package com.amatos.blogs.service.impl;

import com.amatos.blogs.repository.PostRepository;
import com.amatos.blogs.service.CommentService;
import com.amatos.blogs.service.PostService;
import com.amatos.blogs.service.dto.PostDTO;
import com.amatos.blogs.service.mapper.PostMapper;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PostServiceImpl implements PostService {

  private static final String DRAFT = "borrador";
  private static final String PUBLISHED = "publicado";

  private final PostRepository repository;
  private final PostMapper mapper;
  private final CommentService commentService;

  public PostServiceImpl(PostRepository repository,
      PostMapper mapper, CommentService commentService) {
    this.repository = repository;
    this.mapper = mapper;
    this.commentService = commentService;
  }

  @Override
  public PostDTO save(PostDTO postDTO) {
    var entity = mapper.toEntity(postDTO);
    var possiblePostsOnSameDay = repository.findByBlogIdAndDateEquals(postDTO.getBlogId(),
        postDTO.getDate());
    if (possiblePostsOnSameDay.isEmpty()) {
      entity = repository.save(entity);
      return mapper.toDto(entity);
    }
    return null;
  }

  @Override
  public List<PostDTO> findAll() {
    return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
  }

  @Override
  public Optional<PostDTO> findOne(Long id) {
    return repository.findById(id).map(mapper::toDto);
  }

  @Override
  public void delete(Long id) {
    repository.deleteById(id);
  }

  @Override
  public List<PostDTO> findAllByBlogId(Long id) {
    return repository.findByBlogId(id).stream().map(mapper::toDto).collect(Collectors.toList());
  }

  @Override
  @Transactional
  public void deleteByBlogId(Long id) {
    var postsToDelete = repository.findByBlogId(id);
    postsToDelete.forEach(post -> {
      commentService.deleteByPostId(post.getId());
      this.delete(post.getId());
    });
  }

  @Override
  public boolean isPostPublished(Long postId) {
    var post = this.findOne(postId);
    return post.map(p -> p.getStatus().equalsIgnoreCase(PUBLISHED)).orElse(false);
  }
}
