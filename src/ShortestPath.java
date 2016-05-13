import java.util.ArrayList;


public class ShortestPath {
	
	//Global variables for the Shortest path class.
	int[][] table; //2d array for the weights
	int l; // length of the 2d array
	ArrayList<Integer> Vs = new ArrayList<Integer>(); //Shortest path vertexes
	ArrayList<Integer> Ws = new ArrayList<Integer>(); //Shortest paths
	
	//Constructor
	public ShortestPath(int[][] t){
		
		table = t;
		l = table.length;
		
	}
	
	//Method to find the shortest path
	public void dijkstra (){
		
		//Variables needed for the method
		int vnear = 0, min, weightSum = 0;
		int[] touch = new int[l];
		int[] length = new int[l];
		
		//Add vertex 1 with weight 0 since we start at that vertex
		Vs.add(1);
		Ws.add(0);
		
		//Initialize the vertexes and its lengths with the first vertex
		for (int i = 1; i < l; i++){
			touch[i] = 0;
			length[i] = table[0][i];
		}
		
		
		for (int i = 0; i < l -1; i++){
			//Initialize the minimum weight on a high number to find the 
			//shortest path to the rest of the vertexes
			min = 999999999;
			for (int j = 1; j < l; j++){
				if(length[j] >= 0){
					if (length[j] <= min){
						min = length[j];
						vnear = j;
					}
				}
			}
			
			//Set up the shortest paths to and from the vertexes given the
			//shortest path just found. 
			for(int j = 1; j < l; j++){
				if (table[vnear][j] >= 0){
					weightSum = min + table[vnear][j];
					if (weightSum < length[j]){
						length[j] = weightSum;
						touch[j] = vnear;
					}
				}
			}
			
			//Adding the found vertex and its path to the arraylists
			Vs.add(vnear + 1);
			Ws.add(length[vnear]);
			length[vnear] = -1;
		}
	}
}
