public class MonthData {
    int[] DateToStep;
    //в месяце 30 дней
    static final int LENGTH_MONTH = 30;

    MonthData() {   //в месяце 30 дней
        DateToStep = new int[LENGTH_MONTH];

    }

    //Converter converter = new Converter();
    void saveDays(int userDay, int userSteps) {
        DateToStep[userDay] = userSteps;
    }

    void printDays() {
        for (int i = 0; i < LENGTH_MONTH; i++) {
            if (i == LENGTH_MONTH - 1) {
                System.out.println((i + 1) + " день: " + DateToStep[i]);
            } else {
                System.out.print((i + 1) + " день: " + DateToStep[i] + ", ");
            }
        }
    }

    void printSumSteps() {
        int sumSteps = 0;
        for (int i = 0; i < LENGTH_MONTH; i++) {
            sumSteps = sumSteps + DateToStep[i];
        }
        System.out.println("Общее количество шагов за месяц: " + sumSteps);
    }

    int getSumSteps() {
        int sumSteps = 0;
        for (int i = 0; i < LENGTH_MONTH; i++) {
            sumSteps = sumSteps + DateToStep[i];
        }
        return sumSteps;
    }

    void printMaxSteps() {
        int maxSteps = DateToStep[0];
        for (int i = 1; i < LENGTH_MONTH; i++) {
            if (maxSteps < DateToStep[i]) {
                maxSteps = DateToStep[i];
            }
        }
        System.out.println("Максимальное пройденное количество шагов в месяце: " + maxSteps);


    }

    void printAvgSteps() {
        int avgSteps = 0;
        avgSteps = getSumSteps() / LENGTH_MONTH;
        System.out.println("Среднее количество шагов: " + avgSteps);
    }

    void printDistance() {
        int distance = 0;
        distance = Converter.getLength(getSumSteps());
        System.out.println("Пройденная дистанция: " + distance);
    }

    void printEnergy() {
        int energy = 0;
        energy = Converter.getEnergy(getSumSteps());
        System.out.println("Количество сожжённых килокалорий: " + energy);
    }

    void printBestSeries(int targetStep) {
        //индекс первого элемента в лучшей серии
        // int indexStartBestSeries = 0;
        //кол-во элементов в лучшей серии
        int contBestSeries = 0;
        // индекс первого элемента в последней серии
        int indexStartLastSeries = 0;
        // кол-во элементов
        int contLastSeries = 0;

        for (int i = 0; i < LENGTH_MONTH; i++) {
            if (DateToStep[i] > targetStep) {
                //если элементы образуют серию
                if (contLastSeries == i - indexStartLastSeries) {
                    contLastSeries = contLastSeries + 1;
                    if (contLastSeries > contBestSeries) {
                        contBestSeries = contLastSeries;
                    }
                } else {
                    indexStartLastSeries = i;
                    contLastSeries = 1;
                }
            }

        }
        System.out.println("Лучшая серия: " + contBestSeries);
    }
}
