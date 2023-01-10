package pl.countedmacrobackend.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface VitaminRepository extends JpaRepository<Vitamin, Long> {
    List<Vitamin> findByProductId(Long id);
}
