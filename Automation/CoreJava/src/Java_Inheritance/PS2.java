package Java_Inheritance;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;


public class PS2 extends PS1{


	@Test
	public void testRun() {
		
		PS3 ps3 = new PS3(3); //constructor( the object must be parameterized)
		int a=3;
		doThis(); //parent class
		
		System.out.println(ps3.increment());
		
		System.out.println(ps3.decrement());
		//PS4 ps4 = new PS4(3);
		
		System.out.println(ps3.multiplyTwo());
		
		System.out.println(ps3.multiplyThree());
			
		
	}


		
	}


