import java.util.*;

public class SimulatorBrain {

  public Vehicle[] vehicles;
  public ArrayList<Ride> listOfRides;
  public int maxTimeSteps;

  public SimulatorBrain(int numberOfVehicles, ArrayList<Ride> listOfRides, int maxTimeSteps) {
    this.listOfRides = listOfRides;
    this.maxTimeSteps = maxTimeSteps;

    Collections.sort(listOfRides);

    vehicles = new Vehicle[numberOfVehicles];
    for (int i = 0; i < numberOfVehicles; i++) {
      vehicles[i] = new Vehicle();
    }
  }

  public void run() {
    for (specificCar : vehicles) {
      if (!specificCar.driving) {
        // ASSIGN A RIDE
        if (listOfRides.size() > 0) {
          specificCar.assignRide(listOfRides.get(0));
          listOfRides.remove(0);
        }
      }
      if (specificCar.driving) {
        specificCar.aLittleStep();
      }
    }
  }
}
