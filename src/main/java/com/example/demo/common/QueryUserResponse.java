package com.example.demo.common;

import com.example.demo.common.BaseResponse;
import com.example.demo.common.QueryResponseData;
import lombok.Data;

@Data
public class QueryUserResponse extends BaseResponse {
    private QueryResponseData data;
}
