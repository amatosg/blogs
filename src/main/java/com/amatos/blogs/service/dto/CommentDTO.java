package com.amatos.blogs.service.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CommentDTO {

  private Long id;

  private Date date;

  private String name;

  private String status;

  private Long postId;
}
