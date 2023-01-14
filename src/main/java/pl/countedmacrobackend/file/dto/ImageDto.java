package pl.countedmacrobackend.file.dto;

public class ImageDto {

    static public Builder builder() {
        return new Builder();
    }

    private String id;
    private String name;
    private String type;
    private byte[] data;

    ImageDto() {
    }

    private ImageDto(final Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.type = builder.type;
        this.data = builder.data;
    }

    public Builder toBuilder() {
        return new Builder()
                .withId(id)
                .withName(name)
                .withType(type)
                .withData(data);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public byte[] getData() {
        return data;
    }

    public static class Builder {
        private String id;
        private String name;
        private String type;
        private byte[] data;

        public Builder withId(String id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withType(String type) {
            this.type = type;
            return this;
        }

        public Builder withData(byte[] data) {
            this.data = data;
            return this;
        }

        public ImageDto build() {
            return new ImageDto(this);
        }
    }
}
