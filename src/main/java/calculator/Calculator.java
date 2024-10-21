package calculator;

public class Calculator {
    private Exception exception = new Exception();

    public int add(String input){
       int[] number =exception.validate(input);
       int sum=0;

       for(int i=0;i<number.length;i++){
          sum+=number[i];
       }
       return sum;
    }
}
