package calculator;

public class Calculator {

    Integer sum = 0;

    public int Calculation(String str) {

        if(str.startsWith("//")) return custom(str.substring(5), str.substring(2, 3)); // 커스텀 구분자(?)를 사용하는 커스텀 계산기
        else return basic(str); // 기본 구분자를 사용하는 기본 계산기

    }

    // 기본 구분자(, :)를 사용하는 기본 계산기
    public int basic(String str) {

        sum = 0;

        String[] numbers = str.split("[,:]+"); // 콤마(,), 콜론(:)을 구분자로 지정

        for(String number : numbers) {
            sum += Integer.parseInt(number);
        }

        return sum;
    }

    // 커스텀 구분자(?)를 사용하는 커스텀 계산기
    public int custom(String str, String sep) {

        sum = 0;

        String[] numbers = str.split(sep); // 콤마(,), 콜론(:)을 구분자로 지정

        for(String number : numbers) {
            sum += Integer.parseInt(number);
        }

        return sum;

    }
}
