package components.planttracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Logger;

/**
 * This class represents a tracker for plants, allowing the user to add plants,
 * display plant information, water plants, and list various plant statuses.
 */
public final class PlantTracker extends PlantTrackerSecondary {
    private static final Logger logger = Logger
            .getLogger(PlantTracker.class.getName());

    private final Map<String, Plant> plants;

    public PlantTracker() {
        this.plants = new HashMap<>();
    }

    @Override
    public void addPlant(String name, String species, int age,
            String careInstructions) {
        if (this.plants.containsKey(name)) {
            logger.info("Plant already exists: " + name);
        } else {
            this.plants.put(name,
                    new Plant(name, species, age, careInstructions));
            logger.info("Added plant: " + name);
        }
    }

    @Override
    protected List<Plant> createRepresentation() {
        return new ArrayList<>(this.plants.values());
    }

    @Override
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

    @Override
    public void waterPlant(String name) {
        Plant plant = this.plants.get(name);
        if (plant != null) {
            logger.info("Watering " + name + "...");
            logger.info(name + " has been watered.");
        } else {
            logger.warning("Plant not found: " + name);
        }
    }

    @Override
    public void showCareInstructions(String name) {
        Plant plant = this.plants.get(name);
        if (plant != null) {
            logger.info("Care instructions for " + name + ": "
                    + plant.getCareInstructions());
        } else {
            logger.warning("Plant not found: " + name);
        }
    }

    @Override
    public void displayAllPlants() {
        if (this.plants.isEmpty()) {
            logger.info("No plants in the tracker.");
        } else {
            for (Plant plant : this.plants.values()) {
                logger.info("Name: " + plant.getName());
                logger.info("Species: " + plant.getSpecies());
                logger.info("Age: " + plant.getAge() + " years");
                logger.info(
                        "Care Instructions: " + plant.getCareInstructions());
                logger.info("--------------------------");
            }
        }
    }

    @Override
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
            logger.info(
                    "Care Instructions: " + randomPlant.getCareInstructions());
        }
    }

    @Override
    public int countPlants() {
        return this.plants.size();
    }

    @Override
    public void removePlant(String name) {
        if (this.plants.containsKey(name)) {
            this.plants.remove(name);
            logger.info(name + " has been removed from the tracker.");
        } else {
            logger.warning("Plant not found: " + name);
        }
    }

    @Override
    public void clear() {
        this.plants.clear();
        logger.info("All plants have been cleared.");
    }

    @Override
    public void transferFrom(PlantTracker source) {
        List<Plant> sourceRepresentation = source.createRepresentation();
        this.createRepresentation().clear();
        this.createRepresentation().addAll(sourceRepresentation);
        sourceRepresentation.clear();
    }

    @Override
    public void listPlantsThatNeedWater() {
        boolean found = false;

        for (Plant plant : this.plants.values()) {
            boolean needsWater = false;

            // example logic to determine if the plant needs water based on age
            if (plant.getAge() < 2) {
                // younger plants may need water more frequently
                needsWater = true;
            } else if (plant.getAge() >= 5) {
                // older plants may also need water more frequently
                needsWater = true;
            }

            // if the plant needs water, log it
            if (needsWater) {
                logger.info(plant.getName() + " needs water.");
                found = true;
            }
        }

        if (!found) {
            logger.info("No plants need water at the moment.");
        }
    }

    @Override
    public PlantTracker newInstance() {
        return new PlantTracker();
    }

}
