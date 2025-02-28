package com.lpa.common.factory;

import com.lpa.common.constant.CommonResponseStatusEnum;
import com.lpa.common.dto.ApiResponse;
import com.lpa.common.dto.response.IResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseFactory {

    public ResponseEntity<?> success() {
        ApiResponse<?> apiResponse = new ApiResponse<>();
        apiResponse.setCode(CommonResponseStatusEnum.SUCCESS.getCode());
        apiResponse.setMessage(CommonResponseStatusEnum.SUCCESS.getMessage());
        return ResponseEntity.ok(apiResponse);
    }

    public <T> ResponseEntity<ApiResponse<T>> success(T t) {
        ApiResponse<T> apiResponse = new ApiResponse<>();
        apiResponse.setCode(CommonResponseStatusEnum.SUCCESS.getCode());
        apiResponse.setMessage(CommonResponseStatusEnum.SUCCESS.getMessage());
        apiResponse.setData(t);
        return ResponseEntity.ok(apiResponse);
    }

    public <T> ResponseEntity<ApiResponse<T>> error(HttpStatus httpStatus, IResponseStatus responseStatus) {
        return error(httpStatus, responseStatus.getCode(), responseStatus.getMessage());
    }

    public <T> ResponseEntity<ApiResponse<T>> error(HttpStatus httpStatus, String errorCode, String errorMessage) {
        ApiResponse<T> apiResponse = new ApiResponse<>();
        apiResponse.setCode(errorCode);
        apiResponse.setMessage(errorMessage);
        return new ResponseEntity<>(apiResponse, httpStatus);
    }
}
