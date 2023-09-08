//CSD420 Tyler O'Riley 09/05/2023 Assignments 6
//Java program to manipulate lists using bubble sort

import java.util.Comparator;

public class bubsort {

	public static <E extends Comparable<E>> void bubbleSort(E[] bubble) {   //Primary method that utilizes bubblesort as an algorithm using the comparable interface
	  bubbleSort(bubble, (e1, e2) -> ((Comparable<E>)e1).compareTo(e2));
	}

	public static <E> void bubbleSort(E[] bubble,   //Primary method that utilizes bubblesort as an algorithm using the comparator interface
	    Comparator<? super E> comparator) {
		boolean needNextPass = true;

		for (int k = 1; k < bubble.length && needNextPass; k++) {       //For loop to generate list and comapare each variable to swap if they are in the wrong order
			needNextPass = false;
			for (int i = 0; i < bubble.length - k; i++) {
				if (comparator.compare(bubble[i], bubble[i + 1]) > 0) {
					E temp = bubble[i];
					bubble[i] = bubble[i + 1];
					bubble[i + 1] = temp;

					needNextPass = true; 
				}
			}
		}
	}

  public static void main(String[] args) {

    Integer[] bubble = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};   //Analysis one using integers in list
    bubbleSort(bubble);

    for (int i = 0; i < bubble.length; i++) {       //displays evaluated data
      System.out.print(bubble[i] + " ");
    }
    System.out.println();

    String[] bub1 = {"ABC", "abc", "abm", "Anf", "Good", "Bad", "nice"};    //Analysis two using strings

    bubbleSort(bub1, (s1, s2) -> s1.compareToIgnoreCase(s2));   

    for (int i = 0; i < bub1.length; i++) {
      System.out.print(bub1[i] + " ");
    }
  }
}
