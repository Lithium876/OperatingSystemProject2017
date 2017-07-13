package algorithm;

import Items.List;

public class RR {
	private int Quantum = 2;
	private int RunTime;
	private int ListSize;
	private int JobCount=0;
	private static int n=0;
	
	public RR(){
		ListSize = 0;
		RunTime = 0;
	}
	
	public void run(List list){
		this.setListSize(list.size());
		for(int i=n;i<list.size();i++){
			if(list.getJob(i).Finished == false){
				if(list.getJob(i).getArrivalTime() > list.getCurrentTime()){
					list.setCurrentTime(list.getJob(i).getArrivalTime());
				}
				list.getJob(i).setStartTime(list.getCurrentTime());
				if(Quantum > list.getJob(i).getBurstTime()){
					list.getJob(i).setEndTime(list.getJob(i).getStartTime()+list.getJob(i).getBurstTime());
					list.getJob(i).setRemainingTime(0);
					RunTime = list.getJob(i).getBurstTime();
				}else{
					list.getJob(i).setEndTime(list.getJob(i).getStartTime()+Quantum);
					list.getJob(i).setRemainingTime(list.getJob(i).getRemainTime()-Quantum);
					RunTime = Quantum;
				}
				list.setCurrentTime(list.getCurrentTime()+RunTime);
				System.out.print(list.getJob(i).getProcessId());
				if(list.getJob(i).getProcessId() >= 10){
					System.out.printf("%13s",list.getJob(i).getArrivalTime());
				}else{
					System.out.printf("%14s",list.getJob(i).getArrivalTime());
				}
				System.out.printf("%15s",list.getJob(i).getBurstTime());
				System.out.printf("%17s",list.getJob(i).getStartTime());
				System.out.printf("%14s",list.getJob(i).getEndTime());
				System.out.printf("%19s",list.getJob(i).getTurnaround(list.getCurrentTime()));
				System.out.printf("%22s",list.getJob(i).getWaitTimeRoundRobin(list.getCurrentTime()));
				if(list.getJob(i).getRemainTime() > 0 ){
					System.out.printf("%19s",list.getJob(i).getRemainTime());
				}else{
					System.out.printf("%19s",0);
					list.getJob(i).Finished=true;
					this.setJobCount();
				}
				System.out.printf("%19s",list.getJob(i).getProcessType() +"\n");
				list.getJob(i).setBurstTime(list.getJob(i).getRemainTime());
				n++;
			}
		}
	}
	
	public void setJobCount(){
		JobCount++;
	}
	
	public int getJobCount(){
		return JobCount;
	}
	
	public void setListSize(int size){
		this.ListSize = size;
	}
	
	public int getListSize(){
		return this.ListSize;
	}
}
