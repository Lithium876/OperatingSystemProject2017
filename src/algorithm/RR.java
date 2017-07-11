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
		if(list.size()==1){
			list.getJob(0).setStartTime(0);
			if(Quantum >= list.getJob(0).getBurstTime()){
				list.getJob(0).setEndTime(list.getJob(0).getBurstTime());
				list.getJob(0).setRemainingTime(0);
				RunTime = list.getJob(0).getBurstTime();
			}else{
				list.getJob(0).setEndTime(list.getJob(0).getStartTime()+Quantum);
				list.getJob(0).setRemainingTime(list.getJob(0).getRemainTime()-Quantum);
				RunTime = Quantum;
			}
			
			list.setCurrentTime(list.getJob(0).getEndTime());
			System.out.print("Job "+list.getJob(0).getProcessId()+" ");
			System.out.print("Arrived at time "+list.getJob(0).getArrivalTime()+" ");
			System.out.print("with a burst time of "+list.getJob(0).getBurstTime()+" ");
			System.out.print("and ran for "+RunTime+" units of time \n");
			if(list.getJob(0).getRemainTime() > 0){
				System.out.print(">> Remaining Time is "+list.getJob(0).getRemainTime()+"\n\n");
			}else{
				list.getJob(0).Finished=true;
				this.setJobCount();
			}
			n++;
			list.getJob(0).setBurstTime(list.getJob(0).getRemainTime());
		}else{
			for(int i=n;i<list.size();i++){
				if(list.getJob(i).Finished == false){
					if(list.getJob(i).getArrivalTime() > list.getCurrentTime()){
						list.setCurrentTime(list.getJob(i).getArrivalTime());
					}
					list.getJob(i).setStartTime(list.getCurrentTime());
					if(Quantum >= list.getJob(i).getBurstTime()){
						list.getJob(i).setEndTime(list.getJob(i).getBurstTime());
						list.getJob(i).setRemainingTime(0);
						RunTime = list.getJob(i).getBurstTime();
					}else{
						list.getJob(i).setEndTime(list.getJob(i).getStartTime()+Quantum);
						list.getJob(i).setRemainingTime(list.getJob(i).getRemainTime()-Quantum);
						RunTime = Quantum;
					}
				}
				list.setCurrentTime(list.getCurrentTime()+RunTime);
				if(list.getJob(i).getArrivalTime() >= list.getJob(i).getStartTime()){
					System.out.print("Job "+list.getJob(i).getProcessId()+" ");
					System.out.print("Arrived at time "+list.getJob(i).getArrivalTime()+" ");
					System.out.print("with a burst time of "+list.getJob(i).getBurstTime()+" ");
					System.out.print("and ran for "+RunTime+" units of time \n");
				}else{
					System.out.print("Job "+list.getJob(i).getProcessId()+" ");
					System.out.print("Arrived at time "+list.getJob(i).getArrivalTime()+" ");
					System.out.print("with a burst time of "+list.getJob(i).getBurstTime()+" ");
					System.out.print("but started at "+list.getJob(i).getStartTime()+" ");
					System.out.print("and ran for "+RunTime+" units of time \n");
				}
				
				if(list.getJob(i).getRemainTime() > 0){
					System.out.print(">> Remaining Time is "+list.getJob(i).getRemainTime()+"\n\n");
				}else{
					list.getJob(i).Finished=true;
					this.setJobCount();
				}
				n++;
				list.getJob(i).setBurstTime(list.getJob(i).getRemainTime());
			}
		}
		System.out.println("Current Time: "+list.getCurrentTime()+"\n");
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
