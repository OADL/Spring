package com.oadl.spring.dto;

import com.oadl.spring.entity.SmallAppData;
import lombok.Data;

@Data
public class AppDataDTO {
    public AppDataDTO() {}

    private String name;
    private SmallAppData smallAppData;
}
