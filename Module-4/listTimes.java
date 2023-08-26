//CSD420 Tyler O'Riley 08/26/2023 Assignments 4
//Java program to test processing times using iteration and get(index) on different sized lists

import java.util.*;

public class listTimes {
    public static void main(String[] args) {
        Random ranNum = new Random();


        //Evaluation for 50,000
        

        LinkedList<Integer> listSmall = new LinkedList<Integer>();  //linkedlist so list items are stored as individual containers (linked together, but no defined size like arrays)
        for (int i = 0; i < 50000; i++) {                           //for loop to contain 50,000 random variables
            listSmall.add(ranNum.nextInt());
        }

        long smallListStart = System.currentTimeMillis();           //currentTimeMillis return the current timestamp in milliseconds so run time is marked as while loop begins (long allows the timestamp to hold large values)
        ListIterator<Integer> smallListIterate = listSmall.listIterator();  //utilizes Generic ListIterator as integer so compiler errors can be thrown before run time begins (this way if object smallListIterate runs into comp issues as it iterates, it does not affect your runtime timestamps)
        while (smallListIterate.hasNext()) {                        //while loop iterates through the linked list until no more values remain
            smallListIterate.next();
        }
        long smallListStop = System.currentTimeMillis();            //Same code as above. prints the timestamp as the while loop ends.
        System.out.println("Iteration time to traverse a linked list containing 50,000 integers: " + (smallListStop - smallListStart) + " milliseconds");

        long smallStartTime = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {                           //for loop to use get(index) to read through the linked list
            listSmall.get(i);
        }
        long smallStopTime = System.currentTimeMillis();
        System.out.println("get(index) time to traverse a linked list containing 50,000 integers: " + (smallStopTime - smallStartTime) + " milliseconds");


        //Evaluation for 500,000


        LinkedList<Integer> listLarge = new LinkedList<Integer>();    //SAME CODE AS ABOVE: Utilized for 500,000 integers
        for (int i = 0; i < 500000; i++) {
            listLarge.add(ranNum.nextInt());
        }

        long largeListStart = System.currentTimeMillis();
        ListIterator<Integer> largeListIterate = listLarge.listIterator();
        while (largeListIterate.hasNext()) {
            largeListIterate.next();
        }
        long largeListStop = System.currentTimeMillis();
        System.out.println("Iteration time to traverse a linked list containing 500,000 integers: " + (largeListStop - largeListStart) + " milliseconds");

        long largeStartTime = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
            listLarge.get(i);
        }
        long largeStopTime = System.currentTimeMillis();
        System.out.println("get(index) time to traverse a linked list containing 500,000 integers: " + (largeStopTime - largeStartTime) + " milliseconds");
    }

}

// In both scenarios using 50,000 and 500,000 the time stamps reflected that the iteration method worked vastly better than the get(index) method. the reason for this result lies in the structure of linkedlists themselves. 
// Being individual containers that are linked together with its own iterator implementation, traversly times are optimal when using iteration on the list. 
// Get(index) methods are slower in these scenarios as they have to evaluate each container of the linked list to get each value.