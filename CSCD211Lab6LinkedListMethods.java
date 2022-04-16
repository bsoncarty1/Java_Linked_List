//Brandon Soncarty

package lab6.cscd211methods;

import java.util.Scanner;

public class CSCD211Lab6LinkedListMethods
{

   public static int menu(final Scanner kb)
   {
	  if(kb == null){
         throw new IllegalArgumentException("The scanner is null.");
      }

      int choice;
      System.out.println("Please enter a number for the choice: ");
      do {
         System.out.println("1) Print the List\n" +
                 "2) Create a BoxCar and addFirst\n" +
                 "3) Create a BoxCar and addLast\n" +
                 "4) Create a BoxCar, read and index and add -- at the index\n" +
                 "5) Create a BoxCar, check the list to see if the list contains the BoxCar\n" +
                 "6) Create a BoxCar, find the indexOf that BoxCar\n" +
                 "7) removeFirst\n" +
                 "8) removeLast\n" +
                 "9) Read index remove Node at that index\n" +
                 "10) Create a BoxCar and removeFirstOccurrence of that BoxCar\n" +
                 "11) Create a BoxCar and removeLastOccurrence of that BoxCar\n" +
                 "12) clear the list\n" +
                 "13) Print the size of the list\n" +
                 "14) Quit");

                  choice = kb.nextInt();
      }while(choice < 1 || choice > 14);

      return choice;
   }
   
   /**
    * Prompts the user for a String and reads the String from the keyboard
    */
   public static String buildAString(final Scanner kb) {
      if (kb == null) {
         throw new IllegalArgumentException("The scanner is null.");
      }
      String in = null;
      while (in == null || in.equals("")) {
         System.out.println("Please give a String: ");
         in = kb.next();
      }
      return in;

   }
   
   
   /**
    * readIndex reads a value greater than -1
    */
   public static int readIndex(final Scanner kb){
      if(kb == null){
         throw new IllegalArgumentException("The scanner is null.");
      }

      int index = -1;
      while(index < 0) {
         System.out.println("Please give an index: ");
         index = kb.nextInt();
      }
      return index;
   }
   
   

}