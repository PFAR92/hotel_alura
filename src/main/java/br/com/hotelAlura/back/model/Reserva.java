package br.com.hotelAlura.back.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

public class Reserva {

    private Integer id;
    private Date dataEntrada;
    private Date dataSaida;
    private BigDecimal valor;
    private String formaPagamento;

    public Reserva(Integer id, Date dataEntrada, Date dataSaida, BigDecimal valor, String formaPagamento) {
        this.id = id;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.valor = valor;
        this.formaPagamento = formaPagamento;
    }

    public Reserva() {}

    public Integer getId() {
        return id;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", dataEntrada=" + dataEntrada +
                ", dataSaida=" + dataSaida +
                ", valor=" + valor +
                ", formaPagamento='" + formaPagamento + '\'' +
                '}';
    }
}
