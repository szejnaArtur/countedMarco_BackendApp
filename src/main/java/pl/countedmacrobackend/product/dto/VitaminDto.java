package pl.countedmacrobackend.product.dto;

public class VitaminDto {

    static public Builder builder() {
        return new Builder();
    }

    private Long id;
    private String name;
    private String unit;
    private Double value;

    public VitaminDto() {
    }

    private VitaminDto(final Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.unit = builder.unit;
        this.value = builder.value;
    }

    public Builder toBuilder() {
        return new Builder()
                .withId(id)
                .withName(name)
                .withUnit(unit)
                .withValue(value);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public Double getValue() {
        return value;
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

    public static class Builder {
        private Long id;
        private String name;
        private String unit;
        private Double value;

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withUnit(String unit) {
            this.unit = unit;
            return this;
        }

        public Builder withValue(Double value) {
            this.value = value;
            return this;
        }

        public VitaminDto build() {
            return new VitaminDto(this);
        }

    }
}
