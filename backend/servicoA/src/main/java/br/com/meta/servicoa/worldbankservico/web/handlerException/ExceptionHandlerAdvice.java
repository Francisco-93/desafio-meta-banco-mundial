package br.com.meta.servicoa.worldbankservico.web.handlerException;

import br.com.meta.servicoa.worldbankservico.service.exceptions.PageNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(PageNotFoundException.class)
    public ResponseEntity<DefaultError> pageNotFound(PageNotFoundException e, HttpServletRequest request){
        DefaultError erro = new DefaultError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), Instant.now(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<DefaultError> dataIntegrity(Exception e, HttpServletRequest request){
        DefaultError erro = new DefaultError(HttpStatus.BAD_REQUEST.value(), "Erro inesperado: " + e.getMessage(), Instant.now(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

}
