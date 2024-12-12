package calculator.domain;

public class Calculate {

    private final String[] numbers;
    private int sum = 0;

    public Calculate(Strings strings) {
        this.numbers = strings.distinguisher();
    }

    public int addNumbers() {

        for (String number : numbers) {
            int i = Integer.parseInt(number);

            if (i <= 0) {
                throw new IllegalArgumentException("올바른 값을 입력해주세요");
            }

            sum += i;
        }
        return sum;
    }

}
