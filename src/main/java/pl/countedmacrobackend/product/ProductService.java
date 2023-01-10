package pl.countedmacrobackend.product;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.countedmacrobackend.file.ImageFileFactor;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
class ProductService {

    private final ProductRepository productRepository;
    private final VitaminRepository vitaminRepository;

    ProductService(final ProductRepository productRepository, final VitaminRepository vitaminRepository) {
        this.productRepository = productRepository;
        this.vitaminRepository = vitaminRepository;
    }

    ProductDto add(ProductDto toSave, MultipartFile file) throws IOException {
        toSave.setFile(ImageFileFactor.from(file));
        Product product = new Product(toSave);
        productRepository.save(product);

        ProductDto productDto = new ProductDto(product);
        List<VitaminDto> vitaminDtoList = toSave.getVitaminList();

        if (vitaminDtoList.isEmpty()) {
            System.out.println("Lista jest pusta, nie rób nic.");
        } else {
            List<Vitamin> collect = vitaminDtoList.stream().map(vitamin -> new Vitamin(vitamin, product)).collect(Collectors.toList());
            System.out.println("nowy lista vitamin: " + collect);
            vitaminRepository.saveAll(collect);
        }

        return productDto;
    }

    List<ProductDto> findAll() {
        return productRepository.findAll().stream().map(product -> {
            List<Vitamin> vitamins = vitaminRepository.findByProductId(product.getId());
            List<VitaminDto> vitaminDtoList = vitamins.stream().map(VitaminDto::new).collect(Collectors.toList());

            ProductDto productDto = new ProductDto(product);
            productDto.setVitaminList(vitaminDtoList);

            return productDto;
        }).collect(Collectors.toList());
    }

    ProductDto findById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            ProductDto productDto = new ProductDto(optionalProduct.get());
//            List<VitaminDto> collect = vitaminRepository.findByProductId(productDto.getId())
//                    .stream()
//                    .map(VitaminDto::new)
//                    .collect(Collectors.toList());
//            productDto.setVitamins(collect);
            return productDto;
        }
        throw new IllegalArgumentException("The object does not exist.");
    }
}
