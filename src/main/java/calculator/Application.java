package calculator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Calculator calculator = new Calculator();
        calculator.run();

        /*System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = Console.readLine();
        */

        // 특수문자
        // //~\n1:2,3~4
        // //!\n1:2,3!4
        // //@\n1:2,3@4
        // //#\n1:2,3#4
        // //$\n1:2,3$4
        // //(\n1:2,3(4
        // //)\n1:2,3)4
        // ///\n1:2,3/4
        // //\\n1:2,3\4
        // //?\n1:2,3?4
        // //'\n1:2,3'4
        // //"\n1:2,3"4
        // //[\n1:2,3[4 X 처리완
        // //]\n1:2,3]4 X 처리완
        // //<\n1:2,3<4
        // //>\n1:2,3>4
        // //{\n1:2,3{4{5
        // :21 X 처리완
        // -1,2,3
        // 1:s:2 X -> 구분자 외에 문자 or 문자열을 입력한 경우 예외처리
        // 1:ss:2,3:q
        // ""인경우 0.. X
        // 문자열 길이가 1이하인 경우 X

        /*String a = "";

        // 커스텀 인 경우
        if (str.substring(0, 2).equals("//") && str.substring(3, 5).equals("\\n")) {
            a = String.valueOf(str.charAt(2));

            // \가 커스텀인 경우
            if (a.equals("\\")) {
                a = "\\\\";
            } else if (a.equals("[")) {
                a = "\\[";
            } else if (a.equals("]")) {
                a = "\\]";
            }
            *//*if (a.equals("\\")) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }*//*
            str = str.substring(5);
        }*/

       /* String basicSep = "[,:";
        String totalSep = basicSep + a + "]";
        System.out.println(totalSep);*/

/*
        int sum = 0;

        String[] t = str.split(totalSep);
        for (String s : t) {
            System.out.println(s);
            int num;
            try {
                num = Integer.valueOf(s);
            } catch (NumberFormatException e) {
                //:21 같은 경우 num이 null값이 되기 때문에 0으로
                num = 0;
            }
            if (num < 0) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
            sum += num;
        }
        System.out.println("결과 : " + sum);
*/

    }
}
