
public class Matrix implements Runnable {	
	
	static int size = 2000;   					//size of the 2D array
	static double m_executionTime = 0.0;		//the time it takes to execute the addition of 2D arrays via the parallel and sequential methods
	
	double m_arrayOne[][] = new double[size][size];		//2D array one
	double m_arrayTwo[][] = new double[size][size];		//2D array two
	static double[][] m_added = new double[size][size];  //the 2D array after the addition
	
	
	//setter method
	//sets the values of m_arrayOne and m_arrayTwo, to 1, 2, 3, 4, 5..... 1999
    void setArray() {
		int number = 0;
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				m_arrayOne[i][j] = number;
				m_arrayTwo[i][j] = number;
			
				number++;
			}
		}
	}
    
    //getter methods
    //returns m_arrayOne[][]
    double[][] getArrayOne(){
    	return m_arrayOne;
    }
    //returns m_arrayTwo[][]
    double[][] getArrayTwo(){
    	return m_arrayTwo;
    }
  
    //methods 
	//sequential method
    //calculates the execution time in ms to add m_arrayOne and m_arrayTwo
    //sets the m_executionTime, and returns the added array
	public static double[][] sequentialAddMatrix(double[][]a, double[][]b){
		double[][] added = new double[size][size];
		
		long startTime = System.currentTimeMillis();
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				added[i][j] = a[i][j] + b[i][j];
			}
		}
		long endTime = System.currentTimeMillis();
		m_executionTime = endTime - startTime;
		
		return added;
	}
	
	//parallel method
	public static double[][] parallelAddMatrix(double[][] a, double[][] b){
		
		//creating two threads
		Thread t1 = new Thread(new Matrix());
		Thread t2 = new Thread(new Matrix());
		
		//starting thread 1
		t1.run();
		
		try {
		t1.join();
			
		}
		catch(Exception ex) {
			System.out.print("Exception thrown\n");
			
		}
		t2.run();	
		
		try {
			t2.join();
		}
		catch(Exception ex) {
			System.out.println("Exception thrown");
		}
		
		return m_added;
	}
	
	
	//validates that the values were added correctly in the sequential and parallel methods
	//returns true if addition was successful
	boolean validateAddedMatrix(double[][] added) {
		boolean valid = true;
		int preAddedValue = 0;
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				if(added[i][j] != (preAddedValue + preAddedValue)) {
					valid = false;
				}
				preAddedValue++;
			}
		}
		
		return valid;
		
	}
	
	//returns the final output results
	//if addition was successful, returns the execution time
	//else returns error
	void finalResults(boolean valid, String executionType) {
		if(valid) {
			System.out.print("The Execution Time for " + executionType + " processing is: " + m_executionTime + " ms\n");
		}
		else {
			System.out.print("Error: failure in initialization of arrays or failure in addition of arrays");
		}
	}

	//called from the parallel method
	@Override
	public void run() {
		setArray();
		
		long startTime = System.currentTimeMillis();
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				m_added[i][j] = getArrayOne()[i][j] + getArrayTwo()[i][j];
			}
		}
		long endTime = System.currentTimeMillis();
		m_executionTime = endTime - startTime;
		
	}

	
	


	
}
 