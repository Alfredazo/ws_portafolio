/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portafolio.modelos;

/**
 *
 * @author Alfredazo
 */
public class Algo {
    private String id;
    private String id2;

    public Algo(String id, String id2) {
        this.id = id;
        this.id2 = id2;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId2() {
        return id2;
    }

    public void setId2(String id2) {
        this.id2 = id2;
    }

    @Override
    public String toString() {
        return "Algo{" + "id=" + id + ", id2=" + id2 + '}';
    }
    
}
