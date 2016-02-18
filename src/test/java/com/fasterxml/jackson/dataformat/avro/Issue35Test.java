package com.fasterxml.jackson.dataformat.avro;

import com.demonstration.Event;
import com.demonstration.EventID;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Issue35Test extends AvroTestBase {

    public void testWriteBidResponse() throws JsonProcessingException {
        Event event = new Event();
        event.setPlayerCount(100);
        EventID id = new EventID();
        id.setFirst(10);
        ObjectMapper mapper = new ObjectMapper(new AvroFactory());
        byte[] bytes = mapper.writer(new AvroSchema(Event.SCHEMA$)).writeValueAsBytes(event);
        assertNotNull(bytes);
    }
}
