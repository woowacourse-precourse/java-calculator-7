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
        String customSeparator = parts[0].substring(SeparatorConstants.CUSTOM_SEPARATOR_PREFIX.length());

        validateCustomSeparator(customSeparator);

        join(new Separator(customSeparator.charAt(0)));

        return parts.length > 1 ? parts[1] : "";
    }

    private void validateCustomSeparator(String customDelimiter) {
        validateSingleCharacter(customDelimiter);
        validateNonDigitCharacter(customDelimiter);
    }

    private void validateSingleCharacter(String customDelimiter) {
        if (customDelimiter.length() != 1) {
            throw new IllegalArgumentException("커스텀 구분자는 단일 문자여야 합니다.");
        }
    }

    private void validateNonDigitCharacter(String customDelimiter) {
        if (Character.isDigit(customDelimiter.charAt(0))) {
            throw new IllegalArgumentException("커스텀 구분자는 숫자가 아니어야 합니다.");
        }
    }

}
