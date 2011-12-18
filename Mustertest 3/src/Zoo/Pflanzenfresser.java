
public abstract class Pflanzenfresser implements Tier{
	public boolean eatsMeat() {
		return false;
	}
	
	public abstract double dailyFoodQuantity();
}
