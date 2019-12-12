package wofPlayer;

public class wofPlayer 
{ 
    // Instance Variables 
    String name; 
    int purse; 
  
  
    // Constructor Declaration of Class 
    public wofPlayer(String name, 
                   int purse) 
    { 
        this.name = name; 
        this.purse = purse; 
       
    } 
  
    // method 1 
    public String getName() 
    { 
        return name; 
    } 
  

    // method 2 
    public int getPurse() 
    { 
        return purse; 
    } 
 
  
    @Override
    public String toString() 
    { 
        return("Hi my name is "+ this.getName()+ 
               ".\nMy purse value is $" +  this.getPurse()+
        		"\nAnd I want to win!"); 
    } 
  
    public static void main(String[] args) 
    { 
    	wofPlayer player = new wofPlayer("Generic Name", 0); 
        System.out.println(player.toString()); 
    } 
}
