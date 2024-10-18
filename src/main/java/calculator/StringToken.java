package calculator;

import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class StringToken {
    private String startToken;
    private String endToken;

    public StringToken(String startToken, String endToken){
        this.startToken = startToken;
        this.endToken = endToken;
    }

    public String removeTokenDeclaration(String givenInput){
        String removedString = givenInput;

        for (MatchResult matchResult: regexMatch(givenInput)){
            String tokenDeclaration = matchResult.group(0);
            removedString = removedString.replace(tokenDeclaration,"");
        }

        return removedString;
    }

    public List<MatchResult> regexMatch(String given){
        Pattern regexPattern = Pattern.compile(getTokenDeclarationRegex());
        Matcher regexMatcher = regexPattern.matcher(given);

        return regexMatcher.results().toList();
    }

    public String getTokenDeclarationRegex(){
        return String.format("%s(.*?)%s",this.startToken,this.endToken);
    }

    public String getTokenValue(String tokenDeclaration){
        return tokenDeclaration.replace(startToken,"").replace(endToken,"");
    }
}
