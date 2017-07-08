package algorithm;

import Items.List;

public class RR {
	private int Quantum = 2;
	
	public RR(List list){
		if(list.size()==1){
			list.getJob(0).setStartTime(0);
			list.getJob(0).setEndTime(list.getJob(0).getStartTime()+Quantum);
			list.getJob(0).setRemainingTime(list.getJob(0).getRemainTime()-Quantum);
			System.out.print("Job "+list.getJob(0).getProcessId()+" ");
			System.out.print("Arrived at time "+list.getJob(0).getArrivalTime()+" ");
			System.out.print("with a burst time of "+list.getJob(0).getBurstTime()+" ");
			System.out.print("and ran for "+list.getJob(0).getEndTime()+" units of time \n");
			if(list.getJob(0).getRemainTime() > 0){
				System.out.print("Remaining Time is "+list.getJob(0).getRemainTime()+"\n\n");
			}else{
				list.getJob(0).Finished=true;
			}
		}else{
			for(int i=0;i<list.size();i++){
				if(list.getJob(i).Finished == false){
					list.getJob(i).setStartTime(list.getCurrentTime());
					list.getJob(i).setEndTime(list.getJob(i).getStartTime()+Quantum);
					list.getJob(i).setRemainingTime(list.getJob(i).getRemainTime()-Quantum);
				}
				System.out.print("Job "+list.getJob(i).getProcessId()+" ");
				System.out.print("Arrived at time "+list.getJob(i).getArrivalTime()+" ");
				System.out.print("with a burst time of "+list.getJob(i).getBurstTime()+" ");
				System.out.print("and ran for "+list.getJob(i).getEndTime()+" units of time \n");
				if(list.getJob(i).getRemainTime() > 0){
					System.out.print(">> Remaining Time is "+list.getJob(i).getRemainTime()+"\n\n");
				}else{
					list.getJob(i).Finished=true;
				}
			}
		}
	}
}
