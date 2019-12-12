package updatePurse;

public class updatePurse 
{ 
	// Constructor Declaration of Class 
	public int updatePurse(int wheelVal, int oldPurse, String player) {
		int Moneez;
		if (wheelVal == 0){
		Moneez = 0;
		}
	
		Moneez = oldPurse + wheelVal;
		System.out.println(player+"'s Purse: $"+Moneez);
		return Moneez;
		}
}