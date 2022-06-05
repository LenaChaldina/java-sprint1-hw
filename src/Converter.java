public class Converter {
    int stepLength;
    int stepEnergy;

    Converter() {
        stepLength = 75;
        stepEnergy = 50;
    }

   int getLength(int countSteps) {
       return countSteps * stepLength/10000; //в км
    }
    int getEnergy(int countSteps) {
        return countSteps * stepEnergy/1000; //в ккал
    }

}
