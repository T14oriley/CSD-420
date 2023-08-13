//CSD420 Tyler O'Riley 08/13/2023 Assignments 1
//Java program utilizing FileOutputStream to create OrileyDataFile with included method data

 import java.io.FileOutputStream;
 import java.io.IOException;
 import java.io.PrintWriter;
 import java.text.SimpleDateFormat;
 import java.util.Date;
 import java.util.Random;
 
 public class dateArray {
      public static void main (String[]args) throws IOException {   //IOException included in catch statement
 
         try (PrintWriter output = new PrintWriter(new FileOutputStream("OrileyDataFile.dat", true))) { //FileOutputStream with true to allow appending instead of replacement
 
             Date currentDate = new Date();                                         //sets currentDate object to date type
             SimpleDateFormat simpleFormat = new SimpleDateFormat("MM/dd/yyyy");    //SimpleDateFormat so date appears as mm/dd/yyyy format
             String dateStr = simpleFormat.format(currentDate);                     //stores currentDate in preffered format in object dateStr
             output.println("\nCurrent date:\n" + dateStr);
 
             output.print("\nFive Random Integers:\n");     //random 5 int generator
             Random ranNum = new Random();
             int[] intArray = new int[5];                   //uses array with 5 slots for each Random
             for (int y = 0; y < intArray.length; y++) {
                 intArray[y] = ranNum.nextInt();            //uses nextInt to produce next random number from generator
                 output.println(intArray[y]);
             }
 
             output.println("\nFive Random Doubles:");      //same structure as random int but uses doubles
             Random randDouble = new Random();
             double[] doubleArray = new double[5];
             for (int y = 0; y < doubleArray.length; y++) {
                 doubleArray[y] = randDouble.nextDouble();
                 output.println(doubleArray[y]);
             }
         }catch(IOException e){                             //IOException in event processes within FileOutputStream produces errors
             System.out.println(e);
         }
     }
 }