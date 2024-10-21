package calculator.domain;

public class CaculatorModel {

  public String input;

  public CaculatorModel(String input) {
    this.input = input;
  }


  public int sum(){
    if (input.isBlank()){
      return 0;
    }



    // 임시
    return 0;
  }
}
