package pl.countedmacrobackend.product;

import pl.countedmacrobackend.file.Image;

import java.util.ArrayList;
import java.util.List;

public class ProductDto {

    private Long id;
    private String name;
    private String description;

    private Double calories;
    private Double carbs;
    private Double fat;
    private Double protein;
    private Double water;

    private List<VitaminDto> vitaminList = new ArrayList<>();

    private Image file;

    public ProductDto() {
    }

    public ProductDto(Product source) {
        this.id = source.getId();
        this.name = source.getName();
        this.description = source.getDescription();
        this.calories = source.getCalories();
        this.carbs = source.getCarbs();
        this.fat = source.getFat();
        this.protein = source.getProtein();
        this.water = source.getWater();
        this.file = source.getImage();
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Double getCalories() {
        return calories;
    }

    public void setCalories(final Double calories) {
        this.calories = calories;
    }

    public Double getCarbs() {
        return carbs;
    }

    public void setCarbs(final Double carbs) {
        this.carbs = carbs;
    }

    public Double getFat() {
        return fat;
    }

    public void setFat(final Double fat) {
        this.fat = fat;
    }

    public Double getProtein() {
        return protein;
    }

    public void setProtein(final Double protein) {
        this.protein = protein;
    }

    public Double getWater() {
        return water;
    }

    public void setWater(final Double water) {
        this.water = water;
    }

    public void setVitaminList(final List<VitaminDto> vitaminList) {
        this.vitaminList = vitaminList;
    }

    public Image getFile() {
        return file;
    }

    public void setFile(final Image file) {
        this.file = file;
    }

    public List<VitaminDto> getVitaminList() {
        return vitaminList;
    }

    public void setVitamins(final List<VitaminDto> vitaminList) {
        this.vitaminList = vitaminList;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", calories=" + calories +
                ", carbs=" + carbs +
                ", fat=" + fat +
                ", protein=" + protein +
                ", water=" + water +
                ", vitaminList=" + vitaminList +
                ", file=" + file +
                '}';
    }
}
