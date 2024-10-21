package calculator.model;

// 사용자의 입력을 구분한 뒤 합산하여 반환함
public class Calculator {

    public int calculate(String input, String delimiter) {
       String[] numbers = splitString(input, delimiter);
       int sum = 0;
       try {
           for (String number : numbers) {
               int num = Integer.parseInt(number);
               if (num < 0) {
                   throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
               }
               sum += num;
           }
       } catch (Exception e) {
           throw new IllegalArgumentException("구분자가 아닌 문자가 있습니다.");
       }
      return sum;
    }

    private String[] splitString(String input, String delimiter) {
       return input.split(delimiter);
    }
}
