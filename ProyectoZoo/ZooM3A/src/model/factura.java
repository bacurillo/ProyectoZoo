/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Bryan
 */
public class factura extends Cliente {

    //encabezado
    private int enca_id;
    private Date enca_fecha;
    private int enca_idCliente;
    //detalle
    private int det_id;
    private int det_cantidad;
    private double det_total;
    private int det_idenca;
    private int det_idticket;
    //pie
    private int pie_id;
    private double pie_subTotal;
    private double pie_descuento;
    private double pie_TOTAL;
    private int pie_idEnca;

    //FACTURA GROP BY
    private int Items;
    private int cantTotal;
//    private double sumaBoletos;

    public factura() {
    }

    public factura(int enca_id, Date enca_fecha, int enca_idCliente, int det_id, int det_cantidad, double det_total, int det_idenca, int det_idticket, int pie_id, double pie_subTotal, double pie_descuento, double pie_TOTAL, int pie_idEnca, int Items, int cantTotal) {
        this.enca_id = enca_id;
        this.enca_fecha = enca_fecha;
        this.enca_idCliente = enca_idCliente;
        this.det_id = det_id;
        this.det_cantidad = det_cantidad;
        this.det_total = det_total;
        this.det_idenca = det_idenca;
        this.det_idticket = det_idticket;
        this.pie_id = pie_id;
        this.pie_subTotal = pie_subTotal;
        this.pie_descuento = pie_descuento;
        this.pie_TOTAL = pie_TOTAL;
        this.pie_idEnca = pie_idEnca;
        this.Items = Items;
        this.cantTotal = cantTotal;
    }

    public int getItems() {
        return Items;
    }

    public void setItems(int Items) {
        this.Items = Items;
    }

    public int getCantTotal() {
        return cantTotal;
    }

    public void setCantTotal(int cantTotal) {
        this.cantTotal = cantTotal;
    }

    public int getEnca_id() {
        return enca_id;
    }

    public void setEnca_id(int enca_id) {
        this.enca_id = enca_id;
    }

    public Date getEnca_fecha() {
        return enca_fecha;
    }

    public void setEnca_fecha(Date enca_fecha) {
        this.enca_fecha = enca_fecha;
    }

    public int getEnca_idCliente() {
        return enca_idCliente;
    }

    public void setEnca_idCliente(int enca_idCliente) {
        this.enca_idCliente = enca_idCliente;
    }

    public int getDet_id() {
        return det_id;
    }

    public void setDet_id(int det_id) {
        this.det_id = det_id;
    }

    public int getDet_cantidad() {
        return det_cantidad;
    }

    public void setDet_cantidad(int det_cantidad) {
        this.det_cantidad = det_cantidad;
    }

    public double getDet_total() {
        return det_total;
    }

    public void setDet_total(double det_total) {
        this.det_total = det_total;
    }

    public int getDet_idenca() {
        return det_idenca;
    }

    public void setDet_idenca(int det_idenca) {
        this.det_idenca = det_idenca;
    }

    public int getDet_idticket() {
        return det_idticket;
    }

    public void setDet_idticket(int det_idticket) {
        this.det_idticket = det_idticket;
    }

    public int getPie_id() {
        return pie_id;
    }

    public void setPie_id(int pie_id) {
        this.pie_id = pie_id;
    }

    public double getPie_subTotal() {
        return pie_subTotal;
    }

    public void setPie_subTotal(double pie_subTotal) {
        this.pie_subTotal = pie_subTotal;
    }

    public double getPie_descuento() {
        return pie_descuento;
    }

    public void setPie_descuento(double pie_descuento) {
        this.pie_descuento = pie_descuento;
    }

    public double getPie_TOTAL() {
        return pie_TOTAL;
    }

    public void setPie_TOTAL(double pie_TOTAL) {
        this.pie_TOTAL = pie_TOTAL;
    }

    public int getPie_idEnca() {
        return pie_idEnca;
    }

    public void setPie_idEnca(int pie_idEnca) {
        this.pie_idEnca = pie_idEnca;
    }

}
