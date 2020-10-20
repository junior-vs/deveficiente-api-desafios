package com.vsj.mercadolivre.handler.errors;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.databind.jsontype.impl.TypeIdResolverBase;

public class LowerCaseClassNameResolver extends TypeIdResolverBase {

  @Override
  public String idFromValue(Object value) {
    return value.getClass().getSimpleName().toLowerCase();
  }

  @Override
  public String idFromValueAndType(Object value, Class<?> suggestedType) {
    return idFromValue(value);
  }

  @Override
  public Id getMechanism() {
    return JsonTypeInfo.Id.CUSTOM;
  }

}