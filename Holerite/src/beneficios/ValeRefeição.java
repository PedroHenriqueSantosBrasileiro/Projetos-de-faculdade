package beneficios;

public class ValeRefeição {

        final byte TAXA_VALE_REFEIÇÃO = 3;
        double salarioMinimo = 1212.00;
        double descontoValeRefeição;

        public double CalculoDescontoValeRefeição(double x) {

            if (x <= salarioMinimo) {
                descontoValeRefeição = 0;
            } else {
                descontoValeRefeição = (x * (double) TAXA_VALE_REFEIÇÃO) / 100;

            }

            return descontoValeRefeição;
    }

}
