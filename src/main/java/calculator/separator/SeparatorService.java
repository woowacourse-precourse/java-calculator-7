package calculator.separator;

public class SeparatorService {

    private final SeparatorRepository separatorRepository;

    public SeparatorService(SeparatorRepository separatorRepository) {
        this.separatorRepository = separatorRepository;
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
        if (separatorRepository.isContainSeparator(new Separator(separator))) {
            return true;
        }
        return false;
    }
}
