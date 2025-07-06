### ✅ Final `README.md` (Copy-Paste Ready)

````markdown
# TODO API in Java (Spring Boot)

A simple TODO REST API application built using Java and Spring Boot.  
This app uses in-memory storage (no database), and supports creating, listing, updating, retrieving, and soft-deleting TODO items.

---

## 📦 API Endpoints

| Method | Endpoint        | Description            |
|--------|------------------|------------------------|
| GET    | /todos           | List all TODOs         |
| POST   | /todos           | Create a new TODO      |
| GET    | /todos/{id}      | Get TODO by ID         |
| PUT    | /todos/{id}      | Update a TODO          |
| DELETE | /todos/{id}      | Soft delete a TODO     |

---

## ▶️ How to Run the App Locally

1. **Clone the repository**

```bash
git clone https://github.com/sanyam-harness/todo-api-java.git
cd todo-api-java
````

2. **Run the app**

```bash
./mvnw spring-boot:run
```

The app will start at:
`http://localhost:8080`

---

## 🧪 How to Test Using curl

Open a second terminal and run the following commands:

---

### ✅ 1. Create a TODO

```bash
curl -X POST http://localhost:8080/todos \
  -H "Content-Type: application/json" \
  -d '{"title": "Learn Java"}'
```

Expected response:

```json
{"id":1,"title":"Learn Java","completed":false,"deleted":false}
```

---

### ✅ 2. Get All TODOs

```bash
curl http://localhost:8080/todos
```

---

### ✅ 3. Get TODO by ID

```bash
curl http://localhost:8080/todos/1
```

---

### ✅ 4. Update a TODO

```bash
curl -X PUT http://localhost:8080/todos/1 \
  -H "Content-Type: application/json" \
  -d '{"title": "Learn Java deeply", "completed": true}'
```

---

### ✅ 5. Soft Delete a TODO

```bash
curl -X DELETE http://localhost:8080/todos/1
```

---

### ✅ 6. Confirm Deletion

```bash
curl http://localhost:8080/todos
```

---

## 📁 Project Structure

```
src/
└── main/
    └── java/
        └── com/sanyam/todo/
            ├── controller/
            │   └── TodoController.java
            ├── model/
            │   └── Todo.java
            └── service/
                └── TodoService.java
```
