package sofplan.softplayer.api.v1.exceptionhandler;

import javassist.NotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import sofplan.softplayer.domain.exception.PeopleNotFoundException;
import sofplan.softplayer.domain.exception.PeopleNotFoundExceptionDetails;

import java.time.LocalDateTime;

@ControllerAdvice
@Log4j2
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<PeopleNotFoundExceptionDetails> handleBadRequestException(PeopleNotFoundException nfe) {
        return new ResponseEntity<>(
                PeopleNotFoundExceptionDetails.builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.NOT_FOUND.value())
                        .title("Registro não encontrado")
                        .details(nfe.getMessage())
                        .developerMessage(nfe.getClass().getName())
                        .build(), HttpStatus.NOT_FOUND);
    }
}