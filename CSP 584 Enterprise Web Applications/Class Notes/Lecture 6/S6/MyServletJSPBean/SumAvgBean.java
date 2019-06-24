package MyServletJSPBean;
        
public class SumAvgBean {
    private int sum;
    private double avg;
    private String bad;
    private String values;

    public void setBad(String bad) {this.bad = bad;}
    public String getBad() {return bad;}

    public void setValues(String values) {
      this.values = values;
    }
    public String getValues() {return values;}

    public void setSum(int sum) {this.sum = sum;}
    public int getSum() {return sum;}

    public void setAvg(double avg) {this.avg = avg;}
    public double getAvg() {return avg;}
}
