package pl.countedmacrobackend.file;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;

public class ImageFileFactor {

    public static Image from(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        return new Image(fileName, file.getContentType(), file.getBytes());
    }

}
