package ar.edu.unju.fi.ejercicio3.constantes;

public enum Provincia {
	JUJUY(780000, 53219),
    SALTA(1441000, 155488),
    TUCUMAN(1687000, 22524),
    CATAMARCA(406000, 102606),
    LA_RIOJA(398000, 89680),
    SANTIAGO_DEL_ESTERO(1011000, 136351);
	
	private int cantidadPoblacion;
    private int superficie;
    
	private Provincia(int cantidadPoblacion, int superficie) {
		this.cantidadPoblacion = cantidadPoblacion;
		this.superficie = superficie;
	}

	public int getCantidadPoblacion() {
		return cantidadPoblacion;
	}

	public void setCantidadPoblacion(int cantidadPoblacion) {
		this.cantidadPoblacion = cantidadPoblacion;
	}

	public int getSuperficie() {
		return superficie;
	}

	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}
    
	// método para calcular la densisdad de la población
	public double calcularDensidadPoblacional() {
        return (double) cantidadPoblacion / superficie;
    }

}
