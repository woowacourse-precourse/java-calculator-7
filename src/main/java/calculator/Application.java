package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args){
        String st = readLine();

        int sum = 0;

        if (st.contains(":") || st.contains(";")) {
            String[] arr = st.split("\\D");

            for (int i = 0; i < arr.length; i++) {
                if(arr[i].equals("")) {
                    arr[i] = "0";
                }
            }

            for (String s : arr) {
                int integer = Integer.parseInt(s);
                sum += integer;
            }

            System.out.println("결과 : " + sum);

        } else if (st.contains("//") && st.contains("\\n")) {
            String[] arr1 = st.split("\\D");

            for (int i = 0; i < arr1.length; i++) {
                if(arr1[i].equals("")) {
                    arr1[i] = "0";
                }
            }

            for (String s : arr1) {
                int integer = Integer.parseInt(s);
                sum += integer;
            }

            System.out.println("결과 : " + sum);

        } else {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
        }
    }
}