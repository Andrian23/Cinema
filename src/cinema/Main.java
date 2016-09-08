package cinema;

public class Main {

	public static void main(String[] args) {
		Cinema cinema =new Cinema(new Time(600), new Time(1500));
		Menu menu=new Menu(cinema);
		menu.menu();
	}

}
