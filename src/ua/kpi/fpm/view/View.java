package ua.kpi.fpm.view;

public class View {

    public static final String INPUT_INT_DATA = "Input INT value = ";
    public static final String WRONG_INPUT_INT_DATA = "Wrong input! Repeat please! ";
    public static final String OUR_INT = "INT value = ";

    public void printMessage(String message){
        System.out.println(message);
    }

    public void printMessades(String[] messages) {
        for (String m: messages) {
            System.out.println(m);
        }
    }

    public void printMessades(Object[] messages) {
        for (Object m: messages) {
            System.out.println(m.toString());
        }
    }

}
