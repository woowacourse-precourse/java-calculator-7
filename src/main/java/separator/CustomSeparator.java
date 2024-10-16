package separator;

import java.math.BigInteger;
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

    public CustomSeparator(String inputData,List<String> customSeparators, CustomSeparatorFormat customSeparatorFormat) {
        this.inputData = inputData;
        this.customSeparatorFormat = customSeparatorFormat;
        this.customSeparators = customSeparators;
    }

    @Override
    public List<String> getSeparator() {
        return customSeparators;
    }

    @Override
    public List<BigInteger> getNumbers(String input) {
        return null;
    }

    public String findSeparator() {
        Matcher matcher = customSeparatorFormat.getPattern().matcher(inputData);

        if(matcher.find()){
            String group = matcher.group(1);
            System.out.println("----- custom : " + group);
            String validatedCustomSeparator = validateCustomSeparator(group);
            return validatedCustomSeparator;
        }else {
            throw new IllegalArgumentException("커스텀문자를 찾을 수 없습니다.");
        }



    }

//    String[] split = inputData.split(validatedCustomSeparator);
//        for (int i = 0; i < split.length; i++) {
//        System.out.println(i + " : " + split[i]);
//    }


    public String validateCustomSeparator(String separator){
        try {
            Integer.parseInt(separator);
            throw new IllegalArgumentException("커스텀 구분자에는 숫자가 올 수 없습니다.");
        }catch (NumberFormatException e){
            return separator;
        }
    }


}
