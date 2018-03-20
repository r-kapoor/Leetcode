package java1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class S332 {

	public static void main(String[] args) {
//		String[][] tickets = {{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
//		String[][] tickets = {{"JFK","SFO"}, {"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
//		String[][] tickets = {{"EZE","AXA"},{"TIA","ANU"},{"ANU","JFK"},{"JFK","ANU"},{"ANU","EZE"},{"TIA","ANU"},{"AXA","TIA"},{"TIA","JFK"},{"ANU","TIA"},{"JFK","TIA"}};
		String[][] tickets = {{"EZE","TIA"},{"EZE","AXA"},{"AUA","EZE"},{"EZE","JFK"},{"JFK","ANU"},{"JFK","ANU"},{"AXA","TIA"},{"JFK","AUA"},{"TIA","JFK"},{"ANU","EZE"},{"ANU","EZE"},{"TIA","AUA"}};
		List<String> itinerary = findItinerary(tickets);
		System.out.println(itinerary);
	}
	
	public static List<String> findItinerary(String[][] tickets) {
		String startPoint = "JFK";
		HashMap<String, ArrayList<String>> adjEdges = new HashMap<String, ArrayList<String>>();
		for(String[] ticket : tickets){
			ArrayList<String> dests = adjEdges.get(ticket[0]);
			if(dests == null){
				dests = new ArrayList<String>();
				adjEdges.put(ticket[0], dests);
			}
			dests.add(ticket[1]);
		}
		for(String node:adjEdges.keySet()){
			Collections.sort(adjEdges.get(node));
		}
		HashSet<String> coveredTickets = new HashSet<String>();
		List<String> itinerary = dfs(startPoint, coveredTickets, adjEdges, tickets.length);
		return itinerary;
    }

	private static LinkedList<String> dfs(String startPoint, HashSet<String> coveredTickets, HashMap<String, ArrayList<String>> adjEdges, int expectedlength) {
		ArrayList<String> adjs = adjEdges.get(startPoint);
		if(adjs != null){
			int index = 0;
			for(String dest:adjs){
				if(!coveredTickets.contains(startPoint+":"+index)){
					coveredTickets.add(startPoint+":"+index);
					LinkedList<String> itineraryFromHere = dfs(dest, coveredTickets, adjEdges, expectedlength-1);
					if(itineraryFromHere != null && itineraryFromHere.size() == expectedlength){
						itineraryFromHere.addFirst(startPoint);
						return itineraryFromHere;
					}
					coveredTickets.remove(startPoint+":"+index);
				}
				index++;
			}
		}
		if(expectedlength == 0){
			LinkedList<String> itineraryFromHere = new LinkedList<String>();
			itineraryFromHere.add(startPoint);
			return itineraryFromHere;
		}
		return null;
		
	}
}
