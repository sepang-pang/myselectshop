package com.sparta.myselectshop.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserInfoParam {
    String username;
    boolean isAdmin;
}