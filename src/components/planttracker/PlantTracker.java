package components.planttracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/**
 * This class represents a tracker for plants, allowing the user to add plants,
 * display plant information, water plants, and list various plant statuses.
 */
public final class PlantTracker {
    private static final Logger logger = Logger.getLogger(PlantTracker.class.getName());

    private final Map<String, Plant> plants;

    public PlantTracker() {
        this.plants = new HashMap<>();
    }

    public void addPlant(String name, String species, int age, String careInstructions) {
        if (this.plants.containsKey(name)) {
            logger.info("Plant already exists: " + name);
        } else {
            this.plants.put(name, new Plant(name, species, age, careInstructions));
            logger.info("Added plant: " + name);
        }
    }

    public List<String> listAllPlants() {
        List<String> plantNames = new ArrayList<>();
        if (this.plants.isEmpty()) {
            logger.info("No plants in the tracker.");
        } else {
            for (Plant plant : this.plants.values()) {
                plantNames.add(plant.getName());
            }
        }
        return plantNames;
    }

    public void waterPlant(String name) {
        Plant plant = this.plants.get(name);
        if (plant != null) {
            logger.info("Watering " + name + "...");
            logger.info(name + " has been watered.");
        } else {
            logger.warning("Plant not found: " + name);
        }
    }

    public void showCareInstructions(String name) {
        Plant plant = this.plants.get(name);
        if (plant != null) {
            logger.info("Care instructions for " + name + ": " + plant.getCareInstructions());
        } else {
            logger.warning("Plant not found: " + name);
        }
    }

    public void displayAllPlants() {
        if (this.plants.isEmpty()) {
            logger.info("No plants in the tracker.");
        } else {
            for (Plant plant : this.plants.values()) {
                logger.info("Name: " + plant.getName());
                logger.info("Species: " + plant.getSpecies());
                logger.info("Age: " + plant.getAge() + " years");
                logger.info("Care Instructions: " + plant.getCareInstructions());
                logger.info("--------------------------");
            }
        }
    }

    public void getRandomPlant() {
        if (this.plants.isEmpty()) {
            logger.info("No plants in the tracker.");
        } else {
            List<Plant> plantList = new ArrayList<>(this.plants.values());
            Random rand = new Random();
            Plant randomPlant = plantList.get(rand.nextInt(plantList.size()));
            logger.info("Random Plant: " + randomPlant.getName());
            logger.info("Species: " + randomPlant.getSpecies());
            logger.info("Age: " + randomPlant.getAge() + " years");
            logger.info("Care Instructions: " + randomPlant.getCareInstructions());
        }
    }

    public int countPlants() {
        return this.plants.size();
    }

    public void removePlant(String name) {
        if (this.plants.containsKey(name)) {
            this.plants.remove(name);
            logger.info(name + " has been removed from the tracker.");
        } else {
            logger.warning("Plant not found: " + name);
        }
    }

    public void clear() {
        this.plants.clear();
        logger.info("All plants have been cleared.");
    }

    public void transferFrom(PlantTracker source) {
        this.plants.clear();
        this.plants.putAll(source.plants);
    }

    public void listPlantsThatNeedWater() {
        boolean found = false;

        for (Plant plant : this.plants.values()) {
            boolean needsWater = false;

            if (plant.getAge() < 2) {
                needsWater = true;
            } else if (plant.getAge() >= 5) {
                needsWater = true;
            }

            if (needsWater) {
                logger.info(plant.getName() + " needs water.");
                found = true;
            }
        }

        if (!found) {
            logger.info("No plants need water at the moment.");
        }
    }

    public static class Plant {
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

        public String getName() {
            return this.name;
        }

        public String getSpecies() {
            return this.species;
        }

        public int getAge() {
            return this.age;
        }

        public String getCareInstructions() {
            return this.careInstructions;
        }
    }
}
