package calculator.model;

import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Extractor {
    public Matcher divideDelimiterAndNumber(String calculationValue) {
        final String START_POINT_DELIMITER = "//";
        final String END_POINT_DELIMITER = "\n";
        Pattern pattern = Pattern.compile(START_POINT_DELIMITER + "(.*)" + END_POINT_DELIMITER + "(.*)");
        return pattern.matcher(calculationValue);
    }

    public ExtractorDto extractDelimiterAndNumber(String calculationValue) {
        final int POSITION_DELIMITER = 1;
        final int POSITION_NUMBERS = 2;
        ExtractorDto extractorDto = new ExtractorDto();
        Delimiter delimiter=new Delimiter();;
        String values= new String();

        Matcher matcher = divideDelimiterAndNumber(calculationValue);
        if (matcher.matches()) {
            List<String> customDelimiters = Collections.singletonList(matcher.group(POSITION_DELIMITER));
            values = matcher.group(POSITION_NUMBERS);
            delimiter.settingDelimiters(customDelimiters);
        } else if (!matcher.matches()) {
            values = calculationValue;
        }
        extractorDto.settingExtractorDto(delimiter.getDelimiters(), values);

        return extractorDto;
    }

    public Numbers extractValues(ExtractorDto extractorDto) {
        List<String> delimiters = extractorDto.getDelimiters();

        String appointedValues = extractorDto.getValues();
        String appointedDelimiters = String.join("|", delimiters);
        String[] valuesBeforeExtract = appointedValues.split(appointedDelimiters);

        List<Number> values = new ArrayList<>();
        for (String value : valuesBeforeExtract) {
            Number number = new Number(Integer.parseInt(value.trim()));
            values.add(number);
        }
        Numbers numbers = new Numbers(values);
        return numbers;
    }
}
