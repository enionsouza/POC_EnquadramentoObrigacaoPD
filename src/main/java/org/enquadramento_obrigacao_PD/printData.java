package org.enquadramento_obrigacao_PD;

import java.util.List;

public class printData {
    static void exec(List<Double> data, String dataType, String message) {
        System.out.println(message);

        final int[] i = {1};
        data.forEach((Double num) -> {
            System.out.println(dataType + " #" + i[0] + ": " + num);
            i[0]++;
        });
        System.out.println();
    }
}
