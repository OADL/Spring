package com.oadl.spring.entity;

import lombok.Data;

import javax.persistence.*;

import static com.oadl.spring.constants.Constants.APP_DATA_TABLE_NAME;

@Data
@Entity
@Table(name = APP_DATA_TABLE_NAME)
public class AppData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private SmallAppData smallAppData;

}
