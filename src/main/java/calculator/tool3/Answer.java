package calculator.tool3;

public class Answer {

  private int[] nums;

  public long calSum() {
    long sum = 0;
    for (int num : this.nums) {
      sum += num;
    }
    return sum;
  }

  public void printAns() {
    System.out.println("결과 : " + this.calSum());
  }

  public Answer(int[] nums) {
    this.nums = nums;
  }

}
