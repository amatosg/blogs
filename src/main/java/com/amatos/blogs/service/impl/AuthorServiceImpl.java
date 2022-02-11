package com.amatos.blogs.service.impl;

import com.amatos.blogs.repository.AuthorRepository;
import com.amatos.blogs.service.AuthorService;
import com.amatos.blogs.service.BlogService;
import com.amatos.blogs.service.dto.AuthorDTO;
import com.amatos.blogs.service.mapper.AuthorMapper;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

  private final AuthorRepository repository;
  private final AuthorMapper mapper;
  private final BlogService blogService;

  public AuthorServiceImpl(AuthorRepository repository,
      AuthorMapper mapper, BlogService blogService) {
    this.repository = repository;
    this.mapper = mapper;
    this.blogService = blogService;
  }

  @Override
  public AuthorDTO save(AuthorDTO authorDTO) {
    var entity = mapper.toEntity(authorDTO);
    entity = repository.save(entity);
    return mapper.toDto(entity);
  }

  @Override
  public List<AuthorDTO> findAll() {
    return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
  }

  @Override
  public Optional<AuthorDTO> findOne(Long id) {
    return repository.findById(id).map(mapper::toDto);
  }

  @Override
  public void delete(Long id) {
    blogService.deleteByAuthorId(id);
    repository.deleteById(id);
  }

  @Override
  public Boolean isAuthorAllowedToCreateBlog(Long id) {
    var author = this.findOne(id);
    var now = LocalDate.now();
    if (author.isPresent()) {
      var birth = LocalDate.ofInstant(author.get().getBirthDate().toInstant(),
          ZoneId.systemDefault());
      Period diff = Period.between(birth, now);
      return diff.getYears() >= 18;
    }
    return false;
  }
}
