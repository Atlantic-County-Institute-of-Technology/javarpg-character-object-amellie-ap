public class Main {
    public static void main(String[] args) {
        Character evil = new Character();
        evil.createCharacter("evilness", "wizard");
        System.out.println(evil.getcharacter_Name());
        evil.rollStats();
        evil.getStats();


    }
}
