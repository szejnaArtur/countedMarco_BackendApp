package pl.countedmacrobackend.product;

import pl.countedmacrobackend.file.query.SimpleImageQueryDto;
import pl.countedmacrobackend.product.dto.ProductDto;

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
    private SimpleImageQueryDto image;

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
        this.image = new SimpleImageQueryDto(
                dto.getImage().getId(),
                dto.getImage().getName(),
                dto.getImage().getType(),
                dto.getImage().getData()
        );
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

    public SimpleImageQueryDto getImage() {
        return image;
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
