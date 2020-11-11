package io.juliocdet.tiendaderopa.service;

import java.util.Scanner;

public class UiService {

    private Scanner scanner;
    private boolean jumpLineConsumido;

    public UiService() {
        scanner = new Scanner(System.in);
        jumpLineConsumido = false;
    }

    public void mostrarMenu(String menu) {
        System.out.println(menu);
    }

    public int seleccionarOpcion() {
        jumpLineConsumido = false;
        return scanner.nextInt();
    }

    public void limpiarPantalla() {
        for (int i = 0; i < 5; i++) {
            System.out.println();
        }
    }

    public String leerString() {
        if (!jumpLineConsumido) {
            scanner.nextLine(); // Limpiar el scanner de saltos de linea
        }
        jumpLineConsumido = true;
        return scanner.nextLine();
    }

    public void close() {
        scanner.close();
    }
}
