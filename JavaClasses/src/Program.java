
public class Program {

	public static void main(String[] args) {
		Person person = new Person();
		
		person.setAge(5);
		person.setName("Stuart");
		System.out.printf("Age %d  Name %s", person.getAge(), person.getName());

	}

}
