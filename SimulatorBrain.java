import java.util.*;

public class SimulatorBrain {

  public Vehicle[] vehicles;
  public ArrayList<Ride> listOfRides;

  public SimulatorBrain(int numberOfVehicles, ArrayList<Ride> listOfRides) {
    this.listOfRides = listOfRides;
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
