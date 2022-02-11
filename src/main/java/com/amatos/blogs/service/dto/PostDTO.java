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
public class PostDTO {

  private Long id;

  private String title;

  private Date date;

  private String status;

  private String content;

  private Long blogId;
}
