package cinema;

public class Time {
	private int min;
	private int hours;
	Time(int min){
		this.min=min%60;
		this.hours=min/60;
		if(hours>23){
			hours-=24;
		}
	}
	
	
	
//	Getters and setters
	
	
	public void setMin(int min) {
		this.min = min;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getMin() {
		return min;
	}
	public int getHours() {
		return hours;
	}
	
	
//	Mathematical operations with time
	
	public void add(Time t){
		min+=t.min;
		if(min>59){
			min-=60;
			hours++;
		}
		hours+=t.hours;
		if(hours>23){
			hours-=24;
		}
	}
	public void sub(Time t){
		min-=t.min;
		if(min<0){
			min+=60;
			hours--;
		}
		hours-=t.hours;
		if(hours<0){
			hours+=24;
		}
	}
	
	
//	Audit time
	
	
	public boolean audit(Time t1){
		int x1=hours*60+min;
		int x2=t1.hours*60+t1.min;
		if(x1>x2){
			return true;
		}
		return false;
	}
	public boolean auditForEnd(Time t1){
		int x1=hours*60+min;
		int x2=t1.hours*60+t1.min;
		if(x1<600){
			x1+=1440;
		}
		if(x2<600){
			x2+=1440;
		}
		if(x1>x2){
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		return "["+hours+":"+min+"]";
	}
	
	
	
}
