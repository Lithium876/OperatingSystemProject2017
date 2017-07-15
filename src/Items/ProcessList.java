package Items;

import java.io.File;

import presentation.ReportWriter;

public class ProcessList extends ReportWriter{
	
	private List mainList;
	private int currentTime = 0; // current simulation time
	
	/**
     * create an empty list with size for a specific number of jobs
     * @param number is the number of jobs
     */
	public ProcessList(int number){
		super("Report.txt");
		mainList = new List(number);
	}
	
	/**
     * @return current time in simulation
     */
	public int getCurrentTime(){
		return currentTime;
	}
	
	/**
     * @param time is the current time in simulation
    */
	public void setCurrentTime(int time){
		currentTime = time;
	}
	
	/**Get a job at a specific position
    * @param num is the number of the job in the queue
    * @return selected job
    */
	public Job getJob(int num){
	    try {
			return mainList.get(num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
     * Add job to the end of the list
     * @param job is the job to be added
    */
	public void addJob(Job job){
		mainList.add(job);  
	}
	
	/**
    * @return the size-1 of the list 
    */
	public int size(){
		return mainList.lenght();
	}
	
	/**
     * check if the list is empty
     * @return true if empty
    */
	public boolean isEmpty(){
		return (mainList.isEmpty());
	}
	
	/**Remove a job at a specific position
     * @param job is the job to be added
    */
	public void removeJob(int i){
		try {
			mainList.remove(i);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
     * order the jobs inside the list by arrive time
    */
	public void OrderedByArrive(){
		for(int i=0 ; i<mainList.lenght() ; i++){
			for(int j=i+1 ; j<mainList.lenght() ;j++){
				try{
					Job j1 = mainList.get(i);
		            Job j2 = mainList.get(j);
		            if(j2.isFirst(j1)){
		            	mainList.set(i, j2);
		                mainList.set(j, j1);
		            }
				}catch (Exception e) {
					e.printStackTrace();
				}
	       }
	   }
	}
	
	/**
    * order the jobs inside the queue by the shortest remaining time
    */
	public void OrderedByShortRemain(){
		for(int i=0 ; i<mainList.lenght() ; i++){
			for(int j=i+1 ; j<mainList.lenght() ;j++){
				try{
					Job j1 = mainList.get(i);
					Job j2 = mainList.get(j);
					if(j2.isShortRemain(j1)){
						mainList.set(i, j2);
						mainList.set(j, j1);
		           }
				}catch(Exception e){
					e.printStackTrace();
				}
	       }
	   }
	}
	
	/**
    * Show queue content (every job details)
    */
	public void showProcessList(){
		if(mainList.isEmpty()){
			System.out.println("Empty Queue"); 
		}else{
			try{
				System.out.println("\t\t   Orignal Process Control Block");
				System.out.println("\t   Process Type 'Interative' has a Quantum of 2\n");
				File file = new File(super.getFileName());
				if(file.length() == 0){
					super.WriteReport(String.format("\t\t   Orignal Process Control Block\r\n"));
				}else{
					for (int i=0; i<138; i++){
						super.WriteReport(String.format("*"));
					}
					super.WriteReport(String.format("\r\n\r\n\t\t   Orignal Process Control Block\r\n"));
				}
				super.WriteReport(String.format("\t   Process Type 'Interative' has a Quantum of 2\r\n"));
				System.out.println("PID\tProcess Type\tPriority\tArrival Time\tBurst Time");
				super.WriteReport(String.format("\r\nPID\tProcess Type\tPriority\tArrival Time\tBurst Time\r\n"));
				
				for(int i=0 ; i<mainList.lenght() ; i++){
					Job temp = mainList.get(i);
					System.out.print(temp.getProcessId());
					super.WriteReport(String.format(Integer.toString(temp.getProcessId())));
					if(temp.getProcessId() >= 10){
						System.out.printf("%15s",temp.getProcessType());
						super.WriteReport(String.format("%15s",temp.getProcessType()));
					}else{
						System.out.printf("%16s",temp.getProcessType());
						super.WriteReport(String.format("%16s",temp.getProcessType()));
					}
					System.out.printf("%12s",temp.getPriority());
					System.out.printf("%18s",temp.getArrivalTime());
					System.out.printf("%16s",temp.getBurstTime()+"\n");
					super.WriteReport(String.format("%12s",temp.getPriority()));
					super.WriteReport(String.format("%18s",temp.getArrivalTime()));
					super.WriteReport(String.format("%16s",temp.getBurstTime()+"\r\n"));
				}
			}catch(Exception e){
			e.printStackTrace();
			}
		}
	}
}