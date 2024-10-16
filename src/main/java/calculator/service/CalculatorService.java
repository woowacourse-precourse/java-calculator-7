package calculator.service;

public class CalculatorService {

    // 더하기 메소드 구현
    // 1) 구분자 [,:] 를 제외하여 더해야함
    public int add(String input) {
        String[] str = input.split("[,:]");

        int sum = 0;
        for (String s : str) {
            sum += Integer.parseInt(s);
        }

        return sum;
    }
    // 2) 커스텀 구분자를 포함하여 숫자를 구분하여 더함.

    // 3) 예외 처리

}
