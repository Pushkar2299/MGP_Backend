package com.game.gadev.vo;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

public class UserVO {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String username;

    private String mobileNumber;

    private Boolean isActive;

    private String profileImage;
    private String device;


    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
