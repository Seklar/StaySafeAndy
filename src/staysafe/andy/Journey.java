package staysafe.andy;

public class Journey {

	private String name;
	private String startingloc;
	private String destination;
	private double duration;
	private double interval;
	
	public Journey(String name, String startingloc, String destination, double duration, double interval)
	{
		this.name = name;
		this.startingloc = startingloc;
		this.destination = destination;
		this.duration = duration;
		this.interval = interval;
	}
	
	public String getName() {return name;}
	public String getStart() {return startingloc;}
	public String getEnd() {return destination;}
	public double getDuration() {return duration;}
	public double getInterval() {return interval;}
	
	public void setName(String name){this.name = name;}
	public void setStart(String startingloc){this.startingloc = startingloc;}
	public void setEnd(String destination){this.destination = destination;}
	public void setDuration(double duration){this.duration = duration;}
	public void setInterval(double interval){this.interval = interval;}
	
}
