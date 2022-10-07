# Todo App Project 
***

![](https://img.shields.io/badge/java_17-✓-blue.svg)
![](https://img.shields.io/badge/spring_boot-✓-blue.svg)
![](https://img.shields.io/badge/H2Database-✓-blue.svg)
![](https://img.shields.io/badge/jwt-✓-blue.svg)
![](https://img.shields.io/badge/swagger-✓-blue.svg)
![](https://img.shields.io/badge/Thymeleaf-✓-blue.svg)

***
### Models
- User, TodoItem, Role
***

### Controller
- MainController (for thymeleaf)
- UserController (for swagger) 
- UserRegistrationController (for thymeleaf)

***
### Services
- UserService (Interface) 
- UserServiceImpl 
***

### Repository
- UserRepository (has 1 method)
```
  User findByEmail(String email)
  ```
- TodoItemRepository (has nativeQuery)
```
@Query(nativeQuery = true, value = "SELECT * FROM TASKlIST WHERE TODO_USER_ID= ?1")
    List<TodoItem> findAllByUserId(int id);
```
***

### Register Json for Swagger :
```json
{
  "firstName": "abkode",
  "lastName": "example",
  "password": "123",
  "email": "aa@deneme.com"
}
```
***
### Register for Thymeleaf :
![](src/main/resources/img/th-registration.png)
***
### Login with Thymeleaf :
![](src/main/resources/img/login-page-thymleaf.png)
***
### Index Page After Login : 
![](src/main/resources/img/index-page.png)
--Delete button and todolist buttons are active. 
***
***
### ToDo Page After Index : 
![](src/main/resources/img/todolist.png)
---Use change status button to change false to true and also u can delete it.
***
***
### New Task Page After Index :
![](src/main/resources/img/newTask.png)
***
### H2Database User : 
![](src/main/resources/img/h2user.png)
***
### H2Database TaskList : 
![](src/main/resources/img/h2TaskList.png)
***
### Swagger-ui :
![](src/main/resources/img/swagger1.png)
![](src/main/resources/img/swagger2.png)
***
