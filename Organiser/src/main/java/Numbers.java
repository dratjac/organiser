
public class Numbers {
	
	protected String number;
	protected double value;
	
	public Numbers(String num) {
		this.number = num;
	}
	
	public void Empty() {
		this.number = "";
	}
	
	public void Add(String num) {
		this.number += num;
	}
	
	public void Parse() {
	}
	
	public void setDNumber(double num) {	
	}
	
	public double getNumD() {
		return this.value;
	}
	
	public void setStrNumber(String num) {
		if(num.charAt(num.length()-1) == '.') {
			num = num.substring(0, num.length()-1);
		}
		this.number = num;
	}
}
