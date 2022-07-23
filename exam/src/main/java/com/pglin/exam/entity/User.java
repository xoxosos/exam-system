package com.pglin.exam.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author LinRenJie
 * @version 1.0.0
 * @ClassName User.java
 * @Description TODO
 * @createTime 2022年07月23日
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String username;
    private String password;
}
