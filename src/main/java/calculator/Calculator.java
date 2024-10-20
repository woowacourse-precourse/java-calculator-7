package calculator;

public class Calculator {
    int result = 0;
    void print(){
        System.out.println(result);
    }
    String[] processing(String input){
        String[] splitInput = input.trim().split("[,:]");
       return splitInput;
    }
    void calculate(String[] input){
        for(int i=0;i<input.length;i++){
            String s = input[i];
            this.result += Integer.valueOf(s);
        }
    }
}
