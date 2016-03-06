package fr.istic.oci;

public class Technologie {

    private String technoName;
    private String description;
    

    public Technologie(String name) {
        technoName = name;
    }

    public Technologie(String name, String description) {
        technoName = name;
        this.description = description;
    }

    

    public String getDescription() {
        return description;
    }

    public String getTechnoName() {
        return technoName;
    }

    
}
