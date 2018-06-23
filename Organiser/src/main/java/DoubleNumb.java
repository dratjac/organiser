
public class DoubleNumb extends Numbers {
	
	public DoubleNumb(String num) {
		super(num);
	}
	
	public void Parse() {
		value = Double.parseDouble(number);
		System.out.println("Parsing " + number + "\n Parsed: "+value);
	}
	
	public void setDnumber(double num) {
		value = num;
	}
}
