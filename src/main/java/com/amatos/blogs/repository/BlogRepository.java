package com.amatos.blogs.repository;

import com.amatos.blogs.domain.Blog;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {

  void deleteByAuthorId(Long id);

  List<Blog> getAllByAuthorId(Long id);

  Integer countAllByAuthorId(Long id);
}
