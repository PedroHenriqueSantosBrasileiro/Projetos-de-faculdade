package descontosFolha;

public class Inss {

    double descontoInss;

    final double ALIQUOTA_1 = 7.5;
    final double ALIQUOTA_2 = 9;
    final double ALIQUOTA_3 = 12;
    final double ALIQUOTA_4 = 14;
    

    public double CalculoDescontoInss(double x) {
        if (x <= 1212.00) {
            descontoInss = (ALIQUOTA_1 * x) / 100;
        } else if (x >= 1212.01 & x <= 2427.35) {
            descontoInss = ((ALIQUOTA_2 * x) / 100) - 18.18;
        } else if (x >= 2427.36 & x <= 3641.03) {
            descontoInss = ((ALIQUOTA_3 * x) / 100) - 91.00;
        } else if (x >= 3641.04 & x <= 7087.22 ) {
            descontoInss = ((ALIQUOTA_4 * x) / 100) - 163.82;

        }else if(x >= 7087.23){
            descontoInss = 828.39;
        }

        return descontoInss;
    }

}
    


