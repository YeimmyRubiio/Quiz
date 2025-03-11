package org.example;

public class Producto1 {

    private int codigo;
    private String nombre_producto;
    private int precio_producto;
    private int cantidad_producto;

    public Producto1() {
    }

    public Producto1(int codigo, String nombre_producto, int precio_producto, int cantidad_producto) {
        this.codigo = codigo;
        this.nombre_producto = nombre_producto;
        this.precio_producto = precio_producto;
        this.cantidad_producto = cantidad_producto;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public int getPrecio_producto() {
        return precio_producto;
    }

    public void setPrecio_producto(int precio_producto) {
        this.precio_producto = precio_producto;
    }

    public int getCantidad_producto() {
        return cantidad_producto;
    }

    public void setCantidad_producto(int cantidad_producto) {
        this.cantidad_producto = cantidad_producto;
    }

    public void venderProducto(int cantidad) {

        if (cantidad_producto >= cantidad) {
            System.out.println("Venta realizada. Stock actual: " + cantidad_producto);
        } else {
            System.out.println("No hay suficiente stock.");
        }
    }

    public void aplicarDescuento(double porcentaje) {
        precio_producto -= precio_producto * (porcentaje / 100);
        System.out.println("Descuento aplicado. Precio actual: " + precio_producto);
    }

    public void mostrarInformacion(){
        System.out.println(" Codigo " + codigo);
        System.out.println(" Nombre " + nombre_producto);
        System.out.println(" Precio " + precio_producto );
        System.out.println(" Cantidad " + cantidad_producto);
    }

    public void aumentarPrecio(double porcentaje) {
        precio_producto += precio_producto * (porcentaje / 100);
        System.out.println("Precio aumentado. Precio actual: " + precio_producto);
    }
}
