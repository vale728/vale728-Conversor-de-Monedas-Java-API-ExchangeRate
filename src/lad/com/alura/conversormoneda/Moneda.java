package lad.com.alura.conversormoneda;

import java.util.Map;

public class Moneda {
    private String result;
    private String base_code;
    private Map<String, Double> conversion_rates;

    public Map<String, Double> getConversion_rates() {
        return conversion_rates;
    }

    public String getResult() {
        return result;
    }

    public String getBase_code() {
        return base_code;
    }
}
