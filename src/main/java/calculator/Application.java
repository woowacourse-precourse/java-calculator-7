package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static int sol(String S)
    {
        String[] separators = {",", ":"};
        // 아무 입력 받지 못한 경우에 0을 반환
        if(S==null||S.isEmpty())
            return 0;

        String str = S;
        // 커스텀 구분자 확인 (구분자가 한 개만 입력된다는 가정)
        if(S.startsWith("//"))
        {
            char customSeparators = S.charAt(2);
            
            str=S.substring(5);
            // 구분자가 두 개 일 경우를 위해 추후 수정 가능하게 코드를 짬
            String[] temp = new String[separators.length+1];
            System.arraycopy(separators, 0, temp, 0, separators.length);
            temp[separators.length]=String.valueOf(customSeparators);
            separators=temp;
            
        }

        String Pattern = String.join("|", separators);
        String[] number = str.split(Pattern);

        for (String num : number)
            if (num.isEmpty() || num.startsWith("-"))
                throw new IllegalArgumentException();


        int total = 0;
        try 
        {
            for (String i : number) 
                if (!i.isEmpty()) 
                    total += Integer.parseInt(i);
        }
        catch (NumberFormatException e) 
        {
            throw new IllegalArgumentException();
        }

        return total;
    }
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        try 
        {
            System.out.println(sol(input));
        } 
        catch (IllegalArgumentException e) 
        {
            System.out.println(e.getMessage());
        }
    }
}
