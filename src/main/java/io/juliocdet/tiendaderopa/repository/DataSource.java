package io.juliocdet.tiendaderopa.repository;

import io.juliocdet.tiendaderopa.model.Cliente;
import io.juliocdet.tiendaderopa.model.Producto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DataSource {

    public static final List<Producto> productos =
            Arrays.asList(
                    new Producto(1, "Playera", "Ropa superior", 100.0F),
                    new Producto(2, "Pantalon", "Ropa inferior", 300.0F),
                    new Producto(3, "Sudadera", "Ropa superior", 350.0F),
                    new Producto(4, "Calcetines", "Ropa interior", 25.0F),
                    new Producto(5, "tenis", "Zapatos", 400.0F),
                    new Producto(6, "boxer", "Ropa interior", 50.0F),
                    new Producto(7, "Saco", "Ropa superior", 700.0F)
            );

    public static final List<Cliente> clientes = Collections.EMPTY_LIST;
}
