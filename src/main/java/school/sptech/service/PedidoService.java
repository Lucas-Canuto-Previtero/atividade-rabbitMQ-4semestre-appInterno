package school.sptech.service;

import org.springframework.stereotype.Service;
import school.sptech.dto.Pedido;
import school.sptech.dto.PedidoMessage;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {

    private final List<Pedido> pedidos = new ArrayList<>();

    public void salvar(PedidoMessage pedidoMessage) {
        Pedido novoPedido = new Pedido(
                pedidoMessage.id(),
                pedidoMessage.cliente(),
                pedidoMessage.produto(),
                pedidoMessage.quantidade()
        );
        pedidos.add(novoPedido);
    }

    public List<Pedido> listar() {
        return pedidos;
    }
}
