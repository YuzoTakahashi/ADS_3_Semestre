package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LimiteUltrapassadoException extends Exception{
    String dataHora;

    public LimiteUltrapassadoException(String msg){
        super(msg);
        dataHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));

    }

    public static void main(String[] args) {
    }
}
