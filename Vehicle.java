public class Vehicle {
  public int stepsNeeded, posX, posY, earliestStart;
  public boolean driving = false;

  public Vehicle() {
    posX = 0;
    posY = 0;
  }

  public void assignGoal(int goalX, int goalY, earliestStart) {
    stepsNeeded = Math.abs(goalX - posX) + Math.abs(goalY - posY);
    posX = goalX;
    posY = goalY;
    this.earliestStart = earliestStart;
  }


  public void aLittleStep() {
    stepsNeeded--;
    if (stepsNeeded == 0){
      driving = false;
    }
  }
}
