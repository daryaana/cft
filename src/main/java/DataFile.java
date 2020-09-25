import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class DataFile {
    private Map<Integer, Car> allCars = new HashMap<Integer, Car>();//список всех машин с id- key
    private File file;

    public DataFile(String fileName) {
        this.file = new File(fileName);
    }

    /**
     * TO DO
     * загружать бд каждую опрецию и при запуске программы
     */
    public void loadDB() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int id = 1;
            while ((line = reader.readLine()) != null) {
                String[] split = line.split(" ");
                Car car = new Car(split[0], split[1], split[2], split[3], split[4]);
                allCars.put(id, car);
                reader.readLine();
            }
        } catch (IOException e) {
            System.out.println(e + "A new file db.txt will be created\n");
        }
    }

    public void addDF(Car car) throws IOException {
        allCars.put(countLines(),car);
        saveTxt();


    }


    /*  public void save(Car car) {
          try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
              writer.write(car.getId() + " " + car.getProducer() + " " + car.getModel() + " " + car.getTypeOfBody() + " " + car.getAge() + "\n");
          } catch (IOException e) {
              throw new RuntimeException(e);
          }
          loadInFileConsole();
      }
  */
    public void saveWithoutLoad(Car car) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(car.getId() + " " + car.getProducer() + " " + car.getModel() + " " + car.getTypeOfBody() + " " + car.getAge() + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public void deleteCar(int id) {
        allCars.remove(id);
        saveTxt();

    }

    private void loadInFileConsole() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String carAttrib;
            while ((carAttrib = reader.readLine()) != null) {
                //   String[] args = reader.readLine().split(" ");
                String[] split = carAttrib.split(" ");
                Car car = new Car(split[0], split[1], split[2], split[3]/*,split[4]*/);
                //  allCars.put(nextID.getAndIncrement(), car);//cars.add(car);
                reader.readLine();
            }
        } catch (IOException e) {
            System.out.println(e + "A new file db.txt will be created\n");
        }
    }

    public void saveTxt() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            for (Map.Entry<Integer, Car> item : allCars.entrySet()) {
                int id = (int) item.getKey();
                Car car = item.getValue();
                writer.write(id + " " + car.getProducer() + " " + car.getModel() + " " + car.getTypeOfBody() + " " + car.getAge() + "\n");
            }
    //        loadDB();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void showBD() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line = in.readLine();
        while (line != null) {
            System.out.println(line);
            line = in.readLine();
        }
    }


    public void changeCar(int id, String strProducer, String strModel, String strBodyType, String strAge) {
        for (Map.Entry<Integer, Car> item : allCars.entrySet()) {
            if (item.getKey() == id) {
                allCars.put(id, new Car(strProducer, strModel, strBodyType, strAge));
            }
        }
        saveTxt();
    }
    public static int countLines() throws IOException {
        InputStream is = new BufferedInputStream(new FileInputStream("db.txt"));
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
