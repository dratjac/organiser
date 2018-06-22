
public class DoubleNumb extends Numbers {
	private double value;
	
	public DoubleNumb() {
		super();
	}
	
	public void setNum() {
		value = Double.parseDouble(Calculator.textField.getText());
	}
	
	public double getNum() {
		return value;
	}

}
