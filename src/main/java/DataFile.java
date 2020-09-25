import com.google.gson.Gson;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class DataFile {
    private File file;
    //private
    // private List<Car> cars = new ArrayList<>();
    private Map<Integer, Car> cars = new HashMap<Integer, Car>();
    private static AtomicInteger nextID = new AtomicInteger(0);

    public DataFile(String fileName) {
        this.file = new File(fileName);
    }

    public int countOfcars() {
        return cars.size();
    }

    public void save(Car car) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(car.getId() + " " + car.getProducer() + " " + car.getModel() + " " + car.getTypeOfBody() + " " + car.getAge() + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        loadInFileConsole();
        writeToJson();
    }

    public void saveWithoutLoad(Car car) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(car.getId() + " " + car.getProducer() + " " + car.getModel() + " " + car.getTypeOfBody() + " " + car.getAge() + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public void deleteFromFile(int id) {
        Map<Integer, Car> copy = new HashMap<>(cars);
        cars.remove(id);
  /*      for(Map.Entry<Integer, Car> pair: copy.entrySet()){
            if (pair.getValue().equals(Integer.toString(id))){
                cars.remove(pair.getKey());
            }
            loadInFile();
        }*/
        loadInFile();

    }

    private void loadInFileConsole() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String carAttrib;
            while ((carAttrib = reader.readLine()) != null) {
                //   String[] args = reader.readLine().split(" ");
                String[] split = carAttrib.split(" ");
                Car car = new Car(split[0], split[1], split[2], split[3]/*,split[4]*/);
                cars.put(nextID.getAndIncrement(), car);//cars.add(car);
                reader.readLine();
            }
        } catch (IOException e) {
            System.out.println(e + "A new file db.txt will be created\n");
        }
    }

    private void loadInFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            for (int i = 0; i < cars.size(); i++) {
                Car car = cars.get(i);
                writer.write(car.getId() + " " + car.getProducer() + " " + car.getModel() + " " + car.getTypeOfBody() + " " + car.getAge() + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadFromFile() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line = in.readLine();
        while (line != null) {
            System.out.println(line);
            line = in.readLine();
        }
    }

    private void writeToJson() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("data_file.json"))) {
            Gson gson = new Gson();
            bw.write(gson.toJson(cars));
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
