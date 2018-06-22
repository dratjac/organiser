
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
	
	public double getNumD() {
		return this.value;
	}
	
	public void setNumber(String num) {
		this.number = num;
	}
}
