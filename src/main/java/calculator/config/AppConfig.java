package calculator.config;

import calculator.repository.MemorySeparatorRepository;
import calculator.service.SeparatorService;
import calculator.service.SeparatorServiceImpl;
import calculator.view.InputView;

public class AppConfig {
    public InputView inputView() {
        return new InputView();
    }



    public MemorySeparatorRepository separatorRepository() {
        return new MemorySeparatorRepository();
    }



    public SeparatorService separatorService() {
        MemorySeparatorRepository repository = separatorRepository();
        SeparatorInitializer separatorInitializer = new SeparatorInitializer(repository);
        separatorInitializer.initialize();

        return new SeparatorServiceImpl(repository);
    }
}
