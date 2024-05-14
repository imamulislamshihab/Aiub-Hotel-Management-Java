package Entity;

import java.lang.*;

public abstract class Person {
    private String name;
    private String age;
	private String contactNum;
    
	public Person(){}
	
    public Person(String name, String age,String contactNum) {
        this.name = name;
        this.age = age;
		this.contactNum = contactNum;
    }
    
	public void setName(String name) {
        this.name = name;
    }
	
    public String getName() {
        return name;
    }
    
	public void setAge(String age) {
		this.age = age;
	}
	
    public String getAge() {
        return age;
    }
	
	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}
	
    public String getContactNum() {
        return contactNum;
    }
	
	
	public void showInfo() {
		System.out.println("Name: "+ getName());
		System.out.println("Age: "+ getAge());
		System.out.println("Contact Number: "+ getContactNum());
	}
}

