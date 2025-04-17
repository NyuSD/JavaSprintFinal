# Gym‑Management System

A small, console–driven application that lets **Admins, Trainers, and Members**  
register / log in, buy memberships, create workout classes, and query
revenue persisted in a PostgreSQL database.  
Passwords are stored securely with **BCrypt**.

---

## Table of Contents
1. [How the app works ](#how-it-works)
2. [Class overview & interactions](#classes)
3. [Project structure](#structure)
4. [Build & dependencies](#build)
5. [Database setup](#database)
6. [Running the program](#run)
7. [Clone & try it yourself](#clone)

---

<a name="how-it-works"></a>1  How the application works


* **UserService** hashes plaintext passwords with BCrypt, saves via **UserDao**.
* Generated primary‑keys are read back with `getGeneratedKeys()` so later
  inserts (memberships / classes) satisfy constraints.
* **MembershipService** sums all `membershipCost` values → annual revenue.
* **WorkoutClassService** lets trainers CRUD their classes.
* `GymApp` codes a demo scenario; swap in a menu later.

---

## <a name="classes"></a>2  Main classes & interactions

| Layer | Classes | Key responsibility |
|-------|---------|--------------------|
| **DAO** | `UserDao`, `MembershipDAO`, `WorkoutClassDAO` | SQL CRUD |
| **Service** | `UserService`, `MembershipService`, `WorkoutClassService` | Business logic: BCrypt hashing, validation, totals |
| **Util** | `DatabaseConnection` | Returns connections |
| **Entry** | `GymApp` | Demonstration  |

---

## <a name="structure"></a>3  Project directory layout

* Add later

---

## <a name="build"></a>4  Build process & dependencies

* **Maven 3.9+** (`pom.xml`)
  * `postgresql`
  * `org.mindrot:jbcrypt` for password hashing
  * `exec‑maven‑plugin` to run `GymApp`
* **Java 17** (source + target)

Build:

```bash
mvn clean package      # compiles & unit‑tests
mvn javadoc:javadoc    # optional API docs
```

## <a name="database"></a>5  Database setup (development)

```bash
CREATE DATABASE your_gym_db;

\c your_gym_db

CREATE TABLE users (
    userId SERIAL PRIMARY KEY,
    userName      VARCHAR(50)  UNIQUE NOT NULL,
    password      VARCHAR(255) NOT NULL,
    email         VARCHAR(100),
    address       VARCHAR(255),
    phoneNumber   VARCHAR(50),
    role          VARCHAR(20)  -- admin / trainer / member
);

CREATE TABLE memberships (
    membershipId SERIAL PRIMARY KEY,
    membershipType        VARCHAR(50),
    membershipDescription VARCHAR(255),
    membershipCost        DECIMAL(10,2),
    memberId              INT REFERENCES users(userId)
);

CREATE TABLE workoutclasses (
    workoutClassId SERIAL PRIMARY KEY,
    workoutClassType        VARCHAR(50),
    workoutClassDescription VARCHAR(255),
    trainerId               INT REFERENCES users(userId)
);
```

Update DatabaseConnection.java with your DB name / user / password.

## <a name="run"></a>6  Running the program

# 1) Make sure PostgreSQL is running and tables exist
# 2) Compile & run via Maven "mvn exec:java"

## <a name="clone"></a>7  Cloning & trying it yourself

git clone https://github.com/NyuSD/JavaSprintFinal
cd JavaSprintFinal

# edit src/main/java/org/keyin/database/DatabaseConnection.java
#  → put your PostgreSQL URL / user / password

psql -U postgres          # run the SQL schema above

mvn clean compile         # Java 17 required
mvn -Dexec.mainClass=org.keyin.GymApp exec:java


