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
		SRTF srtf;
		RR rr = new RR();
		Scanner in = new Scanner(System.in);
	
		System.out.println("Enter Number Processes to use: ");
		NoOfProcesses = in.nextInt();
		
		ProcessList listofJobs = new ProcessList(NoOfProcesses);
		ProcessList workingBatchList = new ProcessList(NoOfProcesses);
		ProcessList workingInteractiveList = new ProcessList(NoOfProcesses);
		
		for(int i=0 ; i<NoOfProcesses ; i++){
			listofJobs.addJob(new Job(i+1));
        }

		listofJobs.OrderedByArrive();
		listofJobs.showProcessList();
		
		try {
			System.out.println("\nPID\tArrival Time\tBurst Time\tStart Time\tEnd Time\tTurnaround Time \tWait time\tRemaining Time\tProcess Type");
			report.WriteReport(String.format("\r\nPID\tArrival Time\tBurst Time\tStart Time\tEnd Time\tTurnaround Time \tWait time\tRemaining Time\tProcess Type\r\n"));

			for(int j=0;j<NoOfProcesses;j++){
				workingBatchList.setCurrentTime(time);
				workingInteractiveList.setCurrentTime(time);
			
				if(listofJobs.getJob(j).getProcessType().equals("Interactive")){
					workingInteractiveList.addJob(listofJobs.getJob(j));
					time = rr.run(workingInteractiveList);
				}else if(listofJobs.getJob(j).getProcessType().equals("Batch")){
					workingBatchList.addJob(listofJobs.getJob(j));
					time = fcfs.run(workingBatchList);
				}
			}
			rr.Check(workingInteractiveList);
			in.close();
	
			report.CloseReport();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}