package org.example;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.Objects;

import static spark.Spark.port;
import static spark.Spark.post;

public class Main {
    public static void main(String[] args) {
        PainelGrafico pg = new PainelGrafico();

        port(8080);

        post("/api", (req, res) -> {

            String corpoRequisicao = req.body();
            System.out.println("Corpo JSON: " + corpoRequisicao);

            JsonElement jsonElement = JsonParser.parseString(corpoRequisicao);
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            pg.inputFieldCodigoRecebido.setText(jsonObject.get("codigo").getAsString());
            String codigoRecebido = pg.inputFieldCodigoRecebido.getText().trim();

            String codigoCorreto = pg.inputFieldCodigoCorreto.getText().trim();

            // testar os valores para debugar:
            System.out.println("codigoRecebido: " + codigoRecebido); // Print the received code
            System.out.println("codigoCorreto: " + codigoCorreto); // Print the correct code

            if (Objects.equals(codigoRecebido, codigoCorreto)) {
                return "{\"ack\":\"1\"}";
            } else {
                return "{\"ack\":\"0\"}";
            }

        });
    }
}