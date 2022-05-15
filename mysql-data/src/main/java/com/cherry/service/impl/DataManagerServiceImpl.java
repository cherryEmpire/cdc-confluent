package com.cherry.service.impl;

import com.cherry.common.dtos.CommonResult;
import com.cherry.entities.Department;
import com.cherry.entities.User;
import com.cherry.repositories.DepartmentRepository;
import com.cherry.repositories.UserRepository;
import com.cherry.service.DataManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : 翁鑫豪
 * @Date : 2022/1/30 16:32
 * @Description: DataManagerServiceImpl
 */
@Service
public class DataManagerServiceImpl implements DataManagerService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public CommonResult<List> listData(int page, int size) {
        return null;
    }

    @Override
    public CommonResult<String> initData() {
//        initDepartment();
//        initUser();
        return CommonResult.succeed("init success");
    }

    private void initUser() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            User user = new User();
            user.setName("Name" + i);
            user.setType("Type" + i);
            int x = i + 7;
            if (x >= 7 && x <= 106) {
                user.setDepartment((long) x);
            } else {
                x = x % 106;
                user.setDepartment((long) x);
            }
            user.setLevel("Level" + i);
            user.setPassword("Name" + i + "-123456");
            users.add(user);
        }
        userRepository.saveAll(users);
    }

    private User createUser() {
        User user = new User();
        return user;
    }

    private void initDepartment() {
        List<Department> departments = new ArrayList<>();
        int index = 1;
        departments.add(createDepartment(index, null, "总公司", "type-总公司", "address-总公司"));

        for (int i = 2; i < 33; i++) {
            index++;
            departments.add(createDepartment(index, 1, "分公司" + i, "type-分公司" + i, "address-分公司" + i));
        }

        for (int i = 2; i < 33; i++) {
            for (int j = 0; j <= 100; j++) {
                index++;
                departments.add(createDepartment(index, i, "分公司" + i + "-" + "子部门" + j, "type-分公司" + i + "-" + "子部门" + j, "address-分公司" + i + "-" + "子部门" + j));
            }
        }
        departmentRepository.saveAll(departments);
    }

    private Department createDepartment(Integer id, Integer parentId, String name, String type, String address) {
        Department department = new Department();
        department.setId((long) id);
        if (parentId != null) {
            department.setParent((long) parentId);
        }
        department.setName(name);
        department.setType(type);
        department.setDescription(address);
        return department;
    }

}
