package com.amatos.blogs.controller;

import com.amatos.blogs.service.CommentService;
import com.amatos.blogs.service.PostService;
import com.amatos.blogs.service.dto.CommentDTO;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment/")
public class CommentController {

  private final CommentService service;
  private final PostService postService;


  public CommentController(CommentService service, PostService postService) {
    this.service = service;
    this.postService = postService;
  }

  @GetMapping
  public ResponseEntity<List<CommentDTO>> findAll() {
    var list = this.service.findAll();
    return ResponseEntity.ok(list);
  }

  @GetMapping("post/{id}")
  public ResponseEntity<List<CommentDTO>> findAllByPost(@PathVariable("id") Long id) {
    var list = this.service.findAllByPostId(id);
    return ResponseEntity.ok(list);
  }

  @PostMapping
  public ResponseEntity<CommentDTO> createComment(@RequestBody CommentDTO commentDTO)
      throws URISyntaxException {
    boolean isPostPublished = postService.isPostPublished(commentDTO.getPostId());
    if (null == commentDTO.getName() || null == commentDTO.getPostId() || !isPostPublished) {
      return ResponseEntity.badRequest().build();
    }
    var result = service.save(commentDTO);
    return ResponseEntity.created(new URI("/comment/" + result.getId())).body(result);
  }
}
