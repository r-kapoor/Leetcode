package java1;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {


	public static void main(String args[]) throws ParseException {

		Scanner sc = new Scanner(System.in);
		String[] logLines = {"10.10.10.10 - - [27/Sep/2016:05:22:00 +0000] \"GET /1.1/friendships/list.json?user_id=123 HTTP/1.1\" 500 563 19 \"Twitter-iPhone/6.63 iOS/10.2.2 (Apple;iPhone7,2;;;;;1)\" 177.177.177.177",
		                   "10.10.10.10 - - [27/Sep/2016:05:22:08 +0000] \"GET /1.1/friendships/list.json?user_id=123 HTTP/1.1\" 200 563 19 \"Twitter-iPhone/6.63 iOS/10.2.2 (Apple;iPhone7,2;;;;;1)\" 177.177.177.177",
		                   "10.10.10.10 - - [27/Sep/2016:05:22:31 +0000] \"GET /1.1/friendships/list.json HTTP/1.1\" 200 563 19 \"Twitter-iPhone/6.63 iOS/10.0.2 (Apple;iPhone7,2;;;;;1)\" 177.177.177.177",
		                   "10.10.10.10 - - [27/Sep/2016:05:22:59 +0000] \"GET /1.1/friendships/list.json HTTP/1.1\" 200 94 6 \"Twitter-iPhone/6.63 iOS/10.0.1 (Apple;iPhone7,2;;;;;1)\" 177.177.177.177",
		                   "10.10.10.10 - - [27/Sep/2016:05:23:01 +0000] \"GET /1.1/users/show.json?include_entities=1&user=123 HTTP/1.1\" 200 94 6 \"Twitter-iPhone/6.63 iOS/10.0.1 (Apple;iPhone7,2;;;;;1)\" 177.177.177.177",
		                   "10.10.10.10 - - [27/Sep/2016:22:45:33 +0000] \"GET /1.1/friendships/list.json?user_id=234 HTTP/1.1\" 200 94 6 \"Twitter-iPhone/6.63 iOS/10.0.1 (Apple;iPhone7,2;;;;;1)\" 177.177.177.177",
		                   "10.10.10.10 - - [27/Sep/2016:22:45:51 +0000] \"GET /1.1/friendships/create.json HTTP/1.1\" 200 94 6 \"Twitter-iPhone/6.63 iOS/10.0.1 (Apple;iPhone7,2;;;;;1)\" 177.177.177.177"};
		
		ArrayList<String> endPoints = new ArrayList<String>();
		HashMap<String, Integer> successCounts = new HashMap<String, Integer>();
		HashMap<String, Integer> failureCounts = new HashMap<String, Integer>();
		SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss Z");
		SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		outputDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
		Pattern pattern = Pattern.compile(".* - - \\[(.*)\\] \\\"[A-Z]* (.*) .*\\\" ([0-9]*) .*");
		Date currentDate = new Date(0);
		String currentDateString = outputDateFormat.format(currentDate);
//		for(String line : logLines){
		while(sc.hasNext()){
			String line = sc.nextLine();
			if(line.equals("")){
				break;
			}
			Matcher matcher = pattern.matcher(line);
			if(matcher.find()){
				String timeString = extractTimeString(line,  matcher);
				String newEndPoint = extractEndPoint(line, matcher);
				String responseCode = extractResponseCode(line, matcher);
				Date date = inputDateFormat.parse(timeString);
				String newDateString = outputDateFormat.format(date);
				if(!currentDateString.equals(newDateString)){
					//New minute. Output all calls from the current time 
					Collections.sort(endPoints);
					for(String endPoint : endPoints){
						int successCount = successCounts.containsKey(endPoint)?(successCounts.get(endPoint)):0;
						int failureCount = failureCounts.containsKey(endPoint)?failureCounts.get(endPoint):0;
						double successPercent = (successCount*100.0)/(successCount+failureCount);
						System.out.println(currentDateString+" "+endPoint+" "+String.format("%.2f", successPercent));
					}
					endPoints.clear();
					successCounts.clear();
					failureCounts.clear();
				}
				currentDateString = newDateString;
				if(!endPoints.contains(newEndPoint)){
					endPoints.add(newEndPoint);
				}
				if(isSuccess(responseCode)){
					int count = 1;
					if(successCounts.containsKey(newEndPoint)){
						count += successCounts.get(newEndPoint);
					}
					successCounts.put(newEndPoint, count);
				}
				else{
					int count = 1;
					if(failureCounts.containsKey(newEndPoint)){
						count += failureCounts.get(newEndPoint);
					}
					failureCounts.put(newEndPoint, count);
				}
			}
			else{
				break;
			}
		}
		Collections.sort(endPoints);
		for(String endPoint : endPoints){
			int successCount = successCounts.containsKey(endPoint)?(successCounts.get(endPoint)):0;
			int failureCount = failureCounts.containsKey(endPoint)?failureCounts.get(endPoint):0;
			double successPercent = (successCount*100.0)/(successCount+failureCount);
			System.out.println(currentDateString+" "+endPoint+" "+String.format("%.2f", successPercent));
		}
	}
	
	public static String extractTimeString(String line, Matcher matcher){
		return matcher.group(1);
	}
	
	public static String extractEndPoint(String line, Matcher matcher){
		return matcher.group(2).split("\\?")[0];
		
	}
	
	public static String extractResponseCode(String line, Matcher matcher){
		return matcher.group(3);
	}
	
	public static boolean isSuccess(String responseCode){
		return responseCode.charAt(0) == '2';
	}
}
