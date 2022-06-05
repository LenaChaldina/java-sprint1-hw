import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();


        printMenu();
        int userInput = scanner.nextInt();

        while (userInput != 0) {
            // обработка разных случаев
            if (userInput == 1) {
                System.out.println("Введите через пробел: номер месяца от 0 до 11, номер дня - от 1 до 30, кол-во шагов за этот день");

                int userMonth = scanner.nextInt();
                int userDay = scanner.nextInt() - 1; // так как массивы от 0
                int userSteps = scanner.nextInt();

                if (userMonth < 0 || userDay < 0 || userSteps < 0) {
                    userMonth = 0;
                    userDay = 0;
                    userSteps = 0;
                    System.out.println("Вводить отрицательные значения нельзя. Пришлось обулить этот ввод.");
                }

                stepTracker.saveSteps(userMonth,userDay, userSteps);


            } else if (userInput == 2) {
                System.out.println("Введите номер месяца, за который нужно напечатать статистику");
                int userMonth = scanner.nextInt();
                stepTracker.printDaysStatistics(userMonth);
                stepTracker.getSumSteps(userMonth);
                stepTracker.getMaxSteps(userMonth);
                stepTracker.getAvgSteps(userMonth);
                stepTracker.getDistance(userMonth);
                stepTracker.getEnergy(userMonth);
                stepTracker.getBestSeries(userMonth);

            } else if (userInput == 3) {
                System.out.println("Укажите новое целевое кол-во шагов в день");
                int newTargetStep = scanner.nextInt();
                System.out.println("Целевое кол-во шагов: " + stepTracker.changeTargetStep(newTargetStep));


            } else {
                System.out.println("Извините, такой команды пока нет.");
            }
            printMenu(); // печатаем меню ещё раз перед завершением предыдущего действия
            userInput = scanner.nextInt(); // повторное считывание данных от пользователя
        }
        System.out.println("Программа завершена");
    }

    private static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выйти из приложения");
    }
}
