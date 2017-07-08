package Items;
import java.util.Random;

public class Job {
	private int ProcessId;
	private String ProcessType;
	private int Priority;
	private int BurstTime;
	private int ArrivalTime;
	private int StartTime;
	private int EndTime;
	private int Remaining;
	private int WaitTime;
	public boolean Finished;
	

	private Random rand = new Random();
	
	public Job(int pid) {
		ProcessId = pid;
		BurstTime = rand.nextInt(10) + 1;
		this.setProcessType();
		if(ProcessId == 1){
			ArrivalTime=0;
		}else{
			ArrivalTime = rand.nextInt(29) + 0;
		}
		EndTime = -1;
		Finished = false;
	    Remaining = BurstTime;
	}
	
	public Job(Job process){
		this.ProcessId = process.ProcessId;
		this.ProcessType = process.ProcessType;
		this.Priority = process.Priority;
		this.ArrivalTime = process.ArrivalTime;
		this.BurstTime = process.BurstTime;
	}
	
	public void setProcessId(int processId) {
		ProcessId = processId;
	}
	
	public void setProcessType() {
		String[] processTypes = new String[]{"System", "Interactive", "Batch"};
	    int rnd = new Random().nextInt(processTypes.length);
	    ProcessType = processTypes[rnd];
	    
	    if(ProcessType.equals("System")){
	    	this.setPriority(1);
	    }else if(ProcessType.equals("Interactive")){
	    	this.setPriority(2);
	    }else{
	    	this.setPriority(3);
	    }
	}
	
	public void setProcessType(String processTypes) {
	    ProcessType = processTypes;
	}
	
	public void setPriority(int Priority) {

		this.Priority = Priority;
	}
	
	public void setBurstTime(int time) {

		BurstTime = time;
	}

	public void setArrivalTime(int time) {
		ArrivalTime = time;
	}
	
	public void setStartTime(int startTime) {
		StartTime = startTime;
	}
	
	public void setEndTime(int endTime) {
		EndTime = endTime;
	}
	
	public void setRemainingTime(int remainingTime){
		Remaining = remainingTime;
	}
	
	public int getProcessId() {
		return ProcessId;
	}
	
	public String getProcessType() {
		return ProcessType;
	}
	
	public int getPriority() {
		return Priority;
	}
	
	public int getBurstTime() {
		return BurstTime;
	}
	
	public int getArrivalTime() {
		return ArrivalTime;
	}
	
	public int getStartTime() {
		return StartTime;
	}
	
	public int getEndTime() {
		return EndTime;
	}
	
	public int getRemainTime(){
		return Remaining;
	}
	
	public int getTurnaround(int SimulationTime){
        if(Finished){ 
            return (EndTime - ArrivalTime );
        }
        if(SimulationTime > ArrivalTime){ 
           return (SimulationTime - ArrivalTime);
        }
        return 0; 
    }
	
	 public int getWaitTime(int SimulationTime) {
	        return (getTurnaround(SimulationTime) - (this.BurstTime));
	    }
	
    public boolean isFirst(Job other) {
        if(this.ArrivalTime == other.ArrivalTime){
            return (this.ProcessId < other.ProcessId);
        }
        return (this.ArrivalTime < other.ArrivalTime);
    }
    
    public boolean isShort(Job other){
        if(this.BurstTime == other.BurstTime){
            return isFirst(other);
        }
        return (this.BurstTime < other.BurstTime);
    }
    
    public boolean isShortRemain(Job other){
        if(this.Remaining == other.Remaining){
            return isFirst(other);
        }
        return (this.Remaining < other.Remaining);
    }

	public void displayJob(){
		System.out.print(ProcessId+"\t");
		System.out.print(ProcessType+"\t");
		System.out.print(Priority+"\t");
		System.out.print(ArrivalTime+"\t");
		System.out.print(BurstTime+"\n");
//		System.out.print(StartTime+"\t");
//		System.out.print(EndTime+"\n");
	}
}
