package calculator;

import java.util.NoSuchElementException;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static int sol(String S)
    {
        String separators = ",|:";
        // 아무 입력 받지 못한 경우에 0을 반환
        if(S==null||S.isEmpty())
            return 0;

        
        if(S.startsWith("//"))
        {
            int customIndex = S.indexOf("\\n");
            if(customIndex!=-1)
            {
                String customSeparators = S.substring(2,customIndex);
                separators+="|"+customSeparators;
                S=S.substring(customIndex+2);
            }
            else
            {
                throw new IllegalArgumentException();
            }
        }

        String[] number = S.split(separators);
        
        int total = 0;

        for (String i : number)
        {
            int num=notNumber(i);
            isMinus(num);
            total += num;
        }
                
        return total;
    }
    public static int notNumber(String str)
    {
        try
        {
            return Integer.parseInt(str);
        }
        catch(NumberFormatException e)
        {
            throw new IllegalArgumentException();
        }
    }
    public static void isMinus(int num)
    {
        if(num<0)
            throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        
        String input="";
        try
        {
            input = Console.readLine();
        }
        catch(NoSuchElementException e)
        {
            input="";
        }
        
  
        System.out.println("결과 : "+sol(input));
        
    }
}
