package org.enquadramento_obrigacao_PD;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class VerificaObrigacoesAtual {

    static void exec(List<Double> aportes_ICTsPublicas, List<Double> aportes_ICTsPrivadas, List<Double> Obrigacao_PD) {
        Double totalAportesICTsPublicas = sum(aportes_ICTsPublicas);
        Double totalAportesICTsPrivadas = sum(aportes_ICTsPrivadas);
        Double totalObrigacao_PD = sum(Obrigacao_PD);

        Double ObrigacaoIncI = totalObrigacao_PD * 0.9 / 5;
        Double ObrigacaoIncVI = totalObrigacao_PD * 0.4 / 5;

        Double DispendiosIncI = totalAportesICTsPublicas + totalAportesICTsPrivadas;
        Double DispendiosIncVI = totalAportesICTsPublicas;

        System.out.printf("TOTAL DE DISPÊNDIOS COM ICTs PÚBLICAS: %.2f\n", totalAportesICTsPublicas);
        System.out.printf("TOTAL DE DISPÊNDIOS COM ICTs PRIVADAS: %.2f\n", totalAportesICTsPrivadas);
        System.out.printf("TOTAL DE OBRIGAÇÕES DE P&D: %.2f\n", totalObrigacao_PD);
        System.out.printf("OBRIGAÇÃO DE P&D, conf inc I do § 1º do art 5º do Decreto 10.521/2020: %.2f\n", ObrigacaoIncI);
        System.out.printf("DISPÊNDOS DE P&D, conf inc I do § 1º do art 5º do Decreto 10.521/2020: %.2f\n", DispendiosIncI);
        System.out.printf("OBRIGAÇÃO DE P&D, conf inc VI do § 1º do art 5º do Decreto 10.521/2020: %.2f\n", ObrigacaoIncVI);
        System.out.printf("DISPÊNDOS DE P&D, conf inc VI do § 1º do art 5º do Decreto 10.521/2020: %.2f\n", DispendiosIncVI);

        if (DispendiosIncI >= ObrigacaoIncI) {
            System.out.println("Empresa adimplente conf inc I do § 1º do art 5º do Decreto 10.521/2020 - Forma Atual!");
        }
        else System.out.println("Empresa inadimplente conf inc I do § 1º do art 5º do Decreto 10.521/2020 - Forma Atual!");

        if (DispendiosIncVI >= ObrigacaoIncVI) {
            System.out.println("Empresa adimplente conf inc VI do § 1º do art 5º do Decreto 10.521/2020 - Forma Atual!");
        }
        else System.out.println("Empresa inadimplente conf inc VI do § 1º do art 5º do Decreto 10.521/2020 - Forma Atual!");


    }

    static Double sum(List<Double> list) {
        AtomicReference<Double> total = new AtomicReference<>((double) 0);
        list.forEach((Double num) -> {
            total.updateAndGet(v -> v + num);
        });
        return total.get();
    }
}
