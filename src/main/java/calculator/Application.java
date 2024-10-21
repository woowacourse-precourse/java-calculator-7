package calculator;
import camp.nextstep.edu.missionutils.Console;
public class Application {
    public static void main(String[] args) {
       System.out.println("덧셈할 문자열을 입력하세요.");
       String input = Console.readLine();
       try{
          calc(input);
       System.out.println("결과:"+calc(input));
       }
       catch(IllegalArgumentException e) {
          System.out.println(e.getMessage());
       }
    }
    public static int calc(String input){
          if (input == null || input.isEmpty()) {
               return 0;
          }
       if(input.startsWith("//")){
          String custom=input.substring(2,input.indexOf("\\n"));
          input=input.substring(input.indexOf("\\n")+2);
          input=input.replaceAll(custom,",");
       }else if(input.startsWith("/")) {
          throw new IllegalArgumentException("제대로 된 구분자를 입력해주세요.");
       }
       input=input.replaceAll(":",",");
       String arr[]=input.split(",");
       int sum=0;
       for(int i=0; i<arr.length; i++){
          if(Integer.parseInt(arr[i])<0) {
             throw new IllegalArgumentException("음수를 입력하였습니다. 양수를 입력해주세요.");
          }
          sum+=Integer.parseInt(arr[i]);
       }
       return sum;
    }
}