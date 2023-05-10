package org.enquadramento_obrigacao_PD;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Double> Dispendio_ICTsPublicas = fetchData.exec("ICTsPublicas");
        List<Double> Dispendio_ICTsPrivadas = fetchData.exec("ICTsPrivadas");
        List<Double> Obrigacao_PD = fetchData.exec("Obrigacao_P&D");

        printData.exec(Dispendio_ICTsPublicas, "ICT Pública", "*** Dispêndios com ICTs Públicas ***");
        printData.exec(Dispendio_ICTsPrivadas, "ICT Privada", "*** Dispêndios com ICTs Privadas ***");
        printData.exec(Obrigacao_PD, "Obrigação", "*** Total de Obrigações de P&D ***");

        VerificaObrigacoesAtual.exec(Dispendio_ICTsPublicas, Dispendio_ICTsPrivadas, Obrigacao_PD);
        System.out.println("\n\n");
        VerificaObrigacoesProposta.exec(Dispendio_ICTsPublicas, Dispendio_ICTsPrivadas, Obrigacao_PD);
    }
}