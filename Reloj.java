import java.util.Scanner;

public class Reloj {
    private int hours;
    private int minutes;
    private int seconds;
    private boolean mode24Hours;
    public Reloj() {
    }
    public Reloj(int hours, int minutes, int seconds) {
        setHours(hours, minutes, seconds);
    }
    public int getHours() {
        return hours;
    }
    public void setHours(int hours) {
        if (hours >= 0 && hours <= 23) {
            this.hours = hours;
        } else {
            System.out.println("Hora inválida");
        }
    }
    public int getMinutes() {
        return minutes;
    }
    public void setMinutes(int minutes) {
        if (minutes >= 0 && minutes <= 59) {
            this.minutes = minutes;
        } else {
            System.out.println("Minutos inválidos");
        }
    }
    public int getSeconds() {
        return seconds;
    }
    public void setSeconds(int seconds) {
        if (seconds >= 0 && seconds <= 59) {
            this.seconds = seconds;
        } else {
            System.out.println("Segundos inválidos");
        }
    }
    public boolean isMode24Hours() {
        return mode24Hours;
    }
    public void setMode24Hours(boolean mode24Hours) {
        this.mode24Hours = mode24Hours;
    }
    public void showHour() {
        System.out.println(this);
    }
    public void setHours(int hours, int minutes, int seconds) {
        setHours(hours);
        setMinutes(minutes);
        setSeconds(seconds);
    }
    @Override
    public String toString() {
        String hourFormat = mode24Hours ? "%02d:%02d:%02d" : "%d:%02d:%02d %s";
        int showHours = mode24Hours ? hours : (hours == 0 || hours == 12) ? 12 : hours % 12;
        String amPm = hours < 12 ? "AM" : "PM";
        return String.format(hourFormat, showHours, minutes, seconds, amPm);
    }

}