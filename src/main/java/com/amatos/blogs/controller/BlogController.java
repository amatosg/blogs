package com.amatos.blogs.controller;

import com.amatos.blogs.service.AuthorService;
import com.amatos.blogs.service.BlogService;
import com.amatos.blogs.service.dto.BlogDTO;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blog/")
public class BlogController {

  private final BlogService service;
  private final AuthorService authorService;

  public BlogController(BlogService service, AuthorService authorService) {
    this.service = service;
    this.authorService = authorService;
  }

  @GetMapping
  public ResponseEntity<List<BlogDTO>> getAll() {
    var list = service.findAll();
    return ResponseEntity.ok(list);
  }

  @GetMapping("author/{id}")
  public ResponseEntity<List<BlogDTO>> getByAuthor(@PathVariable("id") Long id) {
    var list = service.findByAuthorId(id);
    return ResponseEntity.ok(list);
  }

  @PostMapping
  public ResponseEntity<BlogDTO> createBlog(@RequestBody BlogDTO blogDTO)
      throws URISyntaxException {
    if (null != blogDTO.getId()) {
      return ResponseEntity.badRequest().build();
    }
    var count = service.countByAuthorId(blogDTO.getAuthorId());
    var isAuthorAllowed = authorService.isAuthorAllowedToCreateBlog(blogDTO.getAuthorId());
    if (count > 3 || Boolean.FALSE.equals(isAuthorAllowed)) {
      return ResponseEntity.badRequest().build();
    }
    var response = this.service.save(blogDTO);
    return ResponseEntity.created(new URI("/blog/" + response.getId())).body(response);
  }

  @PutMapping
  public ResponseEntity<BlogDTO> updateBlog(@RequestBody BlogDTO blogDTO) {
    if (null == blogDTO.getId()) {
      return ResponseEntity.badRequest().build();
    }
    var response = this.service.save(blogDTO);
    return ResponseEntity.ok(response);
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
    this.service.delete(id);
    return ResponseEntity.noContent().build();
  }
}
