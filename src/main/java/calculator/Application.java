package calculator;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        String input;
        String sep = "";
        String str = "";
        int sum, result=0;
        Scanner sc = new Scanner(System.in);
      
        input = sc.nextLine();
        String[] input_split = input.split("");
        String[] str_num = input.split(",|:");

        if(input_split[0].equals("/")){
            try {
                for (int i=2; i<input_split.length; i++){
                    if (input_split[0].equals("/") && input_split[1].equals("/")){
                        if (input_split[i].equals("\\") && input_split[i+1].equals("n")){
                            break;
                        }
                        sep += input_split[i];
                    }
                }
    
                for (int i=4+sep.length(); i<input.length(); i++){
                    str = str + input_split[i];
                }

                String[] input_split2 = str.split(sep);
                for (int i=0; i<input_split2.length; i++){
                    result += Integer.parseInt(input_split2[i]);
                }
                System.out.println("결과 : " + result);
            } catch (Exception e) {
                throw new IllegalArgumentException(e);
            }
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
