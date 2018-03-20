package java1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Packing {
	
	public static void main(String args[]) throws IOException{
		File f = new File("/home/rkapoor/Documents/Code/Input.txt");
		FileWriter fw = new FileWriter("/home/rkapoor/Documents/Code/PracticeOutput.txt");
		PrintWriter pw = new PrintWriter(fw);
		BufferedReader b = new BufferedReader(new FileReader(f));

        String readLine = "";

        String line1 = b.readLine();
        String[] lineSplit = line1.split(":");
        int numberOfSlots = Integer.parseInt(lineSplit[0]);
        boolean emptySlotsRemove = Boolean.parseBoolean(lineSplit[1]);
        boolean nodeStart = false;
        boolean nodesStart = false;
        ArrayList<ArrayList<String>> listOfNodes = new ArrayList<ArrayList<String>>();
        int outputNodeCount = 0, inputNodeCount = 0, outputEmptySlot = 0, inputEmptySlot = 0;
        int currentSlots = 0;
        ArrayList<String> slots = new ArrayList<String>();
        while ((readLine = b.readLine()) != null) {
//            System.out.println(readLine);
            readLine = readLine.trim();
            if(readLine.equals("[")){
            	if(!nodesStart){
            		nodesStart = true;
            		continue;
            	}
            	if((!nodeStart)){
            		nodeStart = true;
            	}
            	continue;
            }
            if(readLine.equals("]")){
            	if(nodeStart){
            		nodeStart = false;
            		inputNodeCount++;
            	}
            	else{
            		nodesStart = false;
            		if(currentSlots > 0){
            			while(currentSlots < numberOfSlots){
            				slots.add("");
            				currentSlots++;
            				outputEmptySlot++;
            			}
            			listOfNodes.add(slots);
                		outputNodeCount++;
            		}
            		break;
            	}
            	continue;
            }
            if(readLine.equals("")){
            	//Empty
            	inputEmptySlot++;
            	if(emptySlotsRemove){
            		continue;
            	}
            	outputEmptySlot++;
            }
            slots.add(readLine);
        	currentSlots++;
            if(currentSlots == numberOfSlots){
            	listOfNodes.add(slots);
            	slots = new ArrayList<String>();
            	outputNodeCount++;
            	currentSlots = 0;
            }
        }
        System.out.println(outputNodeCount);
        System.out.println(inputNodeCount);
        pw.write(outputNodeCount+"\n");
        pw.write(outputNodeCount - inputNodeCount+"\n");
        pw.write(outputEmptySlot - inputEmptySlot+"\n");
        pw.write(outputEmptySlot+"\n");
        pw.write("[\n");
        for(ArrayList<String> node:listOfNodes){
        	pw.write("[\n");
        	for(String slot:node){
        		fw.write(slot+"\n");
        	}
        	pw.write("]\n");
        }
        pw.write("]\n");
        pw.close();
	}

}
