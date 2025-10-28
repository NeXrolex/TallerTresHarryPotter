/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uDistrital.avanzada.tallerTres.control;

import com.uDistrital.avanzada.tallerTres.modelo.Mago;
import java.util.Random;

/**
 * Maneja el control de los magos y ayuda al proceso de hilos para la
 * concurrencia
 *
 * @author Alex
 * @version 1.0
 */
public class ControlMago extends Thread {

    private ControlGeneral cGeneral;
    private Mago mago;
    private Mago rival;
    private Random random = new Random();
    private Object lock;

    /**
     * Recibe la inyeccion del control General para respetar el bajo
     * acoplamiento
     *
     * @param cGeneral Control General
     */
    public ControlMago(ControlGeneral cGeneral, Object lock) {
        this.cGeneral = cGeneral;
        this.lock = lock;
    }

    public void setMagos(Mago mago, Mago rival) {
        this.mago = mago;
        this.rival = rival;
    }

    @Override
    public void run() {
        while (mago.getPuntaje() < 250 && rival.getPuntaje() < 250) {
            synchronized (lock) {
                try {
                    // Esperar si el mago está aturdido
                    if (mago.isEstadoAturdido()) {
                        lock.wait(random.nextInt(250) + 1);
                        mago.setEstado(false);
                        continue;
                    }

                    // Generar hechizo simulado (entre 5 y 25 puntos)
                    int puntosHechizo = random.nextInt(21) + 5;
                    mago.setPuntaje(mago.getPuntaje() + puntosHechizo);
                    mago.setCantidadHechizos(mago.getCantidadHechizos() + 1);

                    // Simular que el rival queda aturdido
                    rival.setEstado(true);

                    // Espera antes del siguiente turno
                    lock.notifyAll();
                    lock.wait(random.nextInt(500) + 1);

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
        synchronized (lock) {
            lock.notifyAll(); // Asegura que el otro hilo no quede bloqueado
        }
    }
}
