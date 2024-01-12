package com.example.repository;

import com.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "select * from user us where us.name like %:keyword% ", nativeQuery = true)
    List<User> findByKeyword(@Param("keyword") String keyword);

}
