public class time {
	private LocalTime start;
	private LocalTime end;

	public time(String start, String end){
		this.start = LocalTime.parse(this.correct(start).split(" ")[0]);
	       this.end = LocalTime.parse(this.correct(end).split(" ")[0]);	
	}

	public String getStart(){
		return this.start.toString();
	}
	public String getEnd(){
		return this.end.toString();
	}

	// correct the clock to 24hr clock period
	private String correct(String time)
}
