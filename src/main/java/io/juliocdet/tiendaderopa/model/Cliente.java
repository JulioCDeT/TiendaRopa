package io.juliocdet.tiendaderopa.model;

public interface Cliente {

    String getNombre();
    String getId();
    float getCuenta();
    void comprar(Producto producto);
}
