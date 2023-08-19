package logica;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ConversorMonedas {

    private double cambioBase;
    private int decimal;
    private double resultado;
    private BigDecimal numeroRedondeado;

    public ConversorMonedas(double cambio) {
        this.cambioBase = cambio;
        decimal = 2;
    }

    public double convertirADivisaExtranjera(double cantidad) {
        numeroRedondeado = new BigDecimal(cantidad * this.cambioBase).setScale(2, RoundingMode.HALF_UP);
        this.resultado = numeroRedondeado.doubleValue();
        return this.resultado;
    }

    public double convertirADivisaBase(double cantidad) {
        numeroRedondeado = new BigDecimal(cantidad / this.cambioBase).setScale(2, RoundingMode.HALF_UP);
        this.resultado = numeroRedondeado.doubleValue();
        return this.resultado;
    }


}
