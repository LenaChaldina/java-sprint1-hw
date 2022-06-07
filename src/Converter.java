public class Converter {
    static final int STEP_LENGTH = 75;
    static final int STEP_ENERGY = 50;


    static int getLength(int countSteps) {
        return countSteps * STEP_LENGTH / 10000; //в км
    }

    static int getEnergy(int countSteps) {
        return countSteps * STEP_ENERGY / 1000; //в ккал
    }

}
