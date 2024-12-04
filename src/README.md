# Plant Tracker Component

## Overview

The Plant Tracker component provides an easy-to-use system for tracking and managing plants in a collection. It allows users to add, display, manage, and remove plants, as well as view important information like care instructions and whether a plant needs water. This component is modular, allowing for flexibility and scalability in handling plant data.

## Features

- **Add Plants**: Add new plants to the tracker with details such as name, species, age, and care instructions.
- **Display Plants**: Display all plants in the tracker with their details.
- **Watering Status**: Check which plants need water based on age or other criteria.
- **Remove Plants**: Easily remove plants from the tracker.
- **Clear All Plants**: Clear all plants from the tracker.
- **Transfer Plants**: Transfer plants between different trackers.
- **Modular Structure**: The component is designed with an abstract base class for easy extensibility.

## Components

The component is composed of several classes that work together to provide the full functionality:

- **Plant**: Represents a plant, holding details such as name, species, age, and care instructions.
- **PlantTracker**: The main class that tracks plants and provides core functionalities (add, display, remove, etc.).
- **PlantTracker1L**: A subclass of `PlantTracker`, providing version-specific functionality and behaviors.
- **PlantTrackerKernel**: A utility class for running plant management applications and testing the system.
- **PlantTrackerSecondary**: An abstract base class that defines common behaviors for all plant tracker implementations.

## Installation

To use the Plant Tracker component, you need to have a Java development environment set up. Follow these steps:

1. Clone the repository or download the source code.
2. Navigate to the `src` directory in your terminal.
3. Compile the classes using the following command:

   ```bash
   javac components/planttracker/*.java

Run the application using:

```bash
java components/planttracker/PlantTrackerKernel
```
## Usage
### Adding and Displaying Plants
The main functionality of the tracker is to add, display, and manage plants.

- Add a Plant: Add a new plant to the tracker by providing its name, species, age, and care instructions.
```java
tracker.addPlant("Rose", "Flowering", 2, "Water every 2 days");
```
- Display All Plants: Display all plants in the tracker with their details.
```java
tracker.displayAllPlants();
```
- List Plants That Need Water: List plants that require watering based on age or care instructions.
```java
tracker.listPlantsThatNeedWater();
```
- Remove a Plant: Remove a specific plant from the tracker by its name.
```java
tracker.removePlant("Rose");
```
- Clear All Plants: Clear all plants from the tracker.
```java
tracker.clear();
```
## Example Code
Here is an example of how to use the PlantTracker in a PlantCareSystem:

```java
import components.planttracker.*;

public class PlantCareSystem {

    public static void main(String[] args) {
        // Create a new instance of PlantTracker
        PlantTracker tracker = new PlantTracker();

        // Add plants
        tracker.addPlant("Rose", "Flowering", 2, "Water every 2 days");
        tracker.addPlant("Cactus", "Succulent", 5, "Water once a week");
        tracker.addPlant("Tulip", "Flowering", 1, "Water every 3 days");

        // Display all plants
        tracker.displayAllPlants();

        // List plants that need watering
        tracker.listPlantsThatNeedWater();

        // Remove a plant
        tracker.removePlant("Cactus");

        // Clear all plants
        tracker.clear();
    }
}
```
## Extending the Tracker
The component is designed for extensibility. You can create custom plant tracker implementations by extending the PlantTrackerSecondary class. For example, you might create a special tracker for tropical plants, adding specific care requirements or other features.

```java

public class TropicalPlantTracker extends PlantTrackerSecondary {

    @Override
    public void addPlant(String name, String species, int age, String careInstructions) {
        // Custom behavior for adding tropical plants
        super.addPlant(name, species, age, careInstructions);
    }

    @Override
    public void displayAllPlants() {
        // Custom display logic for tropical plants
        super.displayAllPlants();
    }
}
```

## Contributing
If you would like to contribute to the project, feel free to fork the repository, create a new branch, and submit a pull request. All contributions are welcome!

## License
This project is licensed under the MIT License - see the LICENSE file for details.

