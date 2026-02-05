import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;


class dice {

    //Instance variables is declared
    private ArrayList<die> dice;

    //Instance variable is declared and creates an empty collection for the dice
    public dice() {
        this.dice = new ArrayList<>();
    }

    public void add_die(int faces) {
        if(faces > 0)
            dice.add(new die(faces));
    }

    public void add_die(int value, int faces) {
        for(int i = 0; i < value; i++)
            add_die(faces);
    }

    public int roll_die(int index) {
        return dice.get(index).roll();
    }

    public int roll_all() {
        int quantity = dice.size();
        int sum = 0;
        for(int i= 0; i < quantity; i++) {
            sum += dice.get(i).roll(); }
        return sum;
    }

    public int getAllValues() {
        int quantity = dice.size();
        int sum = 0;
        for(int i= 0; i < quantity; i++) {
            sum += dice.get(i).getValue(); }
        return sum;
    }

    public int getDieValue(int index) {
        return dice.get(index).getValue();
    }

    public int size() {
        return dice.size();
    }

    public void clear() {
        dice.clear();
    }


    public void removeDie(int index) {
        if(index < 0 || index >= dice.size()) {
            throw new IndexOutOfBoundsException("Invalid die index" + index);
        }
        dice.remove(index);
    }

    public void sortDie() {
        Collections.sort(dice, new Comparator<die>() {
            public int compare(die d1, die d2) {
                return Integer.compare(d1.getValue(), d2.getValue());
            }


        });
    }

    // The die object class used by our dice
    public static class die implements DieInterface {
        private int value;
        private int faces;
        Random random = new Random();

        public die (int faces) {
            this.faces = faces;
            this.random = new Random();}

        public int roll() {
            value = random.nextInt(faces) + 1;
            return value;}

        public int getValue(){
            return value;}

        public int getFaces() {
            return faces;}



    }}
