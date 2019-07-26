
public class TesterClass {
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		//Task 1
		Matrix matrix = new Matrix();
		matrix.setArray();
		
		System.out.print("Task One: \n\n");
		//sequential execution
		matrix.finalResults(matrix.validateAddedMatrix(matrix.sequentialAddMatrix(matrix.getArrayOne(), matrix.getArrayTwo())), "sequential");
		
		//parallel execution
		matrix.finalResults(matrix.validateAddedMatrix(matrix.parallelAddMatrix(matrix.getArrayOne(), matrix.getArrayTwo())), "parallel");
		
		//Task 2
		System.out.print("\nTask Two: \n\n");
		ReverseThread reverseThread = new ReverseThread();
		reverseThread.createThreads();
	}
	
}
