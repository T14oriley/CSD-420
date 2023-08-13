//CSD420 Tyler O'Riley 08/13/2023 Assignments 1
//Java program utilizing FileIutputStream to read OrileyDataFile using while loop

import java.io.FileInputStream;
import java.io.IOException;

public class dateArrayReader {
      public static void main (String[]args) throws IOException{

        try{
            FileInputStream fileReader = new FileInputStream("OrileyDataFile.dat");     //File Input Stream to read existing file

            int y = 0;
            while((y = fileReader.read()) != -1) {  //while loop method to read data within OrileyDataFile.dat
                System.out.print((char) y);
            }

            fileReader.close();     //close method for when file has been read completely
        }catch(Exception e) {       //catch clause in event data read produces an error
            System.out.println(e);
        }
    }
    
}