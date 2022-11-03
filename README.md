## NEW BUILDING CLASS FEATURES: 

 - Overloaded constructors, adding some flexibility about how `Building`s are constructed
 - Various methods for interacting with the building (e.g. `enter()`, `exit()`, `goUp()`, `goDown()`, and `goToFloor(int n)`).
 - A handy `showOptions()` method to tell the user what options are available
 - A few additional class attributes (feel free to explore) 

## Phase 1: Overriding Methods
The `Building` class provides a lot of useful functionality, but some of it doesn't quite work for all three of our `Building` subclasses. This isn't a problem: we'll just **override** them!  _Hint: use `super` whenever possible to avoid duplicating code!_

### `showOptions()`
Since each of the three subclasses have additional options, start by overriding the `showOptions()` method to reflect the subclass-specific options for `House`, `Library`, and `Cafe`.

### `goToFloor(int n)`
Most `Library` buildings (and some `House`s as well) have elevators, which means it is possible to move between non-adjacent floors in a single action. Override the `goToFloor(int n)` method to reflect this. _Hint: you may want to add a `boolean` attribute to elevator-friendly classes to indicate whether or not the building has an evelator, and use this in determining whether or not a call to `goToFloor(...)` is valid._


## Phase 2: Overloading Methods
As we see in the `Building` class, it can often be handy to have multiple versions of a method to handle different types/numbers of input. For this phase, implement **at least 2** overloaded methods for each of the subclasses. You may choose to overload only the constructors, or any other methods of your choosing. 

**Please document which methods you overloaded (and why!) in your `reflection.md`**

## Phase 3: `CampusMap.java`
We'll use the `CampusMap` class to **aggregate** many different `Building`s together:

Expanding on the example in `CampusMap.main(...)`, add at least 10 more of your favorite Smith College buildings.

## Kudos (OPTIONAL)
Want to test your programming chops out on a stretch goal that will help prepare you for your final project? See if you can make your map **interactive** by implementing a `loop` that enables the user to explore various buildings and make use of their various methods (e.g. moving into a `House`, checking out a book at the `Library` or buying a cup of coffee at the `Cafe`).
