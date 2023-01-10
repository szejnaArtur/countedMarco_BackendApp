package pl.countedmacrobackend.file;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.countedmacrobackend.file.Image;

interface ImageFileRepository extends JpaRepository<Image, String> {
}
