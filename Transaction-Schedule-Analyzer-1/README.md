# Transaction Schedule Analyzer

## Day 1 - Project Setup and Core Model Design

### Date

08 June 2026

---

## Project Goal

The goal of this project is to build a Transaction Schedule Analyzer capable of:

* Checking whether a schedule is Conflict Serializable.
* Constructing the Precedence Graph.
* Detecting cycles in the graph.
* Generating all possible serial schedules using topological ordering.
* Providing a visual and deployable interface in later stages.

This project combines concepts from:

* DBMS (Conflict Serializability)
* Data Structures and Algorithms (Graphs, DFS, Topological Sort)
* Java OOP
* Software Engineering

---

## Work Completed Today

### 1. Project Planning

Finalized the project idea:

Transaction Schedule Analyzer

Input:
A transaction schedule containing operations such as:

R1(X) W2(X) R3(Y)

Output:

* Conflict detection
* Precedence graph
* Serializable / Non-Serializable result
* All valid serial schedules

---

### 2. Designed Initial Architecture

Created the initial folder structure:

src/
├── app/
│   └── Main.java
│
└── models/
├── OperationType.java
├── Operation.java
├── Transaction.java
└── Conflict.java

Purpose:

* app package contains application entry point.
* models package contains domain entities.

---

### 3. Learned Java Packages

Studied the purpose of packages in Java.

Key Learnings:

* Packages are used to organize classes.
* Packages prevent naming conflicts.
* Package names must match folder structure.
* Packages become part of the class identity.

Example:

models.Operation

instead of simply:

Operation

---

### 4. Fixed Package Structure Issues

Encountered package-related compilation errors.

Problems:

* Incorrect package declarations.
* Confusion between source root and package names.
* Main class execution issues.

Resolution:

* Created proper src directory.
* Created app and models packages.
* Fixed package declarations.
* Learned how Java resolves package paths.

---

### 5. Learned Java Enum

Studied enum for the first time.

Purpose:

OperationType should only allow:

* READ
* WRITE

Created:

OperationType.java

Key Learning:

Enums restrict values to a predefined set of constants.

---

### 6. Implemented Operation Model

Designed the Operation class.

Fields:

* operationType
* transactionId
* dataItem

Implemented:

* Constructor
* Getters
* Setters

Example Operation:

R1(X)

Stored as:

operationType = READ
transactionId = 1
dataItem = X

---

### 7. Learned About toString()

Studied why Java prints object references by default.

Learned:

* Every class inherits toString() from Object.
* Overriding toString() improves debugging.
* Useful when printing objects and collections.

---

## Challenges Faced

### Challenge 1

Package errors in VS Code.

Reason:

Package declaration did not match folder structure.

Solution:

Reorganized project structure and corrected package names.

---

### Challenge 2

Main class execution error.

Reason:

Code Runner attempted to run Main instead of app.Main.

Solution:

Learned how Java package-qualified class names work.

---

### Challenge 3

Understanding the purpose of packages.

Solution:

Compared packages with folders and understood how large projects are organized.

---

## Key Concepts Learned Today

* Java Packages
* Java Enums
* OOP Modeling
* Constructors
* Getters and Setters
* toString()
* Project Structure Design
* Source Root vs Package
* Class Organization

---

## Files Completed

Completed:

* OperationType.java
* Operation.java

Pending:

* Transaction.java
* Conflict.java

---

## Plan for Day 2

1. Design Transaction.java
2. Design Conflict.java
3. Test interaction between all model classes
4. Improve Operation model if required
5. Prepare for ScheduleParser implementation

---

## Progress Summary

Current Stage:

Project Foundation and Domain Modeling

Status:

Day 1 Completed Successfully
