package com.projetopado.projetopado.config;

import com.projetopado.projetopado.utils.QueueUtils;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import static com.projetopado.projetopado.utils.QueueUtils.EXCHANGE_NAME;
import static com.projetopado.projetopado.utils.QueueUtils.QUEUE_NAME;

@Component
public class MQConfig {

    @Autowired
    private AmqpAdmin amqpAdmin;

    private Queue queue(String queuename) {
        return new Queue(queuename, true, false, false);
    }

    private DirectExchange directExchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    private Binding relate(Queue queue, DirectExchange exchange){
        return new Binding(queue.getName(), Binding.DestinationType.QUEUE,
                directExchange().getName(), queue.getName(),null);
    }

//    @PostConstruct
    private void create(){
        Queue queue = queue(QUEUE_NAME);
        DirectExchange directExchange = directExchange();
        Binding relate = relate(queue,directExchange);
        amqpAdmin.declareQueue(queue);
        amqpAdmin.declareExchange(directExchange);
        amqpAdmin.declareBinding(relate);
    }

}
