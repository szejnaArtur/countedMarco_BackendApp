package pl.countedmacrobackend.product.dto;

import pl.countedmacrobackend.file.dto.ImageDto;

import java.util.ArrayList;
import java.util.List;

public class ProductDto {

    static public Builder builder(String name, Double calories) {
        return new Builder(name, calories);
    }

    private Long id;
    private String name;
    private String description;
    private Double calories;
    private Double carbs;
    private Double fat;
    private Double protein;
    private Double water;
    private List<VitaminDto> vitaminList = new ArrayList<>();
    private ImageDto image;

    ProductDto(){}
    private ProductDto(final Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
        this.calories = builder.calories;
        this.carbs = builder.carbs;
        this.fat = builder.fat;
        this.protein = builder.protein;
        this.water = builder.water;
        this.vitaminList = builder.vitaminList;
        this.image = builder.image;
    }

    public Builder toBuilder() {
        return new Builder()
                .withId(id)
                .withName(name)
                .withDescription(description)
                .withCalories(calories)
                .withCarbs(carbs)
                .withFat(fat)
                .withProtein(protein)
                .withWater(water)
                .withVitaminList(vitaminList)
                .withImage(image);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getCalories() {
        return calories;
    }

    public Double getCarbs() {
        return carbs;
    }

    public Double getFat() {
        return fat;
    }

    public Double getProtein() {
        return protein;
    }

    public Double getWater() {
        return water;
    }

    public ImageDto getImage() {
        return image;
    }

    public void setImage(final ImageDto image) {
        this.image = image;
    }

    public List<VitaminDto> getVitaminList() {
        return vitaminList;
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
                ", image=" + image +
                '}';
    }

    public static class Builder {
        private Long id;
        private String name;
        private String description;
        private Double calories;
        private Double carbs;
        private Double fat;
        private Double protein;
        private Double water;
        private List<VitaminDto> vitaminList;
        private ImageDto image;

        public Builder(){

        }
        public Builder(String name, Double calories){
            this.name = name;
            this.calories = calories;
        }

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withCalories(final Double calories) {
            this.calories = calories;
            return this;
        }

        public Builder withCarbs(final Double carbs) {
            this.carbs = carbs;
            return this;
        }

        public Builder withFat(final Double fat) {
            this.fat = fat;
            return this;
        }

        public Builder withProtein(final Double protein) {
            this.protein = protein;
            return this;
        }

        public Builder withWater(final Double water) {
            this.water = water;
            return this;
        }

        public Builder withVitaminList(final List<VitaminDto> vitaminList) {
            this.vitaminList = vitaminList;
            return this;
        }

        public Builder withImage(final ImageDto image) {
            this.image = image;
            return this;
        }

        public ProductDto build() {
            return new ProductDto(this);
        }
    }
}
