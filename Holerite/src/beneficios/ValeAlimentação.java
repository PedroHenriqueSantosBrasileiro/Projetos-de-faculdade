package beneficios;

public class ValeAlimentação {

    final byte TAXA_VALE_ALIMENTAÇÃO = 2;
    final double TRES_SALARIOS_MINIMOS = 3636.00;
    double descontoValeAlimentação;

    public double CalculoValeAlimentação(double x) {
        if (x <= TRES_SALARIOS_MINIMOS) {
            descontoValeAlimentação = 0;

        } else {
            descontoValeAlimentação = (x * (double) TAXA_VALE_ALIMENTAÇÃO) / 100;
        }
        return descontoValeAlimentação;
    }
    
    public double NãoOptanteValeAlimentação() {
    descontoValeAlimentação = 0;
    return descontoValeAlimentação;   
    }
}
