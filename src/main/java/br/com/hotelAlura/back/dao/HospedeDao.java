package br.com.hotelAlura.back.dao;

import br.com.hotelAlura.back.model.Hospede;
import br.com.hotelAlura.front.views.Sucesso;

import javax.swing.*;
import java.sql.*;

public class HospedeDao {

    private Connection connection;

    public HospedeDao(Connection connection) {
        this.connection = connection;
    }

    public void cadastrar(Hospede hospede) {

        String sql = "INSERT INTO HOSPEDES (NOME, SOBRENOME, DATANASCIMENTO, NACIONALIDADE, TELEFONE, RESERVAS_ID) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, hospede.getNome());
            statement.setString(2, hospede.getSobrenome());
            statement.setDate(3, hospede.getDataNascimento());
            statement.setString(4, hospede.getNacionalidade());
            statement.setString(5, hospede.getTelefone());
            statement.setInt(6, hospede.getReservaId());

            statement.execute();

            try (ResultSet rst = statement.getGeneratedKeys()) {
                while (rst.next()) {
                    hospede.setId(rst.getInt(1));
                }
                Sucesso.main(null);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /*public Hospede buscarReserva(Integer reserva) {

        Hospede hospede = new Hospede();
        String sql = "SELECT H.ID, H.NOME, H.SOBRENOME, H.DATANASCIMENTO, H.NACIONALIDADE, H.TELEFONE, " +
                "H.RESERVAS_ID FROM HOSPEDES H WHERE H.RESERVAS_ID = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, reserva);
            statement.execute();

            try (ResultSet resultado = statement.getResultSet()) {

                while (resultado.next()) {

                    hospede.setId(resultado.getInt(1));
                    hospede.setNome(resultado.getString(2));
                    hospede.setSobrenome(resultado.getString(3));
                    hospede.setDataNascimento(resultado.getDate(4));
                    hospede.setNacionalidade(resultado.getString(5));
                    hospede.setTelefone(resultado.getString(6));
                    hospede.setReservaId(reserva);
                }

            }
            return hospede;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }*/

    public Hospede buscar(String sobrenome) {

        Hospede hospede = new Hospede();
        String sql = "SELECT H.ID, H.NOME, H.SOBRENOME, H.DATANASCIMENTO, H.NACIONALIDADE, H.TELEFONE, " +
                "H.RESERVAS_ID FROM HOSPEDES H WHERE H.SOBRENOME = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, sobrenome);
            statement.execute();

            try (ResultSet resultado = statement.getResultSet()) {

                while (resultado.next()) {

                    hospede.setId(resultado.getInt(1));
                    hospede.setNome(resultado.getString(2));
                    hospede.setSobrenome(resultado.getString(3));
                    hospede.setDataNascimento(resultado.getDate(4));
                    hospede.setNacionalidade(resultado.getString(5));
                    hospede.setTelefone(resultado.getString(6));
                    hospede.setReservaId(resultado.getInt(7));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return hospede;
    }

    public void editar(Integer id, String nome, String sobrenome, Date dataNascimento, String telefone) {

        String sql = "UPDATE HOSPEDES H SET H.NOME = ?, H.SOBRENOME = ?, " +
                "H.DATANASCIMENTO = ?, H.TELEFONE = ? WHERE H.ID = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, nome);
            statement.setString(2, sobrenome);
            statement.setDate(3, dataNascimento);
            statement.setString(4, telefone);
            statement.setInt(5, id);
            statement.execute();

            JOptionPane.showMessageDialog(null, "Hóspede com o id " + id + ", atualizado com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
