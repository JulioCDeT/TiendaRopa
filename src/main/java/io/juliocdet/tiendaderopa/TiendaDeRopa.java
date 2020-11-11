package io.juliocdet.tiendaderopa;

import io.juliocdet.tiendaderopa.model.Cliente;
import io.juliocdet.tiendaderopa.service.TiendaService;
import io.juliocdet.tiendaderopa.service.UiService;

import static io.juliocdet.tiendaderopa.ui.UiConstants.AGREGAR_CLIENTE;
import static io.juliocdet.tiendaderopa.ui.UiConstants.COMPRAR_UI;
import static io.juliocdet.tiendaderopa.ui.UiConstants.COMPRAR_UI_PRODUCTO;
import static io.juliocdet.tiendaderopa.ui.UiConstants.CUENTA_CLIENTE;
import static io.juliocdet.tiendaderopa.ui.UiConstants.INFO_CLIENTE;
import static io.juliocdet.tiendaderopa.ui.UiConstants.INVALID_ID;
import static io.juliocdet.tiendaderopa.ui.UiConstants.LISTA_CLIENTES;
import static io.juliocdet.tiendaderopa.ui.UiConstants.LISTA_PRODUCTOS;
import static io.juliocdet.tiendaderopa.ui.UiConstants.MENU_CLIENTES;
import static io.juliocdet.tiendaderopa.ui.UiConstants.MENU_COMPRAS;
import static io.juliocdet.tiendaderopa.ui.UiConstants.MENU_EXIT;
import static io.juliocdet.tiendaderopa.ui.UiConstants.MENU_PRINCIPAL;
import static io.juliocdet.tiendaderopa.ui.UiConstants.TIPO_DE_CLIENTE;
import static io.juliocdet.tiendaderopa.ui.UiConstants.TIPO_INVALIDO;

public class TiendaDeRopa {

    /* Variables de instancia - Service*/
    private static final TiendaService tiendaService = new TiendaService();
    private static final UiService uiService = new UiService();

    public static void main(String[] args) {

        // Valor contante para salir o regresar
        final int EXIT = 3;
        final int MENU_DEFAULT = 0;

        int seleccion = MENU_DEFAULT;
        do {
            uiService.limpiarPantalla(); // Saltos de lines
            uiService.mostrarMenu(MENU_PRINCIPAL); // Mostramos el menu principal a partir de la constante
            seleccion = uiService.seleccionarOpcion(); // Leer la selecion del usuario

            switch (seleccion) {
                /* Menu de Clientes */
                case 1:
                    uiService.limpiarPantalla();
                    uiService.mostrarMenu(MENU_CLIENTES); // Mostra menu del cliente sacado de las constates
                    seleccion = uiService.seleccionarOpcion();
                    Cliente cliente = null;
                    String idCliente = null;
                    switch (seleccion) {
                        /* Mostrar todos los clientes */
                        case 1:
                            uiService.mostrarMenu(LISTA_CLIENTES);
                            uiService.mostrarMenu(tiendaService.getTodosLosCliente());
                            break;
                        /* Agregar un cliente */
                        case 2:
                            uiService.mostrarMenu(AGREGAR_CLIENTE);
                            String nombre = uiService.leerString();
                            uiService.mostrarMenu(TIPO_DE_CLIENTE);
                            int tipo = Integer.parseInt(uiService.leerString());
                            if (tipo == 1 || tipo == 2 || tipo == 3) {
                                tiendaService.agregarCliente(nombre, tipo);
                            } else {
                                uiService.mostrarMenu(TIPO_INVALIDO);
                            }
                            break;

                        /* Mostrar info de un cliente */
                        case 3:
                            uiService.mostrarMenu(INFO_CLIENTE);
                            idCliente = uiService.leerString();
                            cliente = tiendaService.getCliente(idCliente);
                            if (cliente != null) {
                                uiService.mostrarMenu(cliente.toString());
                            }
                            seleccion = MENU_DEFAULT;
                            break;

                        /* Obtener cuenta de un cliente */
                        case 4:
                            uiService.mostrarMenu(CUENTA_CLIENTE);
                            idCliente = uiService.leerString();
                            cliente = tiendaService.getCliente(idCliente);
                            if (cliente != null) {
                                uiService.mostrarMenu(tiendaService.getCuentaCliente(cliente));
                            }
                            break;
                    }
                    break;

                case 2:
                    /* Menu de compras */
                    uiService.limpiarPantalla();
                    uiService.mostrarMenu(MENU_COMPRAS);
                    seleccion = uiService.seleccionarOpcion();
                    switch (seleccion) {
                        /* Mostrar todos los productos */
                        case 1:
                            uiService.mostrarMenu(LISTA_PRODUCTOS);
                            uiService.mostrarMenu(tiendaService.getTodosLosProductos());
                            break;
                        /* Agregar el compra a un cliente */
                        case 2:
                            uiService.mostrarMenu(COMPRAR_UI);
                            String id = uiService.leerString();
                            if (tiendaService.validarClienteId(id)) {
                                cliente = tiendaService.getCliente(id);
                                uiService.mostrarMenu(COMPRAR_UI_PRODUCTO);
                                int productoId = Integer.parseInt(uiService.leerString());
                                if (tiendaService.validarProductoId(productoId)) {
                                    tiendaService.comprarProducto(cliente, productoId);
                                } else {
                                    System.out.println(INVALID_ID);
                                }
                            } else {
                                System.out.println(INVALID_ID);
                            }
                            break;
                    }
                    break;
            }
        } while (seleccion != EXIT);
        uiService.close();
        uiService.mostrarMenu(MENU_EXIT);
    }
}
