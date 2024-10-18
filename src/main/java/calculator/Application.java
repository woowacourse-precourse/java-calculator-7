package calculator;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        String input;
        String sep = "";
        String str = "";
        int sum, result=0;

	System.out.println("덧셈할 문자열을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        input = sc.nextLine();
        String[] input_split = input.split("");
        String[] str_num = input.split(",|:");

        if(input_split[0].equals("/")){
            
        }else{
            try{
                for (int i=0; i<str_num.length; i++){
                    if (Integer.parseInt(str_num[i]) >=0 ){
                        sum = Integer.parseInt(str_num[i]);
                        result += sum;
                    }else{
                        throw new IllegalArgumentException("잘못된 값입니다.");
                    }
                }    
                System.out.println("결과 : " + result);
            }catch (Exception e){
                throw new IllegalArgumentException(e);
            }
        } 
    }
}
