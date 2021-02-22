# Spring-Cloud-Eureka

#### Postman Collection - [Import from here](https://www.getpostman.com/collections/5481f9e670efc011755a)

__Spring Cloud__ provides multiple solutions such as __Eureka__, __Zookeeper__, __Cloud Foundry__ and __Consul__ to facilitate the process of service discovery. This repo is aimed at providing a simple explanation of service discovery with __Eureka__.

## Service Discovery
A distributed system typically comprises a large number of services which communicate with each other to perform certain operations. Service discovery is the process of one service dynamically discovering the network location (IP address and port) of another service to communicate with it.

## Netflix Eureka
- It is a client-side service discovery mechanism for building the service registry server and Eureka clients which will register themselves and discover other services to call REST APIs.
- The discovery server expects a regular heartbeat message from each microservice instance. If an instance begins to consistently fail to send a heartbeat, the discovery server will remove the instance from his registry. This way we will have a very stable ecosystem of Microservices collaborating among each other, and on top of it we don’t have to manually maintain address of other Microservice, which is a next to impossible task if the scale up/down is very frequent, on demand and we use virtual host to host the services specially in the cloud environment.
