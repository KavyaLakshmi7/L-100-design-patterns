# Proxy Pattern 🎭

## Goal

Provide a surrogate or placeholder object to control access to another object.
In this example, the **ProxyVideo** class acts as a protective layer for **RealVideo**, controlling access based on whether the user is premium or not.

---

## How It Works

* The client interacts with the `Video` interface.
* `ProxyVideo` decides whether to allow access:

  * **Premium users** → allowed to stream via `RealVideo`.
  * **Non-premium users** → access denied with an upgrade prompt.
* The actual heavy object (`RealVideo`) is only created if needed (lazy initialization).

---

## Files

* **ProxyPattern.java** → Main program: handles user input and simulates the proxy scenario.
* **ProxyVideo.java** → Proxy implementation, enforces access control.
* **RealVideo.java** → Real object that streams the video.
* **Video.java** → Common interface for both proxy and real object.

---

## Run

```bash
javac *.java
java ProxyPattern
```

---

## Example Run

```
Enter your username:
Kavya
Are you a premium user? (yes/no):
no
Enter the video you want to play:
Avengers
Access Denied. Upgrade to premium to watch Avengers
```

```
Enter your username:
Lakshmi
Are you a premium user? (yes/no):
yes
Enter the video you want to play:
Inception
Streaming video: Inception for user: Lakshmi
```

---

## Why This Design?

* **Access Control**: Restricts non-premium users.
* **Lazy Initialization**: `RealVideo` created only when necessary.
* **Decoupling**: Clients interact with `Video` interface, not concrete classes.
* **Flexible Extension**: Different proxy types (logging, caching, security) can be added later without changing the client code.
