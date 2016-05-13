/*
 * Jose Cruz
 * 947074
 * Algorithm Design and Analysis
 * Dijkstra
 * This program finds the shortest path to the vertexes stored in the
 * array 'outputV' and displays it separated by commas ','
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//Driver class, loads the txt file and stores all the weights in a 2d array
public class Driver {
	
	public static void main(String[] args) throws IOException {
		//Opens the buffer to read the file
		BufferedReader br = new BufferedReader(new FileReader("djk.txt"));
		String line;
		final int len = 200;
		String[] tabbed;
		String[] temp;
		int[][] table = new int[len][len];
		int[] outputV = {7, 37, 59, 82, 99, 115, 133, 165, 188, 197};
		while ((line = br.readLine()) != null) {
			
			//Read the pointed line in the txt file, and separate the info
			//to store it in the 2d array.
			tabbed = line.split("\t");
			for (int i = 1; i < tabbed.length; i++){
				temp = tabbed[i].split(",");
				table[Integer.parseInt(tabbed[0]) - 1][Integer.parseInt(temp[0]) - 1] = Integer.parseInt(temp[1]);
			}
						
		}
		br.close(); //Close the buffer.
		
		//Assign the 10000000 weight to every vertex that has no connection to another vertex
		for (int i = 0; i < len; i++){
			for (int j = 0; j < len; j++){
				if (table[i][j] == 0 ){
					table[i][j] = 1000000;
				}
			}
		}
		
		//Create the ShortestPath object and run the Dijkstra method
		ShortestPath sp = new ShortestPath(table);
		sp.dijkstra();
		
		//Print the shortest path to the vertexes in outputV array
		for (int i = 0; i < outputV.length; i++){
			if (i < outputV.length - 1){
				System.out.print(sp.Ws.get(sp.Vs.indexOf(outputV[i])) + ", ");
			}
			else{
				System.out.print(sp.Ws.get(sp.Vs.indexOf(outputV[i])));
			}
		}
		
	}
}
