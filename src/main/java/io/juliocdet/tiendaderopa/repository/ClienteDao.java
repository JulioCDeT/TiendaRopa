package io.juliocdet.tiendaderopa.repository;

import io.juliocdet.tiendaderopa.model.Cliente;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ClienteDao implements Dao{

    private static Map<String, Cliente> clientes = new HashMap<>();

    public ClienteDao(List<Cliente> clientesList) {
        clientes = clientesList
                .stream()
                .collect(Collectors.toMap(cliente -> cliente.getId(), cliente -> cliente));
    }

    @Override
    public boolean create(Object newItem) {
        Cliente cliente = (Cliente) newItem;
        if (!clientes.containsKey(cliente.getId())) {
            clientes.put(cliente.getId(), cliente);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Object item, Object newValue) {
        Cliente cliente = (Cliente) item;
        Cliente nuevoCliente = (Cliente) newValue;
        if (clientes.containsKey(cliente.getId())) {
            return clientes.put(cliente.getId(), nuevoCliente) != null;
        }
        return false;
    }

    @Override
    public Object read(Object item) {
        Cliente cliente = (Cliente) item;
        return clientes.getOrDefault(cliente.getId(), null);
    }

    @Override
    public boolean delete(Object item) {
        Cliente cliente = (Cliente) item;
        return clientes.remove(cliente.getId()) != null;
    }

    public List<String> getNombreDeTodosLosClientes() {
        return clientes.keySet()
                .stream()
                .map((id) -> clientes.get(id).getNombre() + " " + id)
                .collect(Collectors.toList());
    }

    public Cliente getById(String id) {
        return clientes.getOrDefault(id, null);
    }
}
