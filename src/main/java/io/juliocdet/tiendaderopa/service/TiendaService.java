package io.juliocdet.tiendaderopa.service;

import io.juliocdet.tiendaderopa.model.Cliente;
import io.juliocdet.tiendaderopa.model.Empleado;
import io.juliocdet.tiendaderopa.model.Mayorista;
import io.juliocdet.tiendaderopa.model.Minorista;
import io.juliocdet.tiendaderopa.model.Producto;
import io.juliocdet.tiendaderopa.repository.ClienteDao;
import io.juliocdet.tiendaderopa.repository.ProductoDao;
import io.juliocdet.tiendaderopa.repository.DataSource;

import java.util.List;

import static io.juliocdet.tiendaderopa.ui.UiConstants.NEW_LINE;

public class TiendaService {

    /* Variables de clase */
    private static List<Producto> productos = DataSource.productos;
    private static List<Cliente> clientes = DataSource.clientes;

    /* Variables de instancia */
    private ClienteDao clienteDao;
    private ProductoDao productoDao;

    public TiendaService() {
        clienteDao = new ClienteDao(clientes);
        productoDao = new ProductoDao(productos);
    }

    public String getTodosLosProductos() {
        StringBuilder listaProductosStr = new StringBuilder();
        for (Producto producto : productoDao.getTodosLosProductos()) {
            listaProductosStr.append("ID = " + producto.getId()).append(NEW_LINE)
                             .append("Nombre: " + producto.getNombre()).append(NEW_LINE)
                             .append("Precio: " + producto.getPrecio()).append(NEW_LINE)
                             .append("----------------------------------").append(NEW_LINE);
        }
        return listaProductosStr.toString();
    }

    public String getTodosLosCliente() {
        StringBuilder listaClientesStr = new StringBuilder()
                .append("--------------------------------------------------").append(NEW_LINE)
                .append("| Nombre |           ID                          |").append(NEW_LINE);

        for (String cliete : clienteDao.getNombreDeTodosLosClientes()) {
            listaClientesStr.append("| ").append(cliete).append(" |").append(NEW_LINE);
        }
        listaClientesStr.append("--------------------------------------------------").append(NEW_LINE);
        return listaClientesStr.toString();
    }

    public boolean validarClienteId(String id) {
        return clienteDao.getById(id) != null;
    }

    public Cliente getCliente(String id) {
        return clienteDao.getById(id);
    }

    public boolean validarProductoId(int id) {
        return productoDao.getById(id) != null;
    }

    public void comprarProducto(Cliente cliente, int productoId) {
        cliente.comprar((Producto) productoDao.getById(productoId));
    }

    public void agregarCliente(String nombre, int tipo) {
        Cliente cliente = null;
        switch (tipo) {
            /* Crear minirista */
            case 1:
                cliente = new Minorista(nombre);
                break;

            case 2:
                cliente = new Mayorista(nombre);
                break;

            case 3:
                cliente = new Empleado(nombre);
                break;
        }
        clienteDao.create(cliente);
    }

    public String getCuentaCliente(Cliente cliente) {
        return "La cuenta todal es: " + cliente.getCuenta();
    }
}
