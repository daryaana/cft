import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class Command {
   public void firstStart() throws IOException {
     //  DataFile file = new DataFile("db.txt");
       BufferedReader file = new BufferedReader(new FileReader("db.txt"));
       if(file.readLine()==null){
           String[] example0 = {"1","Mazda", "mazda6", "sedan", "2005"};
           String[] example1 = {"2","Lexus", "is250", "sedan", "2015"};
           String[] example2 = {"3","Toyota", "Camry", "sedan", "2019"};
           Map<String, String> ex0 = new Main().parse(example0);
           Map<String, String> ex1 = new Main().parse(example1);
           Map<String, String> ex2 = new Main().parse(example2);
           add(ex0);
           add(ex1);
           add(ex2);
           /*Car car0 = new Car(ex0.get("id"), ex0.get("model"),ex0.get("typeOfBody"), ex0.get("age"));
           Car car1 = new Car(ex1.get("id"), ex1.get("model"),ex1.get("typeOfBody"), ex1.get("age"));
           Car car2 = new Car(ex2.get("id"), ex2.get("model"),ex2.get("typeOfBody"), ex2.get("age"));*/
       }
   }
   public void add(Map<String,String> params){
       Car car = new Car( params.get("id"), params.get("producer"), params.get("model"), params.get("typeOfBody"), params.get("age"));
       DataFile file = new DataFile("db.txt");
       file.saveWithoutLoad(car);
    }
    public void showAllCar() throws IOException {
       DataFile file = new DataFile("db.txt");
       file.loadFromFile();
    }
    public void delete(String number){
       DataFile file = new DataFile("db.txt");
       file.deleteFromFile(Integer.valueOf(number));

    }
}
