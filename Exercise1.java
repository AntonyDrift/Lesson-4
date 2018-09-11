public class Main {

    public static void main(String[] args) {

        Time timeObject = new Time(10, 5, 1);
        timeObject.printTime();
    }

}

class Time {
    int second;
    int minute;
    int hour;
    int timeInSecond;

    Time(int sec, int min, int h) {
        second = sec;
        minute = min;
        hour = h;
    }

    Time() {
        timeInSecond = getTimeInSecond();
    }


    void printTime() {
        System.out.println(hour+" Hour('s) " + minute + " minute('s) " + second+" second('s)"
                + "\n" + "Time in seconds: " + getTimeInSecond());
    }

    int getTimeInSecond() {
        timeInSecond = hour * 3600 + minute * 60 + second;
        return (timeInSecond);
    }
}
