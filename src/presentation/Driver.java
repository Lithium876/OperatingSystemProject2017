package presentation;

import java.util.Scanner;
import Items.Job;
import Items.ProcessList;
import algorithm.FCFS;
import algorithm.RR;
import algorithm.SRTF;
public class Driver {
	
	public static void main(String[] args){
		int time =0;
		int NoOfProcesses;
		ReportWriter report = new ReportWriter("Report.txt");
		FCFS fcfs  = new FCFS();
		Scanner in = new Scanner(System.in);
	
		/*Accepts number of processes to generate*/
		System.out.println("Enter Number Processes to use: ");
		NoOfProcesses = in.nextInt();
		
		/*Initialize the lists size */
		ProcessList listofJobs = new ProcessList(NoOfProcesses);
		
		ProcessList workingBatchList = new ProcessList(NoOfProcesses);
		ProcessList workingSystemList = new ProcessList(NoOfProcesses);
		ProcessList workingInteractiveList = new ProcessList(NoOfProcesses);
		
		ProcessList tempWorkingInteractiveList = new ProcessList(NoOfProcesses);
		ProcessList tempWorkSystemList = new ProcessList(NoOfProcesses);
		
		/*Add each process to a list of jobs and create a temporary list
		 * for holding interactive and system process types to use*/
		for(int i=0 ; i<NoOfProcesses ; i++){
			listofJobs.addJob(new Job(i+1));
			if(listofJobs.getJob(i).getProcessType().equals("Interactive")){
				tempWorkingInteractiveList.addJob(listofJobs.getJob(i));
			}else if(listofJobs.getJob(i).getProcessType().equals("System")){
				tempWorkSystemList.addJob(listofJobs.getJob(i));
			}
        }
		
		/*Initialize the algorithms with the temp data*/
		SRTF srtf = new SRTF(tempWorkSystemList);
		RR rr = new RR(tempWorkingInteractiveList);

		/*Order the list of jobs by arrival time and display the original PCB*/
		listofJobs.OrderedByArrive();
		listofJobs.showProcessList();
		
		try {
			System.out.println("\nPID\tArrival Time\tBurst Time\tStart Time\tEnd Time\tRemaining Time\tProcess Type");
			report.WriteReport(String.format("\r\nPID\tArrival Time\tBurst Time\tStart Time\tEnd Time\tRemaining Time\tProcess Type\r\n"));

			/*Scheduler*/
			/*There are 3 different lists, these list share list time*/
			for(int j=0;j<NoOfProcesses;j++){
				workingBatchList.setCurrentTime(time);
				workingSystemList.setCurrentTime(time);
				workingInteractiveList.setCurrentTime(time);
			
				if(listofJobs.getJob(j).getProcessType().equals("System")){
					workingSystemList.addJob(listofJobs.getJob(j));
					/*Execute the shortest remaining time first algorithm*/
					time = srtf.run(workingSystemList);
				}else if(listofJobs.getJob(j).getProcessType().equals("Interactive")){
					workingInteractiveList.addJob(listofJobs.getJob(j));
					/*Execute the Round Robin algorithm*/
					time = rr.run(workingInteractiveList);
				}else if(listofJobs.getJob(j).getProcessType().equals("Batch")){
					/*Execute the first come first served algorithm*/
					workingBatchList.addJob(listofJobs.getJob(j));
					time = fcfs.run(workingBatchList);
				}
			}
			srtf.check(workingSystemList);
			/*Close scanner and file writer*/
			in.close();
			report.CloseReport();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
