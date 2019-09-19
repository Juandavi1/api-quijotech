package com.sumasaas.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTOMongoExample {
    private Integer userId;
    private String id;
    private String title;
    private String body;
}