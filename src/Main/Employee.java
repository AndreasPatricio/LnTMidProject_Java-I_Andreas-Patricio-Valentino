package Main;

public class Employee {
	
	private String nama, gender, jabatan, id;
	private double gaji;

	public Employee(String nama, String gender, String jabatan, String id, double gaji) {
		this.nama = nama;
		this.gender = gender;
		this.jabatan = jabatan;
		this.id = id;
		this.gaji = gaji;
	}
	
	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getJabatan() {
		return jabatan;
	}

	public void setJabatan(String jabatan) {
		this.jabatan = jabatan;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getGaji() {
		return gaji;
	}

	public void setGaji(double gaji) {
		this.gaji = gaji;
	}

	
	
	
}
