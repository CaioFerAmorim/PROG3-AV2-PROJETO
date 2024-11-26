package src.main;

import src.controller.FuncionarioController;

public class App {
    public static void main(String[] args) {
        FuncionarioController controller = new FuncionarioController();

        controller.iniciarSistema();
    }
}