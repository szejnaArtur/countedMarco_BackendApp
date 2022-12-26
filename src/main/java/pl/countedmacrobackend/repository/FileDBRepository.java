package pl.countedmacrobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.countedmacrobackend.entity.FileDB;

public interface FileDBRepository extends JpaRepository<FileDB, String> {
}
