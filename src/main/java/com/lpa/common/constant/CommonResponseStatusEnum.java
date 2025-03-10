package com.lpa.common.constant;

import com.lpa.common.dto.response.IResponseStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
public enum CommonResponseStatusEnum implements IResponseStatus {
    SUCCESS("success", "Success"),
    GENERAL_ERROR("general_error", "Any error occur"),
    TIMEOUT_ERROR("general_error", "Meet timeout error when calling other api"),
    NOT_FOUND_ERROR("invalid_request", "The [%s] is not found"),
    EXIST_ERROR("invalid_request", "The [%s] already exists"),
    FIELD_INVALID("invalid_request", "Field [%s] is invalid"),
    ;
    private final String code;
    private final String message;
}
