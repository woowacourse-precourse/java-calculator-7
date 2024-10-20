package calculator.parser;

import java.util.ArrayList;
import java.util.List;

public class ExtractNumber {
    public int extractNumbers(String[] strings){
        List<Integer> numbers = new ArrayList<>();

        for(String s : strings){
            StringBuilder num = new StringBuilder();

            for(int i = 0; i < s.length(); i++){
                if(Character.isDigit(s.charAt(i))){
                    num.append(s.charAt(i));
                }
            }

            if(!num.isEmpty()){
                numbers.add(Integer.parseInt(num.toString()));
            }
        }

        return sumNumber(numbers);
    }

    int sumNumber(List<Integer> numbers){
        int sum = 0;

        for(Integer i : numbers) {
            sum += i;
        }

        return sum;
    }
}
