package io.juliocdet.tiendaderopa.model;

import java.util.ArrayList;
import java.util.List;

public abstract class ClienteExterno implements Cliente{

    protected String id;
    protected String nombre;
    protected float cuenta;
    protected List<Producto> productos;

    protected ClienteExterno(String nombre) {
        this.nombre = nombre;
        productos = new ArrayList<>();
        cuenta = 0.0F;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void comprar(Producto producto) {
        productos.add(producto);
        cuenta += producto.getPrecio();
    }

    public List<Producto> getProductos() {
        return productos;
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", cuenta=" + cuenta +
                ", productos=" + productos +
                '}';
    }
}
