package calculator;

public class StringCalculator {

    public int add(String input) {
        // input null or 0
        if (input == null || input.isEmpty()) {
            return 0;
        }
        // 구분자 "," 입력

            String[] values =  input.split(",");
            int sum = 0;
            for(String value : values){
                sum += Integer.parseInt(value);
            }
            return sum;

    }


}
