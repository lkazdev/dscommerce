package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.Order;
import com.devsuperior.dscommerce.entities.OrderItem;
import com.devsuperior.dscommerce.entities.OrderStatus;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class OrderDTO {

    private Long id;
    private Instant moment;
    private OrderStatus status;

    private ClientDTO client;
    private  PaymentDTO payment;
    private List<OrdeItemDTO> items = new ArrayList<>();

    public OrderDTO(Long id, Instant moment, OrderStatus status, PaymentDTO payment, ClientDTO client) {
        this.id = id;
        this.moment = moment;
        this.status = status;
        this.payment = payment;
        this.client = client;
    }

    public OrderDTO(Order entity) {
        this.id = entity.getId();
        this.moment = entity.getMoment();
        this.status = entity.getStatus();
        this.client = new ClientDTO(entity.getClient());
        if (entity.getPayment() == null) {
            this.payment = null;
        }
        else {
            this.payment = new PaymentDTO(entity.getPayment());
        }
        for (OrderItem item : entity.getItems()) {
            OrdeItemDTO itemDTO =  new OrdeItemDTO(item);
            items.add(itemDTO);
        }

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public PaymentDTO getPayment() {
        return payment;
    }

    public void setPayment(PaymentDTO payment) {
        this.payment = payment;
    }

    public ClientDTO getClient() {
        return client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }

    public List<OrdeItemDTO> getItems() {
        return items;
    }

    public void setItems(List<OrdeItemDTO> items) {
        this.items = items;
    }

    public Double getTotal() {
        double soma = 0.0;
        for (OrdeItemDTO dto : items) {
            soma += dto.getSubTotal();
        }
        return soma;
    }

}
