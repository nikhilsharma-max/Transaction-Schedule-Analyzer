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


# Day 2 - Precedence Graph, Cycle Detection & Serializability Analysis

## Date
09 June 2026

---

# Goal of Today's Session

Today's objective was to complete the core graph-based logic of the Transaction Schedule Analyzer.

The focus was on:

- Building the precedence graph
- Detecting cycles in the graph
- Determining conflict serializability
- Generating serial schedules using topological sorting
- Improving project architecture using a service layer
- Generating all possible valid serial schedules

---

# Features Implemented

## 1. Graph Data Structure

Created:

```text
graph/Graph.java
```

Responsibilities:

- Store transactions as vertices
- Store precedence relationships as directed edges
- Provide graph utility methods

Implemented methods:

- addVertex()
- addEdge()
- getNeighbors()
- getVertices()
- toString()

Example:

```text
T1 -> T2
T1 -> T3
```

Stored as:

```text
1 -> [2, 3]
2 -> []
3 -> []
```

---

## 2. Precedence Graph Builder

Created:

```text
graph/PrecedenceGraphBuilder.java
```

Responsibilities:

- Create graph from operations and conflicts
- Add all transactions as vertices
- Add conflict-based edges

Pipeline:

```text
Operations
    +
Conflicts
    ↓
Precedence Graph
```

---

## 3. Cycle Detection

Created:

```text
graph/CycleDetector.java
```

Algorithm:

- DFS
- Visited Set
- Recursion Stack

Purpose:

```text
Cycle Present
    ↓
Not Conflict Serializable
```

```text
No Cycle
    ↓
Conflict Serializable
```

Example:

```text
T1 -> T2
T2 -> T1
```

Result:

```text
Cycle Found
```

---

## 4. Topological Sorting

Created:

```text
graph/TopologicalSorter.java
```

Algorithm:

- Kahn's Algorithm
- In-Degree Method

Purpose:

Generate a valid serial schedule.

Example:

```text
T1 -> T2
```

Output:

```text
[T1, T2]
```

---

## 5. All Topological Orders

Created:

```text
graph/AllTopologicalSorts.java
```

Algorithm:

- Backtracking
- Recursive exploration of all zero in-degree nodes

Purpose:

Generate all valid serial schedules.

Example:

Graph:

```text
T1 -> T2

T3
```

Generated schedules:

```text
[T1, T2, T3]
[T1, T3, T2]
[T3, T1, T2]
```

This feature aligns directly with the original project goal.

---

## 6. Analysis Result Model

Created:

```text
models/AnalysisResult.java
```

Purpose:

Store complete analysis output.

Contains:

- Serializable status
- Conflict list
- Precedence graph
- All serial schedules

Implemented:

```java
toString()
```

for easy debugging and console output.

---

## 7. Service Layer

Created:

```text
analyzer/SerializabilityAnalyzer.java
```

Purpose:

Act as the central coordinator of the application.

Workflow:

```text
Schedule
    ↓
Parser
    ↓
Conflict Detector
    ↓
Graph Builder
    ↓
Cycle Detector
    ↓
Topological Sort
    ↓
Analysis Result
```

This significantly improved code organization.

---

# Important Concepts Learned

## Conflict Does NOT Mean Non-Serializable

Example:

```text
R1(X)
W2(X)
```

Conflict exists.

Graph:

```text
T1 -> T2
```

No cycle.

Therefore:

```text
Conflict Serializable
```

---

## Precedence Graph Concept

Edge:

```text
T1 -> T2
```

Means:

```text
T1 must appear before T2
```

in every valid serial schedule.

---

## Topological Sort

Learnt how topological sorting can be used to generate valid serial schedules from a precedence graph.

---

## All Topological Orders

Learnt how backtracking can generate all possible valid serial schedules rather than just one.

---

# Problems Encountered

## 1. Package Errors

Issue:

```text
Incorrect package declaration
```

Cause:

Folder structure did not match package names.

Solution:

Reorganized project into:

```text
src/
 ├── app/
 ├── analyzer/
 ├── graph/
 ├── models/
 └── parser/
```

---

## 2. Java Execution Errors

Issue:

```text
Could not find or load main class
```

Cause:

Incorrect execution command for packaged classes.

Solution:

Learnt correct compilation and execution process.

---

## 3. Duplicate AnalysisResult Class

Issue:

```text
models.AnalysisResult cannot be converted to app.AnalysisResult
```

Cause:

Two AnalysisResult classes existed in different packages.

Solution:

Removed duplicate class and kept only:

```text
models/AnalysisResult.java
```

---

# Current Project Status

Backend Progress:

```text
Parser                     ✅
Conflict Detection         ✅
Graph Construction         ✅
Cycle Detection            ✅
Topological Sort           ✅
All Serial Schedules       ✅
Service Layer              ✅
Analysis Result DTO        ✅
```

Overall Backend Completion:

```text
~95%
```

---

# Sample Output

```text
===== ANALYSIS RESULT =====

Serializable: YES

Conflicts:
R1(X) -> W2(X)

Precedence Graph:
1 -> [2]
2 -> []
3 -> []

All Valid Serial Schedules:
1. T1 T2 T3
2. T1 T3 T2
3. T3 T1 T2
```

---

# Next Steps

## Backend

- Freeze Version 1 backend
- Convert project into Spring Boot REST API

Endpoints:

```text
POST /analyze
```

---

## Frontend

Tech Stack:

- React
- TypeScript
- Tailwind CSS
- React Flow

Planned Features:

- Schedule Input
- Conflict Visualization
- Precedence Graph Visualization
- Serializable Status
- Serial Schedule Display

---

# Key Achievement

Today the project evolved from a collection of individual classes into a complete graph-based DBMS serializability analysis engine capable of:

- Detecting conflicts
- Building precedence graphs
- Detecting cycles
- Determining conflict serializability
- Generating all valid serial schedules