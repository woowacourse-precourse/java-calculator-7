package calculator;
import camp.nextstep.edu.missionutils.Console;
public class Application {
    public static void main(String[] args) {
       System.out.println("덧셈할 문자열을 입력하세요.");
       String input = Console.readLine();
    }
    public static int calc(String input){
          if (input == null || input.isEmpty()) {
               return 0;
          }
       input=input.replaceAll(":",",");
       String arr[]=input.split(",");
       int sum=0;
       for(int i=0; i<arr.length; i++){
          if(Integer.parseInt(arr[i])<0) {
          }
          sum+=Integer.parseInt(arr[i]);
       }
       return sum;
    }
}