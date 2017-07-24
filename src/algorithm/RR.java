package algorithm;

import Items.ProcessList;
import presentation.ReportWriter;

public class RR extends ReportWriter{
	private int Quantum = 2;
	private int RunTime;
	private ProcessList mainList;
	private ProcessList readyList = new ProcessList(1);
	
	public RR(ProcessList list){
		super("Report.txt");
		RunTime = 0;
		mainList = list;
		mainList.OrderedByArrive();
	}
	
	public int run(ProcessList list){
		try {
			/*Move processes from the main list to the ready list to be 
			 * sent to the cpu list*/
			this.check(list);
				
			/*Execute the Round Robin Algorithm with a time quantum of 2*/
			for(int j=0;j<readyList.size();j++){
				/*If the current job is not completed*/
				if(!readyList.getJob(j).Finished){
					/*If the arrival time is greater than the current cpu time,
					 * set the cpu current time to be the process arrival time*/
					if(readyList.getJob(j).getArrivalTime() > list.getCurrentTime()){
						list.setCurrentTime(readyList.getJob(j).getArrivalTime());
					}
					/*Process start time is always set to the current cpu time*/
					readyList.getJob(j).setStartTime(list.getCurrentTime());
					/*Checks if the quantum is greater than the process burst
					 * time.*/
					if(Quantum > readyList.getJob(j).getBurstTime()){
						
						/*If the quantum is greater than the process burst time,
						 * run the process for it's burst time*/
						readyList.getJob(j).setEndTime(readyList.getJob(j).getStartTime()+readyList.getJob(j).getBurstTime());
						readyList.getJob(j).setRemainingTime(0);
						RunTime = readyList.getJob(j).getBurstTime();
						list.setCurrentTime(list.getCurrentTime()+RunTime);
					}else{
						/*If the quantum is less than the process burst time,
						 *run the the process for the quantum time, then check
						 *if any new processes arrived that the current cpu time,
						 *add them to the ready list, then add the unfinished process
						 *back to the ready list*/
						readyList.getJob(j).setEndTime(readyList.getJob(j).getStartTime()+Quantum);
						readyList.getJob(j).setRemainingTime(readyList.getJob(j).getRemainTime()-Quantum);
						RunTime = Quantum;
						list.setCurrentTime(list.getCurrentTime()+RunTime);
						this.check(list);
						readyList.addJob(readyList.getJob(j));
					}
					
					/*OUTPUT AND REPORT GENERATION*/
					System.out.print(readyList.getJob(j).getProcessId());
					super.WriteReport(String.format(Integer.toString(readyList.getJob(j).getProcessId())));
					if(readyList.getJob(j).getProcessId() >= 10){
						System.out.printf("%13s",readyList.getJob(j).getArrivalTime());
						super.WriteReport(String.format("%13s",readyList.getJob(j).getArrivalTime()));
					}else{
						System.out.printf("%14s",readyList.getJob(j).getArrivalTime());
						super.WriteReport(String.format("%14s",readyList.getJob(j).getArrivalTime()));
					}
					System.out.printf("%15s",readyList.getJob(j).getBurstTime());
					System.out.printf("%17s",readyList.getJob(j).getStartTime());
					System.out.printf("%14s",readyList.getJob(j).getEndTime());
					super.WriteReport(String.format("%15s",readyList.getJob(j).getBurstTime()));
					super.WriteReport(String.format("%17s",readyList.getJob(j).getStartTime()));
					super.WriteReport(String.format("%14s",readyList.getJob(j).getEndTime()));
					if(readyList.getJob(j).getRemainTime() > 0 ){
						System.out.printf("%19s",readyList.getJob(j).getRemainTime());
						super.WriteReport(String.format("%19s",readyList.getJob(j).getRemainTime()));
					}else if(readyList.getJob(j).getRemainTime() == 0 ){
						System.out.printf("%19s",0);
						super.WriteReport(String.format("%19s",0));
						readyList.getJob(j).Finished=true;
					}
					System.out.printf("%19s",readyList.getJob(j).getProcessType() +"\n");
					super.WriteReport(String.format("%19s",readyList.getJob(j).getProcessType() +"\r\n"));
					
					readyList.getJob(j).setBurstTime(readyList.getJob(j).getRemainTime());
					if(readyList.getJob(j).Finished){
						readyList.removeJob(j);
					}
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list.getCurrentTime();
	}

	public void check(ProcessList list){
		/*Checks the main list for process that are less than or equal to 
		 * the current cpu time and add those process to the ready list*/
		for(int i=0;i<mainList.size();i++){
			if(mainList.getJob(i).getArrivalTime()<=list.getCurrentTime()){
				readyList.addJob(mainList.getJob(i));
				mainList.removeJob(i);
			}else{
				list.setCurrentTime(list.getCurrentTime()+1);
			}
		}
	}
}
