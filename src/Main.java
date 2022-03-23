import java.util.ArrayList;

class Main {
    private static final int NUMBER_OF_EXERCISES = 5; //количество примеров
    private static final int MIN = -20; //нижняя граница диапазона значений чисел в примерах
    private static final int MAX = 20; //верхняя граница диапазона значений чисел в примерах
    private static final int CALCULATION_ACCURACY = 2;

    private static final int TIME_FOR_ADDITION = 5; //секунд для выполнения сложения
    private static final int TIME_FOR_SUBTRACTION = 5; //секунд для выполнения вычитания
    private static final int TIME_FOR_MULTIPLICATION = 10; //секунд для выполнения умножения
    private static final int TIME_FOR_DIVISION = 30; //секунд для выполнения деления

    public static void main(String[] args) throws InterruptedException {
        String exercise;
        int nOfAdditions = 0;
        int nOfSubtractions = 0;
        int nOfMultiplications = 0;
        int nOfDivisions = 0;
        ArrayList<String> answers = new ArrayList<>();

        System.out.println("\nРешите данные примеры:");

        for (int i = 1; i <= NUMBER_OF_EXERCISES; i++) {
            int random1 = 0;
            while (random1 == 0) {
                random1 = (int) (Math.random() * (MAX + 1 - MIN) + MIN);
            }

            int random2 = 0;
            while (random2 == 0) {
                random2 = (int) (Math.random() * (MAX + 1 - MIN) + MIN);
            }

            String random2Str;
            if (random2 < 0) {
                random2Str = "(" + random2 + ")";
            }
            else {
                random2Str = random2 + "";
            }

            double random = Math.random();
            if (random < 0.25) {
                exercise = i + ". " + random1 + " + " + random2Str;
                answers.add(random1 + random2 + "");
                nOfAdditions++;
            } else if (random < 0.5) {
                exercise = i + ". " + random1 + " - " + random2Str;
                answers.add(random1 - random2 + "");
                nOfSubtractions++;
            } else if (random < 0.75) {
                exercise = i + ". " + random1 + " * " + random2Str;
                answers.add(random1 * random2 + "");
                nOfMultiplications++;
            } else {
                exercise = i + ". " + random1 + " : " + random2Str;
                double result = (int) Math.round(((double) random1 / (double) random2) * Math.pow(10, CALCULATION_ACCURACY)) / Math.pow(10, CALCULATION_ACCURACY);
                answers.add(Double.toString(result));
                nOfDivisions++;
            }
            System.out.println(exercise);
        }

        //таймер
        int timeWanted = nOfAdditions * TIME_FOR_ADDITION +
                nOfSubtractions * TIME_FOR_SUBTRACTION +
                nOfMultiplications * TIME_FOR_MULTIPLICATION +
                nOfDivisions * TIME_FOR_DIVISION;

        int timeMinute = timeWanted / 60;
        String minutes = timeMinute + "";
        if (timeMinute < 10) {
            minutes = "0" + minutes;
        }

        int timeSeconds = timeWanted % 60;
        String seconds = timeSeconds + "";
        if (timeSeconds < 10) {
            seconds = "0" + seconds;
        }

        System.out.println("\nУ вас есть " + minutes + ":" + seconds + ", чтобы решить примеры!");
        for (int j = 0; j < timeWanted; j++) {
            Thread.sleep(1000);
        }
        System.out.println("\nВремя вышло!");

        //ответы
        System.out.println("\nОтветы:");
        for (int k = 1; k <= NUMBER_OF_EXERCISES; k++) {
            System.out.println(k + ". " + answers.get(k - 1));
        }
    }
}