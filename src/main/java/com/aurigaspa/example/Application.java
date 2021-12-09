package com.aurigaspa.example;

import org.glassfish.jersey.server.ResourceConfig;
import org.zalando.logbook.DefaultSink;
import org.zalando.logbook.Logbook;
import org.zalando.logbook.StreamHttpLogWriter;
import org.zalando.logbook.jaxrs.LogbookServerFilter;
import org.zalando.logbook.json.JsonHttpLogFormatter;

public class Application extends ResourceConfig {
	
	Logbook logbook = Logbook.builder()
		    .sink(new DefaultSink(
		            new JsonHttpLogFormatter(),
		            new StreamHttpLogWriter(System.err)
		    ))
		    .build();
	
    public Application() {
        packages("com.aurigaspa.example.services");
        register(new LogbookServerFilter(logbook));
    }
    
}