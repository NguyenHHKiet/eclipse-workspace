package com.theplayer.kits.deprecated;

public class Thay {
	
//	private ThinhVan tvan;
//	public Thay(ThinhVan tvan) {
//	this.tvan = tvan;
//	System.out.println(this+" need "+tvan);
//}
	private Student student;
	public Thay(Student student) {
		this.student = student;
		System.out.println(this + " need "+ student);
	}
	private Interpreter interpretor;
	public void setInterpretor(Interpreter arg) {
		this.interpretor = arg;
	}
	public Interpreter getInterpretor() {
		return this.interpretor;
	}
	

}
