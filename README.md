# Library-Management-System

# 📚 Smart Library Management System

A console-based **Library Management System** developed using **Core Java**, **JDBC**, and **MySQL**. This project demonstrates CRUD operations, database connectivity, and object-oriented programming concepts through a real-world library management application.

## 🚀 Features

### 📖 Book Management
- Add Book
- Display All Books
- Search Book by ID
- Update Book Details
- Delete Book

### 👤 User Management
- Add User
- Display All Users
- Search User by ID
- Update User Details
- Delete User

### 📚 Borrow Management
- Borrow Book
- Return Book
- Display Borrow Records
- Search Borrow Record
- Automatic Fine Calculation
- Automatic Book Quantity Update
- Automatic Borrowed Book Count Update

---

## 🛠️ Technologies Used

- Core Java
- JDBC
- MySQL
- VS Code
- MySQL Connector/J

---

## 🗄️ Database

The project uses three tables:

### Books
Stores book information including:
- Book ID
- Book Name
- Author
- Category
- Price
- Quantity
- Status

### Users
Stores user details including:
- User ID
- User Name
- Phone Number
- Email
- Borrowed Book Count

### Borrow Records
Stores borrowing information including:
- Record ID
- Book ID
- User ID
- Borrow Date
- Return Date
- Fine

---

## 📂 Project Structure

```
SmartLibraryManagementSystem
│
├── src
│   ├── database
│   │   └── DBConnection.java
│   ├── model
│   │   ├── Book.java
│   │   ├── User.java
│   │   └── BorrowRecord.java
│   ├── service
│   │   ├── BookService.java
│   │   ├── UserService.java
│   │   └── BorrowService.java
│   └── main
│       └── Library.java
│
├── lib
│   └── mysql-connector-j-9.7.0.jar
│
└── README.md
```

---

## ⚙️ Setup

1. Clone the repository

```bash
git clone https://github.com/your-username/SmartLibraryManagementSystem.git
```

2. Create a MySQL database

```sql
CREATE DATABASE library;
```

3. Create the required tables (`books`, `users`, `borrowrecords`).

4. Update the database credentials in `DBConnection.java`.

5. Compile and run the project.

---

## 📸 Output

The application provides a menu-driven console interface for managing books, users, and borrow records with MySQL database integration.

---

## 📖 Learning Outcomes

This project helped me gain practical experience in:

- Object-Oriented Programming
- JDBC Database Connectivity
- SQL CRUD Operations
- Prepared Statements
- Exception Handling
- MySQL Integration
- Menu-driven Console Applications

---

## 👨‍💻 Author

**Sai Krishna**

If you found this project useful, feel free to ⭐ the repository.
