# The Fate of Middle-earth – A Java RPG

## About the Project

**The Fate of Middle-earth** is a text-based RPG (Role-Playing Game) developed in Java and inspired by J.R.R. Tolkien's *The Lord of the Rings* universe.

The player takes on the role of a hero who must prepare for a series of battles against the forces of darkness, ultimately facing Sauron, the Dark Lord, and potentially Morgoth, the First Dark Lord.

The game features character creation, class selection, weapon equipment, inventory management, consumable items, character progression, training battles, and boss encounters.

The project was developed as a practical application of **Object-Oriented Programming (OOP)** concepts in Java.

**Important:** The game interface, menus, character names, and in-game messages are entirely in Portuguese. The source code and original game experience have been preserved in their original language. This README provides English explanations and translations to make the project accessible to international developers and recruiters.

## Game Overview

The adventure begins at the gates of Barad-dûr, where Sauron awaits the player.

Before entering combat, the player must create a hero, choose a character class, equip a weapon, and select items to carry in their inventory.

Players can also choose to fight Orcs to gain experience before facing the main boss.

After defeating Sauron, a final challenge becomes available: facing Morgoth, the First Dark Lord.

## Main Features

### 1. Character Creation

Players can create their own hero by entering a name and selecting one of five character classes:

| Portuguese | English |
|---|---|
| Humano | Human |
| Mago | Wizard |
| Elfo | Elf |
| Anão | Dwarf |
| Hobbit | Hobbit |

Each character is represented through its own class in the game's object-oriented structure.

### 2. Weapon Selection

Players can choose their preferred weapon before entering combat.

| Portuguese | English | Description |
|---|---|---|
| Espada | Sword | Balanced damage |
| Machado | Axe | Variable damage |
| Cajado | Staff | Magic-based weapon |
| Arco | Bow | Ranged attacks |

### 3. Inventory Management

Before starting the adventure, players can collect supplies and manage their inventory.

The inventory has a maximum capacity of 10 items.

Available consumable items include:

| Portuguese | English | Effect |
|---|---|---|
| Poção de Vida | Health Potion | Restores 30 HP |
| Poção de Força | Strength Potion | Increases attack by 10 |
| Poção de Defesa | Defense Potion | Increases defense by 10 |

Players can select multiple items until their inventory is full or they decide to proceed.

### 4. Training and Experience

Before confronting Sauron, players can choose to train by fighting Orcs.

Training battles provide an opportunity to gain experience (XP) and improve the character before the main encounter.

Players can continue fighting new Orcs or proceed directly to the boss battle.

### 5. Boss Battles

The game features two major encounters:

- **Sauron – The Dark Lord:** the main boss encountered after character preparation and optional training.
- **Morgoth – The First Dark Lord:** an optional final challenge unlocked after defeating Sauron.

The final encounter allows players to continue using their hero at the level achieved throughout the adventure.

## Object-Oriented Programming

The project was designed using an object-oriented approach, organizing the game into separate classes and entities.

The main class coordinates the game flow and interacts with the other components.

The code demonstrates the use of object-oriented design through concepts such as:

- **Classes and Objects:** representation of characters, weapons, items, and battles.
- **Encapsulation:** organization of data and operations within individual classes.
- **Inheritance:** character and weapon types are represented through specialized classes.
- **Polymorphism:** the main class interacts with different character and weapon implementations through shared reference types.

These concepts help organize the game's components and separate responsibilities across different entities.

## Technologies

- Java
- Object-Oriented Programming (OOP)
- Java Collections Framework
- Java Scanner API
- Console-based user interaction

## Project Structure

The project is organized into multiple Java classes, each responsible for a specific part of the game.

The main components include:

| Component | Responsibility |
|---|---|
| `Main` | Controls the game flow and player interactions |
| `Combatente` | Represents the base combat character |
| `Humano`, `Mago`, `Elfo`, `Anao`, `Hobbit` | Represent playable character classes |
| `Arma` | Represents the weapon abstraction |
| `Espada`, `Machado`, `Cajado`, `Arco` | Represent different weapon types |
| `Item` | Represents inventory items |
| `PocaoVida`, `PocaoForca`, `PocaoDefesa` | Represent consumable items |
| `Batalha` | Manages combat encounters |
| `Orque` | Represents Orc enemies |
| `Sauron` | Represents the boss implementation used in the encounters |

## Portuguese-to-English Game Translation

Although the game is entirely in Portuguese, the following glossary explains the most important terms displayed during gameplay.

### Main Menu and Game Messages

| Portuguese | English |
|---|---|
| O Destino da Terra Média | The Fate of Middle-earth |
| Você chegou aos portões de Barad-dûr | You have reached the gates of Barad-dûr |
| Sauron desce de seu trono para enfrentá-lo | Sauron descends from his throne to face you |
| Preparação do Herói | Hero Preparation |
| Deseja treinar antes de enfrentar Sauron? | Would you like to train before facing Sauron? |
| Sim | Yes |
| Não | No |
| Escolha | Choose |
| Fim de jogo | Game Over |
| A Batalha Final de Verdade | The True Final Battle |
| Aposentar-se como lenda | Retire as a Legend |

### Inventory and Equipment

| Portuguese | English |
|---|---|
| Suprimentos de Guerra | War Supplies |
| Mochila Atual | Current Inventory |
| Vazia | Empty |
| Itens disponíveis para pegar | Available Items |
| Escolha um item | Select an Item |
| Mochila fechada! Rumo à batalha! | Inventory closed! On to battle! |
| A mochila já está cheia! | The inventory is already full! |
| Escolha sua arma | Choose your weapon |

### Combat and Progression

| Portuguese | English |
|---|---|
| Orc selvagem apareceu | A wild Orc has appeared |
| Enfrentar Orcs para ganhar XP | Fight Orcs to gain XP |
| Continuar treinando | Continue Training |
| Ir para Sauron | Proceed to Sauron |
| Você morreu durante o treinamento | You died during training |
| Você sente uma presença terrível | You sense a terrible presence |
| Sauron, o Senhor do Escuro | Sauron, the Dark Lord |
| Morgoth, o Primeiro Senhor do Escuro | Morgoth, the First Dark Lord |
| A última batalha começa agora | The final battle begins now |

## How to Run

The project requires a Java Development Kit (JDK) installed on your computer.

If the Java source files are located in the same directory and do not use package declarations, you can compile the project using:

```bash
javac *.java
```

Then run the game with:

```bash
java Main
```

The game runs in the terminal and uses numbered options for player interaction.

## Project Goals and Learning Outcomes

This project provided practical experience in:

- Applying Object-Oriented Programming principles.
- Designing and organizing multiple interacting Java classes.
- Modeling game entities and their relationships.
- Implementing character and weapon selection systems.
- Managing inventories and consumable items.
- Developing turn-based combat interactions.
- Implementing game progression through experience points.
- Organizing application logic into separate responsibilities.

## Project Status

Academic Java project developed as an exploration of Object-Oriented Programming through a console-based RPG inspired by Middle-earth.

The original implementation and Portuguese game interface are maintained as part of the project's design.
