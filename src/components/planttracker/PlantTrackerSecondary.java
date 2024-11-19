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
     * A nested static class representing a Plant.
     */
    protected static class Plant {
        private final String name;
        private final String species;
        private final int age;
        private final String careInstructions;

        /**
         * Constructs a Plant with the specified details.
         *
         * @param name the name of the plant
         * @param species the species of the plant
         * @param age the age of the plant (in years)
         * @param careInstructions the care instructions for the plant
         */
        public Plant(String name, String species, int age, String careInstructions) {
            this.name = name;
            this.species = species;
            this.age = age;
            this.careInstructions = careInstructions;
        }

        /**
         * Returns the name of the plant.
         *
         * @return the name of the plant
         */
        public String getName() {
            return this.name;
        }

        /**
         * Returns the species of the plant.
         *
         * @return the species of the plant
         */
        public String getSpecies() {
            return this.species;
        }

        /**
         * Returns the age of the plant.
         *
         * @return the age of the plant (in years)
         */
        public int getAge() {
            return this.age;
        }

        /**
         * Returns the care instructions for the plant.
         *
         * @return the care instructions for the plant
         */
        public String getCareInstructions() {
            return this.careInstructions;
        }

        /**
         * Provides a string representation of the plant.
         *
         * @return a string representation of the plant
         */
        @Override
        public String toString() {
            return "Plant{" +
                    "name='" + this.name + '\'' +
                    ", species='" + this.species + '\'' +
                    ", age=" + this.age +
                    ", careInstructions='" + this.careInstructions + '\'' +
                    '}';
        }

        /**
         * Checks if this plant is equal to another object.
         *
         * @param obj the object to compare with
         * @return true if the objects are equal, false otherwise
         */
        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || this.getClass() != obj.getClass()) {
                return false;
            }
            Plant plant = (Plant) obj;
            return this.age == plant.age &&
                    this.name.equals(plant.name) &&
                    this.species.equals(plant.species) &&
                    this.careInstructions.equals(plant.careInstructions);
        }
    }

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
