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
        HoraExtra horaextra = new HoraExtra ();

        double salarioBruto,horaExtra, salarioLiquido, salarioMenosInss;
        String nome;

        System.out.println("Insira o nome do funcionário: ");
        nome = tc.nextLine();

        System.out.println("Insira o salário do Funcionário: ");
        salarioBruto = tc.nextDouble();
        
        System.out.println("Informe o valor de horas extras: ");
        horaExtra = tc.nextDouble();
        horaextra.CalculoHoraExtra(horaExtra, salarioBruto);
        
        

        inss.CalculoDescontoInss(salarioBruto);
        salarioMenosInss = horaextra.salarioBrutoMaisHoraExtra - inss.CalculoDescontoInss(horaextra.salarioBrutoMaisHoraExtra);

        System.out.println(nome);
        System.out.printf("Salario: %.2f%n",salarioBruto);
        System.out.printf("Hora Extra; %.2f%n",horaextra.salarioBrutoMaisHoraExtra);
        System.out.printf("Inss = %.2f%n", inss.CalculoDescontoInss(horaextra.salarioBrutoMaisHoraExtra));
        System.out.printf("Vt = %.2f%n", valeTransporte.CalculoDescontoValeTransporte(salarioBruto));
        System.out.printf("Ir = %.2f%n", irrf.CalculoDescontoIrrf(salarioMenosInss));
        System.out.printf("Vr = %.2f%n", valeRefeição.CalculoDescontoValeRefeição(salarioBruto));
        System.out.printf("VA = %.2f%n", valeAlimentação.CalculoValeAlimentação(salarioBruto));
        System.out.printf("Convenio = %.2f%n", convenio.CalculoDescontoConvenio(salarioBruto));

    }

}
