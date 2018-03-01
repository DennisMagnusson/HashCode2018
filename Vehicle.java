public class Vehicle {
  public int posX, posY, stepsNeeded;
  public Ride currentRide;

  public boolean driving = false;
  public boolean gettingToStart;

  public Vehicle() {
    posX = 0;
    posY = 0;
  }

  public void assignRide(Ride newRide) {
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
