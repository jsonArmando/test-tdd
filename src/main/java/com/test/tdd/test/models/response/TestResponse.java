package com.test.tdd.test.models.response;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.*;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TestResponse implements Serializable{
    private int code;
    private String name;
    private Date date;
    private boolean active;
    private String status;
    private String message;
}
