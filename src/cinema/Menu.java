package cinema;

import java.util.Scanner;

public class Menu {
	Scanner sc =new Scanner(System.in);
	private Cinema cinema;

	public Menu(Cinema cinema) {
		super();
		this.cinema = cinema;
	}
	
	public void menu(){
		other:while(true){
			System.out.println("\n---------------------------\n"
					+ "1) Add movie\n2) Add seanse\n3) Remove movie\n4) Remove seanse\n"
					+ "5) Show weekly schedule\n6) Show schedule for day\n"
					+ "-------------------------------\n");
			int c=sc.nextInt();
			switch(c){
			case 1:cinema.addMovie();
			break;
			case 2:cinema.addSeanse();;
			break;
			case 3:cinema.removeMovie();
			break;
			case 4:cinema.removeSeanse();
			break;
			case 5:cinema.showWeek();
			break;
			case 6:cinema.showDay();
			break;
			default:break other;
			}
		}
	}
}
