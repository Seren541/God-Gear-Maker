package pack;

public class Start {
	
	Main main;
	
	public static void main(String[] args) {
		
		Start run = new Start();
		run.main = new Main();
		
		run.main.setUp();
		
	}
}
