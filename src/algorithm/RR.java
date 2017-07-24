package algorithm;

import java.io.IOException;

import Items.ProcessList;
import presentation.ReportWriter;

public class RR extends ReportWriter{
	private int Quantum = 2;
	private int RunTime;
	private int JobCount;
	private static int n=0;
	
	public RR(){
		super("Report.txt");
		RunTime = 0;
		JobCount =0;
	}
	
	public int run(ProcessList list){
		try {
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
					super.WriteReport(String.format("%15s",list.getJob(i).getBurstTime()));
					super.WriteReport(String.format("%17s",list.getJob(i).getStartTime()));
					super.WriteReport(String.format("%14s",list.getJob(i).getEndTime()));
					if(list.getJob(i).getRemainTime() > 0 ){
						System.out.printf("%19s",list.getJob(i).getRemainTime());
						super.WriteReport(String.format("%19s",list.getJob(i).getRemainTime()));
					}else if(list.getJob(i).getRemainTime() == 0 ){
						System.out.printf("%19s",0);
						super.WriteReport(String.format("%19s",0));
						list.getJob(i).Finished=true;
						JobCount++;
					}
					System.out.printf("%19s",list.getJob(i).getProcessType() +"\n");
					super.WriteReport(String.format("%19s",list.getJob(i).getProcessType() +"\r\n"));

					list.getJob(i).setBurstTime(list.getJob(i).getRemainTime());
					n++;
				}
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		return list.getCurrentTime();
	}
	
	public void Check(ProcessList list){
		while(this.getJobCount() != list.size()){
		this.n=0;
		this.run(list);
		}
	}
	
	public int getJobCount(){
		return JobCount;
	}
}
