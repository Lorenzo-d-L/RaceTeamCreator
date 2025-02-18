# RaceTeamCreator

![Hoofdlogo](C:\Users\loren\Desktop\Opleiding informatica\Leerjaar 1\Periode 2\Beroepsproduct\Broepsproduct\RaceTeamCreator\src\main\resources\com\lorenzo\raceteamcreator_bp02\icons\HoofdLogo.png)

## Project Overview

The RaceTeamCreator application helps users create, manage, and organize racing teams efficiently. It provides a user-friendly interface to handle team information, including drivers, cars, and performance statistics. The primary functionality of the application is to add, edit, or delete teams.

## Installation Instructions

### Prerequisites

* Java Development Kit (JDK) 17 or higher

* XAMPP or MAMP for a local database

### Installation Steps

1. Download or clone the repository:

    ```bash
    git clone <repository_url>
    cd RaceTeamCreator
    ```

2. Open the project in your preferred IDE (e.g., IntelliJ IDEA, Eclipse).

3. Make sure XAMPP or MAMP is running and MySQL service is enabled.

4. Open the application.properties file and configure the database connection if needed.

5. Build the project using Maven:
    ```bash
    ./mvnw clean install
    ```

6. Run the application:
    ```bash
    java -jar target/RaceTeamCreator.jar
    ```

**If you just want to use it, open the jar file directly by double-clicking it.**

## Configuration

The application does not require additional configuration for basic usage. However, to customize team properties, modify the application.properties file.

## Usage Guide

1. Launch the application.

2. Add a new team by providing a team name and relevant details.

3. View the list of all existing teams.

4. Edit team information, such as team name or team members.

5. Delete teams that are no longer needed.

6. View detailed information about each team.

## Features

* Add

* Edit

* Delete

* See

## Roadmap / Timeline

* **Q1 2025: Enhance user interface with more customization options.**

* **Q2 2025: Implement data export features.**

* **Q3 2025: Add performance analytics and reporting.**

* **Q4 2025: Introduce user accounts and admin accounts for better access control.**

We welcome contributions! Please submit a pull request or open an issue if you have any ideas or encounter any problems.

