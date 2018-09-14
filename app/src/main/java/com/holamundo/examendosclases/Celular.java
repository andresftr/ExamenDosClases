package com.holamundo.examendosclases;

public class Celular {
    private String marca;
    private String color;
    private String sistOp;
    private int ram;
    private int precio;

    public Celular(String marca, String color, String sistOp, int ram, int precio) {
        this.marca = marca;
        this.color = color;
        this.sistOp = sistOp;
        this.ram = ram;
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSistOp() {
        return sistOp;
    }

    public void setSistOp(String sistOp) {
        this.sistOp = sistOp;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void guardar(){
        Datos.guardar(this);
    }
}
