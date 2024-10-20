package calculator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Calculator {
    private int result = 0;
    public void print(){
        System.out.println("결과 : " + result);
    }
    public String[] processing(String input)  {

        if(input==null){
            throw new IllegalArgumentException("입력값이 null입니다.");
        }
        String regex = "//(.*)\\\\n";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(input.trim());
        if (matcher.find()) {
            String customSplitter = matcher.group(1);
            String restOfInput = input.substring(matcher.end());

            return restOfInput.split(customSplitter);
        } else {
            return input.split("[,:]");
        }
    }
    public void calculate(String[] input){
        for (String s : input){
           if(!s.matches("-?\\d+"))
           {
               throw new IllegalArgumentException("숫자가 아닌 값입니다.");
           }
           int number = Integer.valueOf(s);
           if(number<0){
               throw new IllegalArgumentException("입력한 수가 음수입니다.");
           }
            this.result += number;
        }
    }
}
