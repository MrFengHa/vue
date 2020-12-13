package com.home.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 文件描述
 *
 * @author 冯根源
 * @date 2020/12/13 18:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class User {
    private String id;
    private String name;
    private Integer age;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GTM+8")
    private Date bir;
}
