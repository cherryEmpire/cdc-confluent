package com.cherry.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author : 翁鑫豪
 * @Date : 2022/1/30 22:02
 * @Description: Department
 */
@Entity(name = "depart_master")
@Data
public class Department implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "depart_id")
    private Long id;

    @Column(name = "depart_name")
    private String name;

    @Column(name = "parent")
    private Long parent;

    @Column(name = "depart_type")
    private String type;

    @Column(name = "description")
    private String description;

}
