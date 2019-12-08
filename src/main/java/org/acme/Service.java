package org.acme;

import org.acme.properties.PropertySource;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class Service {

    private PropertySource propertySource;

    public Service(PropertySource propertySource) {
        this.propertySource = propertySource;
    }

    public String hello() {
        return propertySource.helloMessage();
    }

    public List<String> getListFromProperties() {
        return propertySource.listFromProperties();
    }

    public Integer getFromPropertyUnnamed() {
        return propertySource.getInteger();
    }

    public String getString() {
        return propertySource.getString();
    }
}
