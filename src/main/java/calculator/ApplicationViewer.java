package calculator;
import camp.nextstep.edu.missionutils.Console;

// 입력 및 출력을 하는 객체(View)
public class ApplicationViewer {
    private ApplicationViewer(){}

    public static String input(){
       return Console.readLine(); // TEMP: Scanner 를 싱글톤으로 접근케 하는 오브젝트
    }

    public static void outputLine(String msg){
        System.out.println(msg);
    }

    public static void output(String msg){
        System.out.print(msg);
    }
}
