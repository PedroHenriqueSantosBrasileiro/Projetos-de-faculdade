package beneficios;

public class ValeTransporte {

    final byte TAXA_VALE_TRANSPORTE = 6;
    double descontoValeTransporte;

    public double CalculoDescontoValeTransporte(double x) {

        descontoValeTransporte = (x * (double) TAXA_VALE_TRANSPORTE) / 100;
        return descontoValeTransporte;

    }
    
    public double NãoOptanteValeTransporte() {

        descontoValeTransporte = 0;
        return descontoValeTransporte;

    }
}
