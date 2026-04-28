package com.example.demo.entity;

import lombok.Data;
import java.util.Date;

@Data
public class User {

    // ID
    private Long id;

    // name
    private String name;

    // address
    private String address;

    // telephone number
    private String phone;

    // 更新日時
    private Date updateDate;

    // 登録日時
    private Date createDate;

    // 削除日時
    private Date deleteDate;
}