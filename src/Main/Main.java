package Main;

import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;

public class Main {

	public static void main(String[] args) {
		new Main();
	}
	
	Scanner scan = new Scanner(System.in);
	Vector<Employee> data = new Vector<Employee>();
	
	int counterManager = 0;
	int counterSupervisor = 0;
	int counterAdmin = 0;
	
	
	void insertKaryawan() {
		String nama, gender, jabatan, id = "";
		double gaji;
		
		scan.nextLine();
		
		do {
			System.out.print("Input nama karyawan [>= 3]: ");
			nama = scan.nextLine();
		}
		while(nama.length() < 3);
		
		do {
			System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
			gender = scan.nextLine();
		}
		while(!gender.equals("Laki-laki") && !gender.equals("Perempuan"));
		
		do {
			System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
			jabatan = scan.nextLine();
		}
		while(!jabatan.equals("Manager") && !jabatan.equals("Supervisor") && !jabatan.equals("Admin"));
		
		for(int i = 0; i < 2; i++) {
			id += (char)((Math.random() * 26) + 'A');
		}
		id += '-';
		id += (int) (Math.random()*(10000 - 1000 + 1) + 1000);
		
		for(int j = 0; j < data.size(); j++) {
			if(data.get(j).getId() == id) {
				for(int i = 0; i < 2; i++) {
					id += (char)((Math.random() * 26) + 'A');
				}
				id += '-';
				id += (int) (Math.random()*(10000 - 1000 + 1) + 1000);
			}
		}
		
		
		if(jabatan.equals("Manager")) {
			gaji = 8000000;
			data.add(new Manager(nama, gender, jabatan,id, gaji));
			counterManager++;
			int count = 0;
			if(counterManager % 3 == 1 && counterManager != 1) {
				System.out.print("Bonus sebesar 10% telah diberikan kepada karyawan dengan id");
				for(int i = 0; i < data.size(); i++) {
					if(data.get(i).getJabatan().equals("Manager")) {
						if(count == (counterManager-1)) {
							break;
						}
						else {
							System.out.print(" "+data.get(i).getId());
							data.set(i, new Manager(data.get(i).getNama(), data.get(i).getGender(), data.get(i).getJabatan(), data.get(i).getId(), (data.get(i).getGaji() + (gaji * 10)/ 100)));
							count++;
						}
					}
				}
				scan.nextLine();
			}
		}
		
		else if(jabatan.equals("Supervisor")) {
			gaji = 6000000;
			data.add(new Supervisor(nama, gender, jabatan,id, gaji));
			counterSupervisor++;
			int count = 0;
			if(counterSupervisor % 3 == 1 && counterSupervisor != 1) {
				System.out.print("Bonus sebesar 7.5% telah diberikan kepada karyawan dengan id");
				for(int i = 0; i < data.size(); i++) {
					if(data.get(i).getJabatan().equals("Supervisor")) {
						if(count == (counterSupervisor-1)) {
							break;
						}
						else {
							System.out.print(" "+data.get(i).getId());
							data.set(i, new Supervisor(data.get(i).getNama(), data.get(i).getGender(), data.get(i).getJabatan(), data.get(i).getId(), (data.get(i).getGaji() + (gaji * 7.5)/ 100)));
							count++;
						}
					}
				}
				scan.nextLine();
			}
		}
		
		else if(jabatan.equals("Admin")) {
			gaji = 4000000;
			data.add(new Admin(nama, gender, jabatan,id, gaji));
			counterAdmin++;
			int count = 0;
			if(counterAdmin % 3 == 1 && counterAdmin != 1) {
				System.out.print("Bonus sebesar 10% telah diberikan kepada karyawan dengan id");
				for(int i = 0; i < data.size(); i++) {
					if(data.get(i).getJabatan().equals("Admin")) {
						if(count == (counterAdmin-1)) {
							break;
						}
						else {
							System.out.print(" "+data.get(i).getId());
							data.set(i, new Admin(data.get(i).getNama(), data.get(i).getGender(), data.get(i).getJabatan(), data.get(i).getId(), (data.get(i).getGaji() + (gaji * 5)/ 100)));
							count++;
						}
					}
				}
				scan.nextLine();
			}
		}
		System.out.println("Berhasil menambahkan karyawan dengan id "+ id);
		
		String validasi;
		do {
			System.out.print("Insert data karyawan lagi [Ya atau Tidak] (Case Sensitive): ");
			validasi = scan.nextLine();
			if(validasi.equals("Ya")) {
				System.out.println("ENTER to continue");
				insertKaryawan();
			}
			else if(validasi.equals("Tidak")) {
				System.out.println("ENTER to return");
			}
		}
		while(!validasi.equals("Ya") && !validasi.equals("Tidak"));
			scan.nextLine();
	}
	
	void sort() {
		data.sort(new Comparator<>() {
			public int compare(Employee A, Employee B) {
				return A.getNama().compareTo(B.getNama());
			}
		});
	}
	
	void display() {
		System.out.println("|-----------------------------------------------------------------------|");
		sort();
		for(int i = 0; i < data.size(); i++) {
			System.out.println("|"+(i+1) +"  |"+ data.get(i).getId() +"  |"+ data.get(i).getNama() +"  |"+ data.get(i).getGender() +"  |"+ data.get(i).getJabatan() +"  |"+ data.get(i).getGaji());
		}
		System.out.println("|-----------------------------------------------------------------------|");
	}
	
	void viewKaryawan() {
		if(data.isEmpty()) {
			System.out.println("Data Kosong");
		}
		else {
			display();
		}
		
	}
	
	void updateKaryawan() {
		if(data.isEmpty()) {
			System.out.println("Data Kosong");
		}
		else {
			display();
		}
		
		int nomor;
		
		System.out.print("Input nomor urutan karyawan yang ingin diupdate [input 0 untuk cancel]: ");
		nomor = scan.nextInt();
		
		if(nomor == 0) {
			System.out.println("Tidak jadi mengupdate data");
		}
		
		else {
			nomor -= 1;
			String jabatan = data.get(nomor).getJabatan();
			
			String nama, gender, newJabatan, id = "";
			double gaji;
			
			scan.nextLine();
			
			do {
				System.out.print("Input nama karyawan [>= 3]: ");
				nama = scan.nextLine();
			}
			while(nama.length() < 3);
			
			do {
				System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
				gender = scan.nextLine();
			}
			while(!gender.equals("Laki-laki") && !gender.equals("Perempuan"));
			
			do {
				System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
				newJabatan = scan.nextLine();
			}
			while(!newJabatan.equals("Manager") && !newJabatan.equals("Supervisor") && !newJabatan.equals("Admin"));
			
			for(int i = 0; i < 2; i++) {
				id += (char)((Math.random() * 26) + 'A');
			}
			id += '-';
			id += (int) (Math.random()*(10000 - 1000 + 1) + 1000);
			
			for(int j = 0; j < data.size(); j++) {
				if(data.get(j).getId() == id) {
					for(int i = 0; i < 2; i++) {
						id += (char)((Math.random() * 26) + 'A');
					}
					id += '-';
					id += (int) (Math.random()*(10000 - 1000 + 1) + 1000);
				}
			}
			
			if(newJabatan.equals(jabatan)) {
				jabatan = newJabatan;
				if(jabatan.equals("Manager")) {
					gaji = 8000000;
					data.set(nomor, new Manager(nama, gender, jabatan,id, gaji));
				}
				
				else if(jabatan.equals("Supervisor")) {
					gaji = 6000000;
					data.set(nomor, new Supervisor(nama, gender, jabatan,id, gaji));
				}
				
				else if(jabatan.equals("Admin")) {
					gaji = 4000000;
					data.set(nomor, new Admin(nama, gender, jabatan,id, gaji));
				}
			}
			else {
				if(jabatan.equals("Manager")) {
					counterManager--;
				}
				
				else if(jabatan.equals("Supervisor")) {
					counterSupervisor--;
				}
				
				else if(jabatan.equals("Admin")) {
					counterAdmin--;
				}
				
				if(newJabatan.equals("Manager")) {
					gaji = 8000000;
					data.set(nomor, new Manager(nama, gender, newJabatan,id, gaji));
					counterManager++;
					int count = 0;
					if(counterManager % 3 == 1 && counterManager != 1) {
						System.out.print("Bonus sebesar 10% telah diberikan kepada karyawan dengan id");
						for(int i = 0; i < data.size(); i++) {
							if(data.get(i).getJabatan().equals("Manager")) {
								if(count == (counterManager-1)) {
									break;
								}
								else {
									System.out.print(" "+data.get(i).getId());
									data.set(i, new Manager(data.get(i).getNama(), data.get(i).getGender(), data.get(i).getJabatan(), data.get(i).getId(), (data.get(i).getGaji() + (gaji * 10)/ 100)));
									count++;
								}
								scan.nextLine();
							}
						}
					}
				}
				
				else if(newJabatan.equals("Supervisor")) {
					gaji = 6000000;
					data.set(nomor, new Supervisor(nama, gender, newJabatan,id, gaji));
					counterSupervisor++;
					int count = 0;
					if(counterSupervisor % 3 == 1 && counterSupervisor != 1) {
						System.out.print("Bonus sebesar 7.5% telah diberikan kepada karyawan dengan id");
						for(int i = 0; i < data.size(); i++) {
							if(data.get(i).getJabatan().equals("Supervisor")) {
								if(count == (counterSupervisor-1)) {
									break;
								}
								else {
									System.out.print(" "+data.get(i).getId());
									data.set(i, new Supervisor(data.get(i).getNama(), data.get(i).getGender(), data.get(i).getJabatan(), data.get(i).getId(), (data.get(i).getGaji() + (gaji * 7.5)/ 100)));
									count++;
								}
								scan.nextLine();
							}
						}
					}
				}
				
				else if(newJabatan.equals("Admin")) {
					gaji = 4000000;
					data.set(nomor, new Admin(nama, gender, newJabatan,id, gaji));
					counterAdmin++;
					int count = 0;
					if(counterAdmin % 3 == 1 && counterAdmin != 1) {
						System.out.print("Bonus sebesar 10% telah diberikan kepada karyawan dengan id");
						for(int i = 0; i < data.size(); i++) {
							if(data.get(i).getJabatan().equals("Admin")) {
								if(count == (counterAdmin-1)) {
									break;
								}
								else {
									System.out.print(" "+data.get(i).getId());
									data.set(i, new Admin(data.get(i).getNama(), data.get(i).getGender(), data.get(i).getJabatan(), data.get(i).getId(), (data.get(i).getGaji() + (gaji * 5)/ 100)));
									count++;
								}
								scan.nextLine();
							}
						}
					}
				}
			}
			
			System.out.println("Berhasil mengupdate karyawan dengan id "+ id);
		}
		
		
	}
	
	void deleteKaryawan() {
		if(data.isEmpty()) {
			System.out.println("Data Kosong");
		}
		else {
			display();
		}
		int nomor;
		System.out.print("Input nomor urutan karyawan yang ingin dihapus: ");
		nomor = scan.nextInt();
		nomor -= 1;
		System.out.println("Karyawan dengan kode "+ data.get(nomor).getId() + " berhasil dihapus");
		data.remove(nomor);
	}
	
	public Main() {
		int pilihan;
		do {
			System.out.println("Menu");
			System.out.println("1. Insert Data Karyawan");
			System.out.println("2. View Data Karyawan");
			System.out.println("3. Update Data Karyawan");
			System.out.println("4. Delete Data Karyawan");
			System.out.print("Pilih >> ");
			pilihan = scan.nextInt();
			
			if(pilihan == 1) {
				insertKaryawan();
			}
			
			if(pilihan == 2) {
				viewKaryawan();
				System.out.println("ENTER to return");
				scan.nextLine(); scan.nextLine();
			}
			
			if(pilihan == 3) {
				updateKaryawan();
				System.out.println("ENTER to return");
				scan.nextLine(); scan.nextLine();
			}
			
			if(pilihan == 4) {
				deleteKaryawan();
				System.out.println("ENTER to return");
				scan.nextLine(); scan.nextLine();
			}
		}
		while(pilihan != 5);
		
	}
}
