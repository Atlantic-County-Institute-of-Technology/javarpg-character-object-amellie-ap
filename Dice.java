// Dice.java
// @author: A_Ariz
// last update: 2.5.2026

// Java imports.
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

// Our dice class that handles the rolling and all functions of the dices.
class dice {

    //Instance variables is declared.
    private ArrayList<die> dice;

    //Instance variable is declared and creates an empty collection for the dice.
    public dice() {
        this.dice = new ArrayList<>(); }

    // Adds dices in the array as long as the face is more than one.
    public void add_die(int faces) {
        if(faces > 0)
            dice.add(new die(faces)); }

    // Adds as many dice as they are stated and their faces.
    public void add_die(int value, int faces) {
        for(int i = 0; i < value; i++)
            add_die(faces);}

    // Rolls a specific die at a given index.
    public int roll_die(int index) {
        return dice.get(index).roll();}

    //Rolls all dice present in the array.
    public int roll_all() {
        int quantity = dice.size();
        int sum = 0;
        for(int i= 0; i < quantity; i++) {
            sum += dice.get(i).roll(); }
        return sum;}

    // Returns a sum of all the values of all the dice within the array.
    public int getAllValues() {
        int quantity = dice.size();
        int sum = 0;
        for(int i= 0; i < quantity; i++) {
            sum += dice.get(i).getValue(); }
        return sum;}

    // Returns the value of the dice roll at a given index.
    public int getDieValue(int index) {
        return dice.get(index).getValue();}

    // Returns the size of the dice array.
    public int size() {
        return dice.size();}

    // Clears the dice array.
    public void clear() {
        dice.clear();}

    // Removes the dice at a given index.
    public void removeDie(int index) {
        if(index < 0 || index >= dice.size()) {
            throw new IndexOutOfBoundsException("Invalid die index" + index);
        }
        dice.remove(index);}

    // Sorts the dice from the lowest roll.
    public void sortDie() {
        Collections.sort(dice, new Comparator<die>() {
            public int compare(die d1, die d2) {
                return Integer.compare(d1.getValue(), d2.getValue()); }
        });
    }

    // The die object class used by our dice.
    public static class die implements DieInterface {
        private int value;
        private int faces;
        Random random = new Random();


//Methods that return multiple values such as the faces of the die and their value.
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
