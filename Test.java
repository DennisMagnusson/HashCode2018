import java.*;
import java.lang.*;
import java.util.*;
import java.io.*;
import java.nio.*;

public class Test {

  public static void main(String[] args) {

    if(args.length == 0) {
      System.out.println("READ A FILE YOU IDIOT");
    }
    ArrayList<String> lines = new ArrayList<>();
    try {
      FileReader fr = new FileReader(args[0]);
      BufferedReader br = new BufferedReader(fr);
      String line;
      while((line = br.readLine()) != null) {
        lines.add(line);
      }
      br.close();
    } catch(Exception e) {}

    String firstLine = lines.remove(0);
    ArrayList<Ride> data = new ArrayList<>();
    int index = 0;
    for(String line : lines) {
      ArrayList<Integer> a = new ArrayList<>();
      String[] l = line.split(" ");

      int startx = Integer.parseInt(l[0]);
      int starty = Integer.parseInt(l[1]);
      int goalx = Integer.parseInt(l[2]);
      int goaly = Integer.parseInt(l[3]);
      int earliestStart = Integer.parseInt(l[4]);
      int latestFinish = Integer.parseInt(l[5]);

      Ride v = new Ride(index, startx, starty, goalx, goaly, earliestStart, latestFinish);
      data.add(v);
      index++;
    }

    String[] firstLineInts = firstLine.split(" ");
    int rows = Integer.parseInt(firstLineInts[0]);
    int cols = Integer.parseInt(firstLineInts[1]);
    int numVehicles = Integer.parseInt(firstLineInts[2]);
    int numRides = Integer.parseInt(firstLineInts[3]);
    int bonus = Integer.parseInt(firstLineInts[4]);
    int timeSteps = Integer.parseInt(firstLineInts[5]);

    SimulatorBrain brain = new SimulatorBrain(numVehicles, data, timeSteps);

    
    ArrayList<Integer>[] e = new ArrayList[numVehicles]; 
    for(int i = 0; i < numVehicles; i++) {
      e[i] = brain.vehicles[i].history;
    }


    writeToFile(e); 
  }


  public static void writeToFile(ArrayList<Integer>[] a) {
    int q = 1;
    for(ArrayList<Integer> k: a) {
      System.out.print(k.size());
      for(int i : k) {
        System.out.print(" "+i);
      }
      q++;
      System.out.println();
    }
  }
}
