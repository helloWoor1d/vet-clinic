package ru.clinic.vetclinic.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ProblemDetail handleAccessDeniedException(final AccessDeniedException ex) {
        ProblemDetail detail = ProblemDetail.forStatusAndDetail(HttpStatus.FORBIDDEN, ex.getMessage());
        detail.setTitle(HttpStatus.FORBIDDEN.getReasonPhrase());
        return detail;
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public ProblemDetail handleNotFoundException(final NotFoundException ex) {
        ProblemDetail detail = ProblemDetail.forStatusAndDetail(NOT_FOUND, ex.getMessage());
        detail.setTitle(NOT_FOUND.getReasonPhrase());
        return detail;
    }

    @ExceptionHandler({IllegalArgumentException.class})
    @ResponseStatus(BAD_REQUEST)
    public ProblemDetail handleIllegalArgumentException(final RuntimeException ex) {
        ProblemDetail detail = ProblemDetail.forStatusAndDetail(BAD_REQUEST, ex.getMessage());
        detail.setTitle(BAD_REQUEST.getReasonPhrase());
        return detail;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(BAD_REQUEST)
    public ProblemDetail handleNotValidException(final MethodArgumentNotValidException ex) {
        ProblemDetail detail = ProblemDetail
                .forStatusAndDetail(BAD_REQUEST, ex.getBindingResult().getFieldError().getDefaultMessage());
        detail.setTitle(BAD_REQUEST.getReasonPhrase());
        return detail;
    }
}
