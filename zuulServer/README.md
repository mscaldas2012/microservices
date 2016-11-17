Zuul Server with Service Discovery running on port 8080.

To access the services, send http://<host>:8080/<service-name>/<rest-interface>. For example the spring-caller service can be called at http://localhost:8080/spring-caller/getMessage.

This needs an eureka-server running on http://localhost:8761. These properties should be externalized on a configuration server later.
