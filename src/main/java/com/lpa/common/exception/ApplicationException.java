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
public class ApplicationException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -320312093541221100L;
    private static final Logger log = LoggerFactory.getLogger(ApplicationException.class);

    HttpStatus httpStatus;
    String errorCode;
    String errorMessage;

    public ApplicationException(IResponseStatus responseStatus) {
        super(responseStatus.getMessage());
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        this.errorCode = responseStatus.getCode();
        this.errorMessage = responseStatus.getMessage();
    }

    public ApplicationException(HttpStatus httpStatus, IResponseStatus responseStatus) {
        super(responseStatus.getMessage());
        this.httpStatus = httpStatus;
        this.errorCode = responseStatus.getCode();
        this.errorMessage = responseStatus.getMessage();
    }
}
