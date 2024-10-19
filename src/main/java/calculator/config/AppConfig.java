package calculator.config;

import calculator.repository.MemorySeparatorRepository;
import calculator.service.SeparatorService;
import calculator.service.SeparatorServiceImpl;

public class AppConfig {
    public SeparatorService separatorService() {
        MemorySeparatorRepository repository = new MemorySeparatorRepository();
        SeparatorInitializer separatorInitializer = new SeparatorInitializer(repository);
        separatorInitializer.initialize();

        return new SeparatorServiceImpl(repository);
    }
}
