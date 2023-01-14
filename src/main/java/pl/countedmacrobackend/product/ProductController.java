package pl.countedmacrobackend.product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pl.countedmacrobackend.file.dto.ResponseMessage;
import pl.countedmacrobackend.product.dto.ProductDto;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin("http://localhost:3000")
class ProductController {

    private final ProductFacade productFacade;

    ProductController(final ProductFacade productFacade) {
        this.productFacade = productFacade;
    }

    @PostMapping
    ResponseEntity<ResponseMessage> add(@RequestPart("product") ProductDto productDto, @RequestPart("file") MultipartFile file) {
        String message = "";

        try {
            productFacade.add(productDto, file);
            message = "Saved the product successfully: " + productDto.getName();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not saved the product: " + productDto.getName() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @GetMapping
    ResponseEntity<List<ProductDto>> findAll() {
        return ResponseEntity.ok().body(productFacade.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<ProductDto> findById(@PathVariable Long id) {
        ProductDto dto = productFacade.findById(id);
        return ResponseEntity.ok().body(dto);
    }
}
