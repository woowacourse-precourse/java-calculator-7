package calculator;

public class Calculator implements AutoCloseable{
    private String input;

    //Generator: 기본 구분자 추가
    public Calculator(String input) {
        this.input = input;
    }

    //process() : 구분자 처리, 숫자만 남은 문자열 처리, 합 계산 과정
    public void process() {
        DelimiterService delimiterService = new DelimiterService(input);

        while(delimiterService.isDelimStarting()) {
            delimiterService.addDelimiter();
        }
        delimiterService.replacePattern();

        input = delimiterService.getInput();
        if(input.isEmpty()) {
            int sum = 0;
            return;
        }

        String delimiterRegex = delimiterService.getDelimiters();
        IntegerService integerService = new IntegerService(input, delimiterRegex);
        integerService.getIntegers();
        integerService.printSum();
    }

    @Override
    public void close() throws IllegalArgumentException {
        System.out.println("종료되었습니다.");
    }
}
