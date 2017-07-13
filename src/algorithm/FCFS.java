package algorithm;

import Items.List;

public class FCFS {
	
	public FCFS(){
		
	}
	
	public void run(List list){
		for(int i=0;i<list.size();i++){
			if(list.getJob(i).Finished == false){
				if(list.getJob(i).getArrivalTime() > list.getCurrentTime()){
					list.setCurrentTime(list.getJob(i).getArrivalTime());
				}
				list.getJob(i).setStartTime(list.getCurrentTime());
				list.getJob(i).setEndTime(list.getCurrentTime() + list.getJob(i).getBurstTime());
				list.setCurrentTime(list.getJob(i).getEndTime());
				list.getJob(i).Finished = true;
				
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
				System.out.printf("%22s",list.getJob(i).getWaitTime(list.getCurrentTime()));
				System.out.printf("%19s",0);
				System.out.printf("%19s",list.getJob(i).getProcessType() +"\n");
			}
		}
	}
}