package clase;

import javax.swing.JLabel;
import javax.swing.JProgressBar;

/**
 *
 * @author Graciela
 */
public class CaballosHilo extends Thread {
    
    public static final int INICIO = 10;

    private String nombre;
    private int meta;
    private int pos;
    private int avance;
    private JLabel caballo;
    private JLabel nomLabel;
    private JProgressBar barra;

    private MainCarrera ventana;
    private long time;

    public CaballosHilo(String nombre, JLabel caballo,JProgressBar barra ,int pos, MainCarrera ventana, int meta) {
        this.nombre = nombre;
        this.caballo = caballo;
        this.barra = barra;
        this.ventana = ventana;
        this.meta = meta;
        this.pos = pos;
        this.avance = 0;
    }

    @Override
    public void run() {

        long inicio = System.currentTimeMillis();
        barra.setMaximum(meta - pos);
        barra.setValue(0);
        
        

        while (pos + avance < meta) {

            avance = avance + (int) (Math.random() * 10) + 1;

            if (pos + avance > meta) {

                avance = meta - pos;

            }

            caballo.setLocation(pos + avance, caballo.getY());
            nomLabel.setLocation(pos + avance, nomLabel.getY());
            
            try{
                Thread.sleep(50);
            }catch(InterruptedException e){
                System.out.println("Interrupted");
            }
        }
        
        time = System.currentTimeMillis() - inicio;
        ventana.caballoTermino();

    }

    public String getNombre() {
        return nombre;
    }

    public long getTime() {
        return time;
    }
    
    

    public int getPos() {
        return pos;
    }

    public int getAvance() {
        return avance;
    }
    
    

}
