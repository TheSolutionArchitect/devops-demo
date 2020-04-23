#RESTful Web Services


- Retrive all users - GET    /users
- Create an user   - POST   /users
- Retrive one user - GET    /users/{userId} -> /users/1
- Delete a user    - DELETE /users/{userId} -> /users/1

- Retrive all tasks for an user - GET /user/{userid}/tasks -> /user/1/tasks 
- Create a post for an user - GET /user/{userid}/tasks -> /user/1/tasks 
- Retrive single task of an user -GET /user/{userid}/tasks/{taskId} -> /user/1/tasks/1 

- service versioning 
- validation
- internationalization 
- exception handling 
- content negotioation
- generate documentation 
- hetos
- how to monitor the services

Spring security username/password: awstechguide/awstechguide

Check the APIs of this projects
after starting the project browse below urls
http://localhost:8080/swagger-ui.html
http://localhost:8080/v2/api-docs

Actuator
http://localhost:8080/actuator
Health
http://localhost:8080/actuator/health


Dynamic Filtering
http://localhost:8080/filter/person
http://localhost:8080/filter/person/list


Internationalization
http://localhost:8080/welcome


Using JPA H2 database
GET:
http://localhost:8080/users/jpa
http://localhost:8080/users/1/jpa

Delete:
http://localhost:8080/users/2/jpa/delete

Create: 
http://localhost:8080/users/jpa/add