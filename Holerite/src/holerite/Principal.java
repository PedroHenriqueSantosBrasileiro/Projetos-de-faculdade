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

        double salarioBruto, salarioLiquido, salarioBrutoMenosInss;
        String nome;

        System.out.println("Insira o nome do funcionário: ");
        nome = tc.nextLine();

        System.out.println("Insira o salário do Funcionário: ");
        salarioBruto = tc.nextDouble();

        inss.CalculoDescontoInss(salarioBruto);
        salarioBrutoMenosInss = salarioBruto - inss.CalculoDescontoInss(salarioBruto);

        System.out.println(nome);
        System.out.printf("Inss = %.2f%n", inss.CalculoDescontoInss(salarioBruto));
        System.out.printf("Vt = %.2f%n", valeTransporte.CalculoDescontoValeTransporte(salarioBruto));
        System.out.printf("Ir = %.2f%n", irrf.CalculoDescontoIrrf(salarioBrutoMenosInss));
        System.out.printf("Vr = %.2f%n", valeRefeição.CalculoDescontoValeRefeição(salarioBruto));
        System.out.printf("VA = %.2f%n", valeAlimentação.CalculoValeAlimentação(salarioBruto));
        System.out.printf("Convenio = %.2f%n", convenio.CalculoDescontoConvenio(salarioBruto));

    }

}
