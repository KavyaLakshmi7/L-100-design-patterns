# Command Pattern - Approval Workflow

## 📌 Overview
This project demonstrates the **Command Design Pattern** using a real-world **Approval Workflow** example.  

The **Command Pattern** encapsulates a request as an object, allowing:
- Decoupling of the **Invoker** (who triggers the action) from the **Receiver** (who performs the action).
- Support for queuing, logging, undo/redo operations, and easy extensibility.

---

## 🏗️ Project Structure
```

CommandPattern/
│── Command.java                # Command interface
│── ApproveCommand.java         # Concrete command - Approve document
│── RejectCommand.java          # Concrete command - Reject document
│── RequestChangesCommand.java  # Concrete command - Request document changes
│── Manager.java                # Receiver - performs actual actions
│── ApprovalSystem.java         # Invoker - stores & executes commands
│── ApprovalClient.java         # Client - sets up commands & triggers execution

````

---

## ⚙️ Classes & Roles

1. **Command (Interface)**  
   - Declares `execute()` method for all commands.

2. **Concrete Commands**  
   - `ApproveCommand` → Approves a document.  
   - `RejectCommand` → Rejects a document.  
   - `RequestChangesCommand` → Requests modifications for a document.  

3. **Receiver (`Manager`)**  
   - Knows how to perform the actual approval, rejection, and request changes.

4. **Invoker (`ApprovalSystem`)**  
   - Stores commands in a queue.  
   - Executes them in order.  

5. **Client (`ApprovalClient`)**  
   - Creates commands and adds them to the invoker.  

---

## ▶️ How to Run
1. Compile the project:
   ```bash
   javac *.java
````

2. Run the client:

   ```bash
   java ApprovalClient
   ```

---

## 📖 Example Output

```
Manager: Approving document - Project Proposal
Manager: Rejecting document - Budget Report
Manager: Requesting changes for document - Design Document
```

---

## ✅ Benefits of Command Pattern

* Decouples the **request sender** (Approval System) from the **request receiver** (Manager).
* Supports **batch execution** of commands.
* Easily extendable by adding new commands (e.g., `EscalateCommand`, `ArchiveCommand`).
* Enables potential **undo/redo** operations by storing executed commands.

