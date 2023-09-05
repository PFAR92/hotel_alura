package br.com.hotelAlura.back.controller;

import br.com.hotelAlura.back.dao.ReservaDao;
import br.com.hotelAlura.back.factory.ConnectionFactory;
import br.com.hotelAlura.back.model.Reserva;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;

public class ReservaController {

    private ReservaDao reservaDao;

    public ReservaController() {

        Connection connection = new ConnectionFactory().recuperarConexao();
        this.reservaDao = new ReservaDao(connection);
    }

    public void reservar (Reserva reserva) {
        this.reservaDao.reservar(reserva);
    }

    public Reserva bucarReserva (int numero) {
       return this.reservaDao.buscar(numero);
    }

    public void editar(Integer numeroReserva, Date dataEntrada, Date dataSaida, BigDecimal valor) {
        this.reservaDao.editar(numeroReserva, dataEntrada, dataSaida, valor);
    }
    public void deletar (Integer id) {
        this.reservaDao.deletar (id);
    }
}
