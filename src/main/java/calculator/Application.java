package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Application {
    public static void main(String[] args) throws IOException {

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        int sum =0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String input[] = str.split("\\\\n");

        if(str.indexOf("//")!=0&&str.contains("\\n")) // //이 없는 경우
                throw new IllegalArgumentException();
        else if(str.indexOf("//")==0&&!str.contains("\\n")) // \n이 없는 경우
            throw new IllegalArgumentException();
        String[] dividedIntoBasic;

        if(str.indexOf("//")!=0&&!str.contains("\\n")){
            dividedIntoBasic = input[0].split(",|;");
            try{
                for(int i =0;i<dividedIntoBasic.length;i++){
                    sum+=Integer.parseInt(dividedIntoBasic[i]);
                }
            }catch(Exception e){
                throw new IllegalArgumentException();
            }
        }else {
            dividedIntoBasic = input[1].split(",|;");


            String custom = input[0].substring(2);
            String regexChar = "+?^$|()[]{}";

            StringBuilder sb = new StringBuilder();

            for (char ch : custom.toCharArray()) {
                if (regexChar.indexOf(ch) != -1) {
                    sb.append("\\").append(ch); // 이스케이프 처리
                }
            }
            try {
                for (int i = 0; i < dividedIntoBasic.length; i++) {
                    String dividedIntoCustom[] = dividedIntoBasic[i].split(sb.toString());

                    for (String answer : dividedIntoCustom) {
                        sum += Integer.parseInt(answer);

//                        System.out.print(answer + " ");
                    }
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }
        System.out.println("결과 : "+sum);


    }
}

