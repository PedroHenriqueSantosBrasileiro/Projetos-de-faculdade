package beneficios;

public class Convenio {

    final byte TAXA_CONVENIO = 2;
    final double salarioMinimo = 1212;
    double descontoConvenio;

    public double CalculoDescontoConvenio(double x) {

        if (x <= salarioMinimo) {
            descontoConvenio = 0;
        } else {
            descontoConvenio = (x * (double) TAXA_CONVENIO) / 100;

        }
        return descontoConvenio;

    }

}
    

