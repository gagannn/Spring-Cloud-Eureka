# Spring-Cloud-Eureka

#### Postman Collection - [Import from here](https://www.getpostman.com/collections/5481f9e670efc011755a)

__Spring Cloud__ provides multiple solutions such as __Eureka__, __Zookeeper__, __Cloud Foundry__ and __Consul__ to facilitate the process of service discovery. This repo is aimed at providing a simple explanation of service discovery with __Eureka__.

## Service Discovery
A distributed system typically comprises a large number of services which communicate with each other to perform certain operations. Service discovery is the process of one service dynamically discovering the network location (IP address and port) of another service to communicate with it.

## Netflix Eureka
- It is a client-side service discovery mechanism for building the service registry server and Eureka clients which will register themselves and discover other services to call REST APIs.
- The discovery server expects a regular heartbeat message from each microservice instance. If an instance begins to consistently fail to send a heartbeat, the discovery server will remove the instance from his registry. This way we will have a very stable ecosystem of Microservices collaborating among each other, and on top of it we don’t have to manually maintain address of other Microservice, which is a next to impossible task if the scale up/down is very frequent, on demand and we use virtual host to host the services specially in the cloud environment.

## Repo - spring-cloud-eureka-server
>The `@EnableEurekaServer` annotation is used to make our Spring Boot application acts as a Eureka Server.

- It is a good convention to put this registry on a separate port when using it locally. Therefore, I have used `server.port = 8761` which also tends to be the standard port for Eureka server
- When Eureka starts up, it will try to register itself as a client by default. For convenience, I used `eureka.client.register-with-eureka = false` configuration to prevent Eureka server from registering itself in the server upon startup.
- In a real world scenario, we may have multiple Eureka server nodes acting together as peer registries. When a Eureka server starts up, by default it searches for other peer registries. In order to prevent this in our local setup, I used `eureka.client.fetch-registry = false` configuration.
- I have used `logging.level.com.netflix.eureka = OFF` and `logging.level.com.netflix.discovery = OFF` properties to turn off the verbose logging.

## Repo - spring-cloud-eureka-client
Spring Cloud supports multiple discovery solutions such as Eureka, Consul, Zookeeper and Cloud Foundry. The `@EnableDiscoveryClient` instructs Spring Boot to scan the classpath and identify the service discovery implementation used (In this case Eureka as `spring-cloud-starter-netflix-eureka-server` dependency is used). Afterwards, Spring Boot activates DicoveryClient implementation and register the service name and the corresponding network location in the Eureka server.
There is another annotation namely `@EnableEurekaClient` that you can use to create an Eureka client application. In contrast to `@EnableDiscoveryClient` , `@EnableEurekaClient` can only be used with Eureka.

> By having `spring-cloud-starter-netflix-eureka-client` on the classpath, your application automatically registers with the Eureka Server. We need to annotate a `@Configuration` with either `@EnableDiscoveryClient` or `@EnableEurekaClient`
>> Note that this annotation is optional if we have the `spring-cloud-starter-netflix-eureka-client` dependency on the classpath.

- `spring.application.name` property is used to indicate the service name. Eureka client service registers in the Eureka server with whatever the name you have provided for this property. Service’s network location will be attached to it’s service name. This value will be used by other microservices to obtain the network location via the service registry. __bootstrap.properties__ file is picked up before the __application.properties__ file by Spring Boot. `spring.application.name` property is used in the earliest phases of service’s configuration. Therefore, by convention, this property should be placed in the __bootstrap.properties__ file but i have used them in __application.properties__.
- `eureka.client.serviceUrl.defaultZone` indicates the location of the Eureka server. Client service will use this URL to access the Eureka server application. In this particular instance, the URL is set to `http://localhost:8761/eureka` .
