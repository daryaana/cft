import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static boolean firstStart;
static String menu = new String("Enter 1 to see all cars.\n" +
        "Enter 2 to add one of cars. \n" +
        "Enter 3 to delete one of cars. \n" +
        "Enter 4 to change one of car\n"+
        "Enter 5 to exit\n");
    public static void main(String[] args) throws IOException, ClassNotFoundException {


        int carId=countLines("db.txt");

        //   Map<Integer, Car> carsMap = new HashMap<Integer, Car>();
        System.out.println("Hello! It's list of cars. \n");
        System.out.println(menu);/*
                "Enter 1 to see all cars.\n" +
                "Enter 2 to add one of cars. \n" +
                "Enter 3 to delete one of cars. \n" +
                "Enter 4 to change one of cars");*/

        Command command = new Command();
    /*    if(firstStart){
            createExample(command);
        }*/
        //command.firstStart();

        Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
        int num = in.nextInt();
        if (num == 1) {
            command.firstStart();
            command.showAllCar();
            System.out.println(menu);

        }
        //   in.close();
        if (num == 2) {
            Scanner in2 = new Scanner(System.in);
            System.out.println("Введите Марку: ");

            String strProducer = in2.nextLine();
            System.out.println("Введите Модель:");
            String strModel = in2.next();
            System.out.println("Введите Тип Кузова:");
            String strBodyType = in2.next();
            System.out.println("Введите год выпуска:");
            String strAge = in2.next();
            String[] argum = {Integer.toString(carId), strProducer, strModel, strBodyType, strAge};
            carId++;
            Map<String, String> params = new Main().parse(argum);
            command.add(params);
            System.out.println(menu);
            //   fromSerialize(toSerialize(carsMap));
            // System.out.println("1");
        }
        if(num == 3){
            System.out.println("Введите номер автомобиля, который хотите удалить");
            Scanner in3 = new Scanner(System.in);
            String number=in3.nextLine();
            command.delete(number);

        }


        //Сериализация с помощью класса ByteArrayOutputStream
     /*   ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);

        objectOutputStream2.writeObject(example0);
        objectOutputStream2.writeObject(example1);
        objectOutputStream2.writeObject(example2);
        objectOutputStream2.flush();
        //Восстановление с помощью класса ByteArrayInputStream
        ObjectInputStream objectInputStream2 = new ObjectInputStream(
                new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
        Car example1RestoredFromByte = (Car) objectInputStream2.readObject();
        Car example2RestoredFromByte = (Car) objectInputStream2.readObject();
        Car example3RestoredFromByte = (Car) objectInputStream2.readObject();
        objectInputStream2.close();
        System.out.println("Before Serialize: " + "\n" + example0 + "\n" + example1 + "\n" + example2);
        System.out.println("After Restored From Byte: " + "\n" + example1RestoredFromByte + "\n" + example2RestoredFromByte + "\n" + example3RestoredFromByte);
        // System.out.println("After Restored: " + "\n" + igorRestored + "\n" + renatRestored);
*/
    }

    /* private static ByteArrayOutputStream toSerialize(Map<Integer, Car> carsMap) throws IOException {
         ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

         ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);

         objectOutputStream2.writeObject(carsMap);
         objectOutputStream2.flush();
         return objectOutputStream2;
     }

     private static void fromSerialize(ObjectOutputStream objectOutputStream2) throws IOException, ClassNotFoundException {

       /*  Car example1RestoredFromByte = (Car) objectInputStream2.readObject();
         Car example2RestoredFromByte = (Car) objectInputStream2.readObject();
         Car example3RestoredFromByte = (Car) objectInputStream2.readObject();
       */
     /*   Map<Integer, Car> map = (Map<Integer, Car>) objectOutputStream2.rereadObject();
        objectOutputStream2.close();
    }*/
    public Map<String, String> parse(String[] args) {
        String[] key = {"id","producer", "model", "typeOfBody", "age"};
        Map<String, String> parameters = new HashMap<>();
        for (int i = 0; i < args.length; i += 1) {
            parameters.put(key[i], args[i]);
        }
        return parameters;
    }

    public static void createExample(Command command) {
        firstStart = false;
        String[] example0 = {"1","Mazda", "mazda6", "sedan", "2005"};
        String[] example1 = {"2","Lexus", "is250", "sedan", "2015"};
        String[] example2 = {"3","Toyota", "Camry", "sedan", "2019"};
        Map<String, String> ex0 = new Main().parse(example0);
        Map<String, String> ex1 = new Main().parse(example1);
        Map<String, String> ex2 = new Main().parse(example2);
        command.add(ex0);
        command.add(ex1);
        command.add(ex2);
    }
    public static int countLines(String filename) throws IOException {
        InputStream is = new BufferedInputStream(new FileInputStream(filename));
        try {
            byte[] c = new byte[1024];
            int count = 0;
            int readChars = 0;
            boolean empty = true;
            while ((readChars = is.read(c)) != -1) {
                empty = false;
                for (int i = 0; i < readChars; ++i) {
                    if (c[i] == '\n') {
                        ++count;
                    }
                }
            }
            return (count == 0 && !empty) ? 1 : count;
        } finally {
            is.close();
        }
    }
}
