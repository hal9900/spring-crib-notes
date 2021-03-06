package keel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

// example-start
@ControllerAdvice
public class ErrorControllerAdvice {

    private final Logger LOGGER = LoggerFactory.getLogger(ErrorControllerAdvice.class);

    /**
     * 楽観ロック例外が発生した場合は、HTTPステータスコードに409を設定します。
     *
     * @param e 楽観ロック例外
     */
    @ExceptionHandler(OptimisticLockingFailureException.class)
    @ResponseStatus(value = HttpStatus.CONFLICT, reason = "楽観排他エラー")
    public void optimisticLockingFailureExceptionHandler(OptimisticLockingFailureException e) {
        LOGGER.debug("排他制御エラーが発生しました", e);
    }
}
// example-end