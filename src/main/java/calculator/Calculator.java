package calculator;

public class Calculator {

    // DelimiterChecker에서 넘어온 숫자들을 배열로 저장
    // 이때 숫자의 개수까지 체크하여 배열의 개수로 저장
    int[] intNumbers;
    double[] doubleNumbers;

    // 저장된 배열의 숫자들을 전부 더하고 Application으로 반환
    public Calculator(String formula) {
        DelimiterCheck checker = new DelimiterCheck(formula);

        // 배열 초기화
        intNumbers = checker.getIntNumArray();
        doubleNumbers = checker.getDoubleNumArray();


        if (intNumbers != null) {
            int sum = 0;
            for (int i = 0; i < intNumbers.length; i++) {
                sum += intNumbers[i];
            }
            System.out.println("결과 : " + sum);
            System.out.println();
        } else if (doubleNumbers != null) {
            double sum = 0;
            for (int i = 0; i < doubleNumbers.length; i++) {
                sum += doubleNumbers[i];
            }
            System.out.println("결과 : " + sum);
            System.out.println();
        }
    }


}
