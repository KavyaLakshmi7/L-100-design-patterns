# 🕹️ Memento Pattern - Game Checkpoint System

## 📌 Overview
The **Memento Pattern** is a behavioral design pattern that allows an object to save and restore its state without exposing its internal details.  
It’s useful for implementing **undo/redo** functionality, checkpoints, and history management.

In this example, we simulate a **game checkpoint system**, where the player's progress (position, health, and level) can be saved and restored later.

---

## 🛠️ Components

1. **Player (Originator)**  
   - Holds the game state (`position`, `health`, `level`).  
   - Can play, take damage, level up.  
   - Creates and restores checkpoints (`PlayerMemento`).  

2. **PlayerMemento (Memento)**  
   - Stores a snapshot of the `Player` state.  
   - Immutable (only getters, no setters).  

3. **CheckpointManager (Caretaker)**  
   - Stores checkpoints in a stack.  
   - Allows undoing to the previous checkpoint.  

4. **Game (Client)**  
   - Simulates gameplay, saving and restoring checkpoints.  

---

## 📂 Class Diagram

```

Player (Originator)
├── position, health, level
├── play()
├── levelUp()
├── saveCheckpoint() → PlayerMemento
└── restoreCheckpoint(PlayerMemento)

PlayerMemento (Memento)
├── position
├── health
└── level

CheckpointManager (Caretaker)
├── Stack<PlayerMemento> history
├── save(PlayerMemento)
└── undo() → PlayerMemento

Game (Client)
└── main()

```

---

## ▶️ Example Run

```

💾 Checkpoint saved.
Player moved to Forest and took 30 damage. Health: 70
💾 Checkpoint saved.
Player moved to Dungeon and took 50 damage. Health: 20
💾 Checkpoint saved.
Player moved to DragonLair and took 80 damage. Health: -60
Undoing to last checkpoint...
Rewind to checkpoint → Position: Dungeon, Health: 20, Level: 1
Level up! Now at Level 2 with full health.
💾 Checkpoint saved.
Undoing to last checkpoint...
Rewind to checkpoint → Position: Dungeon, Health: 20, Level: 1

````

---

## ✅ Key Benefits
- Provides **undo functionality** without exposing internal object details.  
- Saves complete snapshots of an object’s state.  
- Maintains history using a caretaker (here, the `CheckpointManager`).  

---

## 📖 Real-World Use Cases
- Game checkpoints / save files  
- Text editor undo/redo  
- Transaction rollback in databases  
- Version control systems  

---

## 🚀 How to Run
1. Compile all `.java` files:  
   ```bash
   javac *.java
````

2. Run the program:

   ```bash
   java Game
   ```
