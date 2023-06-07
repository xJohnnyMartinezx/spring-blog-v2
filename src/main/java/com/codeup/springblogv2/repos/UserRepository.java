package com.codeup.springblogv2.repos;

import com.codeup.springblogv2.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
