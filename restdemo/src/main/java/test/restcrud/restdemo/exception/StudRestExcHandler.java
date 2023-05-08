package test.restcrud.restdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import test.restcrud.restdemo.entity.StudErrResp;

@ControllerAdvice
public class StudRestExcHandler {
    @ExceptionHandler
    public ResponseEntity<StudErrResp> handleException(StudNotFoundExc e) {
        StudErrResp ser = new StudErrResp();
        ser.setStatus(HttpStatus.NOT_FOUND.value());
        ser.setMessage(e.getMessage());
        ser.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(ser, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudErrResp> handleException(Exception e) {
        StudErrResp ser = new StudErrResp();
        ser.setStatus(HttpStatus.BAD_REQUEST.value());
        ser.setMessage(e.getMessage());
        ser.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(ser, HttpStatus.BAD_REQUEST);
    }
}
