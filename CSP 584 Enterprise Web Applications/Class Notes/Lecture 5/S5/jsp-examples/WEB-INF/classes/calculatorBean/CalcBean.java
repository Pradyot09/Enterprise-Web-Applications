package calculatorBean;

public class CalcBean implements java.io.Serializable {
  private int value1;
  private int value2;

  public void setValue1(int value1) {
    this.value1 = value1;
  }

  public void setValue2(int value2) {
    this.value2 = value2;
  }

  public int getSum() {
    return value1 + value2;
  }
}
