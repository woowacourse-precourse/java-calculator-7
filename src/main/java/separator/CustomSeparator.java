package separator;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomSeparator implements Separator {
    private final String inputData;
    private List<String> customSeparators;
    private CustomSeparatorFormat customSeparatorFormat;



    public CustomSeparator(String inputData, CustomSeparatorFormat customSeparatorFormat) {
        this.inputData = inputData;
        this.customSeparatorFormat = customSeparatorFormat;
        this.customSeparators = List.of(findSeparator());
    }

    public CustomSeparator(String inputData, List<String> customSeparators, CustomSeparatorFormat customSeparatorFormat) {
        this.inputData = inputData;
        this.customSeparatorFormat = customSeparatorFormat;
        this.customSeparators = customSeparators;
    }



    public String findSeparator() {
        Matcher matcher = customSeparatorFormat.getPattern().matcher(inputData);

        if (matcher.find()) {
            String group = matcher.group(1);
            String validatedCustomSeparator = validateCustomSeparator(group);
            return validatedCustomSeparator;
        } else {
            throw new IllegalArgumentException("커스텀문자를 찾을 수 없습니다.");
        }
    }

    public String validateCustomSeparator(String separator) {
        try {
            Integer.parseInt(separator);
            throw new IllegalArgumentException("커스텀 구분자에는 숫자가 올 수 없습니다.");
        } catch (NumberFormatException e) {
            return separator;
        }
    }

    @Override
    public List<String> getSeparator() {
        return customSeparators;
    }

    @Override
    public List<BigInteger> getNumbers() {
        Matcher matcher = customSeparatorFormat.getPattern().matcher(inputData);
        String group;
        if (matcher.find()) {
            group = matcher.group(2);
        } else {
            throw new IllegalArgumentException("커스텀문자를 찾을 수 없습니다.");
        }
        String[] split = group.split(customSeparators.get(0));
        List<BigInteger> bigIntegerList = new ArrayList<>();
        for (String str : split) {
            bigIntegerList.add(new BigInteger(str));
        }
        return bigIntegerList;
    }


}
