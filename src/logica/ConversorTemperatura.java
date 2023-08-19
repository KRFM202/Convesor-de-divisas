package logica;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ConversorTemperatura {

    private final double constanteKelvin = 273.15;
    private final double constanteFahren = 32;
    private final double constanteFahrenDecimal = 1.8;
    private double resultado;

    public ConversorTemperatura() {
        resultado = 0;
    }

    public void convertirAKevin(double valor) {
        this.resultado = valor + constanteKelvin;
    }

    public void convertirAFahren(double valor) {
        this.resultado = valor * this.constanteFahrenDecimal + this.constanteFahren;
    }

    public void pasarDeKelvin(double valor) {
        this.resultado = valor - this.constanteKelvin;
    }

    public void pasarDeFahren(double valor) {
        this.resultado = (valor - this.constanteFahren) / this.constanteFahrenDecimal;
    }

    public double getResultado() {
        BigDecimal numeroRedondeado = new BigDecimal(this.resultado).setScale(2, RoundingMode.HALF_UP);
        return this.resultado = numeroRedondeado.doubleValue();
    }
}
