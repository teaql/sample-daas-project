package com.doublechaintech.model.wechatworkappidentity;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.model.ModelObjectPlainCustomSerializer;

public class WechatWorkappIdentitySerializer
    extends ModelObjectPlainCustomSerializer<WechatWorkappIdentity> {

  @Override
  public void serialize(
      WechatWorkappIdentity wechatWorkappIdentity, JsonGenerator jgen, SerializerProvider provider)
      throws IOException, JsonProcessingException {
    Map<String, Object> ctx = new HashMap<>();
    this.writeBaseEntityField(jgen, null, wechatWorkappIdentity, provider, ctx);
  }
}
