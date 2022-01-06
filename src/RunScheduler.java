/* Thomas Latona
 * CPU Scheduling Program (RUN CLASS)
 * 4/23/2021
 */

import java.util.*;

public class RunScheduler {

	public static void main(String[] args) {
		
		//create arraylist and fill it with demo variables (for simulation)
		ArrayList<Process> x = new ArrayList<Process>();
		x.add(new Process(451, 4, 1, 3));
		x.add(new Process(322, 7, 2, 2));
		x.add(new Process(763, 3, 3, 4));
		x.add(new Process(534, 3, 4, 9));
		x.add(new Process(245, 4, 5, 7));
		x.add(new Process(636, 7, 6, 1));
		x.add(new Process(247, 3, 7, 10));
		x.add(new Process(538, 3, 8, 8));
		x.add(new Process(539, 3, 9, 6));
		x.add(new Process(210, 3, 10, 5));
		
		Scheduler.fcfs(x); //will output order, wait time, turn-around time. and averages
		Scheduler.priority(x); //does the same thing but with priority algorithm
	}
}
