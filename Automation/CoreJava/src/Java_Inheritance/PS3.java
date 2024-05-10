package Java_Inheritance;

public class PS3 extends PS4{

	
	int a;   //a will receive the value of 3 from the this keyword.
	public PS3(int a) {
		// TODO Auto-generated constructor stub
		super(a);  //only used when a parent class constructor /inhertance is there.Super
		this.a=a;
	}
	public int increment() {
		// TODO Auto-generated method stub
  a = a+1;
  return a;
	}
	public int decrement() {
		// TODO Auto-generated method stub
  a = a-1;
  return a;
	}

}
