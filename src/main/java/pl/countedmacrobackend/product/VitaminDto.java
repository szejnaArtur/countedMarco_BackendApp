package pl.countedmacrobackend.product;

import pl.countedmacrobackend.product.Vitamin;

public class VitaminDto {

    private Long id;
    private String name;
    private String unit;
    private Double value;

    public VitaminDto() {
    }

    public VitaminDto(Vitamin source) {
        this.id = source.getId();
        this.name = source.getName();
        this.unit = source.getUnit();
        this.value = source.getValue();
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

    public String getUnit() {
        return unit;
    }

    public void setUnit(final String unit) {
        this.unit = unit;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(final Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "VitaminDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", unit='" + unit + '\'' +
                ", value=" + value +
                '}';
    }
}
