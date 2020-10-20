package com.vsj.mercadolivre.handler.errors;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.databind.annotation.JsonTypeIdResolver;

@JsonTypeInfo(include = As.WRAPPER_OBJECT, use = Id.CUSTOM, property = "error", visible = true)
@JsonTypeIdResolver(LowerCaseClassNameResolver.class)
public class ApiError {

  private HttpStatus status;
  @JsonFormat(shape = STRING, pattern = "dd-MM-yyyy hh:mm:ss")
  private LocalDateTime timestamp;
  private String message;
  private String debugMessage;
  private List<ApiSubError> subErros;

  public ApiError() {
    this.timestamp = LocalDateTime.now();
  }

  public ApiError(HttpStatus status, String message, Throwable ex) {
    this();
    this.status = status;
    this.message = message;
    this.debugMessage = ex.getLocalizedMessage();
  }


  public ApiError(HttpStatus status, Throwable ex) {
    this();
    this.status = status;
    this.message = "Unexpected error";
    this.debugMessage = ex.getLocalizedMessage();
  }

  public void addValidationErrors(List<FieldError> fieldErrors) {
    fieldErrors.forEach(this::addValidtionError);
  }

  public void addValidationError(List<ObjectError> globalError) {
    globalError.forEach(this::addValidationError);
  }

  /**
   * Utility method for adding error of ConstraintViolation. Usually when a @Validated validation
   * fails.
   *
   * @param cv the ConstraintViolation
   */
  private void addValidationError(ConstraintViolation<?> cv) {
    this.addValidationError(cv.getRootBeanClass().getSimpleName(),
        ((PathImpl) cv.getPropertyPath()).getLeafNode().asString(), cv.getInvalidValue(),
        cv.getMessage());
  }

  public void addValidationErrors(Set<ConstraintViolation<?>> constraintViolations) {
    constraintViolations.forEach(this::addValidationError);
  }

  public void addValidationError(ObjectError objectError) {
    this.addValidationError(objectError.getObjectName(), objectError.getDefaultMessage());
  }

  private void addValidtionError(FieldError fieldError) {
    this.addValidationErrors(fieldError.getObjectName(), fieldError.getField(),
        fieldError.getRejectedValue(), fieldError.getDefaultMessage());
  }

  private void addValidationErrors(String objectName, String field, Object rejectedValue,
      String defaultMessage) {
    addSubError(new ApiValidationError(objectName, field, rejectedValue, message));
  }

  private void addSubError(ApiSubError subError) {
    if (subErros == null)
      subErros = new ArrayList<ApiSubError>();
    subErros.add(subError);
  }

  private void addValidationError(String object, String field, Object rejectedValue,
      String message) {
    addSubError(new ApiValidationError(object, field, rejectedValue, message));
  }

  private void addValidationError(FieldError fieldError) {
    this.addValidationError(fieldError.getObjectName(), fieldError.getField(),
        fieldError.getRejectedValue(), fieldError.getDefaultMessage());
  }

  private void addValidationError(String objectName, String defaultMessage) {
    addSubError(new ApiValidationError(objectName, message));
  }

  public HttpStatus getStatus() {
    return status;
  }

}
