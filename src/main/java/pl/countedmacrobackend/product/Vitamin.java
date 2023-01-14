package pl.countedmacrobackend.product;

import pl.countedmacrobackend.product.dto.VitaminDto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "vitamins")
class Vitamin {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "unit", nullable = false)
    private String unit;
    @Column(name = "value", nullable = false)
    private Double value;

    @ManyToOne
    @JoinColumn(name = "source_id")
    private Product product;

    Vitamin(VitaminDto dto, Product product) {
        this.id = dto.getId();
        this.name = dto.getName();
        this.unit = dto.getUnit();
        this.value = dto.getValue();
        this.product = product;
    }

    public Vitamin() {

    }

    Long getId() {
        return id;
    }

    void setId(final Long id) {
        this.id = id;
    }

    String getName() {
        return name;
    }

    void setName(final String name) {
        this.name = name;
    }

    String getUnit() {
        return unit;
    }

    void setUnit(final String unit) {
        this.unit = unit;
    }

    Double getValue() {
        return value;
    }

    void setValue(final Double value) {
        this.value = value;
    }

    Product getProduct() {
        return product;
    }

    void setProduct(final Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Vitamin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", unit='" + unit + '\'' +
                ", value=" + value +
                ", product=" + product +
                '}';
    }
}
