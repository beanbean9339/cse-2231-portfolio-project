package components.planttracker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The PlantTrackerSecondary class is an abstract implementation of the
 * PlantTrackerKernel interface. It manages a collection of plants using only kernel
 * methods.
 */
public abstract class PlantTrackerSecondary implements PlantTrackerKernel {
    // Nested static Plant class
    protected static class Plant {
        private final String name;
        private final String species;
        private final int age;
        private final String careInstructions;

        public Plant(String name, String species, int age, String careInstructions) {
            this.name = name;
            this.species = species;
            this.age = age;
            this.careInstructions = careInstructions;
        }

        public final String getName() {
            return this.name;
        }

        @Override
        public final String toString() {
            return "Plant Name: " + this.name + ", Species: " + this.species
                    + ", Age: " + this.age + " years, Care Instructions: "
                    + this.careInstructions;
        }
    }

    // The list of plants will be managed by subclasses using createRepresentation()
    private List<Plant> plants;

    /**
     * The addPlant method should be implemented by subclasses to ensure proper usage
     * of the kernel method.
     *
     * @param name the name of the plant
     * @param species the species of the plant
     * @param age the age of the plant (in years)
     * @param careInstructions the care instructions for the plant
     */
    @Override
    public abstract void addPlant(String name, String species, int age, String careInstructions);

    /**
     * Returns an unmodifiable list of all plants. This method uses the kernel method.
     *
     * @return a list of all plants
     */
    @Override
    public List<String> listAllPlants() {
        List<Plant> plantsList = this.createRepresentation();
        if (plantsList.isEmpty()) {
            System.out.println("No plants in the tracker.");
            return new ArrayList<>(); // Return an empty list if no plants
        } else {
            List<String> plantDetails = new ArrayList<>();
            for (Plant plant : plantsList) {
                plantDetails.add(plant.toString()); // Collect plant details
            }
            return plantDetails; // Return the list of plant details
        }
    }

    /**
     * Kernel method for retrieving all plants.
     *
     * @return an unmodifiable list of plants
     */
    protected List<Plant> getAllPlants() {
        return Collections.unmodifiableList(this.createRepresentation());
    }

    /**
     * Abstract kernel method that should be implemented by subclasses
     * to return the plant representation.
     *
     * @return a mutable list of plants
     */
    protected abstract List<Plant> createRepresentation();
}
