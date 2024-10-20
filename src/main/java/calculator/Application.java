package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine().replace("\"", "").trim();
        try {
            StringCalculator calculator = new StringCalculator(input);
            int result = calculator.addAll();
            System.out.print("결과 : " + result);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }
}

class StringCalculator {
    private final String input;
    private String delim = ",|:";

    public StringCalculator(String input){
        this.input = input;
        if(input.startsWith("//")){
            String[] temp = input.split("\\\\n", 2);
            if(temp.length>1 && temp[0].startsWith("//")){
                delim= temp[0].substring(2);
            }
        }
    }

    public int addAll(){
        String numbers = getNumsPart();
        String[] pieces = splitNums(numbers);
        int[] numArray = makeNums(pieces);
        return addNums(numArray);
    }

    private String getNumsPart(){
        if (input.startsWith("//")){
            String[] temp = input.split("\\\\n", 2);
            return temp.length > 1 ? temp[1] : "";
        }
        return input;
    }

    private String[] splitNums(String numbers) {
        return numbers.split("[" + delim + "]");
    }

    private int[] makeNums(String[] pieces){
        int[] nums = new int[pieces.length];
        int count = 0;

        for(String piece : pieces){
            try {
                int num = Integer.parseInt(piece);
                if (num<0){
                    throw new IllegalArgumentException();
                }
                nums[count++]= num;
            }
            catch (NumberFormatException e){
                throw new IllegalArgumentException(e.getMessage());
            }
        }
        int[] result = new int[count];
        System.arraycopy(nums, 0, result, 0, count);
        return result;
    }

    private int addNums(int[] nums){
        int total = 0;
        for(int num : nums){
            total += num;
        }
        return total;
    }
}
