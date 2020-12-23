package entities;

public class Person {
    private String name;
    private int age;


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return this.age;
    }

    public String getName(){
        return this.name;
    }

    public String getInfo(){
        return "Name: "+this.name+". Age: "+this.age;
    }
}
