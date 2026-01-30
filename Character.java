import java.util.HashMap;

public class Character {

    private final String[] magicList = {"Wizard", "Sorcerer", "Warlock", "Druid", "Paladin", "Cleric", "Bard", "Magic"};
    private final String[] rangedList = {"Ranger", "Archer", "Gunslinger", "Rouge", "Thief", "Ranged"};
    private final String[] meleeList = {"Barbarian", "Monk", "Fighter", "Monster Hunter", "Meele"};


    public int[] attributes = {1, 2, 3, 4, 5, 7};
    public int[] attributes_bonus = {1, 3, 4, 5, 6, 9};
    public String[] statNames = {"STR", "DEX", "INT", "CON", "WIS", "CHA"};


    public int hitPoints;
    public int armorClass;
    public int level;


    public String charClass;

    public HashMap<String, String> characterMatcher;

    dice dice = new dice();
    private String character_name;


    public void getStats() {
        String givenStats = "";
        for (int i = 0; i <= 5; i++) {
            givenStats += statNames[i] + ": " + attributes[i] + "(+" + attributes_bonus[i] + ")\n";
        }
        System.out.println(givenStats);
    }

    public void createCharacter(String character_Name, String character_Class) {
        character_name = character_Name;
        characterMatcher = new HashMap<>();

        for (int i =0; i<8; i++) {
            characterMatcher.put(magicList[i].toLowerCase(), "Magic");
        }
        for (int i =0; i<6; i++) {
            characterMatcher.put(rangedList[i].toLowerCase(), "Ranged");
        }
        for (int i =0; i<5; i++) {
            characterMatcher.put(meleeList[i].toLowerCase(), "Melee");
        }
        charClass = characterMatcher.get(character_Class.toLowerCase());

        System.out.println(charClass);

    }

    
    
    public String getcharacter_Name() {return character_name; }
    
    public String getCharClass() {
        return charClass;
    }

    public int getLevel() {
        return level;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public int getHitPoints() {
        return hitPoints;
    }



}



