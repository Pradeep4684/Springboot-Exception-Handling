# 🚀 Spring Boot Global Exception Handling

This project demonstrates **Global Exception Handling in Spring Boot REST APIs** using:

* `@RestControllerAdvice`
* `@ExceptionHandler`
* Custom Exception Classes
* Standardized Error Response Structure

---

## 📌 Features

✅ Global exception handling using `@RestControllerAdvice`
✅ Custom exception (`ProductNotFoundException`)
✅ Centralized error response (`ExInfo`)
✅ Multiple exception handlers
✅ Clean REST API design
✅ Proper HTTP status codes

---

## 🏗️ Project Structure

```
com.example.demo
│
├── controller
│   ├── ProductRestController.java
│   ├── GreetRestController.java
│   └── WelcomeRestController.java
│
├── exception
│   ├── AppExceptionHandler.java
│   ├── ProductNotFoundException.java
│   └── ExInfo.java
│
└── DemoApplication.java
```

---

## ⚙️ Technologies Used

* Java 17+
* Spring Boot
* Spring Web
* Lombok

---

## 🔥 Exception Handling Flow

1. Controller throws exception
2. `@RestControllerAdvice` catches it
3. Specific `@ExceptionHandler` executes
4. Custom response (`ExInfo`) returned

---

## 📦 Custom Exception Class

```java
public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String msg) {
        super(msg);
    }
}
```

---

## 📄 Error Response Model

```java
@Data
public class ExInfo {
    private String exCode;
    private String exMsg;
    private LocalDateTime date;
}
```

---

## 🌍 Global Exception Handler

```java
@RestControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(value = ArithmeticException.class)
    public ResponseEntity<String> handleArithmeticException() {
        return new ResponseEntity<>("Some problem occured",
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ExInfo> handleExceptionWithCode(Exception e) {
        ExInfo info = new ExInfo();
        info.setExCode("APP00001");
        info.setExMsg(e.getMessage());
        info.setDate(LocalDateTime.now());

        return new ResponseEntity<>(info,
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = ProductNotFoundException.class)
    public ResponseEntity<ExInfo> handleProductExceptionWithCode(ProductNotFoundException e) {

        ExInfo info = new ExInfo();
        info.setExCode("APP00002");
        info.setExMsg(e.getMessage());
        info.setDate(LocalDateTime.now());

        return new ResponseEntity<>(info,
                HttpStatus.BAD_REQUEST);
    }
}
```

---

## 🎮 REST APIs

### 1️⃣ Get Product

```
GET /product/{id}
```

👉 Condition:

* If `id > 100` → throws `ProductNotFoundException`

---

### 2️⃣ Greet API (Null Pointer Exception)

```
GET /greet
```

👉 Generates:

* `NullPointerException`

---

### 3️⃣ Welcome API (Arithmetic Exception)

```
GET /welcome
```

👉 Generates:

* `ArithmeticException (divide by zero)`

---

## 📥 Sample Error Response

```json
{
  "exCode": "APP00002",
  "exMsg": "Invalid ID",
  "date": "2026-04-26T12:00:00"
}
```

---

## ⚠️ Important Notes

* `@RestControllerAdvice` handles exceptions globally
* Controller-level `@ExceptionHandler` (like in `WelcomeRestController`) overrides global handler
* Always use custom exception for business logic
* Use meaningful error codes

---

## 💡 Interview Questions

* What is `@RestControllerAdvice`?
* Difference between `@ControllerAdvice` vs `@RestControllerAdvice`
* How does `@ExceptionHandler` work?
* Global vs Local Exception Handling?
* Why use custom exception?

---

## 👨‍💻 Author

**Pradeep Andhale**

---

## ⭐ Support

If you like this project, give it a ⭐ on GitHub!
