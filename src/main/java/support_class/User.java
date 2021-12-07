package support_class;

public class User {
    int id, age;
    String lastname, firstname;
    double height, weight;

    public User(){

    }

    public User(int id, String lastname, String firstname,
                int age, double height, double weight){
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public User setId(int id) {
        this.id = id;
        return this;
    }

    public int getAge() {
        return age;
    }

    public User setAge(int age) {
        this.age = age;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public User setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getFirstname() {
        return firstname;
    }

    public User setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public double getHeight() {
        return height;
    }

    public User setHeight(double height) {
        this.height = height;
        return this;
    }

    public double getWeight() {
        return weight;
    }

    public User setWeight(double weight) {
        this.weight = weight;
        return this;
    }
}
