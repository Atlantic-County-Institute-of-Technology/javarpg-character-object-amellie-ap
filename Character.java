// Character.java
// @author: A_Ariz
// last update: 2.5.2026



// Hash map import that allows me to match a specific character class to their overarching one.
import java.util.HashMap;

// Class that handles our Character and their stats.
public class Character {

    // Our string that contained some specific roles within the characters class. Using Sean's template as they -
    // encouraged me to expand my classes.
    private final String[] magicList = {"Wizard", "Sorcerer", "Warlock", "Druid", "Paladin", "Cleric", "Bard", "Magic"};
    private final String[] rangedList = {"Ranger", "Archer", "Gunslinger", "Rouge", "Thief", "Ranged"};
    private final String[] meleeList = {"Barbarian", "Monk", "Fighter", "Monster Hunter", "Meele"};


    // Arrays that have placeholders for both the stats and attributes bonus which get overridden in later methods.
    public int[] attributes = {0, 0, 0, 0, 0, 0};
    public int[] attributes_bonus = {0, 0, 0, 0, 0, 0};
    // String that contains the names for the stats.
    public String[] statNames = {"STR", "DEX", "INT", "CON", "WIS", "CHA"};

    // Declares values that will be utilized and returned.
    public int hitPoints;
    public int armorClass;
    public int level;
    public String charClass;
    private String character_name;

    // Creates the Hashmap named characterMatcher.
    public HashMap<String, String> characterMatcher;

    // Creates our dice object
    dice dice = new dice();

    // Method that returns stats in a string but does not get used in this context as I have a toString that
    // returns stats in a certain format.
    public void getStats() {
        String givenStats = "";
        for (int i = 0; i <= 5; i++) {
            givenStats += statNames[i] + ": " + attributes[i] + "(+" + attributes_bonus[i] + ")\n";}
        System.out.println(givenStats); }

    // Method that rolls stats by first clearing the dice array, rolling four six-faced die, sorting them,
    //dropping the lowest one, and adding the value of the dice together.
    public int rollStat() {
        dice.clear();
        dice.add_die(4,6);
        dice.roll_all();
        dice.sortDie();
        dice.removeDie(0);
        return dice.getAllValues();}

    // Returns the ability modifier by running ability score through the math function.
    public int getAbilityModifier(int abilityScore) {
        return ((abilityScore - 10)/2);}

    // Gets the ability primary modifier by matching the overarching class to their responding attribute. This is done-
    // by a switch statement.
    private int getPrimaryAbilityModifier() {
        return switch(charClass) {
            case "Magic" -> getAbilityModifier(attributes[2]);
            case "Ranged" -> getAbilityModifier(attributes[1]);
            case "Melee" -> getAbilityModifier(attributes[0]);
            default -> 0; };}

    //Returns the HP by adding the CON value to the number 20.
    public int calculateBaseHitPoints() {
        return hitPoints = (20 + attributes[3]);}

    // Returns the armor class by obtaining the number from getPrimaryAbilityModifier and adding it to 10.
    public int calculateArmorClass() {
        return armorClass = (10 + getPrimaryAbilityModifier());}

    // Method that rolls the attributes, obtains the attributes bonus for each, and assigns the hitpoints and -
    // armorclass for them to be returned with their respective methods.
    public void rollStats() {
        for (int i = 0; i <= 5; i++) {
            attributes[i] = rollStat();}

        for (int i = 0; i<= 5; i++) {
            attributes_bonus[i] = getAbilityModifier(attributes[i]);}
        hitPoints = calculateBaseHitPoints();
        armorClass = calculateArmorClass(); }


    //Uses the hashmap in order to find the specific category of a class and match it to their overarching class.
    public void createCharacter(String character_Name, String character_Class) {
        character_name = character_Name;
        characterMatcher = new HashMap<>();

        for (int i =0; i<8; i++) {
            characterMatcher.put(magicList[i].toLowerCase(), "Magic"); }

        for (int i =0; i<6; i++) {
            characterMatcher.put(rangedList[i].toLowerCase(), "Ranged"); }

        for (int i =0; i<5; i++) {
            characterMatcher.put(meleeList[i].toLowerCase(), "Melee");}

        charClass = characterMatcher.get(character_Class.toLowerCase());}

    // To String that returns the character's name, LVL, character class, HP, and AC. Does this by adding up to
    // the empty string. Returns it in the format given by the assignment.
    public String toString () {
        String characterInfo = "Character: ";
        characterInfo += getcharacter_Name() + " " + "(Level " + getLevel() + " " + getCharClass() + ")\n" +
                "HP: " + getHitPoints() + " | " + "AC: " + getArmorClass() + "\n";

        for (int i = 0; i <= 2; i++) {
            characterInfo += statNames[i] + ": " + attributes[i] + "(+" + attributes_bonus[i] + ")" ;
            if (i != 2) characterInfo += " | ";}

        characterInfo += "\n";

        for (int i = 3; i <= 5; i++) {
            characterInfo += statNames[i] + ": " + attributes[i] + "(+" + attributes_bonus[i] + ")" ;
            if (i != 5) characterInfo += " | ";}

        return characterInfo; }


    // Methods that return the character name, class, level, armor class, and hit points.
    public String getcharacter_Name() {
        return character_name; }

    public String getCharClass() {
        return charClass;}

    public int getLevel() {
        return level;}

    public int getArmorClass() {
        return armorClass;}

    public int getHitPoints() {
        return hitPoints;}

}
