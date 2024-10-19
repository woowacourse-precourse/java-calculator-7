package calculator.config;

import calculator.repository.MemorySeparatorRepository;

public class SeparatorInitializer {
    private final MemorySeparatorRepository separatorRepository;

    public SeparatorInitializer(MemorySeparatorRepository separatorRepository) {
        this.separatorRepository = separatorRepository;
    }

    public void initialize() {
        SeparatorConstants.getDefaultSeparator()
                .forEach(separatorRepository::save);
    }
}
