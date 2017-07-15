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
	public boolean Finished;
	
	//Variable rand used to generate random values
	private Random rand = new Random();
	
	/**
     * create a Job with random data
     * @param pid is the Process ID for each Job
     */
	public Job(int pid) {
		ProcessId = pid;
		//generate a random value between 1 and 10
		BurstTime = rand.nextInt(10) + 1;
		this.setProcessType();
		//generate a random value between 0 and 29
		ArrivalTime = rand.nextInt(29) + 0;
		EndTime = -1;
		Finished = false;
		//By default, each job's remaining time is equal to their burst time
	    Remaining = BurstTime; 
	}
	
	/**
    * set the process id for a job
    * @param processId is the Process ID for a job
    */
	public void setProcessId(int processId) {
		ProcessId = processId;
	}
	
	/**
     * generates a random process type
     */
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
	
	/**
     * generates a random process priority
     */
	public void setPriority(int Priority) {
		this.Priority = Priority;
	}
	
	/**
     * set the process burst time for a job
     * @param time is the Process burst time for a job
     */
	public void setBurstTime(int time) {

		BurstTime = time;
	}
	
	/**
     * set the process arrival time for a job
     * @param time is the Process arrival time for a job
     */
	public void setArrivalTime(int time) {
		ArrivalTime = time;
	}
	
	/**
     * set the process start time for a job
     * @param startTime is the Process start time for a job
     */
	public void setStartTime(int startTime) {
		StartTime = startTime;
	}
	
	/**
     * set the process end time for a job
     * @param endTime is the Process end time for a job
     */
	public void setEndTime(int endTime) {
		EndTime = endTime;
	}
	
	/**
     * set the process remaining time for a job
     * @param remainingTime is the Process remaining time for a job
     */
	public void setRemainingTime(int remainingTime){
		Remaining = remainingTime;
	}
	
	/**
     * @return process ID of the job
     */
	public int getProcessId() {
		return ProcessId;
	}
	
	/**
     * @return process type of the job
     */
	public String getProcessType() {
		return ProcessType;
	}
	
	/**
     * @return process priority of the job
     */
	public int getPriority() {
		return this.Priority;
	}
	
	/**
     * @return burst time of the job
     */
	public int getBurstTime() {
		return BurstTime;
	}
	
	/**
     * @return arrival time of the job
     */
	public int getArrivalTime() {
		return ArrivalTime;
	}
	
	/**
     * @return start time of the job
     */
	public int getStartTime() {
		return StartTime;
	}
	
	/**
     * @return end time of the job
     */
	public int getEndTime() {
		return EndTime;
	}
	
	/**
     * @return remaining time of the job
     */
	public int getRemainTime(){
		return Remaining;
	}
	
	 /**
     * calculate the turnaround time of the job
     * requires the simulation time
     * @param SimulationTime simulation time since the whole simulation has started 
     * @return turnaround time of the job
     */
	public int getTurnaround(int SimulationTime){
		//if the job is finished return the difference of End time and arrival time 
        if(Finished){ 
            return (EndTime - ArrivalTime );
        }
        /*if the simulation time is greater than the arrival time, 
         *return the difference of the simulation time and the arrival time
         *This usually happens if a job arrived but hasn't finished yet
         */
        if(SimulationTime > ArrivalTime){ 
           return (SimulationTime - ArrivalTime);
        }
        return 0; 
    }
	
	/**
     * calculate the wait time of the job
     * wait = turnaround - burst time.
     * @param SimulationTime simulation time since the whole simulation has started
     * @return waiting time of the job
     */
	 public int getWaitTimeFCFS(int SimulationTime) {
	        return (getTurnaround(SimulationTime) - (this.BurstTime));
	    }
	 
	 public int getWaitTime(int SimulationTime) {
	        return (getTurnaround(SimulationTime) - (this.BurstTime - this.Remaining));
	    }
	
	 /**
	 * compare the arrive time to see which job arrived first 
	 * based off process ID
	 * @param other is another job
	 * @return true if this job is the first 
	 */
    public boolean isFirst(Job other) {
        if(this.ArrivalTime == other.ArrivalTime){
            return (this.ProcessId < other.ProcessId);
        }
        return (this.ArrivalTime < other.ArrivalTime);
    }
    
    /**
     * compare the arrive time 
     * @param other is another job
     * @return true if this job is the first 
     */
    public boolean isShortRemain(Job other){
    	/*If the remaining time of the two jobs are the same,
    	 * use the isFirst function to see which job to return
    	 */
        if(this.Remaining == other.Remaining){
            return isFirst(other);
        }
        return (this.Remaining < other.Remaining);
    }

    /*Display job data*/
	public void displayJob(){
		System.out.print(ProcessId+"\t");
		System.out.print(ProcessType+"\t");
		System.out.print(Priority+"\t");
		System.out.print(ArrivalTime+"\t");
		System.out.print(BurstTime+"\n");
		System.out.print(StartTime+"\t");
		System.out.print(EndTime+"\n");
	}
}
