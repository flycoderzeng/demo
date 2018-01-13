package com.example.demo.common;

import com.example.demo.common.BaseResponse;
import com.example.demo.model.User;
import lombok.Data;

@Data
public class LoadUserResponse extends BaseResponse{
    private User data;
}
