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
public class AuthorDTO {

  private Long id;
  private String name;
  private String email;
  private String phone;
  private Date birthDate;

}
