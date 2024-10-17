package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //1. 문자열에서 숫자 추출(+ ""의 경우 0으로 추출, 쉼표와 콜론으로 구분.)
        //2. 커스텀 구분자 //과 \n 사이에 있는 문자는 구분자로 인식.
        //3. 잘못된 값이 입력될 경우, illegalArgumentException 발생 후 애플리케이션 종료.
        /* BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        /*
        String str = "1//1";
        if (str.length() == 0) {
            System.out.println("0");
        }else {
            String arr[] = str.split("//|\n|,|:");
            int sum = 0;
            for (String cut : arr) {
                int num = Integer.valueOf(cut);
                sum += num;
            }
            System.out.println(arr[1]);
            System.out.println(sum);
        }
        */ //예외문 처리
        String str2 = "//;\n1;2;3";
        String divider = str2.split("//|\n")[1]; //Divider = ; 지정 (문자열 스플릿 > 인덱스)
        String output = str2.split("\n")[1]; //\n 이후의 문자열을 커스텀 구분자와 기본 구분자 ,와 |로 구분 (문자열 인덱스)
        System.out.println(output);

        String arr2[] = output.split(divider);
        int sum2 = 0;
        for (String cut : arr2) {
            int num2 = Integer.valueOf(cut);
            sum2 += num2;
        }
        System.out.println(sum2);

    }
}
