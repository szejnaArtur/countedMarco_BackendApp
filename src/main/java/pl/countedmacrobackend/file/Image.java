package pl.countedmacrobackend.file;

import org.hibernate.annotations.GenericGenerator;
import pl.countedmacrobackend.file.dto.ImageDto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "files")
class Image {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String name;

    private String type;

    @Lob
    private byte[] data;

    public Image() {

    }

    public Image(ImageDto dto){
        this.id = dto.getId();
        this.name = dto.getName();
        this.type = dto.getType();
        this.data = dto.getData();
    }

    public Image(String name, String type, byte[] data) {
        this.name = name;
        this.type = type;
        this.data = data;
    }

    public ImageDto toDto(){
        return ImageDto.builder()
                .withId(id)
                .withName(name)
                .withType(type)
                .withData(data)
                .build();
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

    public void setData(byte[] data) {
        this.data = data;
    }
}
