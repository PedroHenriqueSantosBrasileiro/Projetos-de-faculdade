package descontosFolha;

public class Irrf {

    double descontoIrrf;

    double ALIQUOTA_1 = 7.5;
    double ALIQUOTA_2 = 15;
    double ALIQUOTA_3 = 22.5;
    double ALIQUOTA_4 = 27.5;

    public double CalculoDescontoIrrf(double x) {
        if (x <= 1903.98) {
            descontoIrrf = 0;
        } else if (x >= 1903.99 & x <= 2826.65) {
            descontoIrrf = ((ALIQUOTA_1 * x) / 100) - 142.80;
        } else if (x >= 2826.66 & x <= 3751.05) {
            descontoIrrf = ((ALIQUOTA_2 * x) / 100) - 354.80;
        } else if (x >= 3751.06 & x <= 4664.68) {
            descontoIrrf = ((ALIQUOTA_3 * x) / 100) - 636.13;
        } else if (x >= 4664.69 ) {
            descontoIrrf = ((ALIQUOTA_4 * x) / 100) - 869.36;

            
        }
        return descontoIrrf;
        
    }
}