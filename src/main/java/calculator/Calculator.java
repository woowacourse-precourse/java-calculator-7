package calculator;

public class Calculator {

    public void Calculation(String str) {

        basic(str); // 기본 구분자를 사용하는 기본 계산기

    }

    // 기본 구분자(, :)를 사용하는 기본 계산기
    public static void basic(String str) {

        Integer sum = 0;

        String[] numbers = str.split("[,:]+"); // 콤마(,), 콜론(:)을 구분자로 지정

        for(String number : numbers) {
            sum += Integer.parseInt(number);
        }

        System.out.println(sum);
    }
}
