/* Java Program to inherit time class (i.e. First class has the hour component, Second class has the minutes component & the Third class
has a seconds component.) Given 2 objects, find the time lapsed between them. (Generate Documentation for your program.)*/

class Second {
    int second;

    public Second() {

    }

    public Second(int second) {
        this.second = second;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }
}

class Minute extends Second {
    int minute;

    public Minute() {

    }

    public Minute(int minute) {
        this.minute = minute;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }
}

class Hour extends Minute {
    int hour;

    public Hour() {

    }

    public Hour(int hour) {
        this.hour = hour;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }
}

class Time extends Hour {
    public Time(int Hours, int Minutes, int Seconds) {
        setHour(Hours);
        setMinute(Minutes);
        setSecond(Seconds);
    }

    public String timeLapsed(Time x) {
        int h = this.getHour() - x.getHour();
        int m = this.getMinute() - x.getMinute();
        int s = this.getSecond() - x.getSecond();
        return (h + ":" + m + ":" + s);
    }
}

public class Q1 {
    public static void main(String[] args) {
        Time t1 = new Time(18, 30, 40);
        Time t2 = new Time(13, 20, 40);
        // time difference
        String difference = t1.timeLapsed(t2);

        System.out.println("Time difference: " + difference);
    }
}