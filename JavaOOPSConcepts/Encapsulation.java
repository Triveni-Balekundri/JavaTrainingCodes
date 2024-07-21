package objectOrientedPrograms;

public class Encapsulation {

	//Student name and age variable
		private String name;
		private int age;
		
		//Using public methods in order to setName, setAge
		public String getName()
		{
			return name;
		}
		public void setName(String newName)
		{
			name=newName;
			System.out.println("Now the name-value has been set for the private variable 'name' with the help of the setName()" );
		}

}
