package br.com.hotelAlura.front.views;

import javax.swing.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class Comandos {

    public static void encerra() {

        int escolha = JOptionPane.showConfirmDialog(null, "Deseja sair?",
                "Hotel Alura", JOptionPane.YES_NO_OPTION);

        if (escolha == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Finalizando Programa",
                    "Hotel Alura", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }

    public static boolean prosseguirComReserva(LocalDate checkIn, LocalDate checkOut) {
        long diasReservados = ChronoUnit.DAYS.between(checkIn, checkOut);
        if (diasReservados < 0) {
            JOptionPane.showMessageDialog(null, "Não pode ser uma data retroativa",
                    "Atenção", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        if (checkIn.isBefore(LocalDate.now())) {
            JOptionPane.showMessageDialog(null, "A data de check in não pode estar no passado",
                    "Atenção", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        if (diasReservados > 30) {
            JOptionPane.showMessageDialog(null, "O máximo de dias da reserva é 30 dias",
                    "Atenção", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        return true;
    }

    public static int gerarIdAleatorio() {
        int numeroAleatorio = 0;

        while (numeroAleatorio < 999) {
            Random random = new Random();
            numeroAleatorio = random.nextInt(10000);
        }


        return numeroAleatorio;
    }

    public static String verificaInput(String entrada, String campo) {
        if (entrada.isEmpty() || entrada.isBlank()) {
            JOptionPane.showMessageDialog(null, "O campo " + campo + " não pode estar em branco",
                    "Atenção", JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
        return entrada;
    }

    public static LocalDate verificaInput(LocalDate date) {

        long idade = ChronoUnit.DAYS.between(date, LocalDate.now());
        if (idade < 6571) {
            JOptionPane.showMessageDialog(null, "A reserva só é possível para maiores de 18 anos",
                    "Atenção", JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
        return date;
    }

    public static String verificaInput(String entrada) {


        if (entrada.isEmpty() || entrada.isBlank()) {
            JOptionPane.showMessageDialog(null, "O campo TELEFONE não pode estar em branco",
                    "Atenção", JOptionPane.INFORMATION_MESSAGE);
            return null;
        } else if (entrada.length() != 11) {
            JOptionPane.showMessageDialog(null, "No campo TELEFONE digite apenas os números com o DDD",
                    "Atenção", JOptionPane.INFORMATION_MESSAGE);
            return null;
        } else {
            for (char caractere : entrada.toCharArray()) {
                if (!Character.isDigit(caractere)) {
                    JOptionPane.showMessageDialog(null, "No campo TELEFONE digite apenas os números com o DDD",
                            "Atenção", JOptionPane.INFORMATION_MESSAGE);
                    return null;
                }
            }
        }
        return entrada;
    }

    public static boolean buscar (String entrada) {

        if (entrada.length() == 4) {
            for (char caractere : entrada.toCharArray()) {
                if (!Character.isDigit(caractere)) {
                    JOptionPane.showMessageDialog(null, "Digite apenas os 4 números da reserva",
                            "Atenção", JOptionPane.INFORMATION_MESSAGE);
                    return false;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Digite os 4 números da reserva",
                    "Atenção", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        return true;
    }

    public static BigDecimal calcularValor(Long dias) {
        long valorTotal = 100 * dias;
        return BigDecimal.valueOf(valorTotal);
    }
}
