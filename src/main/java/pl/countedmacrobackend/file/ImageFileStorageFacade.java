package pl.countedmacrobackend.file;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import pl.countedmacrobackend.file.dto.ImageDto;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class ImageFileStorageFacade {

    private final ImageFileRepository imageFileRepository;

    ImageFileStorageFacade(final ImageFileRepository imageFileRepository) {
        this.imageFileRepository = imageFileRepository;
    }

     public ImageDto store(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
         Image image = imageFileRepository.save(new Image(fileName, file.getContentType(), file.getBytes()));
         return image.toDto();
     }

    Image getFile(String id) {
        Optional<Image> optionalImage = imageFileRepository.findById(id);
        return optionalImage.orElse(null);
    }

    Stream<Image> getAllFiles() {
        return imageFileRepository.findAll().stream();
    }
}
