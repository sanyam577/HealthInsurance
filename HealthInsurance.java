import java.util.Scanner;
class RichClassException extends Exception{
	public RichClassException(String msg) {
		super(msg);
	} 
}

class MiddleClassException extends Exception{
	public MiddleClassException(String msg) {
		super(msg);
	} 
}
class WeakerClassException extends Exception{
	public WeakerClassException(String msg){
		super(msg);
	}
	
}


class Health{
String name;
int age; 
double income;
String address;

public void input() {
	Scanner scan = new Scanner(System.in);
	System.out.println("enter your name"); 
	name = scan.nextLine();
	System.out.println("enter your address"); 
	address = scan.nextLine();
	System.out.println("enter your age");
	age = scan.nextInt();
	System.out.println("enter your annual income");
	income = scan.nextDouble();
}
public void verify() throws RichClassException, MiddleClassException, WeakerClassException{
	if(income>3000000) {
		RichClassException r = new RichClassException("you need not to take health insurance");
		System.out.println(r.getMessage());
		throw r;
		
	}
	
	if((income<500000) && (income>300000)) {
		MiddleClassException m = new MiddleClassException("you need to take health insurance");
		System.out.println(m.getMessage());
		throw m;
	}
	
	if(income<300000) {
		WeakerClassException w = new WeakerClassException("Government launch a program 'Ayushman Bharat' please register over there for support");
		System.out.println(w.getMessage());
		throw w;
	}
}

}

class Agent{
	public void agent() {
		Health h = new Health();
		try {
		h.input();
	    h.verify();
	    }
		catch(RichClassException | MiddleClassException | WeakerClassException e1){
			
		}
	}
}

public class HealthInsurance {

	public static void main(String[] args) {
		Agent aa = new Agent();
		aa.agent();

	}

}