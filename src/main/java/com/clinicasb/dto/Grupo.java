/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinicasb.dto;


public class Grupo{
    private int exagrp;
    private String desgrp;

    public int getExagrp() {
        return exagrp;
    }

    public void setExagrp(int exagrp) {
        this.exagrp = exagrp;
    }

    public String getDesgrp() {
        return desgrp;
    }

    public void setDesgrp(String desgrp) {
        this.desgrp = desgrp;
    }

    public Grupo(int exagrp, String desgrp) {
        this.exagrp = exagrp;
        this.desgrp = desgrp;
    }

    public Grupo() {
    }
    
}