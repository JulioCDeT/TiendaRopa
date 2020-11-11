package io.juliocdet.tiendaderopa.ui;

public interface UiConstants {

    String NEW_LINE = System.lineSeparator();

    String MENU_PRINCIPAL = new StringBuilder()
            .append("************************").append(NEW_LINE)
            .append("** Tu Tienda sde ropa **").append(NEW_LINE)
            .append("************************").append(NEW_LINE)
            .append("Selecciona entre las sig. optiones:").append(NEW_LINE)
            .append("1) Clientes").append(NEW_LINE)
            .append("2) Comprar").append(NEW_LINE)
            .append("3) Salir").append(NEW_LINE)
            .toString();

    String MENU_CLIENTES = new StringBuilder()
            .append("************************").append(NEW_LINE)
            .append("****** Clientes ********").append(NEW_LINE)
            .append("************************").append(NEW_LINE)
            .append("1) Mostrar Clientes").append(NEW_LINE)
            .append("2) Agregar cliente").append(NEW_LINE)
            .append("3) Mostrar info cliente").append(NEW_LINE)
            .append("4) Get cuenta del cliente").append(NEW_LINE)
            .toString();

    String MENU_COMPRAS = new StringBuilder()
            .append("******************************").append(NEW_LINE)
            .append("*********  Compras  **********").append(NEW_LINE)
            .append("******************************").append(NEW_LINE)
            .append("1) Mostrar todos los productos").append(NEW_LINE)
            .append("2) Comprar").append(NEW_LINE)
            .toString();

    String LISTA_PRODUCTOS = new StringBuilder()
            .append("*******************************").append(NEW_LINE)
            .append("********  Productos  **********").append(NEW_LINE)
            .append("*******************************").append(NEW_LINE)
            .append("Todos los productos disponibles").append(NEW_LINE)
            .append("son: ")
            .toString();

    String COMPRAR_UI = new StringBuilder()
            .append("*******************************").append(NEW_LINE)
            .append("********  Comprar  **********").append(NEW_LINE)
            .append("*******************************").append(NEW_LINE)
            .append("Hola ingresa tu id de cliente:").append(NEW_LINE)
            .toString();

    String COMPRAR_UI_PRODUCTO = new StringBuilder()
            .append("Ingresa el id del producto a compra: ").append(NEW_LINE)
            .toString();

    String LISTA_CLIENTES = new StringBuilder()
            .append("*******************************").append(NEW_LINE)
            .append("********  Clientes  ***********").append(NEW_LINE)
            .append("*******************************").append(NEW_LINE)
            .append("Estos son todos los clientes:").append(NEW_LINE)
            .toString();

    String AGREGAR_CLIENTE = new StringBuilder()
            .append("*************************************").append(NEW_LINE)
            .append("********  Agregar cliente  **********").append(NEW_LINE)
            .append("*************************************").append(NEW_LINE)
            .append("Ingresa nombre por favor:").append(NEW_LINE)
            .toString();

    String INFO_CLIENTE = new StringBuilder()
            .append("*************************************").append(NEW_LINE)
            .append("********  Info cliente  **********").append(NEW_LINE)
            .append("*************************************").append(NEW_LINE)
            .append("Ingresa id del cliente:").append(NEW_LINE)
            .toString();

    String CUENTA_CLIENTE = new StringBuilder()
            .append("*************************************").append(NEW_LINE)
            .append("********  Cuenta cliente  **********").append(NEW_LINE)
            .append("*************************************").append(NEW_LINE)
            .append("Ingresa id del cliente:").append(NEW_LINE)
            .toString();

    String TIPO_DE_CLIENTE = new StringBuilder()
            .append("Que tipo de cliente se desea agregar").append(NEW_LINE)
            .append("1) Minorista").append(NEW_LINE)
            .append("2) Mayorista").append(NEW_LINE)
            .append("3) Empleado nuestro").append(NEW_LINE)
            .toString();

    String MENU_EXIT = new StringBuilder()
            .append("************************").append(NEW_LINE)
            .append("** Muchas gracias por **").append(NEW_LINE)
            .append("**  por comprar aqui  **").append(NEW_LINE)
            .append("************************").append(NEW_LINE)
            .toString();

    String INVALID_ID = "Lo sentimos id invalido";

    String TIPO_INVALIDO =  "Lo sentimos el tipo ingresado es invalido";
}
