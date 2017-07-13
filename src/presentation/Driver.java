package presentation;

import java.util.Scanner;
import Items.Job;
import Items.List;
import algorithm.FCFS;
import algorithm.RR;
import algorithm.SRTF;
public class Driver {
	
	@SuppressWarnings("unused")
	public static void main(String[] args){
		int time =0;
		int NoOfProcesses;
		FCFS fcfs  = new FCFS();
		SRTF srtf;
		RR rr = new RR();
		Scanner in = new Scanner(System.in);
	
		System.out.println("Enter Number Processes to use: ");
		NoOfProcesses = in.nextInt();
		
		List listofJobs = new List(NoOfProcesses);
		List workingBatchList = new List(NoOfProcesses);
		List workingInteractiveList = new List(NoOfProcesses);
		
		

		for(int i=0 ; i<NoOfProcesses ; i++){
			listofJobs.addJob(new Job(i+1));
        }
		
		listofJobs.OrderedByArrive();
//		listofJobs.showList();
		System.out.println("PID\tArrival Time\tBurst Time\tStart Time\tEnd Time\tTurnaround Time \tWait time\tRemaining Time\tProcess Type");
		for(int j=0;j<NoOfProcesses;j++){
			
//			rr.run(workingList);
//			fcfs.run(workingList);

//			workingList.addJob(listofJobs.getJob(j));
//			srtf = new SRTF(workingList);
//			
			if(listofJobs.getJob(j).getProcessType().equals("Interactive")){
				workingInteractiveList.addJob(listofJobs.getJob(j));
				rr.run(workingInteractiveList);
			}else{
//				workingBatchList.addJob(listofJobs.getJob(j));
//				fcfs.run(workingBatchList);
			}
		}
		in.close();
	}
}