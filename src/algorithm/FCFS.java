package algorithm;

import Items.ProcessList;
import presentation.ReportWriter;

public class FCFS extends ReportWriter{
	
	public FCFS(){
		super("Report.txt");
	}
	
	public int run(ProcessList list){
		try {
			for(int i=0;i<list.size();i++){
				if(list.getJob(i).getArrivalTime() > list.getCurrentTime()){
					list.setCurrentTime(list.getJob(i).getArrivalTime());
				}
				list.getJob(i).setStartTime(list.getCurrentTime());
				list.getJob(i).setEndTime(list.getCurrentTime() + list.getJob(i).getBurstTime());
				list.setCurrentTime(list.getJob(i).getEndTime());
				list.getJob(i).Finished = true;
				
				System.out.print(list.getJob(i).getProcessId());
				super.WriteReport(String.format(Integer.toString(list.getJob(i).getProcessId())));
				if(list.getJob(i).getProcessId() >= 10){
					System.out.printf("%13s",list.getJob(i).getArrivalTime());
					super.WriteReport(String.format("%13s",list.getJob(i).getArrivalTime()));
				}else{
					System.out.printf("%14s",list.getJob(i).getArrivalTime());
					super.WriteReport(String.format("%14s",list.getJob(i).getArrivalTime()));
				}
				System.out.printf("%15s",list.getJob(i).getBurstTime());
				System.out.printf("%17s",list.getJob(i).getStartTime());
				System.out.printf("%14s",list.getJob(i).getEndTime());
				System.out.printf("%19s",0);
				System.out.printf("%19s",list.getJob(i).getProcessType() +"\n");
				super.WriteReport(String.format("%15s", list.getJob(i).getBurstTime()));
				super.WriteReport(String.format("%17s",list.getJob(i).getStartTime()));
				super.WriteReport(String.format("%14s",list.getJob(i).getEndTime()));
				super.WriteReport(String.format("%19s",0));
				super.WriteReport(String.format("%19s",list.getJob(i).getProcessType() +"\r\n"));
				
				if(list.getJob(i).Finished == true){
					list.removeJob(i);
				}
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list.getCurrentTime();
	}
}