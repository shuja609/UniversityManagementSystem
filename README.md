# AcademiaStream: University Management System

 Complete Project of University Management system



Overview
========

AcademiaStream is a comprehensive University Management System (UMS) developed using
 JavaFX, Scene Builder, and JDBC SQL. It aims to streamline various administrative, 
 academic, and faculty tasks, ensuring a cohesive and efficient management process 
 within a university. This application provides a user-friendly interface for 
 administrators, students, and faculty members, facilitating smooth interaction and 
 data management.

Features
========

Admin Subsystem
---------------
- **User Management**: Register, update, and delete users.
- **Course Management**: Add, update, and delete courses.
- **Fee Management**: Update and manage fee structures.
- **View Courses**: Display all available courses.
- **View Users**: Display all registered users.
- **Update Fee**: Update fee for per credit hour.

Student Subsystem
-----------------
- **Course Registration**: Register in courses.
- **View Attendance**: Check attendance records.
- **Fee Details**: View fee details.
- **Study Plan**: Access the courses offered in all semesters.
- **View Academic Marks**: Check marks of each course in assignment, qiz , fina etc.

Faculty Subsystem
-----------------

- **Mark Studnt's Attendance**: Mark the students present,absent or Leave.
- **Update Academic Records**: Submit marks for each assesment.

Technology Stack
================
- **JavaFX**: For building the user interface.
- **Scene Builder**: For designing the UI.
- **JDBC SQL**: For database connectivity and operations.
- **MySQL**: As the database management system.

Installation
============

Prerequisites
-------------
- Java Development Kit (JDK) 8 or higher
- JavaFX SDK
- MySQL Database
- Scene Builder

Steps
-----
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/your-repo/Project.git
   ```

2. **Set Up Database**:
   - Install MySQL and create a database named `AcademiaStream`.
   - Run the SQL script `AcademiaStream.sql` provided in the project to set up the necessary tables.

3. **Configure Database Connection**:
   - Update the database connection details in the `sqliteConnection` class:

     ```java
     String url = "jdbc:mysql://localhost:3306/university_management";
     String user = "root";
     String password = "yourpassword";
     ```

4. **Import Project into IDE**:
   - Open your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse).
   - Import the cloned repository as a new project.
   - Ensure that JavaFX libraries are correctly set up in the project settings.

5. **Run the Application**:
   - Locate the main class (e.g., `Main.java`).
   - Run the main class to start the application.

Setting up JavaFX and Scene Builder in Eclipse
==============================================

Prerequisites
-------------
- Eclipse IDE
- JavaFX SDK
- Scene Builder

Steps
-----
1. **Download and Install Eclipse IDE**:
   - Download Eclipse IDE from the [Official website](https://www.eclipse.org/downloads/).
   - Install Eclipse following the provided instructions.

2. **Download JavaFX SDK**:
   - Download JavaFX SDK from the [Gluon website](https://gluonhq.com/products/javafx/).

3. **Set Up JavaFX in Eclipse**:
   - Open Eclipse and create a new JavaFX project.
   - Go to `Help > Eclipse Marketplace`.
   - Search for `e(fx)clipse` and install it.
   - Add the JavaFX SDK to your project:
     - Right-click on your project and go to `Properties`.
     - Navigate to `Java Build Path > Libraries`.
     - Click `Add External JARs` and select the JavaFX SDK `lib` directory.
   - Add the JavaFX user library:
     - Go to `Window > Preferences > Java > Build Path > User Libraries`.
     - Click `New`, name it `JavaFX`, and add all JAR files from the JavaFX SDK `lib` directory.

4. **Configure JavaFX Run Configuration**:
   - Right-click your project and select `Run As > Run Configurations`.
   - Under `VM arguments`, add:
     ```plaintext
     --module-path "path-to-javafx-sdk-lib" --add-modules javafx.controls,javafx.fxml
     ```

5. **Install and Configure Scene Builder**:
   - Download Scene Builder from the [Gluon website](https://gluonhq.com/products/scene-builder/).
   - Install Scene Builder following the provided instructions.
   - Set Scene Builder path in Eclipse:
     - Go to `Window > Preferences > JavaFX`.
     - Browse and set the Scene Builder executable path.

Usage
=====

Admin Interface
---------------
1. **Login as Admin**.
2. **Manage Users**: Add, update, or delete user records.
3. **Manage Courses**: Add, update, or delete course records.
4. **Update Fees**: Modify the fee structure.

Student Interface
-----------------
1. **Login as Student**.
2. **Enroll in Courses**: Choose courses to enroll in.
3. **View Attendance and Fees**: Check attendance and fee details.
4. **Access Study Plan**: View the courses offered in each semester.
5. **Access Marks**: View the marks in each course registered and each assesment.
6. **View Transcript**: View the grades in each course passed.

Faculty Interface
-----------------
1. **Login as Faculty**.
2. **Update Attendance**: Update Student attendance in each course.
3. **Upload the marks**: Update the marks of students in each assesment.


Development
===========

Project Structure
-----------------
```
Project
│
├── JRE System Library [JavaSE-20]
├── src
│ ├── aController
│ ├── aView
│ ├── fController
│ ├── fView
│ ├── img
│ │ ├── img.Blunicons.PNG
│ │ ├── img.PNG
│ ├── mainP
│ ├── sample
│ ├── sController
│ ├── sView
│ ├── utilities
│ └── META-INF
├── JavaFX
├── Referenced Libraries
├── out
├── PNG@2_white_icons
├── AcademiaStream.sql
├── LICENSE
├── mysql-connector-java-8.0.17.jar
├── Readme
├── UMS_Project_Report.pdf
├── UMS_Project_ScopeSlides.pdf
├── UMS_Project_Scope.pptx
└── testUMS.iml
 

```

Dependencies
------------
Ensure the following dependencies are included in your project:
- JavaFX
- MySQL Connector/J

Example Dependency Configuration (Eclipse IDE)
------------------------------------------------
```xml
<dependencies>
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.17</version>
    </dependency>
    <dependency>
        <groupId>org.openjfx</groupId>
        <artifactId>javafx-controls</artifactId>
        <version>11</version>
    </dependency>
    <dependency>
        <groupId>org.openjfx</groupId>
        <artifactId>javafx-fxml</artifactId>
        <version>11</version>
    </dependency>
</dependencies>
```

Contributions
=============
Contributions are welcome! Please fork the repository and submit pull requests for any enhancements or bug fixes.

License
=======
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

Contact
=======
For any queries or support, please contact:
- Name: Mohammad Shuja Uddin
- Email: shujaqurashi2172@gmail.com
- GitHub: Shuja Qurashi

---

Thank you for using AcademiaStream!
