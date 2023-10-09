package org.example.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.example.dto.search.ValueDTO;

import java.io.IOException;

public class ValueDtoSerializer extends StdSerializer<ValueDTO> {

    public ValueDtoSerializer() {
        this(null);
    }

    public ValueDtoSerializer(Class<ValueDTO> t) {
        super(t);
    }

    @Override
    public void serialize(ValueDTO value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        if(value.getName() == null){
            gen.writeStartObject();
            gen.writeStringField("displayName", value.getDisplayName());
            gen.writeNumberField("quantity",value.getQuantity());
            gen.writeStringField("sinceOrTill",value.getSinceOrTill());
            gen.writeNumberField("tense", value.getTense());
            gen.writeStringField("type", value.getType());
            gen.writeNumberField("operator", value.getOperator());
            gen.writeEndObject();
        } else {
            gen.writeStartObject();
            gen.writeStringField("name", value.getName());
            gen.writeStringField("displayName", value.getDisplayName());
            gen.writeEndObject();
        }

    }
}
