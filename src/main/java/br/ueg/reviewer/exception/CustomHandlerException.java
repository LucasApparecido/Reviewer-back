package br.ueg.reviewer.exception;

import br.ueg.reviewer.enums.ErrorEnum;
import br.ueg.genericarchitecture.exception.ApiResponseExceptionHandler;
import br.ueg.genericarchitecture.exception.MessageResponse;
import net.sf.jasperreports.engine.JRException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomHandlerException extends ApiResponseExceptionHandler {

    @ExceptionHandler(JRException.class)
    public ResponseEntity<MessageResponse> handleJRException(JRException ex) {
        ex.printStackTrace();
        MessageResponse messageResponse = mountMessageResponse(HttpStatus.BAD_REQUEST, ErrorEnum.PDF_ERROR);

        return ResponseEntity.status(messageResponse.getStatusCode()).body(messageResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MessageResponse> handleException(Exception ex) {
        ex.printStackTrace();
        MessageResponse messageResponse = mountMessageResponse(HttpStatus.BAD_REQUEST, ErrorEnum.GENERAL);

        return ResponseEntity.status(messageResponse.getStatusCode()).body(messageResponse);
    }
}
