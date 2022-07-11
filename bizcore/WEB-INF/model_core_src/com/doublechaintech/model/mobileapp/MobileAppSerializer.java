package com.doublechaintech.model.mobileapp;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.model.ModelObjectPlainCustomSerializer;

public class MobileAppSerializer extends ModelObjectPlainCustomSerializer<MobileApp> {

  @Override
  public void serialize(MobileApp mobileApp, JsonGenerator jgen, SerializerProvider provider)
      throws IOException, JsonProcessingException {
    Map<String, Object> ctx = new HashMap<>();
    this.writeBaseEntityField(jgen, null, mobileApp, provider, ctx);
  }
}
