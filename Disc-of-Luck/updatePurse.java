package updatePurse;

public class updatePurse 
{ 
	// Constructor Declaration of Class 
	public int updatePurse(int wheelVal, int oldPurse, String player) {
		int Money;
		if (wheelVal == 0){
		Money = 0;
		}
	
		Money = oldPurse + wheelVal;
		System.out.println(player+"'s Purse: $"+Money);
		return Money;
		}
}
