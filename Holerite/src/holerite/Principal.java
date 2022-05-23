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
        CalculoDescontos calculoDescontos = new CalculoDescontos();

        double salarioBruto, salarioLiquido, salarioMenosInss;
        char resposta[] = new char[6];
        double contadorDeDescontos[] = new double[6];
        String nome;

        while (resposta[5] != 'n' || resposta[5] != 'N') {

            if ((resposta[5] == 'n') || (resposta[5] == 'N')) {
                break;

            }

            while ((resposta[0] != '2') && (resposta[0] != '1')) {

                System.out.println("GERADOR DE HOLERITE");
                System.out.printf("[1] para continuar %n[2] para sair%n");
                resposta[0] = tc.next().charAt(0);
                if (resposta[0] == '2') {
                    break;
                } else if (resposta[0] != '2' & resposta[0] != '1') {
                    System.out.println("ERRO ESCOLHA UMA OPÇÃO VALIDA");
                    continue;
                }
            }
            if (resposta[0] == '2') {
                break;
            }
            do {

                System.out.println("Insira o nome do funcionário: ");
                //nome = tc.nextLine();
                nome = tc.nextLine();

                System.out.println("Insira o salário do Funcionário: ");
                salarioBruto = tc.nextDouble();

                System.out.println("Informe a quantidade horas extras feitas: ");
                horaextra.horasExtrasFeitas = tc.nextInt();
                horaextra.CalculoDaHora(horaextra.horasExtrasFeitas, salarioBruto);
                horaextra.CalculoHoraExtra(salarioBruto, horaextra.valorHoraExtra);

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

                System.out.println("---------------------------------------------------------");
                System.out.println("\t\t\t -Holerite_ \t\t\t");
                System.out.println("---------------------------------------------------------");
                System.out.printf("Nome: %s%n", nome);
                System.out.println("---------------------------------------------------------");
                System.out.println("PROVENTOS");
                System.out.printf("Salario: %.2f%n", salarioBruto);
                System.out.printf("Hora Extra: R$ %.2f%n", horaextra.valorHoraExtra);
                System.out.printf("TOTAL PROVENTOS: R$ %.2f%n", horaextra.salarioBrutoMaisHoraExtra);
                System.out.println("---------------------------------------------------------");
                System.out.println("Descontos");
                System.out.printf("INSS = %.2f%n", inss.CalculoDescontoInss(horaextra.salarioBrutoMaisHoraExtra));
                contadorDeDescontos[0] = inss.CalculoDescontoInss(horaextra.salarioBrutoMaisHoraExtra);
                System.out.printf("IRRF = %.2f%n", irrf.CalculoDescontoIrrf(salarioMenosInss));
                contadorDeDescontos[1] = irrf.CalculoDescontoIrrf(salarioMenosInss);

                if ((resposta[1] == 's') || (resposta[1] == 'S')) {
                    System.out.printf("Vale Transporte: %.2f%n", valeTransporte.CalculoDescontoValeTransporte(salarioBruto));
                    contadorDeDescontos[2] = valeTransporte.CalculoDescontoValeTransporte(salarioBruto);
                } else {
                    System.out.printf("Vale Transporte; R$ %.2f (Não Possui)%n", valeTransporte.NãoOptanteValeTransporte());
                    contadorDeDescontos[2] = valeTransporte.NãoOptanteValeTransporte();
                }

                if ((resposta[2] == 's') || (resposta[2] == 'S')) {
                    System.out.printf("Vale Refeição: R$ %.2f%n", valeRefeição.CalculoDescontoValeRefeição(salarioBruto));
                    contadorDeDescontos[3] = valeRefeição.CalculoDescontoValeRefeição(salarioBruto);
                } else {
                    System.out.printf("Vale Refeição: R$ %.2f (Não Possui)%n", valeRefeição.NãoOptanteValeRefeição());
                    contadorDeDescontos[3] = valeRefeição.NãoOptanteValeRefeição();
                }

                if ((resposta[3] == 's') || (resposta[3] == 'S')) {
                    System.out.printf("Vale Alimentação: R$ %.2f%n", valeAlimentação.CalculoValeAlimentação(salarioBruto));
                    contadorDeDescontos[4] = valeAlimentação.CalculoValeAlimentação(salarioBruto);
                } else {
                    System.out.printf("Vale Alimentação: R$ %.2f (Não Possui)%n", valeAlimentação.NãoOptanteValeAlimentação());
                    contadorDeDescontos[4] = valeAlimentação.NãoOptanteValeAlimentação();
                }

                if ((resposta[4] == 's') || (resposta[4] == 'S')) {
                    System.out.printf("Convenio Médico: R$ %.2f%n", convenio.CalculoDescontoConvenio(salarioBruto));
                    contadorDeDescontos[5] = convenio.CalculoDescontoConvenio(salarioBruto);
                } else {
                    System.out.printf("Convenio: R$ %.2f (Não Possui)%n", convenio.NãoOptanteConvenio());
                    contadorDeDescontos[5] = convenio.NãoOptanteConvenio();
                }
                calculoDescontos.CalcularTotalDescontos(contadorDeDescontos[0], contadorDeDescontos[1], contadorDeDescontos[2], contadorDeDescontos[3], contadorDeDescontos[4], contadorDeDescontos[5]);
                System.out.printf("TOTAL DE DESCONTOS: R$ %.2f%n", calculoDescontos.totalDescontos);
                System.out.println("---------------------------------------------------------");
                salarioLiquido = horaextra.salarioBrutoMaisHoraExtra - calculoDescontos.totalDescontos;
                System.out.printf("Salario Liquido: R$ %.2f%n", salarioLiquido);
                System.out.println("---------------------------------------------------------");

                System.out.println("Deseja fazer o Holerite de outro Funcionario? (S/N)");
                resposta[5] = tc.next().charAt(0);
                if ((resposta[5] == 'n') || (resposta[5] == 'N')) {
                    break;
                } else;

            } while (resposta[5] != 'n' || resposta[5] != 'N');

        }
    }
}
