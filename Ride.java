public class Ride {
  public int startX, startY, goalX, goalY, earliestStart, latestFinish;

  public Ride(int startX, int startY, int goalX, int goalY, int earliestStart, int latestFinish) {
    this.startX = startX;
    this.startY = startY;
    this.goalX = goalX;
    this.goalY = goalY;
    this.earliestStart = earliestStart;
    this.latestFinish = latestFinish;
  }
}
