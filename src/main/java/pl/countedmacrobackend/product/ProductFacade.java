package pl.countedmacrobackend.product;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.countedmacrobackend.file.ImageFileStorageFacade;
import pl.countedmacrobackend.file.dto.ImageDto;
import pl.countedmacrobackend.product.dto.ProductDto;
import pl.countedmacrobackend.product.dto.VitaminDto;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
class ProductFacade {

    private final ProductRepository productRepository;
    private final VitaminRepository vitaminRepository;
    private final ImageFileStorageFacade imageFileStorageFacade;

    ProductFacade(final ProductRepository productRepository, final VitaminRepository vitaminRepository,
                  final ImageFileStorageFacade imageFileStorageFacade) {
        this.productRepository = productRepository;
        this.vitaminRepository = vitaminRepository;
        this.imageFileStorageFacade = imageFileStorageFacade;
    }

    ProductDto add(ProductDto toSave, MultipartFile file) throws IOException {
        ImageDto image = imageFileStorageFacade.store(file);
        toSave.setImage(image);
        Product product = new Product(toSave);
        System.out.println(product);
        productRepository.save(product);
        List<VitaminDto> vitaminDtoList = toSave.getVitaminList();

        if (vitaminDtoList.isEmpty()) {
            System.out.println("Lista jest pusta, nie rób nic.");
            return ProductDto.builder(product.getName(), product.getCalories())
                    .withId(product.getId())
                    .withDescription(product.getDescription())
                    .withCarbs(product.getCarbs())
                    .withFat(product.getFat())
                    .withProtein(product.getProtein())
                    .withWater(product.getWater())
                    .withImage(image)
                    .build();
        } else {
            List<Vitamin> collect = vitaminDtoList.stream().map(vitamin -> new Vitamin(vitamin, product)).collect(toList());
            List<Vitamin> vitamins = vitaminRepository.saveAll(collect);
            List<VitaminDto> vitaminsDto = vitamins.stream().map(vitamin -> VitaminDto.builder()
                    .withId(vitamin.getId())
                    .withName(vitamin.getName())
                    .withUnit(vitamin.getUnit())
                    .withValue(vitamin.getValue())
                    .build()
            ).collect(toList());

            return ProductDto.builder(product.getName(), product.getCalories())
                    .withId(product.getId())
                    .withDescription(product.getDescription())
                    .withCarbs(product.getCarbs())
                    .withFat(product.getFat())
                    .withProtein(product.getProtein())
                    .withWater(product.getWater())
                    .withVitaminList(vitaminsDto)
                    .withImage(ImageDto.builder()
                            .withId(product.getImage().getId())
                            .withName(product.getImage().getName())
                            .withType(product.getImage().getType())
                            .withData(product.getImage().getData())
                            .build())
                    .build();
        }
    }

    List<ProductDto> findAll() {
        return productRepository.findAll().stream().map(product -> {
            List<Vitamin> vitamins = vitaminRepository.findByProductId(product.getId());

            return ProductDto.builder(product.getName(), product.getCalories())
                    .withId(product.getId())
                    .withDescription(product.getDescription())
                    .withCarbs(product.getCarbs())
                    .withFat(product.getFat())
                    .withProtein(product.getProtein())
                    .withWater(product.getWater())
                    .withVitaminList(vitamins.stream().map(vitamin -> VitaminDto.builder()
                                    .withId(vitamin.getId())
                                    .withName(vitamin.getName())
                                    .withUnit(vitamin.getUnit())
                                    .withValue(vitamin.getValue())
                                    .build())
                            .collect(toList()))
                    .withImage(ImageDto.builder()
                            .withId(product.getImage().getId())
                            .withName(product.getImage().getName())
                            .withType(product.getImage().getType())
                            .withData(product.getImage().getData())
                            .build())
                    .build();
        }).collect(toList());
    }

    ProductDto findById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();

            ProductDto build = ProductDto.builder(product.getName(), product.getCalories())
                    .withId(product.getId())
                    .withDescription(product.getDescription())
                    .withCarbs(product.getCarbs())
                    .withFat(product.getFat())
                    .withProtein(product.getProtein())
                    .withWater(product.getWater())
                    .withVitaminList(vitaminRepository.findByProductId(product.getId()).stream().map(vitamin -> VitaminDto.builder()
                            .withId(vitamin.getId())
                            .withName(vitamin.getName())
                            .withUnit(vitamin.getUnit())
                            .withValue(vitamin.getValue())
                            .build()
                    ).collect(toList()))
                    .withImage(ImageDto.builder()
                            .withId(product.getImage().getId())
                            .withName(product.getImage().getName())
                            .withType(product.getImage().getType())
                            .withData(product.getImage().getData())
                            .build())
                    .build();
            System.out.println(build);
            return build;
        }
        throw new IllegalArgumentException("The object does not exist.");
    }
}
