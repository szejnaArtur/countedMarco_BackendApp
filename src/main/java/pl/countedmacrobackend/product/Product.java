package pl.countedmacrobackend.product;

import pl.countedmacrobackend.file.Image;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "products")
class Product {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "calories", nullable = false)
    private Double calories;
    @Column(name = "carbs", nullable = false)
    private Double carbs;
    @Column(name = "fat", nullable = false)
    private Double fat;
    @Column(name = "protein", nullable = false)
    private Double protein;
    @Column(name = "water", nullable = false)
    private Double water;

    @OneToOne
    @JoinColumn(name = "image_id")
    private Image image;

    public Product() {
    }

    public Product(ProductDto dto) {
        this.id = dto.getId();
        this.name = dto.getName();
        this.description = dto.getDescription();
        this.calories = dto.getCalories();
        this.carbs = dto.getCarbs();
        this.fat = dto.getFat();
        this.protein = dto.getProtein();
        this.water = dto.getWater();
        this.image = dto.getFile();
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

    public Image getImage() {
        return image;
    }

    public void setImage(final Image image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", calories=" + calories +
                ", carbs=" + carbs +
                ", fat=" + fat +
                ", protein=" + protein +
                ", water=" + water +
                ", image=" + image +
                '}';
    }
}
