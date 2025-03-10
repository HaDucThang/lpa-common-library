package com.lpa.common.exception;

import com.lpa.common.constant.CommonResponseStatusEnum;
import com.lpa.common.factory.ResponseFactory;
import com.lpa.common.utils.LpaStringUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseBody
@RequiredArgsConstructor
@Slf4j
public class ExceptionHandlerController {

    private final ResponseFactory responseFactory;

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<?> handleValidationException(ValidationException e) {
        return responseFactory.error(e.getHttpStatus(), e.getErrorCode(), e.getErrorMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception e) {
        return responseFactory.error(HttpStatus.INTERNAL_SERVER_ERROR, CommonResponseStatusEnum.GENERAL_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        try {
            if (ex.getBindingResult().hasFieldErrors()) {
                FieldError fieldError = ex.getBindingResult().getFieldError();
                String message = String.format(CommonResponseStatusEnum.FIELD_INVALID.getMessage(), LpaStringUtil.toSnakeCase(fieldError.getField()));
                return responseFactory.error(HttpStatus.BAD_REQUEST, CommonResponseStatusEnum.FIELD_INVALID.getCode(), message);
            }
        } catch (Exception exception) {
            log.error("Error:", exception);
        }
        return responseFactory.error(HttpStatus.INTERNAL_SERVER_ERROR, CommonResponseStatusEnum.GENERAL_ERROR);
    }
}
