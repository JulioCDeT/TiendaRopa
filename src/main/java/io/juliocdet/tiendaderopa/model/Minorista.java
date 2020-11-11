package io.juliocdet.tiendaderopa.model;

import java.util.UUID;

public class Minorista extends ClienteExterno {

    public Minorista(String nombre) {
        super(nombre);
        super.id = "Min-" + UUID.randomUUID().toString();
    }

    @Override
    public float getCuenta() {
        return cuenta;
    }
}
