package circuito;

import java.util.concurrent.CopyOnWriteArrayList;

import circuito.Vehiculo.Direction;


public class Cruce extends Thread{
	/**
	 * @author Javier Mena Sanchez
	 */
	private Mapa map;

	private CopyOnWriteArrayList<Semaforo> listaSemaforos;
	
	/**
	 * Constructor de la clase
	 * 
	 * @param Mapa map
	 */
	public Cruce(Mapa map) {
		this.listaSemaforos = new CopyOnWriteArrayList<Semaforo>();
		this.map = map;
	}

	public CopyOnWriteArrayList<Semaforo> getListaSemaforos() {
		return listaSemaforos;
	}

	@Override
	/**
	 * run del thread, coloca los semaforos segun la direccion
	 */
	public void run() {
		aņadirSemaforo(12, 16, Direction.RIGHT);
		aņadirSemaforo(12, 16, Direction.LEFT);
		
		aņadirSemaforo(28, 16, Direction.UP);
		aņadirSemaforo(28, 16, Direction.DOWN);
		aņadirSemaforo(28, 16, Direction.RIGHT);
		aņadirSemaforo(28, 16, Direction.LEFT);

		
		aņadirSemaforo(28, 32, Direction.UP);   
		aņadirSemaforo(28, 32, Direction.DOWN); 
		aņadirSemaforo(28, 32, Direction.RIGHT);
		aņadirSemaforo(28, 32, Direction.LEFT); 
		
		aņadirSemaforo(12, 32, Direction.RIGHT);
		aņadirSemaforo(12, 32, Direction.LEFT);

		aņadirSemaforo(45, 16, Direction.UP);   
		aņadirSemaforo(45, 16, Direction.DOWN); 
		aņadirSemaforo(45, 16, Direction.RIGHT);
		aņadirSemaforo(45, 16, Direction.LEFT); 

		aņadirSemaforo(45, 32, Direction.UP);   
		aņadirSemaforo(45, 32, Direction.DOWN); 
		aņadirSemaforo(45, 32, Direction.RIGHT);
		aņadirSemaforo(45, 32, Direction.LEFT); 
		
	}
	/**
	 * Metodo para aņadir los semaforos dandoles unas coordenadas, iniciandolos y aņadiendolos a la array de semaforos
	 * 
	 * @param int iX
	 * @param int iY
	 * @param Direction direction
	 */
	public void aņadirSemaforo(int iX, int iY, Direction direction) {
		Semaforo semaforo = new Semaforo(map.getTilesMap()[iX][iY], direction);
		semaforo.start();

		listaSemaforos.add(semaforo);
	}
}
