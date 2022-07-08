package com.doublechaintech.model.family;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.model.ModelObjectPlainCustomSerializer;
public class FamilySerializer extends ModelObjectPlainCustomSerializer<Family>{

	@Override
	public void serialize(Family family, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
    Map<String, Object> ctx = new HashMap<>();
    this.writeBaseEntityField(jgen, null, family, provider, ctx);
	}
}


