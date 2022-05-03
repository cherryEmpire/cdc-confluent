package com.cherry.repositories;

import com.cherry.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author : 翁鑫豪
 * @Date : 2022/1/30 22:20
 * @Description: UserRepository
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
