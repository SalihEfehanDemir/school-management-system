# 📚 School Management System (Enhanced)

This is an **enhanced version** of the School Management System, originally developed in **Spring Boot**.  
This system allows managing books, members, and libraries efficiently with improved features.

---

## 🚀 Features & Enhancements

✅ **Exception Handling** - Proper error messages with `@ControllerAdvice`  
✅ **DTO Implementation** - `BookDTO` & `ApiResponse` for clean JSON responses  
✅ **Book Borrowing System** - Borrow & Return books with availability check  
✅ **Pagination Support** - Efficiently retrieve large datasets  
✅ **Improved Database Schema** - Enhanced relationships and data consistency  

---

## 🛠️ Technologies Used

- **Backend:** Spring Boot, Java  
- **Database:** MySQL (Spring Data JPA)  
- **Security:** Basic Authentication (Spring Security planned)  
- **Frontend:** Thymeleaf, HTML, CSS  

---

## 📌 API Endpoints

### 📖 **Books**
- `GET /api/books` → Get all books (Paginated)
- `POST /api/books` → Add a new book
- `PUT /api/books/{id}/borrow` → Borrow a book
- `PUT /api/books/{id}/return` → Return a book

---

## 🔧 Setup & Installation

1️⃣ **Clone the repository**  
```bash
git clone https://github.com/yourusername/schoolmanagement.git
```

2️⃣ **Navigate to the project directory**  
```bash
cd schoolmanagement
```

3️⃣ **Run the application**  
```bash
mvn spring-boot:run
```

4️⃣ **Access the API at:**  
```
http://localhost:8080/api/books
```

---

## 🏆 Contributors

- **Salih Efehan Demir**  
- **Other contributors if any...**  

---

## 📜 License
This project is licensed under the MIT License.

---

💡 **Feel free to contribute and improve this system!**
