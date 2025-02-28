package com.lpa.common.exception;

import java.io.Serial;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import com.lpa.common.dto.response.IResponseStatus;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ValidationException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -320312093541221100L;

    HttpStatus httpStatus;
    String errorCode;
    String errorMessage;

    public ValidationException(HttpStatus httpStatus, String errorCode, String errorMessage) {
        super(errorMessage);
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public ValidationException(IResponseStatus responseStatus, String ... params) {
        super(String.format(responseStatus.getMessage(), params));
        this.httpStatus = HttpStatus.BAD_REQUEST;
        this.errorCode = responseStatus.getCode();
        this.errorMessage = String.format(responseStatus.getMessage(), params);;
    }
}
