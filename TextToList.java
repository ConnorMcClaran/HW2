/**
 * Created by mcclarci on 9/28/2016.
 * Connor McClaran code for 2.2.17
 */
import java.io.*;
import java.util.LinkedList;


public class TextToList {
    public static void main(String [] args) {
        LinkedList<String> list= new LinkedList<String>();
        File file = new File("dma.txt");



        String fileName = "dma.txt";


        String line = null;

        try {

            FileReader fileReader =
                    new FileReader(fileName);


            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                String comma = ",";

                int y = line.lastIndexOf(comma);
                String city;
                city = line.substring(4,y);

                list.add(city);




            }


            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");

        }
        System.out.println(list);


        }



    }

