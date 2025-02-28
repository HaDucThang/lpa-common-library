package com.lpa.common.exception;

import com.lpa.common.constant.CommonResponseStatusEnum;
import com.lpa.common.factory.ResponseFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseBody
@RequiredArgsConstructor
@Slf4j
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    private final ResponseFactory responseFactory;

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<?> handleValidationException(ValidationException e) {
        log.error("handleValidationException", e);
        return responseFactory.error(HttpStatus.BAD_REQUEST, e.getErrorCode(), e.getErrorMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception e) {
        log.error("handleException", e);
        return responseFactory.error(HttpStatus.INTERNAL_SERVER_ERROR, CommonResponseStatusEnum.GENERAL_ERROR);
    }
}
