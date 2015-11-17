public class Berserker extends Character{ 
  // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~
    private String _name = "J. Doe";
    // other attribs inherited from superclass
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    /*=============================================
      default constructor
      pre:  instance vars are declared
      post: initializes instance vars.
      =============================================*/
    public Berserker() {
	_hitPts = 150;
	_strength = 100;
	_defense = 10;
	_attack = .6;
    }


    /*=============================================
      overloaded constructor
      pre:  instance vars are declared
      post: initializes instance vars. _name is set to input String.
      =============================================*/
    public Berserker( String name ) {
	this();
	_name = name;
    }


    // ~~~~~~~~~~~~~~ ACCESSORS ~~~~~~~~~~~~~~~~~
    public String getName() { return _name; }
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //prepare a Berserker for a special attack
    public void specialize2(){
	_attack = _attack + .5; 
	_defense = _defense + 1;
    }
    
    //prepare a Berserker for a special attack
    public void specialize() {
	_attack = 3.0; 
	_hitPts = _hitPts - 5;
	System.out.println(_name + "has inflicted 5 damage on himself!\n");
    }

    //revert to normal mode
    public void normalize() {
	_attack = .8;
    }

    public String moveSet(){
	String s = "";
	s += "\t1: Smashing Blow\n\t2: Reckless Swing \n\t3: Conquer\n";
	return s;
    }
    public int attack( Character opponent ) {

	int damage = (int)( (_strength * _attack) - opponent.getDefense() );
	//System.out.println( "\t\t**DIAG** damage: " + damage );

	if ( damage < 0 )
	    damage = 0;
	opponent.lowerHP( damage );
	if (!(opponent.isAlive())){
	    _strength += 10;
	    System.out.println(_name +"'s strength has increased by 10!");
	}

	return damage;
    }//end attack

    public String about(){
	String s = "";
	s += "BERSERKER: \n";
	s += "Unafraid of death, the berserker lives for the thrill of battle. Motivated by the possiblity of glory, he fights every battle with reckless abandon.\n";
	s += "\tMove Set: Smashing Blow || Reckless Swing || Conquer\n\n";
	return s;
    }

}//end class Berserker


