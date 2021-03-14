package com.example.restcontroller;

import com.example.restcontroller.board.exception.BoardTypeNotFoundException;
import com.example.restcontroller.notice.exception.AlreadyDeletedException;
import com.example.restcontroller.notice.exception.DuplicateNoticeException;
import com.example.restcontroller.notice.exception.NoticeNotFoundException;
import com.example.restcontroller.user.exception.ExistsEmailException;
import com.example.restcontroller.user.exception.PasswordNotMatchException;
import com.example.restcontroller.user.exception.UserNotFoundException;
import com.example.restcontroller.user.model.ResponseMessage;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ NoticeNotFoundException.class,
                        DuplicateNoticeException.class,
                        UserNotFoundException.class,
                        ExistsEmailException.class,
                        PasswordNotMatchException.class,
                        BoardTypeNotFoundException.class })
    public ResponseEntity<?> badRequest(RuntimeException e) {
        return new ResponseEntity<>(ResponseMessage.fail(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<?> internalServerError(DataIntegrityViolationException e) {
        return new ResponseEntity<>("회원 가입 실패", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(AlreadyDeletedException.class)
    public ResponseEntity<?> ok(AlreadyDeletedException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> exception(Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
    }
}