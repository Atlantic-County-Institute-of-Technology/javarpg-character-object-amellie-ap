// Main.java
// @author: A_Ariz
// last update: 2.5.2026
 
//Our public class. 
public class Main {
    public static void main(String[] args) {
        //Creates new Character object under the name "Chara"
        Character Chara = new Character();
        //Creates new character and assigns the character class as wizard. 
        Chara.createCharacter("John Java", "wizard");
        //Rolls the character's stats by calling rollStats. 
        Chara.rollStats();
        System.out.println(Chara);

    }
}
