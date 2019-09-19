package com.sumasaas.repository.entities;

import lombok.Data;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class PostMongoExample extends BaseEntity {

    @TextIndexed
    private Integer userId;

    private String title;

    private String body;
}
