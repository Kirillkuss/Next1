package com.itrail.test.domain.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.json.bind.serializer.JsonbSerializer;
import javax.json.bind.serializer.SerializationContext;
import javax.json.stream.JsonGenerator;

/**
 *
 * @author barysevich_k
 */
//new
public class LocalDateTimeSerializer implements JsonbSerializer<LocalDateTime>{

    @Override
    public void serialize(LocalDateTime t, JsonGenerator jg, SerializationContext sc) {
        jg.write( t.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss") ) );
    }
    
}
