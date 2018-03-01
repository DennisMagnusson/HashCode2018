public class Vehicle {
  public int stepsNeeded, posX, posY, startX, startY, goalX, goalY, earliestStart;
  public boolean driving = false;
  public boolean gettingToStart;

  public Vehicle() {
    posX = 0;
    posY = 0;
  }

  public void assignRide(int startX, int startY, int goalX, int goalY, int earliestStart) {
    this.driving = true;
    this.startX = startX;
    this.startY = startY;
    this.goalX = goalX;
    this.goalY = goalY;
    this.earliestStart = earliestStart;

    stepsNeeded = Math.abs(posX - startX) + Math.abs(posY - startY);
    if (stepsNeeded == 0) {
      stepsNeeded = Math.abs(posX - goalX) + Math.abs(posY - goalY);
      posX = goalX;
      posY = goalY;
      gettingToStart = false;
    }
    else {
      posX = startX;
      posY = startY;
      gettingToStart = true;
    }
  }


  public void aLittleStep() {
    stepsNeeded--;
    if (stepsNeeded == 0){
      if (gettingToStart) {
        gettingToStart = false;
        assignRide(startX, startY, goalX, goalY, earliestStart);
      }
      else {
        driving = false;
      }
    }
  }
}
