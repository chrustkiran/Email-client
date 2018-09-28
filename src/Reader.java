import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Reader {
    private String fileName;
    ArrayList<Persons> personsList;
    ArrayList<String> detailList;


    public Reader(){
        personsList = new ArrayList<>();
        detailList = new ArrayList<>();
    }

 public void readFile(String fileName){

        this.fileName = fileName;

     // This will reference one line at a time
     String line = null;

     try {
         // FileReader reads text files in the default encoding.
         FileReader fileReader =
                 new FileReader(fileName);

         // Always wrap FileReader in BufferedReader.
         BufferedReader bufferedReader =
                 new BufferedReader(fileReader);

         while((line = bufferedReader.readLine()) != null) {
             detailList.add(line);
           String[] detail = line.split(",");
           if(detail.length == 3){                      //if the values in the format is 3, it it official
               Persons officialPerson = new Official();
               officialPerson.setName(detail[0]);
               officialPerson.setEmail(detail[1]);
               ((Official) officialPerson).setDesignation(detail[2]);

               addToList(officialPerson);               //after assigning all the values for this object, adding to the array list
           }

            if(detail.length==4 && isEmail(detail[1])){
               Persons officialFriend = new OfficialFriend();
               officialFriend.setName(detail[0]);
               officialFriend.setEmail(detail[1]);
               ((OfficialFriend) officialFriend).setDesignation(detail[2]);
               ((OfficialFriend) officialFriend).setDob(detail[3]);

               addToList(officialFriend);
           }

           if(detail.length == 4 && isEmail(detail[2])){
               Persons personalPerson = new Personal();
               personalPerson.setName(detail[0]);
               ((Personal) personalPerson).setNickname(detail[1]);
               personalPerson.setEmail(detail[2]);
               ((Personal) personalPerson).setDob(detail[3]);


               addToList(personalPerson);

           }


         }

         // Always close files.
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
         // Or we could just do this:
         // ex.printStackTrace();
     }
 }

 private void addToList(Persons persons){
        personsList.add(persons);
 }

 public ArrayList<Persons> getPersonsDetail(){
        return this.personsList;
 }

 private boolean isEmail(String email){
        boolean isEmail = false;
        if(email.contains("@") && email.contains(".")){         // if this string has @ and . it is an email address
            isEmail = true;
     }
     return isEmail;
 }

public ArrayList<String> getDetailList(){
        return this.detailList;
}

}
