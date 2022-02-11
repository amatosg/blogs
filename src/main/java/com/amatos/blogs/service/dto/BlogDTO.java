package com.amatos.blogs.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class BlogDTO {

  private Long id;

  private String name;

  private String description;

  private String url;

  private String status;

  private Long authorId;
}
