import java.util.*;

public class SimulatorBrain {

  public Vehicle[] vehicles;
  public ArrayList<Ride> listOfRides;
  public int maxTimeSteps;
  public int timeStepsTaken = 0;

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
      for (Vehicle specificCar : vehicles) {
        if (!specificCar.driving) {
          // ASSIGN A RIDE
          if (listOfRides.size() > 0) {
            specificCar.assignRide(listOfRides.get(0));
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
