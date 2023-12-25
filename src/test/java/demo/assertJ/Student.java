package demo.assertJ;

public class Student {

    public Student(String name, int age, String city){
        this.name=name;
        this.age=age;
        this.city=city;
    }
    private String name;
    private int age;
    private String city;
    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    public String getCity(){
        return this.city;
    }


}
