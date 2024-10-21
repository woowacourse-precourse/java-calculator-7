package calculator;


import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //1. 문자열에서 숫자 추출(+ ""의 경우 0으로 추출, 쉼표와 콜론으로 구분.)
        //2. 커스텀 구분자 //과 \n 사이에 있는 문자는 구분자로 인식.
        //3. 잘못된 값이 입력될 경우, illegalArgumentException 발생 후 애플리케이션 종료.

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = readLine();

        try {
            if (str.length() == 0) {
                System.out.println("결과 : 0");
            } else if (str.startsWith("//")) {
                String[] parts = str.split("//|\\\\n"); // "//" 또는 "\n"로 나누기
                String output = str.split("\\\\n")[1]; //\n 이후의 문자열을 커스텀 구분자와 기본 구분자 ,와 |로 구분 (문자열 인덱스)

                if (parts[1].equals("")) {
                    throw new IllegalArgumentException("invaild value");
                }

                String arr[] = output.split("[" + parts[1] + "|,|:" + "]");
                //String p = output.replaceAll(separator,",");
                //String arr[] = p.split(",|:");

                int sum = 0;

                for (String cut : arr) {
                    if (!Validate.isInteger(cut)) {
                        throw new IllegalArgumentException("invaild character");
                    }
                    int num = Integer.valueOf(cut);
                    if (num < 0) {
                        throw new IllegalArgumentException("negative value");
                    }
                    sum += num;
                }
                System.out.println("결과 : " + sum);

            } else {
                String arr[] = str.split(",|:");
                int sum = 0;

                for (String cut : arr) {
                    int num = Integer.valueOf(cut);
                    if (num < 0) {
                        throw new IllegalArgumentException("negative value");
                    }
                    sum += num;
                }
                System.out.println("결과 : " + sum);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력 : " + e.getMessage());
            throw e;
        }
    }
}
