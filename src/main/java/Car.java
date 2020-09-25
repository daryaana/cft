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

    Map<Integer, Car> carsMap = new HashMap<Integer, Car>();
    public Car(String id, String producer, String model, String typeOfBody, String age) {
        this.id=Integer.valueOf(id);
        this.producer = producer;
        this.model = model;
        this.typeOfBody = typeOfBody;
        this.age = age;
        carsMap.put(Integer.valueOf(id), this);
        //  carsMap.put(id)
    }

    public Car(String producer, String model, String typeOfBody, String age) {
        this.id=nextID.get();
        this.producer = producer;
        this.model = model;
        this.typeOfBody = typeOfBody;
        this.age = age;
        carsMap.put(Integer.valueOf(id), this);
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
public int getId(){
        return id;
}

    public void setId(int id) {
        this.id = id;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setTypeOfBody(String typeOfBody) {
        this.typeOfBody = typeOfBody;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "producer:" + producer + '\'' +
                ", model: " + model +
                ", type of body: " + typeOfBody + '\'' +
                ", age: " + age;
    }
/*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(surname, person.surname) &&
                Objects.equals(age, person.age) &&
                Objects.equals(address, person.address);
    }*/

    @Override
    public int hashCode() {
        return Objects.hash(id, producer, model, typeOfBody, age);
    }
}
