package components.planttracker;

import java.util.ArrayList;
import java.util.List;

/**
 * The PlantTrackerSecondary class manages a collection of plants.
 */
public class PlantTrackerSecondary {
    private List<Plant> plants;

    /**
     * Constructor to initialize the plant tracker.
     */
    public PlantTrackerSecondary() {
        this.plants = new ArrayList<>();
    }

    /**
     * Method to add a plant.
     *
     * @param name              the name of the plant
     * @param species           the species of the plant
     * @param age               the age of the plant (in years)
     * @param careInstructions   the care instructions for the plant
     */
    public void addPlant(String name, String species, int age, String careInstructions) {
        Plant newPlant = new Plant(name, species, age, careInstructions);
        this.plants.add(newPlant);
        System.out.println("Added plant: " + newPlant);
    }

    /**
     * Method to get details of all plants.
     *
     * @return a list of all plants
     */
    public List<Plant> getAllPlants() {
        return this.plants;
    }

    /**
     * Method to get a specific plant by name.
     *
     * @param name the name of the plant to retrieve
     * @return the Plant object if found, null otherwise
     */
    public Plant getPlantByName(String name) {
        for (Plant plant : this.plants) {
            if (plant.getName().equalsIgnoreCase(name)) {
                return plant;
            }
        }
        return null; // Return null if not found
    }

    /**
     * Method to display all plants.
     */
    public void displayAllPlants() {
        if (this.plants.isEmpty()) {
            System.out.println("No plants in the tracker.");
        } else {
            System.out.println("Plants in tracker:");
            for (Plant plant : this.plants) {
                System.out.println(plant);
            }
        }
    }
}

