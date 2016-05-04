
public class Human {
	String name;
    int age;
    
    public Human(String name, int age) {
    	if(name == null) throw new NullPointerException("Name cannot be null");
    	if(age < 0) throw new IllegalArgumentException("Age cannot be less than 0"); 
    	
    	this.name =  name;
    	this.age = age;
	}
    
    
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
    public String toString() {
        return name;
    }
}
