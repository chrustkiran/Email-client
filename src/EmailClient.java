import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class EmailClient {

    private static Scanner sc;
    private static Handler handler;
    private static Reader reader;
    private static ArrayList<String> writingList;
    private static Writer writer;
    public static int applicantCount = 0;
    public EmailClient(){

    }


    public static void main(String[] args){
        sc = new Scanner(System.in);
        handler = new Handler();
        reader = new Reader();
        writingList = new ArrayList<>();
        reader.readFile("clientList.txt");
        System.out.println("System has started...");
        System.out.println("Now please enter your name");
        String name  = sc.nextLine();
        handler.setMyname(name);
        System.out.println("Your name is set to "+handler.getMyname());

        System.out.println("Enter option type: \n"
                + "1 - Adding a new recipient\n"
                + "2 - Sending an email\n"
                + "3 - Printing out all the recipients who have birthdays\n"
                + "4 - Printing out details of all the emails sent\n"
                + "5 - Printing out the number of recipient objects in the application");

        int option = sc.nextInt();
        sc.nextLine(); //to ommit the new line after reading int
        switch(option){
            case 1:
                // input format - Official: nimal,nimal@gmail.com,ceo
                // Use a single input to get all the details of a recipient
                // code to add a new recipient
                // store details in clientList.txt file
                // Hint: use methods for reading and writing files

                String input = null;

                while(true){
                    input = sc.nextLine();
                    if(input.equals("quit()")){             //if we type quit() in cmd writer will be closed.
                        System.out.println("Writing is saved and closed");
                        break;
                    }
                    writingList.add(input);
                }

                writer = new Writer();
                writer.setFileName("clientList.txt");
                writingList.addAll(reader.getDetailList());
                Collections.reverse(writingList);
                writer.writeFile(writingList);


                break;
            case 2:
                // input format - email, subject, content
                // code to send an email

                String mailDetail = sc.nextLine();
                String [] mailDetailArray  = mailDetail.split(",");
                Mail mail = new Mail();
                mail.setRecevierMail(mailDetailArray[0]);
                mail.setSubject(mailDetailArray[1]);
                mail.setBody(mailDetailArray[2]);
                SendingEmail sendingEmail = new SendingEmail();
                sendingEmail.sendMail(mail);


                Serializer serializer = new Serializer();
                serializer.save(mail);
                break;
            case 3:
                // input format - yyyy/MM/dd (ex: 2018/09/17)
                // code to print recipients who have birthdays on the given date
                String date = sc.nextLine();
                for(Persons persons : reader.getPersonsDetail()){
                    if(persons instanceof Friend){
                        if(((Friend) persons).getDob().equals(date)){
                            System.out.println(persons.getName());
                        }
                    }
                }
                break;
            case 4:
                // input format - yyyy/MM/dd (ex: 2018/09/17)
                // code to print the details of all the emails sent on the input date
                String mailDate = sc.nextLine();
                Deserializer deserializer = new Deserializer();
                deserializer.read(mailDate);
                break;
            case 5:
                // code to print the number of recipient objects in the application
                System.out.println("Applicant count totla is "+applicantCount);
                break;

        }





    }





}
