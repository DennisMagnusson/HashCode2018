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


    ArrayList<Vehicle> data = new ArrayList<>();
    for(String line : lines) {
      ArrayList<Integer> a = new ArrayList<>();
      String[] l = line.split(" ");

      Vehicle v = new Vehicle();
      v.posX = Integer.parseInt(l[0]);
      v.posY = Integer.parseInt(l[1]);
      v.assignGoal(Integer.parseInt(l[2]), Integer.parseInt(l[3]), Integer.parseInt(l[4]));
      
      data.add(v);
    }
    System.out.println(data);
  }

}
