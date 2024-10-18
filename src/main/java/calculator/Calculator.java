package calculator;

import calculator.feature.Adder;
import calculator.feature.CustomDelimiter;
import calculator.feature.SplitNumber;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    Adder adder;
    CustomDelimiter delimiter;
    SplitNumber spliter;
    String str;

    public Calculator(String str) {
        this.str = str;
    }

    public int calc() {
        char[] deli = {};

        if (str.startsWith("//")) { // 커스텀 구분자가 포함된 경우
            delimiter = new CustomDelimiter(str);
            deli = delimiter.getDelimiter();

            Pattern pattern = Pattern.compile("\\d+.*"); // 커스텀 구분자 외 문자열 가져오기
            Matcher matcher = pattern.matcher(str);

            if(!matcher.find()){
                str = "";
            }else {
                str = matcher.group();
            }
        } else { // -나 +로 시작하는 경우 제외하기
            Pattern pattern = Pattern.compile("^\\d+.*");
            Matcher matcher = pattern.matcher(str);

            if(!matcher.find()){
                throw new IllegalArgumentException();
            }else {
                str = matcher.group();
            }
        }

        spliter = new SplitNumber(deli, str);
        int[] number = spliter.getNumber();

        adder = new Adder(number);
        int sum = adder.getSum();

        return sum;
    }
}
