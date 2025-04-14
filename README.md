# RaceTeamCreator

## 🏁 Project Overview

Welcome to RaceTeamCreator. With this application you can add, edit, delete and see the teams you have created. The meaning behind this app is that you can use your mind to build your owen dream team. No pen and papers or excel files. everything will be saved so you dont have to.

**Why it's valuable:**
- Simplifies racing team management
- Helps track and organize key performance metrics
- Ideal for hobbyists, racing clubs, and event coordinators

---

## 💻 Installation Instructions

### ✅ Requirements

Before you begin, make sure you have the following installed:

- **Java 11** or higher
- **XAMPP** or **MAMP** (for local MySQL database)
- **Git** (for cloning the repository)
- **Maven** (for building the project) – or use the included `mvnw` wrapper
- **IDE** such as IntelliJ IDEA or Eclipse (optional but recommended)

### 📦 Steps to Install and Run

1. **Clone the Repository**

   ```bash
   git clone <repository_url>
   cd RaceTeamCreator
   ```

2. **Start Your Local MySQL Server**

   Open XAMPP or MAMP and ensure the **MySQL** service is running.

3. **Configure the Database Connection**

   Open the `application.properties` file (usually found in `src/main/resources/`) and update the database credentials if needed:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/race_team_db
   spring.datasource.username=root
   spring.datasource.password=your_password
   ```

4. **Build the Project**

   If you have Maven installed:

   ```bash
   ./mvnw clean install
   ```

5. **Run the Application**

   ```bash
   java -jar target/RaceTeamCreator.jar
   ```

   Or, simply **double-click the JAR file** to launch the application (GUI-based).

---

## ⚙️ Configuration

For basic usage, no extra configuration is needed.

However, if you'd like to customize the application, you can do so by editing the `application.properties` file. Common configurable options include:

- Database URL, username, and password
- Server port (if applicable)
- File paths for exported data (future feature)

---

## 🚀 Usage Guide

1. **Launch the Application**

   After running the JAR file, the RaceTeamCreator GUI will open.

2. **Add a Team**

   - Click "Add Team"
   - Enter team name, driver names, and car details
   - Save the team

3. **Edit a Team**

   - Select a team from the list
   - Click "Edit"
   - Update the information and save

4. **Delete a Team**

   - Select the team to delete
   - Click "Delete" and confirm

5. **View Team Info**

   - Click on any team to view detailed information, including performance statistics (if available)

---

## 🛠 Features

- ✅ Add racing teams with drivers and cars
- ✅ Edit team details
- ✅ Delete existing teams
- ✅ View team information
- ⚠️ More advanced features coming soon!

---

## 📅 Roadmap / Timeline

| Quarter | Features Planned |
|--------|------------------|
| **Q1 2025** | Enhance UI with customization options |
| **Q2 2025** | Implement data export (CSV, PDF) |
| **Q3 2025** | Add performance analytics and reporting |
| **Q4 2025** | Introduce user accounts & admin roles |

---

## 🤝 Contributing

We welcome contributions!

- Found a bug? [Open an issue](#)
- Have a new feature idea? Submit a pull request!
- Want to help with documentation or testing? Reach out!