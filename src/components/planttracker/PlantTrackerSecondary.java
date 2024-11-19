package components.planttracker;

import java.util.Collections;
import java.util.List;

/**
 * The PlantTrackerSecondary class manages a collection of plants.
 * This class implements the PlantTrackerKernel interface and
 * provides methods to add and retrieve plants.
 */
public abstract class PlantTrackerSecondary implements PlantTrackerKernel {

    /**
     * Adds a plant to the collection.
     *
     * @param name The name of the plant.
     * @param species The species of the plant.
     * @param age The age of the plant.
     * @param careInstructions The care instructions for the plant.
     */
    @Override
    public abstract void addPlant(String name, String species, int age, String careInstructions);

    /**
     * Retrieves an unmodifiable list of all plants.
     *
     * @return a list of all plants
     */
    protected List<Plant> getAllPlants() {
        return Collections.unmodifiableList(this.createRepresentation());
    }

    /**
     * Creates a representation of the plant collection.
     * This method should be implemented by subclasses to provide the actual list of plants.
     *
     * @return a list of plants
     */
    protected abstract List<Plant> createRepresentation();
}
