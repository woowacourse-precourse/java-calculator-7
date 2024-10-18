package calculator.model;

import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Extractor {
    public ExtractorDto saveExtractorDto(String calculationValue){
        final String START_POINT_DELIMITER = "//";
        final String END_POINT_DELIMITER = "\n";
        Delimiter delimiter = new Delimiter();
        ExtractorDto extractorDto= new ExtractorDto();

        if(calculationValue.contains(START_POINT_DELIMITER)&& calculationValue.contains(END_POINT_DELIMITER)){
            calculationValue.replace(START_POINT_DELIMITER,"");
            extractorDto = extractDelimiterAndNumber(extractorDto,delimiter,calculationValue,END_POINT_DELIMITER);
            return extractorDto;
        }
        extractorDto.settingExtractorDto(delimiter.getDelimiters(),calculationValue);
        return extractorDto;
    }

    public ExtractorDto extractDelimiterAndNumber(ExtractorDto extractorDto, Delimiter delimiter, String calculationValue,String END_POINT_DELIMITER) {
        final int POSITION_DELIMITERS = 0;
        final int POSITION_VALUES = 1;

        List<String> delimiters = new ArrayList<>();
        String[] divideDelimiterAndNumber = calculationValue.split(END_POINT_DELIMITER);
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
            Number number = new Number(Integer.parseInt(value.trim()));
            values.add(number);
        }
        Numbers numbers = new Numbers(values);
        return numbers;
    }
}
