package components.planttracker;
import java.util.Random;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.logging.Logger;

/**
 * This class represents a tracker for plants, allowing the user to add plants,
 * display plant information, water plants, and list various plant statuses.
 */
//<<<<<<< kernel-implementation
public final class PlantTracker {
    private static final Logger logger = Logger.getLogger(PlantTracker.class.getName());
//=======
public interface PlantTracker extends PlantTrackerKernel {

    // Map to store plant names and their details (plant data)
//>>>>>>> main
    private Map<String, Plant> plants;

    public PlantTracker() {
        this.plants = new HashMap<>();
    }

    /**
     * Adds a plant to the tracker.
     *
     * @param name The name of the plant.
     * @param species The species of the plant.
     * @param age The age of the plant.
     * @param careInstructions The care instructions for the plant.
     */
    public void addPlant(String name, String species, int age, String careInstructions) {
        if (this.plants.containsKey(name)) {
            logger.info("Plant already exists: " + name);
        } else {
            this.plants.put(name, new Plant(name, species, age, careInstructions));
            logger.info("Added plant: " + name);
        }
    }

    /**
     * Lists all the plants in the tracker.
     *
     * @return A list of plant names.
     */
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

    /**
     * Water the plant.
     *
     * @param name The name of the plant to water.
     */
    public void waterPlant(String name) {
        Plant plant = this.plants.get(name);
        if (plant != null) {
            logger.info("Watering " + name + "...");
            plant.water();
            logger.info(name + " has been watered.");
        } else {
            logger.warning("Plant not found: " + name);
        }
    }

    /**
     * Show care instructions for the specified plant.
     *
     * @param name The name of the plant.
     */
    public void showCareInstructions(String name) {
        Plant plant = this.plants.get(name);
        if (plant != null) {
            logger.info("Care instructions for " + name + ": " + plant.getCareInstructions());
        } else {
            logger.warning("Plant not found: " + name);
        }
    }

    /**
     * Display all plants with detailed information.
     */
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

    /**
     * Get a random plant from the tracker and display its information.
     */
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

    /**
     * List all plants that need water.
     */
    public void listPlantsThatNeedWater() {
        boolean found = false;
        for (Plant plant : this.plants.values()) {
            if (plant.needsWater()) {
                logger.info(plant.getName() + " needs water.");
                found = true;
            }
        }
        if (!found) {
            logger.info("No plants need water at the moment.");
        }
    }

    /**
     * Count the number of plants in the tracker.
     *
     * @return The number of plants.
     */
    public int countPlants() {
        return this.plants.size();
    }

    /**
     * Remove a plant from the tracker.
     *
     * @param name The name of the plant to remove.
     */
    public void removePlant(String name) {
        if (this.plants.containsKey(name)) {
            this.plants.remove(name);
            logger.info(name + " has been removed from the tracker.");
        } else {
            logger.warning("Plant not found: " + name);
        }
    }

    /**
     * Inner class to represent a plant.
     */
    public class Plant {
        private String name;
        private String species;
        private int age;
        private String careInstructions;
        private Date lastWatered;

        public Plant(String name, String species, int age, String careInstructions) {
            this.name = name;
            this.species = species;
            this.age = age;
            this.careInstructions = careInstructions;
            this.lastWatered = new Date(); // Default to current time
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

        public Date getLastWatered() {
            return this.lastWatered;
        }

        public void water() {
            this.lastWatered = new Date();
        }

        public boolean needsWater() {
            long currentTime = new Date().getTime();
            long timeSinceLastWater = currentTime - this.lastWatered.getTime();
            long daysSinceWater = timeSinceLastWater / (1000 * 60 * 60 * 24); // Convert to days
            return daysSinceWater >= 7;
        }
    }
}
