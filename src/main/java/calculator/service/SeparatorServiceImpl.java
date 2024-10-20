package calculator.service;

import calculator.config.SeparatorConstants;
import calculator.model.Separator;
import calculator.repository.SeparatorRepository;
import java.util.Set;

public class SeparatorServiceImpl implements SeparatorService{
    private final SeparatorRepository separatorRepository;

    public SeparatorServiceImpl(SeparatorRepository separatorRepository) {
        this.separatorRepository = separatorRepository;
    }

    @Override
    public void join(Separator separator) {
        if (!have(separator)) {
            separatorRepository.save(separator);
        }
    }

    private boolean have(Separator separator) {
        return separatorRepository.findAll()
                .stream()
                .anyMatch(i -> i.equals(separator));
    }

    @Override
    public Set<Separator> findAllSeparator() {
        return separatorRepository.findAll();
    }

    @Override
    public String extractCustomSeparator(String input) {
        String[] parts = input.split(SeparatorConstants.CUSTOM_SEPARATOR_NEWLINE, 2);
        char customSeparator = parts[0].charAt(SeparatorConstants.CUSTOM_SEPARATOR_PREFIX.length());
        System.out.println(customSeparator);
        validateCustomSeparator(customSeparator);

        join(new Separator(customSeparator));

        return parts.length > 1 ? parts[1] : "";
    }

    private void validateCustomSeparator(char customDelimiter) {
        validateNonDigitCharacter(customDelimiter);
    }

    private void validateNonDigitCharacter(char customDelimiter) {
        if (Character.isDigit(customDelimiter)) {
            throw new IllegalArgumentException("커스텀 구분자는 숫자가 아니어야 합니다.");
        }
    }

}
