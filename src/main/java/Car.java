import java.io.Serializable;

public class Auto implements Serializable {
    private String producer; // производитель
    private String model;
    private String typeOfBody;
    private String age;

    public Auto(String producer, String model, String typeOfBody, String age) {
        this.producer = producer;
        this.model = model;
        this.typeOfBody = typeOfBody;
        this.age = age;
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
        return "Person{" +
                "producer='" + producer + '\'' +
                ", model=" + model +
                ", type of body='" + typeOfBody + '\'' +
                ", age=" + age +
                '}';
    }
}
