package components;

/**
 * The PlantTrackerKernel interface defines the methods for managing plant tracking
 * functionality, including adding plants, watering them, displaying care instructions,
 * and listing all plants.
 */
public interface PlantTrackerKernel {

    /**
     * Adds a new plant to the tracker with specified care instructions.
     *
     * @param name              the name of the plant
     * @param careInstructions   the care instructions for the plant
     * @param wateringInterval   the interval for watering the plant (in days)
     */
    void addPlant(String name, String careInstructions, int wateringInterval);

    /**
     * Waters the specified plant if it needs watering.
     *
     * @param name the name of the plant to be watered
     */
    void waterPlant(String name);

    /**
     * Displays the care instructions and last watered date for the specified plant.
     *
     * @param name the name of the plant for which to display care instructions
     */
    void showCareInstructions(String name);

    /**
     * Displays a list of all plants in the tracker with their watering status.
     */
    void listAllPlants();
}
