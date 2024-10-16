package calculator;

public class Calculator {

    // DelimiterChecker에서 넘어온 숫자들을 배열로 저장
    // 이때 숫자의 개수까지 체크하여 배열의 개수로 저장
    public int n = 0;
    int[] numbers = new int[n];
    int sum = 0;

    // 저장된 배열의 숫자들을 전부 더하고 Application으로 반환
    public Calculator(String formula) {
        DelimiterCheck checker = new DelimiterCheck(formula);

    }


}
