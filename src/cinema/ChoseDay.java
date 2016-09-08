package cinema;

import java.util.Scanner;

public class ChoseDay {
	
	static public Day choseDay(){
		System.out.println("Which day?\n1)Monday\n2)Tuesday\n3)Wednesday\n4)Thursday\n5)Friday\n6)Saturday\n7)Sunday");
		Scanner sc=new Scanner(System.in);
		int day=sc.nextInt();
		Day d=Day.Friday;
		switch(day){
		case 1:d=Day.Monday;break;
		case 2:d=Day.Tuesday;break;
		case 3:d=Day.Wednesday;break;
		case 4:d=Day.Thursday;break;
		case 5:d=Day.Friday;break;
		case 6:d=Day.Saturday;break;
		case 7:d=Day.Sunday;break;
		}
		return d;
	}
}
