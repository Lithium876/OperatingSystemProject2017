package presentation;

import java.util.Scanner;
import Items.Job;
import Items.ProcessList;
import algorithm.FCFS;
import algorithm.RR;
import algorithm.SRTF;
public class Driver {
	
	@SuppressWarnings("unused")
	public static void main(String[] args){
		int time =0;
		int NoOfProcesses;
		ReportWriter report = new ReportWriter("Report.txt");
		FCFS fcfs  = new FCFS();
		Scanner in = new Scanner(System.in);
	
		System.out.println("Enter Number Processes to use: ");
		NoOfProcesses = in.nextInt();
		
		ProcessList listofJobs = new ProcessList(NoOfProcesses);
		ProcessList workingBatchList = new ProcessList(NoOfProcesses);
		ProcessList workingSystemList = new ProcessList(NoOfProcesses);
		ProcessList workingInteractiveList = new ProcessList(NoOfProcesses);
		ProcessList tempWorkSystemList = new ProcessList(NoOfProcesses);
		
		for(int i=0 ; i<NoOfProcesses ; i++){
			listofJobs.addJob(new Job(i+1));
			if(listofJobs.getJob(i).getProcessType().equals("System")){
				tempWorkSystemList.addJob(listofJobs.getJob(i));
			}
        }
		tempWorkSystemList.OrderedByArrive();
		SRTF srtf = new SRTF(tempWorkSystemList);
		RR rr = new RR();

		listofJobs.OrderedByArrive();
		listofJobs.showProcessList();
		
		try {
			System.out.println("\nPID\tArrival Time\tBurst Time\tStart Time\tEnd Time\tRemaining Time\tProcess Type");
			report.WriteReport(String.format("\r\nPID\tArrival Time\tBurst Time\tStart Time\tEnd Time\tRemaining Time\tProcess Type\r\n"));

			for(int j=0;j<NoOfProcesses;j++){
				workingBatchList.setCurrentTime(time);
				workingSystemList.setCurrentTime(time);
			
				if(listofJobs.getJob(j).getProcessType().equals("System")){
					workingSystemList.addJob(listofJobs.getJob(j));
					time = srtf.run(workingSystemList);
				}else if(listofJobs.getJob(j).getProcessType().equals("Batch")){
					workingBatchList.addJob(listofJobs.getJob(j));
					time = fcfs.run(workingBatchList);
				}
			}
//			rr.Check(workingInteractiveList);
			in.close();
			report.CloseReport();
		
		}catch(Exception e) {
			
		}
	}
}
