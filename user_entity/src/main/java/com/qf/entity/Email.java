package com.qf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @version 1.0
 * @userzhangliang
 * @date2019/6/29 19:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Email implements Serializable {
    private String email;

}
