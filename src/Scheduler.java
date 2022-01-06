/* Thomas Latona
 * CPU Scheduling Program
 * 4/23/2021
 */

import java.util.*;

public class Scheduler {
	
	//method for firsts come first serve 
	//runs processes in order of arrival
	public static void fcfs(ArrayList<Process> processes) {
		
		int turnaroundTime = 0;
		int ttAvg = 0; //turn-around time average
		
		System.out.println("First Come First Serve Algorithm:\n");
		System.out.println("Order of processes:");
		
		for(Process p : processes) {
			System.out.println("PID: "+p.getPid());
			
			//increment wait time
			while(p.getArrivalTime() > p.getWaitTime()) {
				p.waiting();
			}
			System.out.println("\tWait Time: "+p.getWaitTime());
			
			turnaroundTime = p.getWaitTime() + p.getBurstTime();
			System.out.println("\tTurnaround Time: "+ turnaroundTime+"\n");
			ttAvg+=turnaroundTime;
		}
		System.out.println("Average wait time: "+avgWait(processes));
		System.out.println("Average turnaround time: "+ttAvg/10);
		System.out.println("\n\n");
		
	}
	
	//method for priority
	//runs processes in order of priority
	public static void priority(ArrayList<Process> processes) {
		
		System.out.println("Priority Algorithm:\n");
		
		int turnaroundTime = 0;
		int ttAvg = 0;

		//sort arraylist by priority value
		Collections.sort(processes, 
                (o1, o2) -> Integer.compare(o1.getPriority(), o2.getPriority()));
		
		for(Process x : processes) {
			turnaroundTime = x.getBurstTime()+x.getWaitTime();
			ttAvg += turnaroundTime;
			System.out.println("PID: "+x.getPid());
			System.out.println("\tBurst Time: "+x.getBurstTime());
			System.out.println("\tArrival Time: "+x.getArrivalTime());
			System.out.println("\tPriority: "+x.getPriority());
			
			System.out.println("\tWait Time: "+x.getWaitTime());
			System.out.println("\tTurnaround Time: "+ turnaroundTime);
			System.out.println();
		}
		
		System.out.println("Average wait time: " + avgWait(processes));
		System.out.println("Average turnaround time: " + ttAvg/10);
		
	}
	
	public static int avgWait(ArrayList<Process> x) {
		int avg = 0;
		for(Process p : x) {
			avg += p.getWaitTime();
		}
		return avg/10;
	}
	
}