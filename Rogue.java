/*=============================================
  class Rogue
  =============================================*/
 
public class Rogue extends Character {

    // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~
    private String _name = "J. Doe";
    private double dodge;
    // other attribs inherited from superclass
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    /*=============================================
      default constructor
      pre:  instance vars are declared
      post: initializes instance vars.
      =============================================*/
    public Rogue() {
	_hitPts = 120;
	_strength = 150;
	_defense = 0;
	_attack = .6;
	dodge = .5;
    }


    /*=============================================
      overloaded constructor
      pre:  instance vars are declared
      post: initializes instance vars. _name is set to input String.
      =============================================*/
    public Rogue( String name ) {
	this();
	_name = name;
    }


    // ~~~~~~~~~~~~~~ ACCESSORS ~~~~~~~~~~~~~~~~~
    public String getName() { return _name; }
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //prepare a Rogue for a special attack
    public void specialize2(){
	dodge = .8;
	_attack = .4;
    }
    
    //prepare a Rogue for a special attack
    public void specialize() {
	_attack = 1.2;
	dodge = 0;
    }

    //revert to normal mode
    public void normalize() {
	_attack = .6;
	dodge = .3;
    }

    public String moveSet(){
	String s = "";
	s += "\t1: Knife Cut\n\t2: Assasinate \n\t3: Evade\n";
	return s;
    }

    public void lowerHP( int damageInflicted ) {
	if (Math.random() > dodge){
	    _hitPts = _hitPts - damageInflicted;
	}
	else {
	    System.out.println(_name + " has successfully dodged thy enemy's attack!");
	}
    }
	
    public String about(){
	String s = "";
	s += "ROGUE: \n";
	s += "Born in a poor village, the rogue used wit and deceit in order to survive. In order to make a living, the rogue fights monsters and reaps the gold that they drop.\n";
	s += "\tMove Set: Knife Cut || Assasinate || Evade\n\n";
	return s;
    }

}//end class Rogue
