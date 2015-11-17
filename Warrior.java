/*=============================================
  class Warrior -- protagonist of Ye Olde RPG
  =============================================*/
 
public class Warrior extends Character {

    // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~
    private String _name = "J. Doe";
    // other attribs inherited from superclass
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    /*=============================================
      default constructor
      pre:  instance vars are declared
      post: initializes instance vars.
      =============================================*/
    public Warrior() {
	_hitPts = 170;
	_strength = 100;
	_defense = 40;
	_attack = .4;
    }


    /*=============================================
      overloaded constructor
      pre:  instance vars are declared
      post: initializes instance vars. _name is set to input String.
      =============================================*/
    public Warrior( String name ) {
	this();
	_name = name;
    }


    // ~~~~~~~~~~~~~~ ACCESSORS ~~~~~~~~~~~~~~~~~
    public String getName() { return _name; }
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //prepare a Warrior for a special attack
    public void specialize2(){
	_attack = .25;
	_defense = 60;
    }
    
    //prepare a Warrior for a special attack
    public void specialize() {
	_attack = .75;
	_defense = 20;
    }

    //revert to normal mode
    public void normalize() {
	_attack = .4;
	_defense = 40;
    }

    public String moveSet(){
	String s = "";
	s += "\t1: Sword Swing\n\t2: Assault\n\t3: Parry\n";
	return s;
    }

    public String about(){
	String s = "";
	s += "WARRIOR: \n";
	s += "A renowned fighter whose courage is unquestioned and his might undisputed. He indefatigably fights against the forces of evil and happens to be around and up for slime fighting.\n";
	s += "\tMove Set: Sword Swing || Assault || Parry\n\n";
	return s;
    }

}//end class Warrior
