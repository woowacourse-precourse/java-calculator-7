package calculator;

public class Calculator extends RegexCheck{


  Calculator(String input) {
    super(input);
  }

  public void changeInt(String[] args){
    int[] numbers = new int[args.length];
    for(int i=0;i<args.length;i++){
      numbers[i] = Integer.parseInt(args[i]);
    }
  }

  public int add(int[] numbers){
    return 1;
  }


}


