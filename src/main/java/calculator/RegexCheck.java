package calculator;

public abstract class RegexCheck {
  protected String sort = ",:";
  protected String regex = "^([1-9][0-9]*[" + sort + "]|[" + sort + "][1-9][0-9]*)+$";
  private static final String SORT = "^//[^0-9\\\\n]\\\\n([^\\\\n]+)$";
  private  String  strNumber;
  private  String strSort;
  private  String  input;

  RegexCheck(String input){
    this.input = input;
  }

  public Boolean isSort() {
//      String[] split = input.split("\\\\n");
//      strSort = split[0];
//      strNumber=split[1];
      return input.matches(SORT);
  }

  public Boolean isBasic(){
    return input.matches(regex);
  }


}
