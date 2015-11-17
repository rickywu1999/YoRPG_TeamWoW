/*=============================================
  class Mage 
  =============================================*/
 
public class Mage extends Character {

    // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~
    private String _name = "J. Doe";
    private int mana;
    private int burn;
    // other attribs inherited from superclass
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    /*=============================================
      default constructor
      pre:  instance vars are declared
      post: initializes instance vars.
      =============================================*/
    public Mage() {
	_hitPts = 150;
	_strength = 150;
	_defense = 20;
	_attack = .6;
	mana = 100;
    }


    /*=============================================
      overloaded constructor
      pre:  instance vars are declared
      post: initializes instance vars. _name is set to input String.
      =============================================*/
    public Mage( String name ) {
	this();
	_name = name;
    }


    // ~~~~~~~~~~~~~~ ACCESSORS ~~~~~~~~~~~~~~~~~
    public String getName() { return _name; }
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //prepare a Mage for a special attack
    public void specialize2(){
	mana = 100;
	_attack = 0;
	System.out.println("\nMana Left: " + mana);
    }
    
    //prepare a Mage for a special attack
    public void specialize() {
	if (mana >= 25){
	    _attack = .8;
	    mana -= 25;
	    burn = 2;
	}
	else {
	    _attack = 0;
	}
	System.out.println("\nMana Left: " + mana);
    }

    //revert to normal mode
    public void normalize() {
	if (mana >= 10){
	    _attack = .6;
	    mana -= 10;
	}
	else {
	    _attack = 0;
	}
	System.out.println("\nMana Left: " + mana);
    }

    public String moveSet(){
	String s = "";
	s += "\t1: Mana Blast\n\t2: Fireball \n\t3: Mana Regeneration\n";
	return s;
    }

    public int attack( Character opponent ) {

	int damage = (int)( (_strength * _attack) - opponent.getDefense() );
	//System.out.println( "\t\t**DIAG** damage: " + damage );

	if ( damage < 0 )
	    damage = 0;

	opponent.lowerHP( damage );
	
	if ( burn > 0 ){
	    burn -= 1;
	    System.out.println("Enemy has been burned for 20 Damage! Burn will last " + burn + " more turns!");
	    opponent.lowerHP( 20 );
	}

	if (!(opponent.isAlive())){
	    burn = 0;
	}
	
	return damage;
    }//end attack
 
    public String about(){
	String s = "";
	s += "MAGE: \n";
	s += "A connoisseur of the ancient arts and having years of experience studying modern magic, the mage wishes to study the new foes that appear before him in order to forward his knowledge.\n";
	s += "\tMove Set: Mana Blast || Fireball || Mana Regeneration\n\n";
	return s;
    }

}//end class Mage
