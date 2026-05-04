# 🗳️ Voting System (Java Swing + JDBC)

## 📌 Overview

This project is a **simple Voting System application** built using **Java Swing (GUI)** and **JDBC (Database Connectivity)**. It allows users to add candidates, view candidates, cast votes, and display election results through a user-friendly interface.

---

## 🚀 Features

* ➕ Add new candidates
* 📋 View list of candidates
* 🗳️ Cast votes using Candidate ID
* 📊 View results sorted by highest votes
* 💻 Simple GUI using Java Swing
* 🗄️ Database integration using JDBC

---

## 🛠️ Technologies Used

* **Java** (Core + Swing for GUI)
* **JDBC** (Java Database Connectivity)
* **MySQL** (or any relational database)
* **IDE**: IntelliJ / Eclipse / NetBeans

---

## 📂 Project Structure

```
sachin_voting_swing/
│── VotingGUI.java        # Main GUI class
│── CandidateService.java # Business logic
│── DBConnection.java     # Database connection setup
│── Candidate.java        # Model class
```

---

## ⚙️ Setup Instructions

### 1️⃣ Clone the Repository

```
git clone https://github.com/your-username/voting-system.git
cd voting-system
```

---

### 2️⃣ Setup Database

Create a database and table:

```sql
CREATE DATABASE voting_db;

USE voting_db;

CREATE TABLE candidates (
    candidate_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    votes INT DEFAULT 0
);
```

---

### 3️⃣ Configure Database Connection

Update your `DBConnection.java`:

```java
String url = "jdbc:mysql://localhost:3306/voting_db";
String user = "root";
String password = "your_password";
```

---

### 4️⃣ Run the Application

* Open project in IDE
* Run `VotingGUI.java`
* GUI window will launch

---

## 🖥️ Application Workflow

1. Enter candidate name → Click **Add Candidate**
2. Click **View Candidates** → See all candidates with IDs
3. Enter candidate ID → Click **Vote**
4. Click **View Results** → See vote counts sorted

---

## 📸 Screenshots (Optional)

*Add screenshots here for better presentation*

---

## ⚠️ Known Issues

* No authentication (anyone can vote multiple times)
* No input validation for empty fields
* Basic UI design (can be improved)

---

## 🔮 Future Enhancements

* 🔐 User login & authentication system
* 🚫 Prevent duplicate voting
* 📱 Convert to web or mobile app
* 📊 Add charts/graphs for results
* 🧠 Integrate analytics or AI

---

## 🤝 Contributing

Contributions are welcome!
Feel free to fork the repo and submit pull requests.

---

## 📜 License

This project is open-source and available under the **MIT License**.

---

## 👨‍💻 Author

**SACHIN US**

---

## ⭐ Support

If you like this project, give it a ⭐ on GitHub!
