Spring Cloud Gateway Fortune Teller Demo
===

This demo is meant to show one way you can use Spring Cloud Gateway. It takes the [Fortune Teller](https://github.com/spring-cloud-samples/fortune-teller) demo and places both the UI and backend API behind the gateway. The gateway is set up with two different routes:

1. Any requests to `/random` will be sent to the backend API
2. Any other request (matched with the `/**` pattern) will be sent to the UI application

The gateway is configured with two environment variables:

`UI_DOMAIN`: Domain of the [UI application](https://github.com/BrianMMcClain/fortune-teller-ui)

`API_DOMAIN`: Domain of the [backend API](https://github.com/BrianMMcClain/fortune-service)


These applications must be running in a location that the gateway can reach them.

The [sso](https://github.com/BrianMMcClain/fortune-teller-gateway/tree/sso) branch then adds SSO using [Pivotal Single Sign-On](https://docs.pivotal.io/p-identity/1-11/index.html) and [Spring Cloud Security](https://spring.io/projects/spring-security). The idea being that should these backend services only be available through your gateway, and your gateway requires authentication, then your downstream services see those benefits as well.