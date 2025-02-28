package com.lpa.common.constant;

import com.lpa.common.dto.response.IResponseStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
public enum CommonResponseStatusEnum implements IResponseStatus {
    SUCCESS("success", "Success"),
    GENERAL_ERROR("general_error", "Any error occur");

    private final String code;
    private final String message;
}
