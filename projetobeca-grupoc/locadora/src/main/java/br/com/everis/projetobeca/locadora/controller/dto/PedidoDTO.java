package br.com.everis.projetobeca.locadora.controller.dto;

import br.com.everis.projetobeca.locadora.model.FormaPagamento;
import br.com.everis.projetobeca.locadora.model.Pedido;
import br.com.everis.projetobeca.locadora.model.StatusPedido;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class PedidoDTO {

    private Long id;
    private StatusPedido statusPedido;
    private FormaPagamento formaPagamento;
    private Double valorTotal;
    private Double totalPago;
    private LocalDate data = LocalDate.now();

    public PedidoDTO(Pedido pedido) {
        this.statusPedido = pedido.getStatus();
        this.formaPagamento = pedido.getFormaPagamento();
        this.valorTotal = pedido.getValorTotal();
        this.data = pedido.getData();
    }

    public List<PedidoDTO> converterPedido(List<Pedido> pedidos){
        return pedidos.stream().map(PedidoDTO::new).collect(Collectors.toList());
    }
}
