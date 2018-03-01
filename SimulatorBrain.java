import java.util.*;

public class SimulatorBrain {

  public Vehicle[] vehicles;
  public ArrayList<Ride> listOfRides;
  public int maxTimeSteps;
  public int timeStepsTaken = 0;

  public ArrayList<Integer> distancesOfRides;

  public SimulatorBrain(int numberOfVehicles, ArrayList<Ride> listOfRides, int maxTimeSteps) {
    this.listOfRides = listOfRides;
    this.maxTimeSteps = maxTimeSteps;

    Collections.sort(listOfRides);

    vehicles = new Vehicle[numberOfVehicles];
    for (int i = 0; i < numberOfVehicles; i++) {
      vehicles[i] = new Vehicle();
    }

    run();
  }

  public void run() {
    while (timeStepsTaken < maxTimeSteps) {
      for (specificCar : vehicles) {
        if (!specificCar.driving) {
          // ASSIGN A RIDE
          if (listOfRides.size() > 0) {

            distancesOfRides = new ArrayList<Integer>();
            for (int i = 0; i < listOfRides.size(); i++) {
              int distance = Math.abs(specificCar.posX - listOfRides.get(i).startX) + Math.abs(specificCar.posY - listOfRides.get(i).startY);
              distancesOfRides.add(distance);
            }
            int lowestIndex = 0;
            for (int i = 1; i < listOfRides.size(); i++) {
              if (distancesOfRides.get(i) < distancesOfRides.get(lowestIndex)) {
                lowestIndex = i;
              }
            }

            //specificCar.assignRide(listOfRides.get(0));
            specificCar.assignRide(listOfRides.get(lowestIndex));
            listOfRides.remove(0);

          }
        }
        if (specificCar.driving) {
          if (specificCar.gettingToStart || (!specificCar.gettingToStart && specificCar.currentRide.earliestStart >= timeStepsTaken)) {
            specificCar.aLittleStep();
          }
        }
      }
      timeStepsTaken++;
    }
  }
}
