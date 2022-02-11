package com.amatos.blogs.controller;

import com.amatos.blogs.service.AuthorService;
import com.amatos.blogs.service.dto.AuthorDTO;
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
@RequestMapping("/author/")
public class AuthorController {

  private final AuthorService service;

  public AuthorController(AuthorService service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<List<AuthorDTO>> findAll() {
    var list = this.service.findAll();
    return ResponseEntity.ok(list);
  }

  @PostMapping
  public ResponseEntity<AuthorDTO> createAuthor(@RequestBody AuthorDTO authorDTO)
      throws URISyntaxException {
    if (null != authorDTO.getId()) {
      return ResponseEntity.badRequest().build();
    }
    var response = this.service.save(authorDTO);
    return ResponseEntity.created(new URI("/author/" + response.getId())).body(response);
  }

  @PutMapping
  public ResponseEntity<AuthorDTO> updateAuthor(@RequestBody AuthorDTO authorDTO) {
    if (null == authorDTO.getId()) {
      return ResponseEntity.badRequest().build();
    }
    var response = this.service.save(authorDTO);
    return ResponseEntity.ok(response);
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
    this.service.delete(id);
    return ResponseEntity.noContent().build();
  }
}
