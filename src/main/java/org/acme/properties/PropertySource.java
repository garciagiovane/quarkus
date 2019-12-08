package org.acme.properties;

import io.quarkus.arc.config.ConfigProperties;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.List;

@ConfigProperties(prefix = "default")
public interface PropertySource {

    @ConfigProperty(name = "hello-message")
    String helloMessage();

    @ConfigProperty(name = "list")
    List<String> listFromProperties();

    @ConfigProperty
    Integer getInteger();

    String getString();

}
