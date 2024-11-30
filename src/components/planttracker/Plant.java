package components.planttracker;

public class Plant {
    private String name;
    private String species;
    private int age; // Age in months
    private String careInstructions;

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

    @Override
    public String toString() {
        return "Plant{" +
                "name='" + this.name + '\'' +
                ", species='" + this.species + '\'' +
                ", age=" + this.age +
                ", careInstructions='" + this.careInstructions + '\'' +
                '}';
    }
}
