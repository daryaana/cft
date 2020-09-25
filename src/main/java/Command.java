import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Command {
    DataFile datafile = new DataFile("db.txt");

    public void firstStart() throws IOException {

        BufferedReader file = new BufferedReader(new FileReader("db.txt"));
        if (file.readLine() == null) {
            Car car1 = new Car("Mazda", "mazda6", "sedan", "2005");
            Car car2 = new Car("Lexus", "is250", "sedan", "2015");
            Car car3 = new Car("Toyota", "Camry", "sedan", "2019");
            datafile.addDF(car1);
            datafile.addDF(car2);
            datafile.addDF(car3);
        }
   //     datafile.loadDB();

    }

    public void add() throws IOException {
        datafile.loadDB();
        Scanner in2 = new Scanner(System.in);
        System.out.println("Введите Марку: ");
        String strProducer = in2.nextLine();
        System.out.println("Введите Модель:");
        String strModel = in2.next();
        System.out.println("Введите Тип Кузова:");
        String strBodyType = in2.next();
        System.out.println("Введите год выпуска:");
        String strAge = in2.next();
        Car car = new Car(strProducer, strModel, strBodyType, strAge);
        datafile.addDF(car);
    }

    public void show() throws IOException {
      //  datafile.loadDB();
        datafile.showBD();
    }

    public void delete() {
        datafile.loadDB();
        System.out.println("Введите номер автомобиля, который хотите удалить");
        Scanner in = new Scanner(System.in);
        int id = Integer.valueOf(in.nextLine());
        datafile.deleteCar(id);
    }

    public void change() {
        datafile.loadDB();
        System.out.println("Введите номер автомобиля, данные которого хотите изменить");
        Scanner in = new Scanner(System.in);
        int id = Integer.valueOf(in.nextLine());
        System.out.println("Заполните все поля новыми данными. Введите Марку: ");
        String strProducer = in.nextLine();
        System.out.println("Введите Модель:");
        String strModel = in.next();
        System.out.println("Введите Тип Кузова:");
        String strBodyType = in.next();
        System.out.println("Введите год выпуска:");
        String strAge = in.next();

        datafile.changeCar(id,strProducer,strModel,strBodyType,strAge);


    }
}
