public class StepTracker {
    int targetStep;
    MonthData[] monthToData;

    StepTracker() {
        targetStep = 10000;
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void saveSteps(int userMonth, int userDay, int userSteps) {
        monthToData[userMonth].saveDays(userDay, userSteps);
    }

    int changeTargetStep(int newTargetStep) {
        if (newTargetStep < 0) {
            System.out.println("Новое целевое кол-во шагов не может быть отрицательным. Значение не изменилось.");
            return targetStep;
        } else {
            targetStep = newTargetStep;
            return targetStep;
        }
    }

    void printDaysStatistics(int userMonth) {
        monthToData[userMonth].printDays();
    }

    void getSumSteps(int userMonth) {
        monthToData[userMonth].printSumSteps();
    }

    void getMaxSteps(int userMonth) {
        monthToData[userMonth].printMaxSteps();
    }

    void getAvgSteps(int userMonth) {
        monthToData[userMonth].printAvgSteps();
    }

    void getDistance(int userMonth) {
        monthToData[userMonth].printDistance();
    }

    void getEnergy(int userMonth) {
        monthToData[userMonth].printEnergy();
    }

    void getBestSeries(int userMonth) {
        monthToData[userMonth].printBestSeries(targetStep);
    }
}
