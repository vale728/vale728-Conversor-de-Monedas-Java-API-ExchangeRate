package lad.com.alura.conversormoneda;
import com.google.gson.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorApp {
    public Moneda ObtenerMoneda(String monedaOrigen) {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/9fa5f90648f051ef4c4a42af/latest/"+monedaOrigen))
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error de conexión con la API", e);
        }
    }

    public double conversionTasa(Moneda moneda, String monedaDestino){
        Double tasa= moneda.getConversion_rates().get(monedaDestino);

        if (tasa == null) {
            throw new RuntimeException("Moneda no soportada: " + monedaDestino);
        }
        return tasa;
    }

    public double convertir(double montoCambio, double tasaCambio) {
        return montoCambio * tasaCambio;
    }
}
