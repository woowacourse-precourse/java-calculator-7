package calculator;

import java.util.List;

public class InputGuidelines {
    private final String TITLE = "--------------------------[문자열 덧셈 계산기]----------------------------";
    private final String DEFAULT_SEPARATOR_OPTION = "기본 구분자는 아래와 같습니다.";
    private final String CUSTOM_SEPARATOR_STRATEGY = "커스텀 구분자는 문자열 앞부분의 \"//\"와 \"\\n\" 사이에 구분자를 작성하여 만들 수 있습니다.";
    private final String END = "---------------------------------------------------------------------";
    private final String INPUT = "계산할 문자열을 입력해주세요.";


    private final List<String> defaultSeparator;


    public InputGuidelines(List<String> defaultSeparator) {
        this.defaultSeparator = defaultSeparator;
    }


    private String joinWithDefaultSeparator(){
        StringBuilder defaultSeparatorAsString = new StringBuilder();

        for (int i = 0; i < defaultSeparator.size(); i++) {
            if(i<defaultSeparator.size()-1){
                defaultSeparatorAsString.append("( ").append(defaultSeparator.get(i)).append(" ),");
            }else {
                defaultSeparatorAsString.append("( ").append(defaultSeparator.get(i)).append(" )");
            }
        }
        return defaultSeparatorAsString.toString();
    }

    public String getJoinWithDefaultSeparator(){
        return this.joinWithDefaultSeparator();
    }

    public void printInputGuidelines(){
        System.out.println(TITLE);
        System.out.println(DEFAULT_SEPARATOR_OPTION);
        System.out.println("기본 구분자 개수= "+ defaultSeparator.size() +
                " => " + this.joinWithDefaultSeparator());
        System.out.println(CUSTOM_SEPARATOR_STRATEGY);
        System.out.println(END);
        System.out.println(INPUT);
    }
}
