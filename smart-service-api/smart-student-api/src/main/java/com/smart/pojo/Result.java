package com.smart.pojo;

import lombok.Data;
import java.util.List;

@Data
public class Result {
    private String message;
    private Integer code;
    private List<String> data;
}
