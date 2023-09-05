package br.com.hotelAlura.back.dao;

import br.com.hotelAlura.back.model.Reserva;

import javax.swing.*;
import java.math.BigDecimal;
import java.sql.*;

public class ReservaDao {

    private Connection connection;

    public ReservaDao(Connection connection) {
        this.connection = connection;
    }

    public void reservar(Reserva reserva) {

        String sql = "INSERT INTO RESERVAS (ID ,DATAENTRADA, DATASAIDA, VALOR, FORMAPAGAMENTO) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            statement.setInt(1, reserva.getId());
            statement.setDate(2, reserva.getDataEntrada());
            statement.setDate(3, reserva.getDataSaida());
            statement.setBigDecimal(4, reserva.getValor());
            statement.setString(5, reserva.getFormaPagamento());

            statement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Reserva buscar(int numero) {

        Reserva reserva = new Reserva();
        String sql = "SELECT R.ID, R.DATAENTRADA, R.DATASAIDA, R.VALOR, R.FORMAPAGAMENTO FROM RESERVAS R INNER JOIN HOSPEDES H ON R.ID = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            statement.setInt(1, numero);
            statement.execute();

            try (ResultSet resultado = statement.getResultSet()) {

                while (resultado.next()) {

                    reserva.setId(resultado.getInt(1));
                    reserva.setDataEntrada(resultado.getDate(2));
                    reserva.setDataSaida(resultado.getDate(3));
                    reserva.setValor(resultado.getBigDecimal(4));
                    reserva.setFormaPagamento(resultado.getString(5));

                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return reserva;
    }


    public void editar(Integer numeroReserva, Date dataEntrada, Date dataSaida, BigDecimal valor) {
            String sql = "UPDATE RESERVAS R SET R.DATAENTRADA = ?, R.DATASAIDA = ?, R.VALOR = ? WHERE ID = ?";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {

                statement.setDate(1, dataEntrada);
                statement.setDate(2, dataSaida);
                statement.setBigDecimal(3, valor);
                statement.setInt(4, numeroReserva);
                statement.execute();

                JOptionPane.showMessageDialog(null, "Reserva " + numeroReserva + ", atualizado com sucesso!");

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
    }

    public void deletar(Integer id) {
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM RESERVAS WHERE ID = ?")) {
            statement.setInt(1, id);
            statement.execute();
            JOptionPane.showMessageDialog(null, "Reserva " + id + ", excluída com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
