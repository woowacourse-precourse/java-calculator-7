package calculator.addCalculator;

public class AddCalculator {
    public int calculateSum(String[] numbers){
        int sum = 0;

        for(String number : numbers){
            String trimmedNumber = number.trim();
            if(trimmedNumber.isEmpty()){
                continue;
            }
            int num = Integer.parseInt(trimmedNumber);
            if(num < 0){
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
            sum += num;
        }
        return sum;
    }

}
