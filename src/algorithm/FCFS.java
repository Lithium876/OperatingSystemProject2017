package algorithm;

import Items.List;

public class FCFS {
	
	public FCFS(List list){
	
		if(list.size()==1){
			list.getJob(0).setStartTime(0);
			list.getJob(0).setEndTime(list.getJob(0).getBurstTime());
			list.setCurrentTime(list.getJob(0).getEndTime());
			list.getJob(0).Finished = true;
			System.out.print("Job "+list.getJob(0).getProcessId()+" ");
			System.out.print("Arrived at time "+list.getJob(0).getArrivalTime()+" ");
			System.out.print("and ran for "+list.getJob(0).getBurstTime()+" units of time\n");
		}else{
			for(int i=0;i<list.size();i++){
				if(list.getJob(i).Finished == false){
					if(list.getJob(i).getArrivalTime() > list.getCurrentTime()){
						list.setCurrentTime(list.getJob(i).getArrivalTime());
					}
					list.getJob(i).setStartTime(list.getCurrentTime());
					list.getJob(i).setEndTime(list.getCurrentTime() + list.getJob(i).getBurstTime());
					list.setCurrentTime(list.getJob(i).getEndTime());
					list.getJob(i).Finished = true;

					if(list.getJob(i).getArrivalTime() >= list.getJob(i).getStartTime()){
						System.out.print("Job "+list.getJob(i).getProcessId()+" ");
						System.out.print("Arrived at time " +list.getJob(i).getArrivalTime()+" ");
						System.out.print("and ran for "+list.getJob(i).getBurstTime()+" units of time\n");
					}else{
						System.out.print("Job "+list.getJob(i).getProcessId()+" ");
						System.out.print("Arrived at time "+list.getJob(i).getArrivalTime()+" ");
						System.out.print("but started at "+list.getJob(i).getStartTime()+" ");
						System.out.print("and ran for "+list.getJob(i).getBurstTime()+" units of time\n");
					}
					System.out.println("Turn Around Time: "+list.getJob(i).getTurnaround(list.getCurrentTime()));
					System.out.println("Waiting Time: "+list.getJob(i).getWaitTime(list.getCurrentTime()));
				}
				
			}
		}
		System.out.println("Current Time: "+list.getCurrentTime()+"\n");
	}
}
