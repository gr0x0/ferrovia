package ObserverPattern;

public interface ObservadoIF {
	
	public void add(ObservadorIF o);
	public void remove(ObservadorIF o);
	public int get(int i);

}
