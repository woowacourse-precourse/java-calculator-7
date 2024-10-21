package calculator.separator;

import calculator.extract.ExtractRepository;

public class SeparatorService {

    private final SeparatorRepository separatorRepository;
    private final ExtractRepository extractRepository;

    public SeparatorService(SeparatorRepository separatorRepository, ExtractRepository extractRepository) {
        this.separatorRepository = separatorRepository;
        this.extractRepository = extractRepository;
        saveFixedSeparators(separatorRepository);
    }

    private void saveFixedSeparators(SeparatorRepository separatorRepository) {
        FixedSeparator[] fixedSeparators = FixedSeparator.values();
        for (FixedSeparator fixedSeparator : fixedSeparators) {
            separatorRepository.save(new Separator(fixedSeparator.getSeparator()));
        }
    }

    public void saveCustomSeparator(char separator) {
        separatorRepository.save(new Separator(separator));
    }

    public boolean isAllowedSeparator(char separator) {
        if (isExtractSeparatorsContainCustomSeparator(separator)) {
            return false;
        }
        if (separatorRepository.isContainSeparator(new Separator(separator))) {
            return true;
        }
        return false;
    }

    public boolean isExtractSeparatorsContainCustomSeparator(char separator) {
        return extractRepository
                .getExtracts()
                .stream()
                .anyMatch(extract -> extract.startSeparators()
                        .contains(Character.toString(separator)));
    }
}
