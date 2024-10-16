package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private final SeparationProcessor separationProcessor;
    private final Pattern customSeparationCmdPattern;
    private final int customSeparationIdx;

    public Calculator (){
        this.separationProcessor = new SeparationProcessor(',', ':');
        this.customSeparationCmdPattern = Pattern.compile("^(\\/\\/.\\\\n)");
        this.customSeparationIdx = 2;
    }

    public int sum(String cmd){
        if(cmd.isEmpty()){
            return 0;
        }

        Matcher matcher = customSeparationCmdPattern.matcher(cmd);
        boolean containsCustomSeparationCmd = matcher.find();
        if(containsCustomSeparationCmd){
            registerCustomSeparation(matcher);

            // 구분자 등록에 사용됐던 명령어 제거
            cmd = cmd.replace(matcher.group(), "");
        }

        int result = 0;
        String[] rawNumbers = separationProcessor.split(cmd);
        for(String rawNum : rawNumbers){
            result += Integer.parseInt(rawNum);
        }

        return result;
    }

    private void registerCustomSeparation(Matcher matcher){
        Character customSeparation = matcher.group().charAt(customSeparationIdx);
        separationProcessor.addSeparation(customSeparation);
    }
}
