package com.sumasaas.remote;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RemotePost {
    private Integer userId;
    private Integer id;
    private String title;
    private String body;
}

