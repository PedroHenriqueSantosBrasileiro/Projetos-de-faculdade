package holerite;

import descontosFolha.*;
import beneficios.*;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner tc = new Scanner(System.in);
        Inss inss = new Inss();
        ValeTransporte valeTransporte = new ValeTransporte();
        Irrf irrf = new Irrf();
        ValeRefeição valeRefeição = new ValeRefeição();
        ValeAlimentação valeAlimentação = new ValeAlimentação();
        Convenio convenio = new Convenio();
        HoraExtra horaextra = new HoraExtra();

        double salarioBruto, horaExtra, salarioLiquido, salarioMenosInss;
        String nome;
        char resposta[] = new char[6];

        do {

            System.out.println("GERADOR DE HOLERITE");
            System.out.println("Digite 1 para continuar e 2 para sair");
            resposta[0] = tc.next().charAt(0);
            if (resposta[0] == '2') {
                break;
            }

            System.out.println("Insira o nome do funcionário: ");
            nome = tc.next();

            System.out.println("Insira o salário do Funcionário: ");
            salarioBruto = tc.nextDouble();

            System.out.println("Informe o valor de horas extras(se possuir): ");
            horaExtra = tc.nextDouble();
            horaextra.CalculoHoraExtra(horaExtra, salarioBruto);

            inss.CalculoDescontoInss(salarioBruto);
            salarioMenosInss = horaextra.salarioBrutoMaisHoraExtra - inss.CalculoDescontoInss(horaextra.salarioBrutoMaisHoraExtra);

            System.out.println("O funcionario possui vale transporte? (S/N)");
            resposta[1] = tc.next().charAt(0);

            System.out.println("O funcionario possui vale refeiçao? (S/N)");
            resposta[2] = tc.next().charAt(0);

            System.out.println("O funcionario possui vale alimentação? (S/N)");
            resposta[3] = tc.next().charAt(0);

            System.out.println("O funcionario possui convenio médico? (S/N)");
            resposta[4] = tc.next().charAt(0);

            System.out.println(nome);
            System.out.printf("Salario: %.2f%n", salarioBruto);
            System.out.printf("Hora Extra; %.2f%n", horaExtra);
            System.out.printf("Inss = %.2f%n", inss.CalculoDescontoInss(horaextra.salarioBrutoMaisHoraExtra));

            if ((resposta[1] == 's') || (resposta[1] == 'S')) {
                System.out.printf("Vt = %.2f%n", valeTransporte.CalculoDescontoValeTransporte(salarioBruto));
            } else {
                System.out.println("Vt = R$ 0,00 (Não Possui)");
            }

            System.out.printf("Ir = %.2f%n", irrf.CalculoDescontoIrrf(salarioMenosInss));

            if ((resposta[2] == 's') || (resposta[2] == 'S')) {
                System.out.printf("Vr = %.2f%n", valeRefeição.CalculoDescontoValeRefeição(salarioBruto));
            } else {
                System.out.println("Vr = R$ 0,00 (Não Possui)");
            }

            if ((resposta[3] == 's') || (resposta[3] == 'S')) {
                System.out.printf("VA = %.2f%n", valeAlimentação.CalculoValeAlimentação(salarioBruto));
            } else {
                System.out.println("VA = R$ 0,00 (Não Possui)");
            }

            if ((resposta[4] == 's') || (resposta[4] == 'S')) {
                System.out.printf("Convenio = %.2f%n", convenio.CalculoDescontoConvenio(salarioBruto));
            } else {
                System.out.println("Convenio = R$ 0,00 (Não Possui)");
            }

            System.out.println("Deseja fazer o Holerite de outro Funcionario? (S/N)");
            resposta[5] = tc.next().charAt(0);
            if ((resposta[5] == 'n') || (resposta[5] == 'N')) {
                break;
            }

        } while (resposta[5] != 'n' || resposta[5] != 'N');
    }
}
