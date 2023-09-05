package br.com.hotelAlura.back.controller;

import br.com.hotelAlura.back.dao.HospedeDao;
import br.com.hotelAlura.back.factory.ConnectionFactory;
import br.com.hotelAlura.back.model.Hospede;

import java.sql.Connection;
import java.sql.Date;

public class HospedeController {

    private HospedeDao hospedeDao;

    public HospedeController() {

        Connection connection = new ConnectionFactory().recuperarConexao();
        this.hospedeDao = new HospedeDao(connection);
    }

    public void cadastrar (Hospede hospede) {
        this.hospedeDao.cadastrar(hospede);
    }

    public Hospede buscar(String sobrenome){
        return this.hospedeDao.buscar(sobrenome);
    }

    public void editar(Integer id, String nome, String sobrenome, Date dataNascimento, String telefone) {
        this.hospedeDao.editar(id, nome, sobrenome, dataNascimento, telefone);
    }
}
