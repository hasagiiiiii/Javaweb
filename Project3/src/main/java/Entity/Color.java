package Entity;
// Generated Mar 22, 2024, 9:28:17 AM by Hibernate Tools 5.6.15.Final

import java.io.Serializable;

/**
 * Color generated by hbm2java
 */
public class Color implements java.io.Serializable {

	private Integer idColor;
	private Serializable color;

	public Color() {
	}

	public Color(Serializable color) {
		this.color = color;
	}

	public Integer getIdColor() {
		return this.idColor;
	}

	public void setIdColor(Integer idColor) {
		this.idColor = idColor;
	}

	public Serializable getColor() {
		return this.color;
	}

	public void setColor(Serializable color) {
		this.color = color;
	}

}