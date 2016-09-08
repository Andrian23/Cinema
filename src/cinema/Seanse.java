package cinema;

public class Seanse implements Comparable{
	private Movie movie;
	private Time startTime;
	private Time endTime;
	public Seanse(Movie movie, Time startTime) {
		this.movie = movie;
		this.startTime = new Time(startTime.getHours()*60+startTime.getMin());
		this.endTime=new Time(startTime.getHours()*60+startTime.getMin());
		endTime.add(movie.getDuration());
	}
	
//	Getters and setters
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public Time getStartTime() {
		return startTime;
	}
	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}
	public Time getEndTime() {
		return endTime;
	}
	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}
	
	
	
	
//	toString & compareTo
	
	@Override
	public String toString() {
		return "Seanse [movie=" + movie.getTitle() + ", start=" + startTime + ", end=" + endTime + "]";
	}
	@Override
	public int compareTo(Object arg0) {
		Seanse s=(Seanse)arg0;
		if(s.startTime.equals(startTime)&&s.getMovie().equals(getMovie()))
			return 0;
		return -1;
	}
	
	
}
