package calculator.domain.delimiters;

import calculator.domain.InputtedString;
import calculator.domain.delimiter.CustomDelimiter;
import calculator.domain.delimiter.Delimiter;
import calculator.domain.delimiter.ReadyMadeDelimiter;
import calculator.util.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 구분자들을 만들기 위한 클래스 입력된 문자열에서 커스텀 구분자를 추출한 다음
 * 문자열이 올바른 형식(양수와 구분자로만 이루어짐)인지 검증한 다음 구분자들 객체를
 * 생성해서 반환한다.
 */
public class DelimitersFactory {

    public Delimiters getFromStringAfterValidate(InputtedString inputtedString) {
        String line = inputtedString.getLine();
        List<Delimiter> delimiters = new ArrayList<>();
        addReadyMadeDelimiter(delimiters);
        addCustomDelimiter(delimiters, line);
        validateFormCorrectWithDelimiters(line, delimiters);
        return new Delimiters(delimiters);
    }

    private void addReadyMadeDelimiter(List<Delimiter> delimiters) {
        Delimiter comma = new ReadyMadeDelimiter(",");
        Delimiter colons = new ReadyMadeDelimiter(":");
        delimiters.add(comma);
        delimiters.add(colons);
    }

    private void addCustomDelimiter(List<Delimiter> delimiters, String line) {
        Delimiter customDelimiter = CustomDelimiter.getFromLineAfterValidateElseNull(line);
        if (customDelimiter != null) {
            delimiters.add(customDelimiter);
        }
    }

    private void validateFormCorrectWithDelimiters(String lineToValidate,
                                                   List<Delimiter> delimiters) {
        String lineWithoutCustomDelimiterSpecifier =
                getLineWithoutCustomDelimiterWithSpecifier(lineToValidate, delimiters);
        validateOnlyDigitsDelimitersElseThrowException(lineWithoutCustomDelimiterSpecifier, delimiters);
    }

    private String getLineWithoutCustomDelimiterWithSpecifier(String line,
                                                              List<Delimiter> delimiters) {

        Delimiter customDelimiter = getCustomDelimiterElseNull(delimiters);
        if (customDelimiter != null) {
            String customDelimiterSurroundedSpecifier =
                    CustomDelimiter.headSpecifierOfCustomDelimiter +
                            customDelimiter.getSymbol() +
                            CustomDelimiter.tailSpecifierOfCustomDelimiter;
            return line.replace(customDelimiterSurroundedSpecifier, "");
        }
        return line;
    }

    private Delimiter getCustomDelimiterElseNull(List<Delimiter> delimiters) {
        for (Delimiter delimiter : delimiters) {
            if (delimiter instanceof CustomDelimiter) {
                return delimiter;
            }
        }
        return null;
    }

    private void validateOnlyDigitsDelimitersElseThrowException(String lineToValidate,
                                                                List<Delimiter> delimiters) {
        String regexDigitDelimiters = getRegexOnlyDigitsDelimitersFrom(delimiters);
        Pattern patternDigitDelimiters = Pattern.compile(regexDigitDelimiters);
        Matcher matcherDigitDelimiters = patternDigitDelimiters.matcher(lineToValidate);
        if (!matcherDigitDelimiters.matches()) {
            throw new IllegalArgumentException(Constants.exceptionMessagePrefix +
                    "양수와 구분자만 입력하세요.");
        }
    }

    private String getRegexOnlyDigitsDelimitersFrom(List<Delimiter> delimiters) {
        String startWithDigitsOrEmpty = "^([1-9][0-9]*)*(((";
        // String endWithDigitsOrEmpty = "))[1-9][0-9]*)*$";
        String endWithDigitsOrEmpty = "))([1-9][0-9]*)*)*$";
        String orBetweenGrouping = ")|(";
        return delimiters.stream()
                .map(Delimiter::getSymbol)
                .map(Pattern::quote)
                .collect(Collectors.joining(orBetweenGrouping, startWithDigitsOrEmpty,
                        endWithDigitsOrEmpty));
    }
}
