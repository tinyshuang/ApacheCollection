package model;

/**
 * @author Administrator
 * @description
 *2015-5-12  下午12:23:08
 */
public class Person {
    private String name;
    private int age;
    
    
    
    
    public Person() {}


    public Person(String name, int age) {
	this.name = name;
	this.age = age;
    }
    
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
