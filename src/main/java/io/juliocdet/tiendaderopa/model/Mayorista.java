package io.juliocdet.tiendaderopa.model;

import java.util.UUID;

import static io.juliocdet.tiendaderopa.model.Constants.DESCUENTO_MAYORISTA;

public class Mayorista extends ClienteExterno{

    public Mayorista(String nombre) {
        super(nombre);
        super.id = "May-" + UUID.randomUUID().toString();
    }

    @Override
    public float getCuenta() {
        return cuenta - (cuenta * DESCUENTO_MAYORISTA);
    }
}
