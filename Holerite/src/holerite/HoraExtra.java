package holerite;


public class HoraExtra {
    
double salarioBrutoMaisHoraExtra;
double valorHoraExtra;
double salarioPorHora;
int horasExtrasFeitas;


public double CalculoDaHora (int horasExtrasFeitas, double z){
    
salarioPorHora = ((z / 22) / 8);
valorHoraExtra = (salarioPorHora * 1.5) * (double)horasExtrasFeitas;

return valorHoraExtra;
    
}

public double CalculoHoraExtra (double x, double valorHoraExtra){
    salarioBrutoMaisHoraExtra = x + valorHoraExtra;
    
    return salarioBrutoMaisHoraExtra;
}
    
}
