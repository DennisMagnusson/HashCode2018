import java.util.*;

public class SimulatorBrain {

  public Vehicle[] vehicles;
  public ArrayList<Ride> listOfRides;
  public int maxTimeSteps;

  public SimulatorBrain(int numberOfVehicles, ArrayList<Ride> listOfRides, int maxTimeSteps) {
    this.listOfRides = listOfRides;
    this.maxTimeSteps = maxTimeSteps;
    vehicles = new Vehicle[numberOfVehicles];
    for (int i = 0; i < numberOfVehicles; i++) {
      vehicles[i] = new Vehicle();
    }
  }

  public void run() {
    for (specificCar : vehicles) {
      if (!specificCar.driving) {
        // ASSIGN A RIDE

      }
      if (specificCar.driving) {
        specificCar.aLittleStep();
      }
    }
  }
}
