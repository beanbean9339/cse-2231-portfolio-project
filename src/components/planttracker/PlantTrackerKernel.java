package components.planttracker;

import java.util.List;

/**
 * The PlantTrackerKernel interface defines methods for plant tracking functionality.
 */
public interface PlantTrackerKernel {

    /**
     * Adds a new plant to the tracker with specified care instructions.
     *
     * @param name the name of the plant
     * @param species the species of the plant
     * @param age the age of the plant (in years)
     * @param careInstructions the care instructions for the plant
     */
    void addPlant(String name, String species, int age, String careInstructions);

    /**
     * Lists all the plants.
     *
     * @return a list of all plant names or details
     */
    List<String> listAllPlants();

    /**
     * Water the plant if it needs watering.
     *
     * @param name the name of the plant
     */
    void waterPlant(String name);

    /**
     * Show the care instructions for a plant.
     *
     * @param name the name of the plant
     */
    void showCareInstructions(String name);

    /**
     * Display detailed information for all plants.
     */
    void displayAllPlants();

    /**
     * Get a random plant from the tracker and display its information.
     */
    void getRandomPlant();

    /**
     * List all plants that need water.
     */
    void listPlantsThatNeedWater();

    /**
     * Count the number of plants in the tracker.
     *
     * @return the number of plants
     */
    int countPlants();

    /**
     * Remove a plant from the tracker.
     *
     * @param name the name of the plant to remove
     */
    void removePlant(String name);
}
