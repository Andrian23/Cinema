package cinema;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import org.omg.Messaging.SyncScopeHelper;


public class Shedule {
	Scanner sc=new Scanner(System.in);
	private boolean avoid;
	private Time open;
	private Time close;
	private Set <Seanse> seanses;
	public Shedule(Time open, Time close) {
		seanses=new TreeSet<Seanse>();
		this.open=open;
		this.close=close;
	}
	
	
	
//	Setters
	
	public Set<Seanse> getSeanses() {
		return seanses;
	}


	public void setSeanses(Set<Seanse> seanses) {
		this.seanses = seanses;
	}

	
	
//	Add seanse

	public void addSeanse(Movie movie,Time duration){
		avoid=false;
		showShedule();
		System.out.println("\nWhen will seanse start? How many hours?");
		int hours=sc.nextInt();
		System.out.println("\nHow many minutes?");
		int min=sc.nextInt();
		Seanse seanse=new Seanse(movie,new Time((hours*60)+min));
		if(!seanse.getStartTime().audit(open)){
			System.out.println("\nSorry! Cinema open at "+open);
			avoid=true;
		}
		if(seanse.getEndTime().auditForEnd(close)){
			System.out.println("\nSorry! Cinema closed at "+close);
			avoid=true;
		}else{
		seanses.forEach(e-> {
			if(seanse.getStartTime().audit(e.getStartTime())&&e.getEndTime().audit(seanse.getStartTime())||
			seanse.getEndTime().audit(e.getStartTime())&&e.getEndTime().audit(seanse.getEndTime())||
			seanse.getEndTime().audit(e.getEndTime())&&e.getStartTime().audit(seanse.getStartTime())){
				System.out.println("\nSorry! Some seanse will be in this time");
				avoid=true;
			}
		});
		}
		if(!avoid){
			seanses.add(seanse);
			avoid=false;
		}
	}
	
	
	
//	Remove seanse
	
	public void removeSeanse(){
		int i=seanses.size();
		for (Seanse seanse : seanses) {
			System.out.println((i--)+")"+seanse);
		}
		System.out.println("\nWhich seanse you want to remove?");
		int c=sc.nextInt();
		i=seanses.size();
		Seanse seanse=null;
		for (Seanse s1 : seanses) {
			if(i--==c){
				seanse=s1;
			}
		}
		if(seanse==null){
			System.out.println("This seanse not exist");
		}else{
			seanses.remove(seanse);
		}
		
	}
	
	
	
//	Show shedule
	
	public void showShedule() {
		System.out.println("-----------------------------\nOpen at "+open+" a.m.");
		seanses.forEach(System.out::println);
		System.out.println("Close at "+close +" a.m\n-------------------------------");
	}
	
	public void showShedule(Day y) {
		System.out.println("-------------------------\n"+y.name()+":\nOpen:"+open+" a.m.");
		seanses.forEach(System.out::println);
		System.out.println("Close:"+close+" a.m.\n---------------------------");
	}
	
	
	
	
//	toString
	
	@Override
	public String toString() {
		return "Shedule [open=" + open + ", close=" + close + ", seanses=" + seanses.size()+ "]";
	}
	
	
}
