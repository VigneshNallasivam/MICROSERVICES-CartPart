package com.spring.cartpart.exception;

import com.spring.cartpart.dto.ResponseCartDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class CartExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseCartDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<ObjectError> objectErrorList = ex.getBindingResult().getAllErrors();
        List<String> errorMsg = objectErrorList.stream().map(e -> e.getDefaultMessage()).collect(Collectors.toList());
        ResponseCartDTO responseCartDTO = new ResponseCartDTO("Exception Occured..!!", errorMsg.toString());
        return new ResponseEntity<>(responseCartDTO, HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(CartException.class)
    public ResponseEntity<ResponseCartDTO> handleException(CartException ex) {
        ResponseCartDTO responseCartDTO = new ResponseCartDTO("Exception Occured..!!", ex.getMessage());
        return new ResponseEntity<>(responseCartDTO, HttpStatus.BAD_REQUEST);
    }
}
