package org.acme;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Service {

    public String hello() {
        return "Hello Quarkus";
    }

}
