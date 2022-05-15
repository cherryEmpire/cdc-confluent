package com.cherry.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author : 翁鑫豪
 * @Date : 2022/1/30 22:01
 * @Description: User
 */
@Entity(name = "user_master")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_type")
    private String type;

    @Column(name = "user_level")
    private String level;

    @Column(name = "department_id")
    private Long department;

    @Column(name = "password")
    private String password;

}
