package Items;

public class List {
	
	private MyArrayList mainList;
	private int number;
	private int currentTime = 0;
	 
	public List(int number){
		mainList = new MyArrayList(number);
	    this.number = number; 
	}
	
	public int getCurrentTime(){
		return currentTime;
	}
	
	public void setCurrentTime(int time){
		currentTime = time;
	}
	 
	public Job getJob(int num){
	    return mainList.get(num);
	}
	 
	public void removeJob(int num){
		mainList.remove(num);
	}
	 
	public void addJob(Job job){
		mainList.add(job);  
	}
	 
	public void set(int i , Job job){
		mainList.set(i, job);
	}
	 
	public int size(){
		return mainList.lenght();
	}
	 
	public boolean isEmpty(){
		return (mainList.isEmpty());
	}
	 
	public void clearQueue(){
		for(int i =0 ; i< mainList.size() ; i++){
			mainList.remove(i);
	    }
	}
	 
	public void OrderedByArrive(){
		for(int i=0 ; i<mainList.size()-1 ; i++){
			for(int j=i+1 ; j<mainList.size()-1 ;j++){
				Job j1 = mainList.get(i);
	            Job j2 = mainList.get(j);
	            if(j2.isFirst(j1)){
	            	mainList.set(i, j2);
	                mainList.set(j, j1);
	            }
	       }
	   }
	}
	 
	public void OrderedByShortest(){
		for(int i=0 ; i<mainList.size()-1 ; i++){
			for(int j=i+1 ; j<mainList.size()-1 ;j++){
				Job j1 = mainList.get(i);
				Job j2 = mainList.get(j);
				if(j2.isShort(j1)){
					mainList.set(i, j2);
					mainList.set(j, j1);
	            }
	        }
	    }
	}
	 
	 public void OrderedByShortRemain(){
		 for(int i=0 ; i<mainList.size()-1 ; i++){
			 for(int j=i+1 ; j<mainList.size() ;j++){
				 Job j1 = mainList.get(i);
				 Job j2 = mainList.get(j);
				 if(j2.isShortRemain(j1)){
					 mainList.set(i, j2);
					 mainList.set(j, j1);
	            }
	        }
	    }
	}
	 
	public void showList(){
		if(mainList.isEmpty()){
			System.out.println("Empty Queue"); 
		}else{
			for(int i=0 ; i<mainList.lenght() ; i++){
				Job temp = mainList.get(i);
				System.out.println("ProcessId:\t"+temp.getProcessId());
				System.out.println("ProcessType:\t"+temp.getProcessType());
//				System.out.println("Priority:\t"+temp.getPriority());
		     	System.out.println("ArrivalTime:\t"+temp.getArrivalTime());
		     	System.out.println("BurstTime:\t"+temp.getBurstTime()+"\n");	
		    }
		}
	}
}
