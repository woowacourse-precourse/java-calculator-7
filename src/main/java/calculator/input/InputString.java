package calculator.input;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputString {

    public String input(){ //문자열 입력받기
        String st = readLine();
        return st;
    }

    public List<String> findSeparator(String st){ //커스텀 구분자 추출
        List<String> separators = new ArrayList<>();
        separators.add(",");
        separators.add(":");

        if(st.indexOf("//")==0){
            Integer idx = st.indexOf("\\n");
            if(idx!=-1) separators.add(st.substring(2, idx-1));
        }

        return separators;
    }

}
