package com.cherry.repositories;

import com.cherry.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author : 翁鑫豪
 * @Date : 2022/1/30 22:22
 * @Description: DepartmentRepository
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
