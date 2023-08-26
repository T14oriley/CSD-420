//CSD420 Tyler O'Riley 08/26/2023 Assignments 5
//Java program to evaluate and manipulate words read from a file

import java.util.*;
import java.io.*;

public class wordReader {
    public static void main(String[] args) throws Exception {
        	
        File file = new File("C:/Users/t14or/OneDrive/Desktop/CSD/CSD-420/Module-5/collection_of_words.txt");
        TreeSet<String> tSet = new TreeSet<>();     //TreeSet is similar to hashset in that it only contains unique values (no duplicates) and stores its items in ascending order
        try (                                       //We use Generic set up to catch errors at compile time
                Scanner readFile = new Scanner(file);
        ) {
            while (readFile.hasNext()) {
                String[] wordValue = readFile.nextLine().split("[ \n.,]");      //KEY CODE: wordValue is going to hold the values from you .txt file. split is used to remove spaces and seperate all strings by these spaces and periods.
                for (String word: wordValue) {                                        //for loop having variable word hold the value of each instance within wordValue
                    if (word.length() > 0)                                            //if the current loop value of word is greater than 0 (has a minimum of one letter), tSet (TreeSet) will store and auto sort each string as lowercase
                        tSet.add(word.toLowerCase());
                }
            }
        }
        System.out.println(tSet);                                   //standard TreeSet will print as ascending order
        ArrayList<String> fileWords = new ArrayList<>(tSet);        //fileWords will store tSet as an arraylist for manipulation
        Collections.sort(fileWords, Collections.reverseOrder());    //this collections tool is how you are able to adjust the sorting of an ArrayList
        System.out.println(fileWords);
    }
}