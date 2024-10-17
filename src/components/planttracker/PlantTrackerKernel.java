package components.planttracker;

/**
 * Kernel interface for the PlantTracker component.
 */
public interface PlantTrackerKernel {

    /**
     * Adds a new plant to the tracker.
     *
     * @param plantName The name of the plant.
     * @param plantType The type of the plant.
     * @param waterFrequency The frequency at which the plant needs to be watered.
     * @return true if the plant was added successfully, false otherwise.
     * @ensures The plant is now tracked in the system.
     */
    boolean addPlant(String plantName, String plantType, int waterFrequency);

    /**
     * Removes a plant from the tracker.
     *
     * @param plantName The name of the plant to be removed.
     * @return true if the plant was removed successfully, false otherwise.
     * @ensures The plant is no longer tracked in the system.
     */
    boolean removePlant(String plantName);

    /**
     * Retrieves information about a specific plant.
     *
     * @param plantName The name of the plant to retrieve information for.
     * @return A string containing the plant's details, or null if the plant is not found.
     * @ensures The plant details are retrieved.
     */
    String getPlantInfo(String plantName);

    /**
     * Updates the watering frequency for a specific plant.
     *
     * @param plantName The name of the plant to update.
     * @param newWaterFrequency The new watering frequency.
     * @return true if the frequency was updated successfully, false otherwise.
     * @ensures The watering frequency for the plant is updated.
     */
    boolean updateWateringFrequency(String plantName, int newWaterFrequency);

    /**
     * Lists all tracked plants.
     *
     * @return An array of strings containing the names of all tracked plants.
     * @ensures The list of tracked plants is returned.
     */
    String[] listPlants();
}
