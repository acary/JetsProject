# Jets Project

### Description

This application creates a fleet of jets with different capabilities.

##### Running the program:
```
- Import project into Eclipse
- Compile and run main in `JetsApplication.java`
```

The application includes a menu to use the jets and access information about them.

The menu consists of:

```
1. List fleet
2. Fly all jets
3. View fastest jet
4. View jet with longest range
5. Set drone laser and frequency
6. Drone offensive!
7. Add a jet to Fleet
8. Remove a jet from Fleet
9. Quit
```

### UML

![UMLJets](https://user-images.githubusercontent.com/1522180/156845982-7a240f88-9041-4861-9996-217c00ecc60e.png)

- The above image shows a representative UML class diagram.

### Lessons Learned

- The try-with-resources statement that initializes the Scanner ensures that each resource is closed at the end of the statement. A resource is an object that must be closed after the program is finished with it.
- Searching through the Collection with an `enhanced for loop` with nested `if` statement that checks each element using `instanceof` helps identify appropriate items (i.e. belonging to a certain `Class`).
- Abstract classes can be extended by other abstract classes (i.e. `Jet` and `Cargo`) which can be extended by concrete class implementations (i.e. `CargoCarrier`).
- Classes can implement multiple interfaces (i.e. `Drone implements Autonomous, Shielded`) but just one abstract class (multiple inheritance not allowed in Java).

### Technologies Used

- JavaSE-1.8
  - Abstract classes
  - Interfaces
  - File I/O
  - Collections
- Eclipse IDE

### Author

- Andy Cary (@acary)
