import java.util.Scanner;
public class Tienda {
 
    static String[] nombres = new String[50];
    static int[] cantidad = new int[50];
    static int[] precios = new int[50];
    static int totalProductos = 0;
 
    static String[] Nombre_ventas = new String[100];
    static int[] Cantidad_Ventas = new int[100];
    static int[] Total_Ventas = new int[100];
    static int Totales_Vendidos = 0;
    static Scanner Ahuyama = new Scanner(System.in);
 
    public static void main(String[] args) {
 
        int option = 0;
 
        while(option != 5){
            System.out.println("\n /******************************************************");
            System.out.println("               Bienvenido a la tienda Douglas            ");
            System.out.println("******************************************************/");
            System.out.println("¿Que deseas hacer?");
            System.out.println("1 Ingresar nuevo producto");
            System.out.println("2 Realizar venta");
            System.out.println("3 Generar reporte de venta");
            System.out.println("4 Generar reporte de stock");
            System.out.println("5 Salir");
            System.out.println("Elija que deseas hacer: ");
           
            option = Ahuyama.nextInt();
            Ahuyama.nextLine();
 
            if(option == 1){
                IngresarProducto();
            }
            else if(option == 2){
                RealizarVenta();
            }
            else if(option == 3){
                reporte_de_ventas();
            }
            else if (option == 4){
                Reporte_de_Stock();
            }
            else if (option == 5){
                System.out.println("\n /******************************************************");
                System.out.println("          Muchas gracias por utilizar la tienda          ");
                System.out.println("******************************************************/");
            }
            else{
                System.out.println("******************************************************/");
                System.out.println("              La opcion no puede realizarse            ");
                System.out.println("******************************************************/");
            }
        }   

    }

    public static void IngresarProducto(){
        System.out.println("\n /******************************************************");
        System.out.println("                  Ingreso de nuevo producto             ");
        System.out.println("******************************************************/");
        System.out.println("Ingrese nombre del nuevo producto: ");
        String producto = Ahuyama.nextLine();
        int pos = BuscarProducto(producto);

        if (pos != -1){
            System.out.println("\n /******************************************************");
            System.out.println("           El producto ya esta registrado                ");
            System.out.println("******************************************************/");
            return;
        }
 
        System.out.println("Ingrese la cantidad que deseas agregar: ");
        int cantidades = Ahuyama.nextInt();
        System.out.println("Ingrese el precio del producto: ");
        int precio = Ahuyama.nextInt();
        Ahuyama.nextLine();
 
        if (cantidades < 0 || precio < 0){
            System.out.println("\n /******************************************************");
            System.out.println("           No se permiten numeros negativos              ");
            System.out.println("******************************************************/");
            return;
        }
 
        nombres[totalProductos] = producto;
        cantidad[totalProductos] = cantidades;
        precios[totalProductos] = precio;
        totalProductos++;

        System.out.println("\n /******************************************************");
        System.out.println("     Producto '" + producto + "' ha sido agregado con exito"   );
        System.out.println("******************************************************/");
    }
 
    public static void reporte_de_ventas() {

        if (Totales_Vendidos == 0) {
            System.out.println("\n /******************************************************");
            System.out.println("             No se ha registrado ventas"                  );
            System.out.println("******************************************************/");
            return;
        }
        System.out.println("\n /******************************************************");
        System.out.println("                     Reporte de ventas                  ");
        System.out.println("******************************************************/");
        for(int i = 0; i < Totales_Vendidos; i++){
            System.out.println("******************************************************/");
            System.out.println("Producto: " + Nombre_ventas[i] + " Cantidad vendida: " + Cantidad_Ventas[i] + " Total de venta: " + Total_Ventas[i]);
            System.out.println("******************************************************/");
        }
    }

    public static void RealizarVenta(){
        System.out.println("\n /******************************************************");
        System.out.println("                     Realizar venta                    ");
        System.out.println("******************************************************/");
        System.out.println("Ingrese el nombre del producto:");
        String producto = Ahuyama.nextLine();

        int pos = BuscarProducto(producto);
        if (pos == -1){
            System.out.println("\n /******************************************************");
            System.out.println("                 Producto no registrado                 ");
            System.out.println("******************************************************/");
            return;
        }
        System.out.println("Ingrese la cantidad de venta");
        int cantidadVendida = Ahuyama.nextInt();
        Ahuyama.nextLine();
        if (cantidadVendida <=0){
            System.out.println("\n /******************************************************");
            System.out.println("                   Cantidad Invalida                     ");
            System.out.println("*******************************************************/");
            return;
        }
        if (cantidadVendida > cantidad[pos]) {
            System.out.println("\n /******************************************************");
            System.out.println("              Stock insuficiente " + cantidad[pos]          );
            System.out.println("******************************************************/");
            return;
        }
        int total = cantidadVendida * precios[pos];
        cantidad[pos]-= cantidadVendida;
        Nombre_ventas[Totales_Vendidos]= producto;
        Cantidad_Ventas[Totales_Vendidos]= cantidadVendida;
        Total_Ventas[Totales_Vendidos]= total;
        Totales_Vendidos ++;

        System.out.println("\n /******************************************************");
        System.out.println("              venta realizada exitosamente" + total         );
        System.out.println("******************************************************/");
    }
    public static void Reporte_de_Stock(){
        System.out.println("\n /******************************************************");
        System.out.println("                     Reporte de Stock                  ");
        System.out.println("******************************************************/");
        if (totalProductos == 0){
        System.out.println("\n /******************************************************");
        System.out.println("           No se encuentran producto registrado"         );
        System.out.println("******************************************************/");
        return;
        }
        System.out.println("\n /******************************************************");
        System.out.println("             Este es tu reporte de stock                 ");
        System.out.println("******************************************************/");

        for (int i = 0; i < totalProductos; i++){
            System.out.println("******************************************************/");
            System.out.println("Producto: " + nombres[i] + " Cantidad disponible: " + cantidad[i]);
            System.out.println("******************************************************/");
        }
    }
    public static int BuscarProducto(String producto){

        for(int i = 0; i < totalProductos; i++){
            if(nombres[i].equalsIgnoreCase(producto)){
                return i;
            }
        }
        return -1;
    }
}
 
