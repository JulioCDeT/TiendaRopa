package io.juliocdet.tiendaderopa.service;

import java.util.Scanner;

public class UiService {

    private Scanner scanner;

    public UiService() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu(String menu) {
        System.out.println(menu);
    }

    public int seleccionarOpcion() {
        return Integer.parseInt(scanner.nextLine());
    }

    public void limpiarPantalla() {
        for (int i = 0; i < 5; i++) {
            System.out.println();
        }
    }

    public String leerString() {
        return scanner.nextLine();
    }

    public void close() {
        scanner.close();
    }
}
