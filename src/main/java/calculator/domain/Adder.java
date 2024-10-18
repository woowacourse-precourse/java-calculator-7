package calculator.domain;

public class Adder {

    //숫자 리스트의 합계를 계산하여 반환
    public int addAll(String numbers) {
        System.out.println(numbers);
        //validateNumbers(numbers);  // 숫자 리스트 유효성 검사
        int total = 0;

        String[] numberArray = numbers.split(",");

        for (String number : numberArray) {
            if (!number.isEmpty()) {
                total += Integer.parseInt(number.trim());
            }
        }

        return total;
    }
}
