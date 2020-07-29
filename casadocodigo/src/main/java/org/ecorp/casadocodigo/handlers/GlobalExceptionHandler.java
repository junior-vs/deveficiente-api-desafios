package org.ecorp.casadocodigo.handlers;

import org.ecorp.casadocodigo.exceptions.ResourceNotFoundException;
import org.ecorp.casadocodigo.handlers.exceptions.ApiError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler  {
  
  
  private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);


  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
      HttpHeaders headers, HttpStatus status, WebRequest request) {
    log.info("passando por aqui");

    ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, "Validation Error", ex);
    apiError.addValidationErrors(ex.getBindingResult().getFieldErrors());
    apiError.addValidationError(ex.getBindingResult().getGlobalErrors());
    return buildResponseEntity(apiError);

  }


  protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(
      HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status,
      WebRequest request) {
    log.info("passando por aqui");
    StringBuilder builder = new StringBuilder();
    builder.append(ex.getContentType());
    builder.append(" media type is not supported. Supported media types are ");
    ex.getSupportedMediaTypes().forEach(t -> builder.append(t).append(", "));
    return buildResponseEntity(new ApiError(HttpStatus.UNSUPPORTED_MEDIA_TYPE,
        builder.substring(0, builder.length() - 2), ex));
  }



  /**
   * Handles EntityNotFoundException. Created to encapsulate errors with more detail than
   * javax.persistence.EntityNotFoundException.
   *
   * @param ex the EntityNotFoundException
   * @return the ApiError object
   */
  @ExceptionHandler(ResourceNotFoundException.class)
  protected ResponseEntity<Object> handleEntityNotFound(ResourceNotFoundException ex) {
    ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ex);
    log.info("passando por aqui");
    return buildResponseEntity(apiError);
  }

  private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
    return new ResponseEntity<>(apiError, apiError.getStatus());
  }

}
