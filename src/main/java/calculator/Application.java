package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            String input = reader.readLine();

            int result = calculateSum(input);
            System.out.println("결과 : " + result);
        }
        // 오류 처리
        catch(IllegalArgumentException e){
            System.out.println("입력 오류 : "+ e.getMessage());
        }
        // readline error throw
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            try{
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static int calculateSum(String input){
        if(input.isEmpty()){
            return 0;
        }
        String[] numbers;
        String delimiter = ",|:";
        numbers = input.split(delimiter);
        int sum = 0;
        for(String number : numbers){
            int num = Integer.parseInt(number.trim());
            if(num < 0){
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + num);
            }
            sum += num;
        }
        return sum;
    }
}
