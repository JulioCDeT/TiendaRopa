package io.juliocdet.tiendaderopa.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static io.juliocdet.tiendaderopa.model.Constants.DESCUENTO_EMPLEADO;

public class Empleado implements Cliente{

    protected String id;
    protected String nombre;
    protected float cuenta;
    protected List<Producto> productos;

    public Empleado(String nombre) {
        this.nombre = nombre;
        this.id = "Emp-" + UUID.randomUUID().toString();
        this.cuenta = 0.0F;
        this.productos = new ArrayList<>();
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public float getCuenta() {
        return cuenta - cuenta * DESCUENTO_EMPLEADO;
    }

    @Override
    public void comprar(Producto producto) {
        productos.add(producto);
        cuenta += producto.getPrecio();
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
