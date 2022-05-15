package com.cherry.repositories;

import com.cherry.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author : 翁鑫豪
 * @Date : 2022/1/30 22:20
 * @Description: UserRepository
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * from user_master where user_name like %:key% or user_id like %:key%", nativeQuery = true)
    List<User> searchUser(@Param("key") String key);
}
