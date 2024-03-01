package fp.trenes;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

import fp.utiles.Checkers;

public interface TrayectoTren extends Comparable<TrayectoTren> {

	/**
	 * @return El código del tren
	 */
	String getCodigoTren();
	/**
	 * @return El nombre del tren
	 */
	String getNombre();
	/**
	 * @return El tipo del tren
	 */
	TipoTren getTipoTren();
	/**
	 * @return Una lista con los nombres de las estaciones del trayecto
	 */
	List<String> getEstaciones();
	/**
	 * @return Una lista con las horas de salida de las estaciones del trayecto
	 */
	List<LocalTime> getHorasSalida();
	/**
	 * @return Una lista con las horas de llegada a las estaciones del trayecto
	 */
	List<LocalTime> getHorasLlegada();
	/**
	 * @return La hora de salida de la primera estación del trayecto
	 */
	LocalTime getHoraSalida();
	/**
	 * @return La hora de llegada de la última estación del trayecto
	 */
	LocalTime getHoraLlegada();
	/**
	 * @param estacion Nombre de estación
	 * @return La hora de salida de la estación dada como parámetro. Si la estación no pertenece al trayecto, devuelve null
	 */
	LocalTime getHoraSalida(String estacion);
	/**
	 * @param estacion Nombre de estación
	 * @return La hora de llegada a la estación dada como parámetro. Si la estación no pertenece al trayecto, devuelve null
	 */
	LocalTime getHoraLlegada(String estacion);
	/**
	 * @return La duración total del trayecto
	 */
	Duration getDuracionTrayecto();
	
	/**
	 * Añade la estación con el nombre, hora de inicio y hora de fin a la posición dada como parámetro
	 * @param posicion Índice de la estación en el trayecto
	 * @param estacion Nombre de estación
	 * @param horaLlegada Hora de llegada a la estación
	 * @param horaSalida Hora de salida de la estación
	 * @throws IllegalArgumentException si la posición intermedia no está entre 1 y n
	 * @throws IllegalArgumentException si la posición de lsalida no es posterior a la de llegada
	 * @throws IllegalArgumentException si la hora llegada no es posterior a hora salida estación anterior
	 * @throws IllegalArgumentException si la hora salida no es anterior a hora llegada estación posterior
	 */
	void anadirEstacionIntermedia(int posicion, String estacion, 
			LocalTime horaLlegada, LocalTime horaSalida);
	
	/**
	 * Elimina la estación del trayecto cuyo nombre es el dado como parámetro, 
	 * siempre que no sea la estación inicial o la estación final. 
	 * @param estacion Nombre de la estación
	 * @throws IllegalArgumentException si La estación no está en el trayecto
	 * @throws IllegalArgumentException si la estación es la primera o la última del trayecto
	 * 
	 */
	void eliminarEstacionIntermedia(String estacion);
}