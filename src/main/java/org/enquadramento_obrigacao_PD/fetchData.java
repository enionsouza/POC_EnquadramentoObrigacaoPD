package org.enquadramento_obrigacao_PD;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class fetchData {
    static List<Double> exec(String fileName) {
        String filePath = "/media/enionsouza/Data/Estudo/Projetos/Java/POC_EnquadramentoObrigacaoPD/src/main/resources/" + fileName + ".txt";
        List<Double> fetchedData = new ArrayList<>();
        try {
            FileReader srcData = new FileReader(filePath);
            BufferedReader bufferedSrcData = new BufferedReader(srcData);

            String line = bufferedSrcData.readLine();
            Double num;

            while (line != null) {
                num = Double.parseDouble(line);
                fetchedData.add(num);
                line = bufferedSrcData.readLine();
            }
        } catch (IOException e) {
            System.out.printf("Erro na leitura do arquivo %s!\n", filePath);
        }


        return fetchedData;
    }
}
