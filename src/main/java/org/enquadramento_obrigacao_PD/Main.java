package org.enquadramento_obrigacao_PD;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Double> aportes_ICTsPublicas = fetchData.exec("ICTsPublicas");
        List<Double> aportes_ICTsPrivadas = fetchData.exec("ICTsPrivadas");
        List<Double> Obrigacao_PD = fetchData.exec("Obrigacao_P&D");

        printData.exec(aportes_ICTsPublicas, "ICT Pública", "*** Dispêndios com ICTs Públicas ***");
        printData.exec(aportes_ICTsPrivadas, "ICT Privada", "*** Dispêndios com ICTs Privadas ***");
        printData.exec(Obrigacao_PD, "Obrigação", "*** Total de Obrigações de P&D ***");

        VerificaObrigacoesAtual.exec(aportes_ICTsPublicas, aportes_ICTsPrivadas, Obrigacao_PD);
        System.out.println("\n\n");
        VerificaObrigacoesProposta.exec(aportes_ICTsPublicas, aportes_ICTsPrivadas, Obrigacao_PD);
    }
}