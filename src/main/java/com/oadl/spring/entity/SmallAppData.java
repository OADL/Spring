package com.oadl.spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;

import lombok.Data;

import static com.oadl.spring.constants.Constants.SMALL_APP_DATA_TABLE_NAME;

@Data
@Entity
@Table(name = SMALL_APP_DATA_TABLE_NAME)
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class SmallAppData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String value;
}
