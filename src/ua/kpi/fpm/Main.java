package ua.kpi.fpm;

import ua.kpi.fpm.controller.Controller;
import ua.kpi.fpm.model.Model;
import ua.kpi.fpm.view.View;

public class Main {

    public static void main(String[] args) {
        // Initialization
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);
        // Run
        controller.processUser();
    }

}
