package cinema;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Cinema{
	private Scanner sc=new Scanner(System.in);
	private TreeMap <Day,Shedule> cinema;
	private Set <String> movies;
	private Time open;
	private Time close;
	public Cinema( Time open, Time close) {
		this.cinema = new TreeMap<Day,Shedule>();
		for(Day day:Day.values()){
			cinema.put(day, new Shedule(open,close));
		}
		this.open = open;
		this.close = close;
	}
	
	
	// Make a lot of seanses with one movie
	
	public void addMovie(){
		System.out.println("Write title of film");
		String title=sc.next();
		System.out.println("Write duration of film in minutes");
		Time duration=new Time(sc.nextInt());
		int i=0;
		while(i<2){
			Movie movie=new Movie(title, duration);
			cinema.get(ChoseDay.choseDay()).addSeanse(movie,duration);
			System.out.println("Do you want to add one more seanse with this film?\n1)Yes\n2)No");
			i=sc.nextInt();	
		}
	}
	
//	Remove all seanses with one movie
	
	public void removeMovie(){
		System.out.println("Write title of film");
		String title=sc.next();
		cinema.forEach((k,v)-> {
			Set <Seanse> list=new TreeSet<Seanse>();
			v.getSeanses().forEach((e)->{
				if(!e.getMovie().getTitle().equals(title)){
					list.add(e);
				}
			});
			v.getSeanses().clear();
			v.getSeanses().addAll(list);
		});
		
	}
	
//	Don't undestand why this metod don't work
	
//	public void removeMovie(){
//		System.out.println("Write title of film");
//		String title=sc.next();
//		cinema.forEach((k,v)-> {
//			LinkedList <Seanse> list=new LinkedList<Seanse>();
//			v.getSeanses().forEach((e)->{
//				if(e.getMovie().getTitle().equals(title)){
//					list.add(e);
//				}
//			});
//			v.getSeanses().removeAll(list);
//		});
//		
//	}
//	
	
//	Add only one seanse 
	
	public void addSeanse(){
		System.out.println("Write title of film");
		String title=sc.next();
		System.out.println("Write duration of film in minutes");
		Time duration=new Time(sc.nextInt());
		Movie movie=new Movie(title, duration);
		cinema.get(ChoseDay.choseDay()).addSeanse(movie,duration);
	}
	
//	Remove only one seanse
	
	public void removeSeanse(){
		cinema.get(ChoseDay.choseDay()).removeSeanse();
		
	}
	
//	Show weekly schedule
	
	public void showWeek(){
		cinema.forEach((k,v)-> v.showShedule(k));
	}

//	Show schedule for day
	
	public void showDay(){
		Day day=ChoseDay.choseDay();
		cinema.get(day).showShedule(day);
	}
	
}
