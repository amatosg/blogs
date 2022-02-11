package com.amatos.blogs.repository;

import com.amatos.blogs.domain.Post;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

  List<Post> findByBlogId(Long id);

  List<Post> findByBlogIdAndDateEquals(Long blogId, Date date);
}
