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
            System.out.println ("Bienvenido a la tienda Douglas");
            System.out.println("¿Que deseas hacer?");
            System.out.println ("1 Ingresar nuevo producto");
            System.out.println ("2 Realizar venta");
            System.out.println ("3 Generar reporte de venta");
            System.out.println ("4 Generar reporte de stock");
            System.out.println ("5 Salir");
            System.out.print ("Elija que deseas hacer: ");
            
            option = Ahuyama.nextInt();
            Ahuyama.nextLine();

            if(option == 1){
                IngresarProducto();
    }
}
}

    public static void IngresarProducto(){
        System.out.print("Ingrese nombre del nuevo producto: ");
        String producto = Ahuyama.nextLine();

        int pos = BuscarProducto(producto);
        if (pos != -1){
            System.out.println("El producto ya esta registrado");
            return;
        }

        System.out.println("Ingrese la cantidad que deseas agregar: ");
        int cantidades = Ahuyama.nextInt();

        System.out.println("Ingrese el precio del producto: ");
        int precio = Ahuyama.nextInt();
        Ahuyama.nextLine();

        if (cantidades < 0 || precio < 0){
            System.out.println("No se permiten numeros negativos");
            return;
        }
        nombres[totalProductos] = producto;
        cantidad[totalProductos] = cantidades;
        precios[totalProductos] = precio;
        totalProductos++;

        System.out.println("Productos " + nombres + "a sido agregado con exito");
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