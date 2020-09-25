import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static String menu = "Enter 1 to see all cars.\n" +
            "Enter 2 to add one of cars. \n" +
            "Enter 3 to delete one of cars. \n" +
            "Enter 4 to change one of car\n" +
            "Enter 5 to exit\n";
    static final String SHOW_ALL = "1";
    static final String ADD = "2";
    static final String DELETE = "3";
    static final String CHANGE = "4";
    static final String EXIT = "5";

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        System.out.println("Hello! It's list of cars. \n");
        System.out.println(menu);
        String enter = null;
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
        enter = in.next();
        Command command = new Command();
        command.firstStart();
        while (true) {
            enter = in.next();
            switch (enter) {
                case SHOW_ALL:
                    command.show();
                    System.out.print("Input a number: ");
                    break;
                case ADD:
                    command.add();
                    System.out.print("Input a number: ");
                    break;
                case DELETE:
                    command.delete();
                    System.out.print("Input a number: ");
                    break;
                case CHANGE:
                    command.change();
                    System.out.print("Input a number: ");
                    break;
                default:
                    System.out.println("Вы ввели недопустимые символы");
                    break;
            }
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
        String[] key = {"id", "producer", "model", "typeOfBody", "age"};
        Map<String, String> parameters = new HashMap<>();
        for (int i = 0; i < args.length; i += 1) {
            parameters.put(key[i], args[i]);
        }
        return parameters;
    }



}
