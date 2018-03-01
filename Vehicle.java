import java.util.*;

public class Vehicle {
  public int posX, posY, stepsNeeded;
  public Ride currentRide;

  public boolean driving = false;
  public boolean gettingToStart;

  public ArrayList<Integer> history; // the index of the ride that this vehicle drove

  public Vehicle() {
    history = new ArrayList<Integer>();
    posX = 0;
    posY = 0;
  }

  public void assignRide(Ride newRide) {
    // add the ride to history if you have not already done so
    if (!driving) {
      history.add(newRide.index);
    }


    currentRide = newRide;
    this.driving = true;

    stepsNeeded = Math.abs(posX - currentRide.startX) + Math.abs(posY - currentRide.startY);
    if (stepsNeeded == 0) {
      stepsNeeded = Math.abs(posX - currentRide.goalX) + Math.abs(posY - currentRide.goalY);
      posX = currentRide.goalX;
      posY = currentRide.goalY;
      gettingToStart = false;
    }
    else {
      posX = currentRide.startX;
      posY = currentRide.startY;
      gettingToStart = true;
    }
  }


  public void aLittleStep() {
    stepsNeeded--;
    if (stepsNeeded == 0){
      if (gettingToStart) {
        gettingToStart = false;
        assignRide(currentRide);
      }
      else {
        driving = false;
      }
    }
  }
}
