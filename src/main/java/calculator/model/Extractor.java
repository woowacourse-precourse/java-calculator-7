package calculator.model;

import java.util.List;
import java.util.ArrayList;

public class Extractor {
    public ExtractorDto saveExtractorDto(String calculationValue) {
        final String START_POINT_DELIMITER = "//";
        final String END_POINT_DELIMITER = "\\n";
        final String SPLIT_POINT = "\n";
        Delimiter delimiter = new Delimiter();
        ExtractorDto extractorDto = new ExtractorDto();

        if (calculationValue.contains(START_POINT_DELIMITER) && calculationValue.contains(END_POINT_DELIMITER)) {
            calculationValue = calculationValue.replace(START_POINT_DELIMITER, "");
            calculationValue = calculationValue.replace(END_POINT_DELIMITER, SPLIT_POINT);
            String[] divideDelimiterAndNumber = calculationValue.split(SPLIT_POINT);
            extractorDto = saveCustomDelimiter(extractorDto, delimiter, divideDelimiterAndNumber);
            return extractorDto;
        }
        extractorDto.settingExtractorDto(delimiter.getDelimiters(), calculationValue);
        return extractorDto;
    }

    public ExtractorDto saveCustomDelimiter(ExtractorDto extractorDto, Delimiter delimiter, String[] divideDelimiterAndNumber) {
        final int POSITION_DELIMITERS = 0;
        final int POSITION_VALUES = 1;

        List<String> delimiters = new ArrayList<>();
        String appointedDelimiter = divideDelimiterAndNumber[POSITION_DELIMITERS];
        delimiters.add(appointedDelimiter);
        delimiter.settingDelimiters(delimiters);
        String appointedNumbers = divideDelimiterAndNumber[POSITION_VALUES];

        extractorDto.settingExtractorDto(delimiters, appointedNumbers);
        return extractorDto;
    }

    public Numbers extractValues(String calculationValue) {
        ExtractorDto extractorDto = saveExtractorDto(calculationValue);

        List<String> delimiters = extractorDto.getDelimiters();
        String appointedValues = extractorDto.getValues();
        String appointedDelimiters = String.join("|", delimiters);
        String[] valuesBeforeExtract = appointedValues.split(appointedDelimiters);

        List<Number> values = new ArrayList<>();
        for (String value : valuesBeforeExtract) {
            value = value.trim();
            if (value.isEmpty()) value = "0";
            numericErrorDiscriminator(value);
            Number number = new Number(Integer.parseInt(value));
            values.add(number);
        }
        Numbers numbers = new Numbers(values);
        return numbers;
    }

    public void numericErrorDiscriminator(String value) {
        if (!value.matches("-?\\d+")) {
            throw new IllegalArgumentException("입력된 값이 숫자가 아닙니다.");
        }
    }
}
