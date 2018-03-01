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
    for(String line : lines) {
      ArrayList<Integer> a = new ArrayList<>();
      String[] l = line.split(" ");

      int startx = Integer.parseInt(l[0]);
      int starty = Integer.parseInt(l[1]);
      int goalx = Integer.parseInt(l[2]);
      int goaly = Integer.parseInt(l[3]);
      int earliestStart = Integer.parseInt(l[4]);
      int latestFinish = Integer.parseInt(l[5]);

      Ride v = new Ride(startx, starty, goalx, goaly, earliestStart, latestFinish);
      
      data.add(v);
    }

    //writeToFile(a); 
  }


  public static void writeToFile(ArrayList<Integer>[] a) {
    for(ArrayList<Integer> k: a) {
      for(int i : k) {
        System.out.print(i+" ");
      }
      System.out.println();
    }
  }

}
