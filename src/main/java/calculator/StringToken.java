package calculator;

import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public record StringToken(String startToken, String endToken) {
    public String removeToken(String givenInput){
        String removedString = givenInput;

        for (MatchResult matchResult: regexMatch(givenInput)){
            String tokenDeclaration = matchResult.group(0);
            removedString = removedString.replace(tokenDeclaration,"");
        }

        return removedString;
    }

    public List<MatchResult> regexMatch(String given){
        Pattern regexPattern = Pattern.compile(getTokenRegex());
        Matcher regexMatcher = regexPattern.matcher(given);

        return regexMatcher.results().toList();
    }

    public String getTokenRegex(){
        return String.format("%s(.*?)%s",this.startToken,this.endToken);
    }
}
