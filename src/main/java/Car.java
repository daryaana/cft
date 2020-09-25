import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Car implements Serializable {
    private static AtomicInteger nextID = new AtomicInteger(0);


    private int id;
    private String producer; // производитель
    private String model;
    private String typeOfBody;
    private String age;

    public Car(String id, String producer, String model, String typeOfBody, String age) {
        this.id = Integer.valueOf(id);
        this.producer = producer;
        this.model = model;
        this.typeOfBody = typeOfBody;
        this.age = age;
        //*    carsMap.put(Integer.valueOf(id), this);
        //  carsMap.put(id)
    }

    public Car(String producer, String model, String typeOfBody, String age) {
        this.id = nextID.get();
        this.producer = producer;
        this.model = model;
        this.typeOfBody = typeOfBody;
        this.age = age;
        //*   carsMap.put(Integer.valueOf(id), this);
    }


    public String getProducer() {
        return producer;
    }

    public String getModel() {
        return model;
    }

    public String getTypeOfBody() {
        return typeOfBody;
    }

    public String getAge() {
        return age;
    }

    public int getId() {
        return id;
    }
}
