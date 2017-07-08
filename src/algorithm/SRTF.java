package algorithm;

import Items.List;

public class SRTF {
	
	public SRTF(List list){
		for(int i=0;i<list.size();i++){
			if(list.getJob(i).Finished == false){
				if(list.getJob(i).getArrivalTime() == 0 && list.size()==1){
					list.getJob(i).setStartTime(0);
				}
				for(int j=1;j<=list.getJob(i).getBurstTime();j++){
					list.getJob(i).setRemainingTime(list.getJob(i).getRemainTime()-1);
					
				}
//				if(list)
			}
		}
	}
}
	
