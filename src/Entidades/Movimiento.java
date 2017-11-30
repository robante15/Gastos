/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author roban
 */
public class Movimiento {
    private String descripcion;
    private String tipomovimiento;
    private String fecha;
    private Double monto;

    public Movimiento(String descripcion, String tipomovimiento, String fecha, Double monto) {
        this.descripcion = descripcion;
        this.tipomovimiento = tipomovimiento;
        this.fecha = fecha;
        this.monto = (double)Math.round(monto * 100d) / 100d;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipomovimiento() {
        return tipomovimiento;
    }

    public void setTipomovimiento(String tipomovimiento) {
        this.tipomovimiento = tipomovimiento;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
}
