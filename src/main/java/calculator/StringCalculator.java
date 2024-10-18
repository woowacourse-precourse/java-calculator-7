package calculator;

public class StringCalculator {

    public int add(String input) {
        // input null or 0
        if (isBlank(input)) {
            return 0;
        }
       return sum(toInts(split(input)));
    }
    private boolean isBlank(String input) {
        return input == null || input.isEmpty();
    }
    private String[] split(String input) {
        String separator = ",|:";
        if(input.startsWith("//")){
            String customPart = input.substring(2, 3);
            System.out.println(customPart);
            separator += "|" + customPart; //add custom separator
            System.out.println(separator);
            input = input.substring(5);
            System.out.println(input);
        }
        return input.split(separator);
    }

    private int[] toInts(String[] values){
        int[] numbers = new int[values.length];
        for(int i =0; i < values.length; i++){
            int number = Integer.parseInt(values[i]);
            if(number <0){
                throw new IllegalArgumentException();
            }
            numbers[i] = number;
        }
        return numbers;
    }

    private int sum(int[] numbers) {
        int sum = 0;
        for(int number : numbers){
            sum += number;
        }
        return sum;
    }
}
