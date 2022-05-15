package com.cherry.handler;

import com.cherry.common.dtos.CommonResult;
import com.cherry.common.enums.ErrorCodeEnum;
import com.cherry.common.exception.CherryBusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = CherryBusinessException.class)
    public CommonResult cherryExceptionHandler(CherryBusinessException exception) {
        log.error(exception.getMessage(), exception);
        return CommonResult.defineException(exception);
    }

    @ExceptionHandler(value = Exception.class)
    public CommonResult exceptionHandler(Exception exception) {
        log.error(exception.getMessage(), exception);
        return CommonResult.undefineException(ErrorCodeEnum.INTERNAL_SERVER_ERROR);
    }
}
