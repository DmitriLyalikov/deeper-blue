# deeper-blue
A Java based chess engine application from scratch.

# **Chess Engine and Interface Project**
# Team Jason, Frenki, Joel, Dmitri

## Introduction
This project will explore and develop a chess engine (automated opponent) that can play with a user over a chess board in the form of a graphical user interface. It shall be able to participate in a complete chess match playing as both colors and follow the rules, as well as be able to declare different states of the game (checkmate, stalemate). 

It shall also take a reasonably small amount of time to respond to opponent moves, such that it is not unenjoyable to play with the software. 

The GUI that is played on shall adhere to the standard chess board. 

The chess engine shall be able to consistently win as both colors against another automated chess engine that is rated 1000 elo or more. 

This application shall be platform independent (modern Windows, macOS, Linux)

This application shall be extensible and designed as modules which can be continuously improved upon. 
### Definitions and Acronyms
* GUI: Graphical User Interface
* elo: standard chess rating system (https://www.chess.com/terms/elo-rating-chess)


## Process Description
The lifecycle of this project will follow generally a waterfall approach, with distinct phases of requirement gathering, design, implementation, verification/validation, and release/maintenance.

Each of these phases will have clear criteria for entering and exiting the next phase of the design. 

Because the idea of this project is to build the system from scratch, the system can take the form of an evolutionary prototype in the release/maintenance phase as we build upon consecutive iterations. For example, after achieving the original requirements of a 1000 elo in the chess engine, we may decide we can further improve the the engine by using a more efficient or different algorithm. This is why the requirement of being extensible is important in the maintenance phase.
### System Requirements
This phase will involve internal discussion and feedback from the professor and others on how to quantify the 'enjoyability' of the application. response times, visual design, GUI reactions, etc will be considered and created as requirements to test. 

It will also describe at a high level what a functional chess engine should be capable in the form of testeable requirements. 

### Design
After confirming with the team that the requirements are reasonable, testable, and coherent with each other, A high level architectural design will be created that outlines how our software product will achieve these requirements. This can be a UML diagram that describes how software modules will interact with each other. This will be cross checked again.

After the architecture of the product is generally agreed upon, each module within this design will be populated with more practical behavior descriptions in the form of placeholder functions, classes, etc. For example, the GUI module may have a specific behavior to respond to an event of user input, this will be implemented in pseudocode.

Along with this process, tests will be created at this point that will be also verified to correctly test the original requirements that were agreed upon. 

### Implementation

### Validation
### Verification
### Debug
### Release/Maintenance
## Roles
### **Joel**
### **Dmitri**
### **Jason**
### **Frenki** 

### Roles Table
It is noted that no matter what roles each team member is, all of them will be responsible for development of the software product. Also, each role does not have complete authority to drive their specific domain, they just initiate and formalize the aspect of their contribution, and the rest of the team should discuss and eventually agree on the decisions. For example, the architect will create the first high level design structure, but after getting feedback from the rest of the team, will revise until it is accepted.
* Architect: 
    The architect will be responsible for initiating the design and adherence to the high level architecture that meets the engineering requirements. He will also create and maintain the project structure in the Java environment.
* Test Developer:
    This role will work with the architect to ensure testability of the requirements and the design being implemented, this will involve creating test cases, integration tests, and approving team pull requests to the master branch. 
* GUI front end:
    This developing role will particularly focus on the design and adherence to the harder to quantify aspects of the requirements such as enjoyability and experience. This has the freedom to design and use whichever libraries are needed to meet this.
* Algorithm Developer:
    This role will focus on the implementation and optimization of the logical modules of the chess algorithm. This involves the selection of the correct ones, and understanding the tradeoffs and benefits of using each one.
