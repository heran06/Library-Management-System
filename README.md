# Library-Management-System

**Description**
* The Library Management System is a web-based application developed in Java . It helps automate the process of managing a library, including book records, user management, issue/return of books.
* The system provides role-based access for Admin and Users:
     Admin can manage books, users, and track issued/returned books.
     Users can search books, check availability, and request/return books.
* This project ensures efficieny and real time updates.

**Features**
* Login page for users.
* Add, update, delete, and search books.
* Book issue and return dates
* Tracking due dates.
    
**Tech Stack:**
* Frontend: HTML, CSS, JavaScript
* Backend: Java Classes & modules
* Database: MySQL
* Programming Language : Java

**Usage**
After running the program, you will see a menu like:

--- Library Menu ---
1. Add Book
2. List Books
3. Issue Book
4. Return Book
5. Exit

 So,from this the admin can interact with the system by entering the corresponding number.


**Code Structure**
* **LibraryManagementSystem.java**  →   Contains all classes (Book, User, Library) and the main method.
* **Book**       :  Represents a book with ID, title, author, and status.
* **User**       :  Represents a library user.
* **Library**    :  Handles all core library operations (add book, issue/return books, list books).
* **Main method**:  Contains the menu and runs the program.




