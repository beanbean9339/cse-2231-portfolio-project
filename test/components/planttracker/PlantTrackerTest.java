package components.planttracker;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

/**
 * Unit tests for the PlantTracker class.
 * These tests verify the functionality of adding, removing, displaying, and managing plants.
 */
public class PlantTrackerTest {

    private PlantTracker plantTracker;

    /**
     * Set up method that is executed before each test.
     * Initializes a new instance of PlantTracker.
     */
    @Before
    public void setUp() {
        // Initialize a new PlantTracker instance before each test
        this.plantTracker = new PlantTracker();
    }

    /**
     * Test the addPlant() method to verify that plants are correctly added.
     */
    @Test
    public void testAddPlant() {
        // Adding a plant to the tracker
        this.plantTracker.addPlant("Rose", "Flowering", 2, "Water daily and provide sunlight");

        // Verify that the plant has been added
        List<String> plantNames = this.plantTracker.listAllPlants();
        assertTrue("Plant should be added to the tracker", plantNames.contains("Rose"));
    }

    /**
     * Test listAllPlants() to ensure the correct listing of all plants.
     */
    @Test
    public void testListAllPlants() {
        // Adding plants to the tracker
        this.plantTracker.addPlant("Aloe Vera", "Succulent", 1, "Water weekly");
        this.plantTracker.addPlant("Tulip", "Flowering", 3, "Water every 2 days");

        // Verify that the plants are listed correctly
        List<String> plantNames = this.plantTracker.listAllPlants();
        assertTrue("Plant names should be listed", plantNames.contains("Aloe Vera"));
        assertTrue("Plant names should be listed", plantNames.contains("Tulip"));
    }

    /**
     * Test the waterPlant() method to verify watering functionality.
     */
    @Test
    public void testWaterPlant() {
        // Adding a plant to the tracker
        this.plantTracker.addPlant("Cactus", "Succulent", 5, "Water monthly");

        // Water the plant and verify the logger output (for simplicity, we're not verifying logs here)
        this.plantTracker.waterPlant("Cactus");
        // We assume watering works based on the method being executed without exceptions
    }

    /**
     * Test the showCareInstructions() method to verify correct care instructions retrieval.
     */
    @Test
    public void testShowCareInstructions() {
        // Adding a plant to the tracker
        this.plantTracker.addPlant("Fern", "Houseplant", 1, "Keep soil moist and indirect light");

        // Show care instructions for the plant
        this.plantTracker.showCareInstructions("Fern");

        // We cannot easily assert logs, but the method should not throw an exception or error
    }

    /**
     * Test the removePlant() method to ensure that plants can be removed correctly.
     */
    @Test
    public void testRemovePlant() {
        // Adding a plant to the tracker
        this.plantTracker.addPlant("Cactus", "Succulent", 2, "Water monthly");

        // Remove the plant from the tracker
        this.plantTracker.removePlant("Cactus");

        // Verify that the plant was removed
        List<String> plantNames = this.plantTracker.listAllPlants();
        assertFalse("Plant should be removed from the tracker", plantNames.contains("Cactus"));
    }

    /**
     * Test countPlants() to verify that the correct number of plants is returned.
     */
    @Test
    public void testCountPlants() {
        // Adding plants to the tracker
        this.plantTracker.addPlant("Cactus", "Succulent", 2, "Water monthly");
        this.plantTracker.addPlant("Fern", "Houseplant", 1, "Keep soil moist");

        // Verify that the plant count is correct
        assertEquals("There should be 2 plants", 2, this.plantTracker.countPlants());
    }

    /**
     * Test getRandomPlant() to verify that a random plant is selected correctly.
     */
    @Test
    public void testGetRandomPlant() {
        // Adding plants to the tracker
        this.plantTracker.addPlant("Rose", "Flowering", 2, "Water daily");
        this.plantTracker.addPlant("Cactus", "Succulent", 5, "Water monthly");

        // Call the method and verify if it selects a random plant (we'll assume it works based on execution)
        this.plantTracker.getRandomPlant();
        // We are not verifying logs here, but the method should not throw any exception
    }

    /**
     * Test listPlantsThatNeedWater() to ensure plants that need water are listed correctly.
     */
    @Test
    public void testListPlantsThatNeedWater() {
        // Adding plants to the tracker
        this.plantTracker.addPlant("Aloe Vera", "Succulent", 1, "Water weekly");
        this.plantTracker.addPlant("Rose", "Flowering", 6, "Water daily");

        // Call the method to list plants that need water
        this.plantTracker.listPlantsThatNeedWater();

        // We assume that the method works if no exceptions occur, and logs are displayed
    }

    /**
     * Test the clear() method to ensure that all plants are cleared from the tracker.
     */
    @Test
    public void testClear() {
        // Adding plants to the tracker
        this.plantTracker.addPlant("Tulip", "Flowering", 3, "Water every 2 days");
        this.plantTracker.addPlant("Cactus", "Succulent", 5, "Water monthly");

        // Clear all plants
        this.plantTracker.clear();

        // Verify that the plants are cleared
        assertEquals("There should be 0 plants after clear", 0, this.plantTracker.countPlants());
    }

    /**
     * Test the transferFrom() method to ensure plants are transferred correctly.
     */
    @Test
    public void testTransferFrom() {
        // Create another plant tracker and add plants
        PlantTracker anotherTracker = new PlantTracker();
        anotherTracker.addPlant("Tulip", "Flowering", 3, "Water every 2 days");

        // Transfer plants from another tracker to the original tracker
        this.plantTracker.transferFrom(anotherTracker);

        // Verify that the plant has been transferred
        assertTrue("Transferred plant should be in the tracker", this.plantTracker.listAllPlants().contains("Tulip"));
    }
}
