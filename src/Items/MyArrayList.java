package Items;

public class MyArrayList {
	private static final int SIZE_FACTOR=1;
    private Job data[];
    private int index;
    private int size;
     
    public MyArrayList(int initSize){
        this.data=new Job[initSize];
        this.size=initSize;
    }
    
    public int lenght(){
    	return this.index;
    }
    
    public int size(){
    	return this.size;
    }
    
    public boolean isEmpty(){
		if(this.size == 0){
			return true;
		}
		return false;
	}
    
    public void add(int i, Job process){
    	if(this.index==this.size-1){
             //increase the size of data[]
             increaseSizeAndReallocate();
        }
    	if(i<1 || i>this.size+1){
				System.out.println("Sorry, the position is Invalid\n");
    	}else{
    		for(int j=this.size; j>i-1;j--){
    			this.data[j] = this.data[j-1];
    		}
			this.data[i-1]=process; 	
			this.index++;
		}
    }
     
    public void add(Job process){
        if(this.index==this.size-1){
            //increase the size of data[]
            increaseSizeAndReallocate();
        }
        data[this.index]=process;
        this.index++; 
    }
    
    public void set(int index, Job process){
    	if(index<1 || index>this.size+1){
			System.out.println("Sorry, the position is Invalid\n");
		}else{
			data[index] = process;
		}
    }
     
    private void increaseSizeAndReallocate() {
        this.size=this.size+SIZE_FACTOR;
        Job newData[]=new Job[this.size];
        for(int i=0; i<data.length;i++){
            newData[i]=data[i];
        }
        this.data=newData;
    }
     
    public Job get(int i){
        if(i>this.index-1){
           System.out.println("ArrayIndexOutOfBound");
        }
        if(i<0){
        	 System.out.println("Negative Value");
        }
        return this.data[i];  
    }
     
    public void remove(int i){
        if(i>this.index-1){
       	 System.out.println("ArrayIndexOutOfBound");
        }
        if(i<0){
       	 System.out.println("Negative Value");
        }
        for(int x=i; x<this.data.length-1;x++){
            data[x]=data[x+1];
        }
        this.index--;
    }
}