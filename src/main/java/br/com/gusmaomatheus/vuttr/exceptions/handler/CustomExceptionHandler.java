package br.com.gusmaomatheus.vuttr.exceptions.handler;

import br.com.gusmaomatheus.vuttr.exceptions.customs.auth.InvalidPasswordException;
import br.com.gusmaomatheus.vuttr.exceptions.customs.auth.UsernameAlreadyExistsException;
import br.com.gusmaomatheus.vuttr.exceptions.customs.auth.UserUsernameNotFoundException;
import br.com.gusmaomatheus.vuttr.exceptions.customs.tool.TitleAlreadyExistsException;
import br.com.gusmaomatheus.vuttr.exceptions.customs.tool.ToolNotFoundException;
import br.com.gusmaomatheus.vuttr.exceptions.response.CustomExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ToolNotFoundException.class)
    private ResponseEntity<CustomExceptionResponse> toolNotFound(ToolNotFoundException exception) {
        CustomExceptionResponse response = new CustomExceptionResponse(
                HttpStatus.NOT_FOUND.value(),
                exception.getMessage(),
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(TitleAlreadyExistsException.class)
    private ResponseEntity<CustomExceptionResponse> titleAlreadyExists(TitleAlreadyExistsException exception) {
        CustomExceptionResponse response = new CustomExceptionResponse(
                HttpStatus.BAD_REQUEST.value(),
                exception.getMessage(),
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(UsernameAlreadyExistsException.class)
    public ResponseEntity<CustomExceptionResponse> usernameAlreadyExists(UsernameAlreadyExistsException exception) {
        CustomExceptionResponse response = new CustomExceptionResponse(
                HttpStatus.BAD_REQUEST.value(),
                exception.getMessage(),
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(UserUsernameNotFoundException.class)
    public ResponseEntity<CustomExceptionResponse> usernameNotFound(UserUsernameNotFoundException exception) {
        CustomExceptionResponse response = new CustomExceptionResponse(
                HttpStatus.NOT_FOUND.value(),
                exception.getMessage(),
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(InvalidPasswordException.class)
    public ResponseEntity<CustomExceptionResponse> invalidPassword(InvalidPasswordException exception) {
        CustomExceptionResponse response = new CustomExceptionResponse(
                HttpStatus.FORBIDDEN.value(),
                exception.getMessage(),
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
    }
}
