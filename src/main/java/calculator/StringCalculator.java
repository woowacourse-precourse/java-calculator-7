package calculator;

public class StringCalculator {
    NumberParser numberParser;
    Delimiter delimiter;

    /**
     * 구성자
     * @param input 입력받은 문자열
     */
    public StringCalculator(String input) {
        delimiter = new Delimiter(input);
        numberParser = new NumberParser(delimiter);
        numberParser.parseNumber(input);
    }

    /**
     *
     * @return 구분자로 구분된 숫자의 합 출력
     */
    public Integer add() {
        Integer totalSum = 0;
        for(int i = 0; i < numberParser.getSize(); i ++) {
            totalSum += numberParser.getNumberAt(i);
        }
        return totalSum;
    }
}
