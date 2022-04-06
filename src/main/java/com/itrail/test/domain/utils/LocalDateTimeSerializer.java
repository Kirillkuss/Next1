package com.itrail.test.domain.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author barysevich_k
 */
//new
public class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {
    
    @Override
    public void serialize(LocalDateTime date, JsonGenerator generator, SerializerProvider provider) throws IOException {
        generator.writeString(null == date ? "" : date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")));
    }
}
