package com.lpa.common.exception;

import com.lpa.common.dto.ApiResponse;
import com.lpa.common.dto.response.IResponseStatus;
import java.io.Serial;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ValidationException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -320312093541221100L;
    private static final Logger log = LoggerFactory.getLogger(ValidationException.class);

    HttpStatus httpStatus;
    String errorCode;
    String errorMessage;

    public ValidationException(HttpStatus httpStatus, String errorCode, String errorMessage) {
        super(errorMessage);
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public ValidationException(IResponseStatus responseStatus, String... params) {
        super(String.format(responseStatus.getMessage(), params));
        this.httpStatus = HttpStatus.BAD_REQUEST;
        this.errorCode = responseStatus.getCode();
        this.errorMessage = String.format(responseStatus.getMessage(), params);
    }
}
