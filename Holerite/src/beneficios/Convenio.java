package beneficios;

public class Convenio {

    final byte TAXA_CONVENIO = 4;
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
    public double NãoOptanteConvenio() {
      descontoConvenio = 0;
      return descontoConvenio;
    }

}
    

