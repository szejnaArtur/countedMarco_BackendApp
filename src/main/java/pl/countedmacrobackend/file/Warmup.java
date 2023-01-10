package pl.countedmacrobackend.file;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component("imageWarmup")
class Warmup implements ApplicationListener<ContextRefreshedEvent> {

    private final ImageFileStorageService imageService;

    Warmup(final ImageFileStorageService imageService) {
        this.imageService = imageService;
    }

    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {

    }
}
