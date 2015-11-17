/*=============================================
  class Character -- superclass for combatants in Ye Olde RPG
  =============================================*/

public abstract class Character {

    // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~
    protected int _hitPts;
    protected int _strength;
    protected int _defense;
    protected double _attack;
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    /*=============================================
      default constructor
      pre:  instance vars are declared
      post: initializes instance vars.
      =============================================*/
    public Character() {
	_hitPts = 125;
	_strength = 100;
	_defense = 40;
	_attack = .4;
    }


    // ~~~~~~~~~~~~~~ ACCESSORS ~~~~~~~~~~~~~~~~~
    public int getDefense() { return _defense; }
    public int getHealth() {
	if (_hitPts < 0){
	    return 0;
	}
	return _hitPts;
    }
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  
    /*=============================================
      boolean isAlive() -- tell whether I am alive
      post: returns boolean indicated alive or dead
      =============================================*/
    public boolean isAlive() {
	return _hitPts > 0;
    }


    /*=============================================
      int attack(Character) -- simulates attack on a Monster
      pre:  Input not null
      post: Calculates damage to be inflicted, flooring at 0. 
      Calls opponent's lowerHP() method to inflict damage. 
      Returns damage dealt.
      =============================================*/
    public int attack( Character opponent ) {

	int damage = (int)( (_strength * _attack) - opponent.getDefense() );
	//System.out.println( "\t\t**DIAG** damage: " + damage );

	if ( damage < 0 )
	    damage = 0;
	opponent.lowerHP( damage );

	return damage;
    }//end attack


    /*=============================================
      void lowerHP(int) -- lowers life by input value
      pre:  Input >= 0
      post: Life instance var is lowered by input ammount.
      =============================================*/
    public void lowerHP( int damageInflicted ) {
	_hitPts = _hitPts - damageInflicted;
    }

    public abstract void specialize2();
    
    public abstract void specialize();

    public abstract void normalize();

    public abstract String moveSet();

    public String getName(){
	return "Donald Trump";
    }
    
    public String about() {
	String s = "";
	s += "WARRIOR: \n";
	s += "A renowned fighter whose courage is unquestioned and his might undisputed. He indefatigably fights against the forces of evil and happens to be around and up for slime fighting.\n";
	s += "\tMove Set: Sword Swing || Assault || Parry\n\n";

	s += "MAGE: \n";
	s += "A connoisseur of the ancient arts and having years of experience studying modern magic, the mage wishes to study the new foes that appear before him in order to forward his knowledge.\n";
	s += "\tMove Set: Mana Blast || Fireball || Mana Regeneration\n\n";

	s += "ROGUE: \n";
	s += "Born in a poor village, the rogue used wit and deceit in order to survive. In order to make a living, the rogue fights monsters and reaps the gold that they drop.\n";
	s += "\tMove Set: Knife Cut || Assasinate || Evade\n\n";

	s += "VAMPIRE: \n";
	s += "Hungry for fresh blood, the vampire is constantly on the prowl for new monsters to take on. With insane regeneration abilities, the vampire can dish out damage while sustaining himself.\n";
	s += "\tMove Set: Bite || Transfusion || Bloodlust\n\n";

	s += "BERSERKER: \n";
	s += "Unafraid of death, the berserker lives for the thrill of battle. Motivated by the possiblity of glory, he fights every battle with reckless abandon.\n";
	s += "\tMove Set: Smashing Blow || Reckless Swing || Conquer\n\n";
	return s;
    }
}//end class Character
