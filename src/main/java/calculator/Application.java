package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static int sol(String S)
    {
        char[] separators = {',', ':'};
        // 아무 입력 받지 못한 경우에 0을 반환
        if(S==null||S.isEmpty())
            return 0;

        System.out.println(S.charAt(2));
        System.out.println(S.charAt(3));

        String str = S;
        // 커스텀 구분자 확인 (구분자가 한 개만 입력된다는 가정)
        if(S.startsWith("//"))
        {
            char customSeparators = S.charAt(3);
            if(S.charAt(4)=='\n')
            {
                str=S.substring(4);
                // 구분자가 두 개 일 경우를 위해 추후 수정 가능하게 코드를 짬
                char[] temp = new char[separators.length+1];
                System.arraycopy(separators, 0, temp, 0, separators.length);
                temp[separators.length]=customSeparators;
                separators=temp;
            }
            else
            {
                throw new IllegalArgumentException();
            }
            
        }

        



        return -1;
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        System.out.println(input);
        System.out.println(sol(input));
    }
}
