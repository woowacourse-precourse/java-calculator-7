public class Calculator {
     public int add(String input) {
         // 기본 구분자
         String delimiter = ",|:";
         String[] tokens = input.split(delimiter);

     }

    // 분리된 숫자 더하기
    private int sumTokens(String[] tokens) {
        int sum = 0;
        for (String token : tokens) {
            int number = parseNumber(token);
            sum += number;
        }
        return sum;
    }

}