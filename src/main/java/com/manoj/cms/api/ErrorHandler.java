package com.manoj.cms.api;


import com.manoj.cms.exception.ApplicationError;
import com.manoj.cms.exception.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ErrorHandler extends ResponseEntityExceptionHandler {
    @Value("${api_doc_url}")
    public String Details;
    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ApplicationError> handleCustomerNotFoundexception(CustomerNotFoundException exception, WebRequest webRequest){
        ApplicationError error  = new ApplicationError();/// here we are constructiong applicationerror object
        error.setCode(101);
        error.setMessage(exception.getMessage());
        error.setDetails(Details);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);


    }
}
