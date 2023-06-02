# Spring Boot MongoDB Multi-Tenant

MongoDB multi tenant implementation

Tenant 1:
```http request
curl --location --request POST 'http://localhost:8080/' \
--header 'X-Tenant: tenant1' \
--header 'Content-Type: application/json' \
--data-raw '{
   "name": "Category tenant1"
}'
```

Tenant 2:
```http request
curl --location --request POST 'http://localhost:8080/' \
--header 'X-Tenant: tenant2' \
--header 'Content-Type: application/json' \
--data-raw '{
   "name": "Category tenant2"
}'
```

Thanks
 [Assist Software](https://assist-software.net/blog/how-implement-dynamic-multi-tenancy-mongodb-and-spring-boot)