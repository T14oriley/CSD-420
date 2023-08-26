//CSD420 Tyler O'Riley 08/26/2023 Assignments 3
//Java program using Generic structure to build a static method that returns a new ArrayList

import java.util.*;

public class GenericArray {
    public static void main(String[] args) {
        Random ranNum = new Random();   //Random number object generator

        ArrayList<Integer> listOne = new ArrayList<>(50);   //Generic used for ArrayList<Integer> so errors can be detected at compile time vs run time

        System.out.println("ArrayList One:");           //listOne for loop to generate 50 random integers
        for (int i = 0; i < 50; i++) {
            listOne.add(ranNum.nextInt(20) + 1);    //nextInt with bound stipulation so only variables up to 20 can be used REFRESHER(+ 1 is used here because 20 means integers between 0 - 19 since 0 counts as a index. + 1 makes the index range 1 - 20)
            System.out.print(listOne.get(i) + " ");
        }

        System.out.println("\nArrayList Two:");
        ArrayList<Integer> listTwo;                       //Generic integer array established for listTwo
        listTwo = removeDuplicates(listOne);              //removeDuplicates class method called
        for (int i = 0; i < listTwo.size(); i++) {        //for loop to print out listTwo index values
            System.out.print(listTwo.get(i) + " ");
        }
    }

    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {    //Generic static used with E as a generic type. Essentially a placeholder until compiled with a concrete type (class method called with variables)
        ArrayList<E> listTwo = new ArrayList<>(list.size());                //listTwo size is determined by the size of listOne after removeDuplicates has ran with the inherited peramaeter (when generic E is compiled with the concrete listOne)
        for (E arrayList : list) {                                          //for each loop to assign array values of list (listOne values) to generic arrayList defined by E (another method to assist in finding errors at compile time when assigning the adjusted values of listOne to listTwo)
            if (!listTwo.contains(arrayList)) {
                listTwo.add(arrayList);
            }
        }
        return listTwo;
    }
}