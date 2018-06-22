
public class DoubleNumb extends Numbers {
	
	public DoubleNumb(String num) {
		super(num);
	}
	
	public void Parse() {
		value = Double.parseDouble(number);
	}
}
