package io.juliocdet.tiendaderopa.repository;

import io.juliocdet.tiendaderopa.model.Producto;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductoDao implements Dao{

    /* Lista que Simula base de datos */
    private Map<Integer, Producto> productos;

    public ProductoDao(List<Producto> productosList) {
        this.productos = productosList
                .stream()
                .collect(Collectors.toMap(producto -> producto.getId(), producto -> producto));
    }

    @Override
    public boolean create(Object newItem) {
        Producto producto  = (Producto) newItem;
        if (!productos.containsKey(producto.getId())) {
            productos.put(producto.getId(), producto);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Object item, Object newValue) {
        Producto producto = (Producto) item;
        Producto nuevoProducto = (Producto) newValue;
        if (productos.containsKey(producto.getId())) {
            return productos.put(producto.getId(), nuevoProducto) != null;
        }
        return false;
    }

    @Override
    public Object read(Object item) {
        Producto producto =  (Producto) item;
        return productos.getOrDefault(producto.getId(), null);
    }

    @Override
    public boolean delete(Object item) {
        Producto producto = (Producto) item;
        if (productos.containsKey(producto.getId())) {
            return productos.remove(producto.getId()) != null;
        }
        return false;
    }

    public List<Producto> getTodosLosProductos() {
        return productos.keySet()
                .stream()
                .map(producto -> productos.get(producto))
                .collect(Collectors.toList());
    }

    public Object getById(int id) {
        return productos.getOrDefault(id, null);
    }
}
