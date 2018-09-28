import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Writer {

   private ArrayList<String> details;
   private String fileName;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void writeFile(ArrayList<String> details){

        this.details = details;
        // The name of the file to open.


        try {
            // Assume default encoding.
            FileWriter fileWriter =
                    new FileWriter(fileName);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter =
                    new BufferedWriter(fileWriter);

            // Note that write() does not automatically
            // append a newline character.


            for (String detail: details) {
                bufferedWriter.write(detail+"\n");
            }


            // Always close files.
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                    "Error writing to file '"
                            + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
    }
}
