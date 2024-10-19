package calculator;
import java.util.ArrayList;
import java.util.Scanner;

//프로그램을 실행하는 메인 메서드
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        User user = new User();//게임의 사용자 생성
        user.Useroutput();
    }
}

class User{
    public static String s;
    public static final String final_sum="결과: ";
    User(){
        Scanner sc= new Scanner(System.in);
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        s= sc.nextLine();
        Calculator cal=new Calculator(s);
    }

    void Useroutput(){
        System.out.println(final_sum +Calculator.answer);
    }

}

//계산기
class Calculator {
    protected static final String Trim1="," ;
    protected static final String Trim2 =":" ;
    protected static String Trim3 ="";
    //protected static String arr[];
    ArrayList<Integer> list=new ArrayList<>();
    static int answer=0;
    //initiallize
    Calculator(String s){
        s=extraSplitCheck(s);
        Parse(s);
        sumNumber(list);
    }

    //주어진 문자열을 구분자로 나누는 메서드
    void Parse(String s){
        //기본 구분자를 결합한다.
        String delimiter =Trim1+ "|"+ Trim2;
        if (!Trim3.isEmpty()) {
            delimiter += "|" + Trim3;
        }

        //문자열을 구분자로 나눈다.
        String[] tokens =s.split(delimiter);

        //숫자 리스트에 추가.
        for (String token: tokens){
                list.add(Integer.parseInt(token.trim()));
            }

        }
    }

    String extraSplitCheck(String str){
        if (str.startsWith("//")){
            Trim3 = String.valueOf(str.charAt(2));
            //구분자를 처리한 후 실제 숫자 문자열만 남기기.
            return str.substring(4);
        }
        return str;
    }

    //주어진 문자열의 숫자를 합하는 메서드
    void sumNumber(ArrayList<Integer> numbers){
        for (int num: numbers){
            answer+=num;
        }
    }


}

