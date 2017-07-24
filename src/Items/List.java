package Items;

public class List {
	//SIZE_FACTOR is the value to increase the array by if need be
	private static final int SIZE_FACTOR=1; 
    private Job data[];
    private int length; //Size-1 of the array. How much data in list
    private int size;
     
    /**
     * create an array of Jobs objects
     * @param initSize is the initial size of the array when created
     */
    public List(int initSize){
        this.data=new Job[initSize];
        this.size=initSize;
    }
    
    /**
     * @return the length of the array i.e array size - 1
     */
    public int lenght(){
    	return this.length;
    }
    
    /**
     * @return the size of the array
     */
    public int size(){
    	return this.size;
    }
    
    /**
     * @return true if the array is empty
     */
    public boolean isEmpty(){
		if(this.size == 0){
			return true;
		}
		return false;
	}
   
    /**
     * Add a process to the job object array
     * @param process is the element/process to add to the array
     */
    public void add(Job process){
    	//if the array is out of space
        if(this.length==this.size-1){
            //increase the size of data[]
            increaseSizeAndReallocate();
        }
        data[this.length]=process;
        this.length++; 
    }
    
    /**
     * Replaces the element at the specified position 
       in this list with the specified element.
     * @param i is the position to place the element
     * @param process is the element to placed in the array
     */
    public void set(int index, Job process){
    	if(index>this.size+1){
			System.out.println("Sorry, the position is Invalid\n");
		}else{
			data[index] = process;
		}
    }
    
    /**Increases the array by the SIZE_FACTOR*/
    private void increaseSizeAndReallocate() {
        this.size=this.size+SIZE_FACTOR;
        Job newData[]=new Job[this.size];
        for(int i=0; i<data.length;i++){
            newData[i]=data[i];
        }
        this.data=newData;
    }
    
    /**
     * Get a Job 
     * @param i is the position
     * @return process the element at the specified position in this list.
     */
    public Job get(int i) throws Exception{
//    	System.out.println("\nlength: "+this.length);
        if(i>this.length-1){
        	throw new Exception("Array Index Out Of Bound at index: "+i);
        }
        if(i<0){
        	throw new Exception(i+" is a Negative Value");
        }
        return this.data[i];  
    }
    
   /**
   * method removes the element at the specified position in this list.
   * Shifts any subsequent elements to the left  
   * @param i is the position
   */
   public void remove(int i)throws Exception{
	   //remember to throw exceptions here!
	   if(i>this.length-1){
		   throw new Exception("ArrayIndexOutOfBound");
	   }
	   if(i<0){
		   throw new Exception("Negative Value");
	   }
	   for(int x=i; x<this.data.length-1;x++){
		   data[x]=data[x+1];
       }
	   this.length--;
   }
}