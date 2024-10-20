package calculator.domain;

public class SeperatorFactory {
    private static final String SPLITOR="|";
    private static final String ESCAPE_CHAR="\\";

    private static String seperatorRegex=",|:";

    public static void addRegex(String customSeperator) {
        StringBuilder regexBuilder=new StringBuilder();
        //커스텀 구분자가 | 이라면 이스케이프문자를 추가해햐 한다
        if (customSeperator.equals(SPLITOR)){
            customSeperator=addEscapeChar(customSeperator);
        }

        regexBuilder.append(seperatorRegex)
                .append(SPLITOR)
                .append(customSeperator);

        seperatorRegex=regexBuilder.toString();
    }

    private static String addEscapeChar(String customSeperator){
        StringBuilder seperatorBuilder=new StringBuilder();

        seperatorBuilder.append(ESCAPE_CHAR)
                .append(customSeperator);

        return customSeperator.toString();
    }

    public static String getSeperatorRegex(){
        return seperatorRegex;
    }
}
