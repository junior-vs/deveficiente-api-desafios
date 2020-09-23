package com.vsj.mercadolivre.handler.errors;

public class ApiValidationError extends ApiSubError {


  private String object;
  private String field;
  private Object rejectValue;
  private String message;

  public ApiValidationError(String object, String field, Object rejectValue, String message) {
    this.object = object;
    this.field = field;
    this.rejectValue = rejectValue;
    this.message = message;
  }

  public ApiValidationError(String objectName, String message2) {
    this.object = object;
    this.message = message;
  }



}
