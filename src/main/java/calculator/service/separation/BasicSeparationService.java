package calculator.service.separation;

import static calculator.service.validation.SeparationValidator.validate;

import calculator.service.dto.NumberDto;
import calculator.service.dto.NumbersDto;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BasicSeparationService implements SeparationService {

    private static final String COMMA = ",";
    private static final String COLON = ":";
    private static final String BASIC_SEPARATOR_REGEX = "[,:]";

    @Override
    public boolean hasCustomSeparator(String input) {
        return false;
    }

    @Override
    public NumbersDto getNumbers(String input, String... separators) {
        validate(input, COMMA, COLON);

        String[] split = split(input, BASIC_SEPARATOR_REGEX);
        List<NumberDto> values = Arrays.stream(split)
                .map(Integer::parseInt)
                .map(NumberDto::from)
                .collect(Collectors.toList());

        return NumbersDto.from(values);
    }
}
