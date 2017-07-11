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
		FCFS fcfs;
		SRTF srtf;
		RR rr = new RR();
		Scanner in = new Scanner(System.in);
	
		System.out.println("Enter Number Processes to use: ");
		NoOfProcesses = in.nextInt();
		
		List listofJobs = new List(NoOfProcesses);
		List workingList = new List(NoOfProcesses);

		for(int i=0 ; i<NoOfProcesses ; i++){
			listofJobs.addJob(new Job(i+1));
        }
		
		listofJobs.OrderedByArrive();
//		listofJobs.showList();
	
		for(int j=0;j<NoOfProcesses;j++){
			workingList.addJob(listofJobs.getJob(j));
			rr.run(workingList);
//			workingList.addJob(listofJobs.getJob(j));
//			srtf = new SRTF(workingList);
			
//			if(listofJobs.getJob(j).getProcessType().equals("System")){
//				
//			}else if(listofJobs.getJob(j).getProcessType().equals("Interactive")){
//				
//			}else{
//				workingList.addJob(listofJobs.getJob(j));
//				fcfs = new FCFS(workingList);
//			}
		}
		in.close();
	}
}