package lad.com.alura.conversormoneda;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        boolean salir= false;
        String monedaOrigen="";
        String monedaDestino="";

        Scanner teclado = new Scanner(System.in);
        ConversorApp app=new ConversorApp();

        while(!salir){

            String menu= """
                    ********************************************************************\n
                    Sea bienvenido/a al Conversor de Moneda =]\n\n
                    1) Dólar =>> Peso Argentino
                    2) Peso argentino =>> Dólar
                    3) Dólar =>> Real brasileño
                    4) Real brasileno =>> Dólar
                    5) Dólar =>> Peso colombiano
                    6) Peso colombiano =>> Dólar
                    7) Dólar =>> Sol peruano
                    8) Salir\n
                    
                    Elije una opción válida:\n
                    
                    ********************************************************************
                    """;
            System.out.println(menu);
            int opcion= teclado.nextInt();

            if(opcion==8){
                salir=true;
                System.out.println("Gracias por su visita! =] ");
                continue;
            }

            switch (opcion) {
                case 1 -> {
                    monedaOrigen = "USD";
                    monedaDestino = "ARS";
                }
                case 2 -> {
                    monedaOrigen = "ARS";
                    monedaDestino = "USD";
                }
                case 3 -> {
                    monedaOrigen = "USD";
                    monedaDestino = "BRL";
                }
                case 4 -> {
                    monedaOrigen = "BRL";
                    monedaDestino = "USD";
                }
                case 5 -> {
                    monedaOrigen = "USD";
                    monedaDestino = "COP";
                }
                case 6 -> {
                    monedaOrigen = "COP";
                    monedaDestino = "USD";
                }
                case 7 -> {
                    monedaOrigen = "USD";
                    monedaDestino = "PEN";
                }
                default -> {
                    System.out.println("Opcion no valida");
                    continue;
                }
            }
            Moneda monedaObj = app.ObtenerMoneda(monedaOrigen);
            System.out.println("Ingrese el monto que desea cambiar desde " + monedaObj.getBase_code() + ": ");
            double monto= teclado.nextDouble();

            double tasa= app.conversionTasa(monedaObj,monedaDestino);
            double resultado= app.convertir(monto,tasa);

            System.out.printf("Se convirtió %.2f %s a %.2f %s %n",
                    monto, monedaOrigen, resultado, monedaDestino);
        };
        teclado.close();
    }
}