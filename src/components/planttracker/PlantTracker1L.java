package components.planttracker;

import java.util.ArrayList;

public class PlantTracker1L {
    // Define a list to hold plants
    private ArrayList<Plant> plants;

    // Constructor
    public PlantTracker1L() {
        this.plants = new ArrayList<>();
    }

    // Inner class to represent a Plant
    private class Plant {
        private String name;
        private String species;
        private String wateringSchedule;
        private String notes;

        public Plant(String name, String species, String wateringSchedule, String notes) {
            this.name = name;
            this.species = species;
            this.wateringSchedule = wateringSchedule;
            this.notes = notes;
        }

        @Override
        public String toString() {
            return "Plant Name: " + this.name + ", Species: " + this.species +
                   ", Watering Schedule: " + this.wateringSchedule + ", Notes: " + this.notes;
        }
    }

    // Method to add a plant
    public void addPlant(String name, String species, String wateringSchedule, String notes) {
        this.plants.add(new Plant(name, species, wateringSchedule, notes));
        System.out.println("Added plant: " + name);
    }

    // Method to view all plants
    public void viewPlants() {
        if (this.plants.isEmpty()) {
            System.out.println("No plants found.");
        } else {
            for (Plant plant : this.plants) {
                System.out.println(plant);
            }
        }
    }

    // Method to remove a plant by name
    public void removePlant(String name) {
        for (int i = 0; i < this.plants.size(); i++) {
            if (this.plants.get(i).name.equalsIgnoreCase(name)) {
                this.plants.remove(i);
                System.out.println("Removed plant: " + name);
                return;
            }
        }
        System.out.println("Plant not found: " + name);
    }

    // Main method for testing
    public static void main(String[] args) {
        PlantTracker1L tracker = new PlantTracker1L();
        tracker.addPlant("Fern", "Polypodium", "Every 2 weeks", "Needs indirect sunlight.");
        tracker.addPlant("Cactus", "Echinopsis", "Every 3 weeks", "Likes dry soil.");
        tracker.viewPlants();
        tracker.removePlant("Fern");
        tracker.viewPlants();
    }
}
