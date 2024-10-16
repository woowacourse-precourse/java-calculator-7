package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private final SeparatorProcessor separatorProcessor;
    private final Pattern customSeparatorCmdPattern;
    private final int customSeparatorIdx;

    public Calculator (){
        this.separatorProcessor = new SeparatorProcessor(',', ':');
        this.customSeparatorCmdPattern = Pattern.compile("^(\\/\\/.\\\\n)");
        this.customSeparatorIdx = 2;
    }

    public int sum(String cmd){
        if(cmd.isEmpty()){
            return 0;
        }

        Matcher matcher = customSeparatorCmdPattern.matcher(cmd);
        boolean containsCustomSeparatorCmd = matcher.find();
        if(containsCustomSeparatorCmd){
            registerCustomSeparator(matcher);

            // 구분자 등록에 사용됐던 명령어 제거
            cmd = cmd.replace(matcher.group(), "");
        }

        int result = 0;
        String[] rawNumbers = separatorProcessor.split(cmd);
        for(String rawNum : rawNumbers){
            result += Integer.parseInt(rawNum);
        }

        return result;
    }

    private void registerCustomSeparator(Matcher matcher){
        Character customSeparator = matcher.group().charAt(customSeparatorIdx);
        separatorProcessor.addSeparator(customSeparator);
    }
}
