package ar.edu.unju.fi.ejercicio5.model;

public class Producto {
		public enum OrigenFabricacion {
			ARGENTINA, CHINA, BRASIL, URUGUAY;
		}
		public enum Categoria {
			TELEFONIA, INFORMATICA, ELECTROHOGAR, HERRAMIENTAS;
		}
		private String codigo;
		private String descripcion;
		private double precioUnitario;
		private OrigenFabricacion origenFabricacion;
		private Categoria categoria;
		private boolean estado;
		
		public Producto(String codigo, String descripcion, double precioUnitario, OrigenFabricacion origenFabricacion,
				Categoria categoria,  boolean estado) {
			this.codigo = codigo;
			this.descripcion = descripcion;
			this.precioUnitario = precioUnitario;
			this.origenFabricacion = origenFabricacion;
			this.categoria = categoria;
			this.estado= estado;
		}
		
		public String getCodigo() {
			return codigo;
		}
		public void setCodigo(String codigo) {
			this.codigo = codigo;
		}
		public String getDescripcion() {
			return descripcion;
		}
		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
		public double getPrecioUnitario() {
			return precioUnitario;
		}
		public void setPrecioUnitario(double precioUnitario) {
			this.precioUnitario = precioUnitario;
		}
		public OrigenFabricacion getOrigenFabricacion() {
			return origenFabricacion;
		}
		public void setOrigenFabricacion(OrigenFabricacion origenFabricacion) {
			this.origenFabricacion = origenFabricacion;
		}
		public Categoria getCategoria() {
			return categoria;
		}
		public void setCategoria(Categoria categoria) {
			this.categoria = categoria;
		}
		public boolean getEstado() {
			return estado;
		}
		public void setEstado(boolean estado) {
			this.estado=estado;
		}
		@Override
		public String toString() {
			return "[Codigo=" + codigo + ", Descripcion=" + descripcion + ", Precio por unidad=" + precioUnitario
					+ ", Origen de Fabrizacion=" + origenFabricacion + ", Categoria=" + categoria + ", Estado=" + estado + "]";
		}		
}

