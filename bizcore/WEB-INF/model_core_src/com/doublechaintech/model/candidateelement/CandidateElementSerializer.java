package com.doublechaintech.model.candidateelement;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.model.ModelObjectPlainCustomSerializer;

public class CandidateElementSerializer extends ModelObjectPlainCustomSerializer<CandidateElement> {

  @Override
  public void serialize(
      CandidateElement candidateElement, JsonGenerator jgen, SerializerProvider provider)
      throws IOException, JsonProcessingException {
    Map<String, Object> ctx = new HashMap<>();
    this.writeBaseEntityField(jgen, null, candidateElement, provider, ctx);
  }
}
