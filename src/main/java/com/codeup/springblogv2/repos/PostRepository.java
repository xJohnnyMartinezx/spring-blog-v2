package com.codeup.springblogv2.repos;

import com.codeup.springblogv2.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
