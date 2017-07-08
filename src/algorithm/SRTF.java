package algorithm;

import Items.List;

public class SRTF {
	
	public SRTF(List list){
		if(list.size()==2){
			list.getJob(0).setStartTime(0);
			if(list.getJob(0).getBurstTime() > list.getJob(1).getArrivalTime()){
				list.getJob(0).setRemainingTime(list.getJob(0).getBurstTime() - list.getJob(1).getArrivalTime());
				if(list.getJob(0).isShortRemain(list.getJob(1))){
					list.getJob(0).setEndTime(list.getJob(1).getArrivalTime());
					list.setCurrentTime(list.getJob(0).getEndTime());
					list.getJob(0).Finished = true;
				}else{
					
				}
			}
		}
		for(int i=0;i<list.size();i++){
			if(list.getJob(i).Finished == false){
				if(list.getJob(i).getArrivalTime() == 0 && list.size()==1){
					list.getJob(i).setStartTime(0);
				}
				if(list)
			}
		}
	}
}
	
