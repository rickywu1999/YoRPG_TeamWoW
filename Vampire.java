/*=============================================
  class Vampire
  =============================================*/
 
public class Vampire extends Character {

    // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~
    private String _name = "J. Doe";
    private double lifesteal;
    // other attribs inherited from superclass
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    /*=============================================
      default constructor
      pre:  instance vars are declared
      post: initializes instance vars.
      =============================================*/
    public Vampire() {
	_hitPts = 130;
	_strength = 100;
	_defense = 30;
	_attack = .6;
	lifesteal = .25;
    }


    /*=============================================
      overloaded constructor
      pre:  instance vars are declared
      post: initializes instance vars. _name is set to input String.
      =============================================*/
    public Vampire( String name ) {
	this();
	_name = name;
    }


    // ~~~~~~~~~~~~~~ ACCESSORS ~~~~~~~~~~~~~~~~~
    public String getName() { return _name; }
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //prepare a Vampire for a special attack
    public void specialize2(){
	_attack = 1.2;
	lifesteal = .04;
    }
    
    //prepare a Vampire for a special attack
    public void specialize() {
	_attack = .4;
	lifesteal = .8;
    }

    //revert to normal mode
    public void normalize() {
	_attack = .6;
	lifesteal = .25;
        
    }

    public String moveSet(){
	String s = "";
	s += "\t1: Bite\n\t2: Transfusion \n\t3: Bloodlust\n";
	return s;
    }

    public int attack( Character opponent ) {

	int damage = (int)( (_strength * _attack) - opponent.getDefense() );
	//System.out.println( "\t\t**DIAG** damage: " + damage );

	if ( damage < 0 )
	    damage = 0;

	opponent.lowerHP( damage );
	_hitPts += lifesteal * damage;
	System.out.println(_name + " has healed for " + (lifesteal * damage) + " health!");

	return damage;
    }
	
    public String about(){
	String s = "";
	s += "VAMPIRE: \n";
	s += "Hungry for fresh blood, the vampire is constantly on the prowl for new monsters to take on. With insane regeneration abilities, the vampire can dish out damage while sustaining himself.\n";
	s += "\tMove Set: Bite || Transfusion || Bloodlust\n\n";
	return s;
    }

}//end class Vampire
