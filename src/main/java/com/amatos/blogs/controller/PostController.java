package com.amatos.blogs.controller;

import com.amatos.blogs.service.BlogService;
import com.amatos.blogs.service.PostService;
import com.amatos.blogs.service.dto.PostDTO;
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
@RequestMapping("/post/")
public class PostController {

  private final PostService service;
  private final BlogService blogService;

  public PostController(PostService service, BlogService blogService) {
    this.service = service;
    this.blogService = blogService;
  }

  @GetMapping
  public ResponseEntity<List<PostDTO>> findAll() {
    var list = this.service.findAll();
    return ResponseEntity.ok(list);
  }

  @GetMapping("blog/{id}")
  public ResponseEntity<List<PostDTO>> findAllByBlog(@PathVariable("id") Long id) {
    var list = this.service.findAllByBlogId(id);
    return ResponseEntity.ok(list);
  }

  @PostMapping
  public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO)
      throws URISyntaxException {
    if (null != postDTO.getId() || blogService.isBlogInactive(postDTO.getBlogId())) {
      return ResponseEntity.badRequest().build();
    }
    var response = this.service.save(postDTO);
    if (null == response) {
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.created(new URI("/author/" + response.getId())).body(response);
  }

  @PutMapping
  public ResponseEntity<PostDTO> updatePost(@RequestBody PostDTO postDTO) {
    if (null == postDTO.getId()) {
      return ResponseEntity.badRequest().build();
    }
    var response = this.service.save(postDTO);
    return ResponseEntity.ok(response);
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
    this.service.delete(id);
    return ResponseEntity.noContent().build();
  }
}
