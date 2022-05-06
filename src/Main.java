import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final int NUMBER_OF_EXERCISES = 10; //количество примеров
    private static final int MIN = -20; //нижняя граница диапазона значений чисел в примерах
    private static final int MAX = 20; //верхняя граница диапазона значений чисел в примерах
    private static final int CALCULATION_ACCURACY = 2;

    private static final char ADDITION_CHAR = '+';
    private static final char SUBTRACTION_CHAR = '-';
    private static final char MULTIPLICATION_CHAR = '*';
    private static final char DIVISION_CHAR = ':';

    private static final int TIME_FOR_ADDITION = 5; //секунд для выполнения сложения
    private static final int TIME_FOR_SUBTRACTION = 5; //секунд для выполнения вычитания
    private static final int TIME_FOR_MULTIPLICATION = 10; //секунд для выполнения умножения
    private static final int TIME_FOR_DIVISION = 30; //секунд для выполнения деления

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String stringOfSigns = scanner.nextLine();
        char[] signs = stringOfSigns.toCharArray();

        String exercise;
        int nOfAdditions = 0;
        int nOfSubtractions = 0;
        int nOfMultiplications = 0;
        int nOfDivisions = 0;
        ArrayList<String> answers = new ArrayList<>();

        System.out.println("Решите данные примеры:");

        for (int i = 1; i <= NUMBER_OF_EXERCISES; i++) {
            int randomNum1 = 0;
            while (randomNum1 == 0) {
                randomNum1 = (int) (Math.random() * (MAX + 1 - MIN) + MIN);
            }

            int randomNum2 = 0;
            while (randomNum2 == 0) {
                randomNum2 = (int) (Math.random() * (MAX + 1 - MIN) + MIN);
            }

            String randomNum2Str;
            if (randomNum2 < 0) {
                randomNum2Str = "(" + randomNum2 + ")";
            } else {
                randomNum2Str = Integer.toString(randomNum2);
            }

            int random = (int) (Math.random() * signs.length);
            exercise = i + ". " + randomNum1 + " " + signs[random] + " " + randomNum2Str;
            switch (signs[random]) {
                case ADDITION_CHAR:
                    answers.add(Integer.toString(randomNum1 + randomNum2));
                    nOfAdditions++;
                    break;
                case SUBTRACTION_CHAR:
                    answers.add(Integer.toString(randomNum1 - randomNum2));
                    nOfSubtractions++;
                    break;
                case MULTIPLICATION_CHAR:
                    answers.add(Integer.toString(randomNum1 * randomNum2));
                    nOfMultiplications++;
                    break;
                case DIVISION_CHAR:
                    double result = (int) Math.round(((double) randomNum1 / (double) randomNum2) * Math.pow(10, CALCULATION_ACCURACY)) /
                            Math.pow(10, CALCULATION_ACCURACY);
                    String resultStr = Double.toString(result);
                    if (resultStr.endsWith(".0")) {
                        resultStr = Integer.toString((int) result);
                    }
                    answers.add(resultStr);
                    nOfDivisions++;
                    break;
            }
            System.out.println(exercise);
        }

        int timeWanted = nOfAdditions * TIME_FOR_ADDITION +
                nOfSubtractions * TIME_FOR_SUBTRACTION +
                nOfMultiplications * TIME_FOR_MULTIPLICATION +
                nOfDivisions * TIME_FOR_DIVISION;

        int timeMinute = timeWanted / 60;
        String minutes = Integer.toString(timeMinute);
        if (timeMinute < 10) {
            minutes = "0" + minutes;
        }

        int timeSeconds = timeWanted % 60;
        String seconds = Integer.toString(timeSeconds);
        if (timeSeconds < 10) {
            seconds = "0" + seconds;
        }

        System.out.println("\nУ вас есть " + minutes + ":" + seconds + ", чтобы решить примеры!");
        for (int j = 0; j < timeWanted; j++) {
            Thread.sleep(1000);
        }
        System.out.println("Время вышло!");

        System.out.println("\nОтветы:");
        for (int k = 1; k <= NUMBER_OF_EXERCISES; k++) {
            System.out.println(k + ". " + answers.get(k - 1));
        }
    }
}
