# fa18-202-pheonix

Phoenix team has developed a single player game called "The walking Dead".

## Team members:

Kriti Jar

Ruchika Hazariwal

Harsh Agarwal

Hemaprasanthi Mutyala

## Design Patterns

### State Design Pattern: For game Levels (Kriti Jar)

LevelOneState: Initial level of game. It includes 5 zombies.

LevelTwoState: The number of zombies are 8 in level two. 

LevelThreeState: The number of zombies are 10. Once the zombies are killed Final banner is shown.

### Observer Design Pattern (Kriti Jar)

Subject: Human and Bullet

Observers: ItemCollectionObserver and SoundObserver

Observer pattern keep tracks of all the items which are intersected by human or bullet and notifies the observers.
Ex. When human collects kit, ItemCollectionObserver is notifies that updates the message to 'Kit Available'.

If human, collects the sword, soundObserver is notified that plays the sound in background.








