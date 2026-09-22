package iki.employee.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorEntity> resourceNotFound(WebRequest request,
                                                        ResourceNotFoundException notFoundException){
        ErrorEntity errorEntity=new ErrorEntity();
        errorEntity.setMessage(notFoundException.getMessage());
        errorEntity.setErrorCode(request.getDescription(false));
        errorEntity.setLocalDateTime(LocalDateTime.now());
        return ResponseEntity.ok(errorEntity);
    }
    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<ErrorEntity> alreadyFound(WebRequest request,AlreadyExistException alreadyExistException){
        ErrorEntity errorEntity=new ErrorEntity();
        errorEntity.setLocalDateTime(LocalDateTime.now());
        errorEntity.setMessage(alreadyExistException.getMessage());
        errorEntity.setErrorCode(request.getDescription(false));
        return ResponseEntity.ok(errorEntity);
    }
}
