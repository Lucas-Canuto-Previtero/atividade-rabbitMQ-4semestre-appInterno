package school.sptech.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import school.sptech.config.RabbitMQConfig;
import school.sptech.dto.PedidoMessage;
import school.sptech.service.PedidoService;

@Component
public class PedidoConsumer {

    private final PedidoService pedidoService;

    public PedidoConsumer(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void receber(PedidoMessage pedido) {
        System.out.println("\n========== CONSUMER ==========");
        System.out.println("Pedido recebido do RabbitMQ");
        System.out.println("ID: " + pedido.id());
        System.out.println("Cliente: " + pedido.cliente());
        System.out.println("Produto: " + pedido.produto());
        System.out.println("Quantidade: " + pedido.quantidade());
        System.out.println("==============================\n");

        pedidoService.salvar(pedido);
    }
}
