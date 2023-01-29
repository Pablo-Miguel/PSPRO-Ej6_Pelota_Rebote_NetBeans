/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pspro.ej6_pelota_rebote.threads;

import com.mycompany.pspro.ej6_pelota_rebote.model.Pelota;
import com.mycompany.pspro.ej6_pelota_rebote.view.PanelRebote;

/**
 *
 * @author Nitro
 */
public class PelotaThread extends Thread {
    
    private static final int NUM_MOVIMIENTOS = 1000;
    public PanelRebote zonaRebote;
    
    public PelotaThread(String name, PanelRebote zonaRebote) {
        super(name);
        this.zonaRebote = zonaRebote;
    }

    @Override
    public void run() {
        lanzarJuego();
    }
    
    public synchronized void lanzarJuego(){
        Pelota pelota = new Pelota(zonaRebote);//pasarle zonarebote y que se pinte a s� misma

        zonaRebote.add(pelota);

        for (int i = 1; i < NUM_MOVIMIENTOS; i++) {

            pelota.paint();

            //zonaRebote.paint(zonaRebote.getGraphics());//borrar y que paint sea llamado desde update o update desde un paint de pelota
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) { }

        }
    }
    
}
