import java.util.*;

public class SimulatorBrain {

  public Vehicle[] vehicles;
  public ArrayList<Ride> listOfRides;
  public int maxTimeSteps;
  public int timeStepsTaken = 0;
  public int bonusReward;

  public ArrayList<Integer> rewardsOfRides;
  public ArrayList<Integer> timeForRides;
  public ArrayList<Double> rewardPerTimeStep;

  public SimulatorBrain(int numberOfVehicles, ArrayList<Ride> listOfRides, int maxTimeSteps, int bonusReward) {
    this.listOfRides = listOfRides;
    this.maxTimeSteps = maxTimeSteps;
    this.bonusReward = bonusReward;

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


            rewardsOfRides = new ArrayList<>();
            timeForRides = new ArrayList<>();
            rewardPerTimeStep = new ArrayList<>();

            for (int i = 0; i < listOfRides.size(); i++) {
              int currentTimeTaken = 0;
              int currentReward = 0;

              // getting to the starting point
              currentTimeTaken += (Math.abs(specificCar.posX - listOfRides.get(i).startX) + Math.abs(specificCar.posY - listOfRides.get(i).startY)); // distance to start
              if (currentTimeTaken + timeStepsTaken <= listOfRides.get(i).earliestStart) {
                currentReward += bonusReward;
                currentTimeTaken = listOfRides.get(i).earliestStart - timeStepsTaken;
              }

              // getting to the finishing point
              int distanceOfTravel = Math.abs(listOfRides.get(i).goalX - listOfRides.get(i).startX) + Math.abs(listOfRides.get(i).goalY - listOfRides.get(i).startY);
              currentTimeTaken += distanceOfTravel;
              currentReward += distanceOfTravel;
              if (currentTimeTaken + timeStepsTaken > listOfRides.get(i).latestFinish) {
                currentReward = 0;
              }

              double currentRewardPerTimeStep = (double)currentReward / (double)currentTimeTaken;
              rewardPerTimeStep.add(currentRewardPerTimeStep);


              ridesConsidered = new ArrayList<>();
              ridesConsidered.add(i);

              currentReward += rewardOfRide(specificCar, 2, timeStepsTaken + currentTimeTaken);

              rewardsOfRides.add(currentReward);

            }


            int highestIndex = 0;
            for (int i = 1; i < listOfRides.size(); i++) {
              if (rewardPerTimeStep.get(i) > rewardPerTimeStep.get(highestIndex)) {
                highestIndex = i;
              }
            }

            specificCar.assignRide(listOfRides.get(highestIndex));
            listOfRides.remove(highestIndex);
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



  public ArrayList<Integer> ridesConsidered;

  public double rewardOfRide(Vehicle specificCar, int depthLeft, int startTime) {
    double highestRewardPerTimeStep = 0;
    double highestReward = 0;

    if (depthLeft != 0) {
      for (int i = 0; i < listOfRides.size(); i++) {
        if (ridesConsidered.contains(i)) {
          continue;
        }

        int currentTimeTaken = 0;
        int currentReward = 0;

        // getting to the starting point
        currentTimeTaken += (Math.abs(specificCar.posX - listOfRides.get(i).startX) + Math.abs(specificCar.posY - listOfRides.get(i).startY)); // distance to start
        if (currentTimeTaken + startTime <= listOfRides.get(i).earliestStart) {
          currentReward += bonusReward;
          currentTimeTaken = listOfRides.get(i).earliestStart - startTime;
        }

        // getting to the finishing point
        int distanceOfTravel = Math.abs(listOfRides.get(i).goalX - listOfRides.get(i).startX) + Math.abs(listOfRides.get(i).goalY - listOfRides.get(i).startY);
        currentTimeTaken += distanceOfTravel;
        currentReward += distanceOfTravel;
        if (currentTimeTaken + startTime > listOfRides.get(i).latestFinish) {
          currentReward = 0;
        }

        double currentRewardPerTimeStep = (double)currentReward / (double)currentTimeTaken;

        ridesConsidered.add(i);
        currentReward += rewardOfRide(specificCar, depthLeft - 1, startTime + currentTimeTaken);
        ridesConsidered.remove(ridesConsidered.size() - 1);

        if (currentReward > highestReward) {
          highestReward = currentReward;
        }

        //if (currentRewardPerTimeStep > highestRewardPerTimeStep) {
        //  highestRewardPerTimeStep = currentRewardPerTimeStep;
        //}
      }
    }

    return highestReward;
  }
}
