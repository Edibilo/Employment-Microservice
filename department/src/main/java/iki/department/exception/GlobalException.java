package iki.department.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ErrorEntity> notFoundResponseEntity(ResourceNotFound notFound, WebRequest request){

        ErrorEntity errorEntity=new ErrorEntity();
        errorEntity.setErrorCode(request.getDescription(false));
        errorEntity.setMessage(notFound.getMessage());
        errorEntity.setLocalDateTime(LocalDateTime.now());
        return ResponseEntity.ok(errorEntity);
    }
}
