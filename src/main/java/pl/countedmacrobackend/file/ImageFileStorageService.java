package pl.countedmacrobackend.file;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

@Service
class ImageFileStorageService {

    private final ImageFileRepository imageFileRepository;

    ImageFileStorageService(final ImageFileRepository imageFileRepository) {
        this.imageFileRepository = imageFileRepository;
    }

    Image store(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        Image image = new Image(fileName, file.getContentType(), file.getBytes());
        return imageFileRepository.save(image);
    }

    Image getFile(String id) {
        Optional<Image> optionalImage = imageFileRepository.findById(id);
        return optionalImage.orElse(null);
    }

    Stream<Image> getAllFiles() {
        return imageFileRepository.findAll().stream();
    }
}
