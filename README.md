# Transaction Schedule Analyzer

A full-stack web application that analyzes database transaction schedules for **conflict serializability**, generates the **precedence graph**, detects conflicts, and computes all valid serial schedules.

---
# Link to webApp
https://transaction-schedule-analyzer.vercel.app/

## Features

* Build transaction schedules interactively
* Detect conflicting operations
* Generate precedence graph automatically
* Check whether a schedule is conflict-serializable
* Display all valid serial schedules (Topological Orders)
* Visual graph visualization using React Flow
* Serializable and Non-Serializable example schedules
* Responsive UI for desktop and mobile devices
* Backend integration with Java-based analysis engine

---

## Tech Stack

### Frontend

* React
* Vite
* Axios
* React Flow
* CSS

### Backend

* Node.js
* Express.js

### Core Analysis Engine

* Java

---

## Project Architecture

Frontend (React)
↓
Axios API Calls
↓
Backend (Node.js + Express)
↓
Java Serializability Analyzer
↓
JSON Response
↓
Frontend Visualization

---

## How It Works

### 1. Parse Schedule

The schedule is converted into a list of operations.

Example:

R1(X) W2(X) R3(Y)

---

### 2. Detect Conflicts

Conflicting operations are identified:

* Read → Write
* Write → Read
* Write → Write

on the same data item between different transactions.

---

### 3. Build Precedence Graph

Transactions become graph nodes.

Conflicts create directed edges.

Example:

T1 → T2

---

### 4. Cycle Detection

* Cycle Present → Not Serializable
* No Cycle → Serializable

---

### 5. Generate Serial Schedules

If the graph is acyclic, all topological orders are generated.

These represent all valid serial schedules.

---

## Example Serializable Schedule

R1(X) W2(X)

Output:

Serializable: YES

Conflicts:

R1(X) → W2(X)

Valid Serial Schedule:

T1 → T2

---

## Example Non-Serializable Schedule

R1(X) W2(X) R2(Y) W1(Y)

Output:

Serializable: NO

Reason:

Cycle exists in precedence graph.

---

## Installation

### Clone Repository

```bash
git clone <repository-url>
cd Transaction-Schedule-Analyzer
```

---

### Frontend Setup

```bash
cd Frontend
npm install
npm run dev
```

Frontend runs at:

```text
http://localhost:5173
```

---

### Backend Setup

```bash
cd Backend
npm install
node server.js
```

Backend runs at:

```text
http://localhost:8080
```

---

### Java Compilation

Navigate to:

```text
Backend/Transaction-Schedule-Analyzer-1/src
```

Compile:

```bash
javac app/ApiMain.java
```

---

## Environment Variables

Frontend `.env`

```env
VITE_API_URL=http://localhost:8080
```

Frontend `.env.production`

```env
VITE_API_URL=<production-backend-url>
```

---

## API Endpoint

### Analyze Schedule

POST

```text
/analyze
```

Request:

```json
{
  "schedule": "R1(X) W2(X)"
}
```

Response:

```json
{
  "serializable": true,
  "conflicts": [
    "R1(X) -> W2(X)"
  ],
  "graph": {
    "nodes": [
      {
        "id": "T1"
      },
      {
        "id": "T2"
      }
    ],
    "edges": [
      {
        "source": "T1",
        "target": "T2"
      }
    ]
  },
  "serialSchedules": [
    [
      "T1",
      "T2"
    ]
  ]
}
```

---

## Screenshots

### Home Page

(Add screenshot)

### Serializable Schedule Analysis

(Add screenshot)

### Non-Serializable Schedule Analysis

(Add screenshot)

### Precedence Graph Visualization

(Add screenshot)

---

## Future Improvements

* View Serializability Steps Animation
* Export Analysis Report as PDF
* Support for Larger Transaction Sets
* Schedule Import via Text File
* Dark Mode Support
* Execution Timeline Visualization

---

## Learning Outcomes

This project demonstrates:

* Conflict Serializability
* Precedence Graph Construction
* Cycle Detection in Directed Graphs
* Topological Sorting
* Full-Stack Development
* Java + Node.js Integration
* API Design
* React State Management

---

## Author

Nikhil Sharma

B.Tech CSE Student

Focused on Database Systems, Full-Stack Development, Open Source, and GSoC Preparation.
