package components.planttracker;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PlantTracker1LTest {

    private PlantTracker1L tracker;
    private ByteArrayOutputStream outputStreamCaptor;
    private final PrintStream originalSystemOut = System.out; // Store original System.out

    // Runs before each test to initialize objects and set up test environment
    @Before
    public void setUp() {
        this.tracker = new PlantTracker1L();
        this.outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(this.outputStreamCaptor));
    }

    // Runs after each test to restore the original System.out
    @After
    public void tearDown() {
        System.setOut(this.originalSystemOut); // Restore original System.out
    }

    // Test to verify adding a plant
    @Test
    public void testAddPlant() {
        this.tracker.addPlant("Fern", "Polypodium", "Every 2 weeks", "Needs indirect sunlight.");
        String expectedOutput = "Added plant: Fern";
        assertEquals(expectedOutput, this.outputStreamCaptor.toString().trim());

        this.tracker.viewPlants();
        String plantsOutput = this.outputStreamCaptor.toString();
        assertTrue(plantsOutput.contains("Plant Name: Fern"));
    }

    // Test to verify that the system handles no plants gracefully
    @Test
    public void testViewPlantsWhenEmpty() {
        this.tracker.viewPlants();
        String expectedOutput = "No plants found.";
        assertEquals(expectedOutput, this.outputStreamCaptor.toString().trim());
    }

    @Test
public void testRemovePlant() {
    // Add a plant first
    this.tracker.addPlant("Cactus", "Echinopsis", "Every 3 weeks", "Likes dry soil.");

    // Capture output after adding
    this.outputStreamCaptor.reset();  // Reset the output stream

    // Remove the plant
    this.tracker.removePlant("Cactus");

    // Capture the output for removal
    String expectedRemovalOutput = "Removed plant: Cactus";
    assertEquals(expectedRemovalOutput, this.outputStreamCaptor.toString().trim());

    // Now check if the plant is removed by calling viewPlants
    this.outputStreamCaptor.reset(); // Clear previous output so we can capture the next output

    // View the plants
    this.tracker.viewPlants();

    // Assert that the Cactus plant is no longer in the output
    String plantsOutput = this.outputStreamCaptor.toString();
    assertFalse(plantsOutput.contains("Cactus"));
}

    // Test when trying to remove a plant that doesn't exist
    @Test
    public void testRemoveNonExistingPlant() {
        this.tracker.removePlant("NonExistentPlant");
        String expectedOutput = "Plant not found: NonExistentPlant";
        assertEquals(expectedOutput, this.outputStreamCaptor.toString().trim());
    }

    // Test with multiple plants added
    @Test
    public void testMultiplePlants() {
        this.tracker.addPlant("Fern", "Polypodium", "Every 2 weeks", "Needs indirect sunlight.");
        this.tracker.addPlant("Cactus", "Echinopsis", "Every 3 weeks", "Likes dry soil.");

        this.tracker.viewPlants();
        String plantsOutput = this.outputStreamCaptor.toString();
        assertTrue(plantsOutput.contains("Fern"));
        assertTrue(plantsOutput.contains("Cactus"));
    }

    // Test with an empty plant name
    @Test
    public void testAddPlantWithEmptyName() {
        this.tracker.addPlant("", "Polypodium", "Every 2 weeks", "Needs indirect sunlight.");
        String expectedOutput = "Plant name cannot be empty.";
        assertEquals(expectedOutput, this.outputStreamCaptor.toString().trim());
    }

    // Test with an empty species name
    @Test
    public void testAddPlantWithEmptySpecies() {
        this.tracker.addPlant("Fern", "", "Every 2 weeks", "Needs indirect sunlight.");
        String expectedOutput = "Species cannot be empty.";
        assertEquals(expectedOutput, this.outputStreamCaptor.toString().trim());
    }
}
