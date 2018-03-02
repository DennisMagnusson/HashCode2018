 public class Ride implements Comparable<Ride>{
  public int startX, startY, goalX, goalY, earliestStart, latestFinish, index;

  public Ride(int index, int startX, int startY, int goalX, int goalY, int earliestStart, int latestFinish) {
    this.startX = startX;
    this.startY = startY;
    this.goalX = goalX;
    this.goalY = goalY;
    this.earliestStart = earliestStart;
    this.latestFinish = latestFinish;
    this.index = index;
  }

  @Override
  public int compareTo(Ride otherRide) {
    return this.earliestStart - otherRide.earliestStart;
  }
}
