# Rubik’s Cube 2FA Token Generator 

## Overview
This is a **proof-of-concept 2FA token generator** that uses the internal state of a **virtual Rubik’s Cube** as a high-entropy secret.  
After generating a random WCA-style scramble, the cube is scrambled in code, the full sticker configuration is encoded, hashed (SHA-256), and transformed into a 6-character ASCII token.  
This approach provides significantly higher entropy than traditional 6-digit OTPs.

## Why It Matters
-  **Stronger entropy:** A 6-character token using printable ASCII (~94 characters) yields ~39 bits of entropy — almost double the ~20 bits of typical 6-digit OTPs.  
-  **Statistically validated:** In large-scale tests (millions of tokens), collision rates aligned with theoretical predictions, demonstrating randomness and hash quality.  

## Getting Started

### Prerequisites
- Java 11 (or newer)  
- Maven or your preferred Java build tool  

### Build & Run
```bash
git clone https://github.com/edreynoso/Cube-Auth-Token-Generator.git
cd Cube-Auth-Token-Generator
mvn compile  # or javac src/main/java/…
mvn exec:java -Dexec.mainClass="Main"  # or run Main.java
