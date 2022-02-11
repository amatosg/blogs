package com.amatos.blogs.repository;

import com.amatos.blogs.domain.Comment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

  void deleteAllByPostId(Long id);

  List<Comment> findAllByPostId(Long id);
}
