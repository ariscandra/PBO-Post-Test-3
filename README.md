<a name="top"></a>
    
# PBO | Post-Test 3 | Manajemen Pets Daycare Breakdown

<div align="center">
  
### **🐾 PROFIL 🐾**

| **Atribut** | **Nilai**          |
|---------------|--------------------|
| **Nama**      | Aris Candra Muzaffar        |
| **NIM**       | 2409116088          |
| **Kelas**     | Sistem Informasi C '24 |
| **Mata Kuliah**| Pemrograman Berorientasi Objek |

![Java](https://img.shields.io/badge/Java-Pemula-orange?style=flat&logo=java)
![OOP](https://img.shields.io/badge/OOP-Pemula-blue?style=flat)
![Pets](https://img.shields.io/badge/Pet_Lover-Banget-green?style=flat)

</div>

## 📚 Daftar Isi
- [👥 Deskripsi Program](#-deskripsi-program)
- [📖 Penjelasan Kode](#-penjelasan-kode)
- [🖥️ Penjelasan Alur Program](#️-penjelasan-alur-program)

## 👥 Deskripsi Program
**Manajemen Pets Daycare**

Program ini adalah aplikasi manajemen penitipan hewan (Pets Daycare) yang dikembangkan dengan bahasa pemrograman Java menggunakan pendekatan Model-View-Controller (MVC). Berikut ini adalah komponen utamanya:

**1. Fitur Utama**

- **Operasi CRUD**: Program mampu melakukan operasi Create, Read, Update, dan Delete data peliharaan yang dititipkan
- **Manajemen Data Pets**: Mengelola informasi lengkap tentang hewan yang dititipkan termasuk ID, nama, jenis, umur, dan pemilik
- **Pencarian Data**: Fitur search yang memungkinkan pencarian berdasarkan ID, nama, jenis, atau nama pemilik (case-insensitive/tidak peduli dengan besar kecilnya karakter)
  
**2. Arsitektur MVC**

- **Model**: Class `Pet` yang merepresentasikan struktur data dengan properti dan constructor
- **View**: Class `Main` yang menangani tampilan antarmuka pengguna dan input/output
- **Controller**: Class `PetService` yang menangani logika bisnis dan operasi CRUD

**3. Struktur Package**

- **package main**: Berisi class `Main` yang menyimpan menu utama pengguna
- **package service**: Menyimpan class `PetService` dengan logika operasi CRUD
- **package model**: Menyimpan class `Pet` dengan struktur data dan constructor
- **package util**: Menyimpan class `ValidationUtil` dengan fungsi validasi input

**4. Validasi Input**

- **hanyaHurufDanSpasi()**: Memvalidasi bahwa input hanya mengandung huruf dan spasi (untuk nama, jenis, dan nama pemilik)
- **hanyaAngka()**: Memvalidasi bahwa input hanya mengandung angka (untuk field umur)
- **Batas Panjang Input**: Membatasi panjang input untuk setiap field (nama max 30 karakter, jenis max 20 karakter, pemilik max 40 karakter)
- **Rentang Nilai**: Memastikan umur hewan berada dalam rentang yang wajar (0-30 tahun)

**5. Access Modifier & Properties**

- Menggunakan access modifier private untuk properti class dengan getter dan setter
- Terdapat 5 properties dalam class Pet: id, name, jenis, umur, dan pemilik
- Menerapkan constructor untuk inisialisasi objek

**6. Alur Program**

- Program menampilkan menu utama dengan opsi-opsi CRUD dan pencarian
- Pengguna dapat memilih opsi untuk menambah, melihat, mengupdate, menghapus, atau mencari data hewan
- Setiap opsi akan memandu pengguna melalui proses input dengan validasi
- Program akan terus berjalan sampai pengguna memilih opsi keluar

**7. Keamanan Data**

- Program mencegah input yang tidak valid melalui berbagai lapisan validasi
- Menghindari error dengan penanganan exception untuk konversi tipe data
- Memastikan konsistensi data dengan batasan-batasan yang jelas

**8. Inheritance dan Polimorfisme**

- **Superclass**: `Pet` sebagai abstract class yang menjadi dasar untuk semua jenis hewan
- **Subclass**: `Kucing` dan `Anjing` sebagai turunan dari class `Pet`
- **Overriding**: Setiap subclass mengoverride method `getJenis()` untuk mengembalikan nilai yang spesifik
- **Abstraksi**: Class `Pet` memiliki method abstrak yang harus diimplementasikan oleh subclass

**9. Kesimpulan**

Program ini memberikan solusi terstruktur untuk mengelola data penitipan hewan harian dengan menerapkan prinsip-prinsip PBO dan arsitektur MVC.

## 📖 Penjelasan Kode

<details>
  <summary><h3>Penjelasan Kode Versi Post-Test 1</h3></summary>
  <a href="https://github.com/ariscandra/PBO-Post-Test-1?tab=readme-ov-file#-penjelasan-kode">Lihat disini</a>
</details>

<details>
  <summary><h3>Penjelasan Kode Versi Post-Test 2</h3></summary>
  <a href="https://github.com/ariscandra/PBO-Post-Test-2?tab=readme-ov-file#-penjelasan-kode">Lihat disini</a>
</details>

<details>
  <summary><h3>Penjelasan Kode Versi Post-Test 3</h3></summary>

  **1. Class Pet**
```java
package model;

public abstract class Pet {
    private String id;
    private String nama;
    private String umur;
    private String pemilik;

    public Pet(String id, String nama, String umur, String pemilik) {
        this.id = id;
        this.nama = nama;
        this.umur = umur;
        this.pemilik = pemilik;
    }

    public abstract String getJenis();

    // INI GETTER AMA SETTER
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    public String getUmur() { return umur; }
    public void setUmur(String umur) { this.umur = umur; }
    public String getPemilik() { return pemilik; }
    public void setPemilik(String pemilik) { this.pemilik = pemilik; }
}
```

Class Pet sekarang menjadi class abstrak yang berisi:

- Atribut dasar untuk semua hewan: id, nama, umur, dan pemilik
- Method abstrak getJenis() yang harus diimplementasikan oleh subclass
- Getter dan setter untuk semua atribut (menerapkan encapsulation)
  
  **2. Class Kucing**
```java
package model;

public class Kucing extends Pet {
    public Kucing(String id, String nama, String umur, String pemilik) {
        super(id, nama, umur, pemilik);
    }

    @Override
    public String getJenis() {
        return "Kucing";
    }
}
```

Class Kucing extends class Pet dan:

- Menerapkan constructor yang memanggil constructor superclass
- Mengoverride method getJenis() untuk mengembalikan nilai "Kucing"

  **3. Class Anjing**
```java
package model;

public class Anjing extends Pet {
    public Anjing(String id, String nama, String umur, String pemilik) {
        super(id, nama, umur, pemilik);
    }

    @Override
    public String getJenis() {
        return "Anjing";
    }
}
```

Class Anjing extends class Pet dan:

- Menerapkan constructor yang memanggil constructor superclass
- Mengoverride method getJenis() untuk mengembalikan nilai "Anjing"

  **4. Kesimpulan**
  
Program ini memberikan solusi terstruktur untuk mengelola data penitipan hewan harian dengan menerapkan prinsip-prinsip PBO dan arsitektur MVC. Pada versi ini, program telah ditingkatkan dengan:

- **Inheritance**: Mengimplementasikan hierarki class dengan `Pet` sebagai superclass dan `Kucing`/`Anjing` sebagai subclass
- **Polimorfisme**: Menggunakan overriding pada method `getJenis()` untuk mengembalikan nilai yang spesifik berdasarkan subclass
- **Abstraksi**: Menggunakan abstract class dan method untuk membuat kerangka dasar yang harus diikuti oleh subclass

Program ini sekarang lebih modular dan mudah dikembangkan untuk menambahkan jenis hewan lainnya di masa depan.

  
</details>

## 🖥️ Penjelasan Alur Program

### Versi Post-Test 1

<details>
<summary><h3>Menu Utama</h3></summary>

<div align="center">
  <img src="https://github.com/user-attachments/assets/160529b6-3faa-4619-a260-b163aa4f6c1e" alt="" width="500px">
</div>

<p align="justify">Gambar di atas merupakan tampilan menu utama program ketika pertama dijalankan.</p>

**1. Jika input tidak valid**
<div align="center">
  <img src="https://github.com/user-attachments/assets/f3498574-ac7e-4051-9a81-2c6808623bb8" alt="" width="500px">
</div>

<p align="justify">Jika pengguna menginput di luar daripada opsi (0-4) di menu utama, maka akan ada dialog teks seperti pada gambar di atas. Menu akan diulang, pengguna diminta untuk menginput lagi.</p>

**2. Jika opsi 0(Keluar) dipilih**
<div align="center">
  <img src="https://github.com/user-attachments/assets/17ec4145-6c43-4fd0-a33c-2ef6d7d46657" alt="" width="500px">
</div>

<p align="justify">Program akan berhenti berjalan jika pengguna menginput opsi untuk keluar (0). Menu akan berhenti berulang, program selesai.</p>

</details>

<details>
<summary><h3>Menambah Data Pet</h3></summary>

**1. Validasi input dan jika berupa selain huruf dan spasi**
<div align="center">
  <img src="https://github.com/user-attachments/assets/b80c4e30-3f77-4224-8042-927d36d062fb" alt="" width="500px">
</div>

<p align="justify">Jika pengguna mengisi field input nama pet, jenis, dan nama pemilik dengan angka. Maka, akan muncul dialog teks di atas. Pengguna diminta mengulang inputnya.</p>

**2. Validasi input dan jika lebih dari jumlah karakter yang ditentukan**
<div align="center">
  <img src="https://github.com/user-attachments/assets/0e9d08cc-c6d7-4a1b-90a5-4ec632b2fc40" alt="" width="500px">
</div>

<p align="justify">Jika pengguna mengisi field input nama pet dengan karakter lebih dari 30, jenis lebih dari 20, dan nama pemilik lebih dari 40 karakter. Maka, akan muncul dialog teks di atas. Pengguna diminta mengulang inputnya hingga validasi sukses.</p>

**3. Validasi input dan jika umur lebih dari 2 digit atau berupa selain angka**
<div align="center">
  <img src="https://github.com/user-attachments/assets/3042bf6c-fc79-41ad-b6d0-3c27d1fee06a" alt="" width="500px">
</div>

<p align="justify">Jika pengguna menginput lebih dari 3 digit angka atau memasukkan huruf pada field input umur. Maka, akan muncul dialog teks seperti pada gambar di atas.</p>

**4. Validasi input dan jika umur di luar rentang 0-30 tahun**
<div align="center">
  <img src="https://github.com/user-attachments/assets/dcd1329d-d8ca-4a34-9b85-ef5ca8b74d51" alt="" width="500px">
</div>

<p align="justify">Jika pengguna memasukkan umur pet di bawah 0 atau lebih dari 30 tahun, maka akan diminta input ulang.</p>

**5. Berhasil menambah data**
<div align="center">
  <img src="https://github.com/user-attachments/assets/4805e553-e2fa-4d30-9019-6c85aad5afa3" alt="" width="500px">
</div>

<p align="justify">Pada gambar di atas merupakan tampilan apabila proses penambahan data pet berhasil.</p>

</details>

<details>
<summary><h3>Melihat Data Pet</h3></summary>

**1. Jika data pet pada ArrayList masih kosong**
<div align="center">
  <img src="https://github.com/user-attachments/assets/bf990e63-b24d-4c18-82a5-d06b7f12f08e" alt="" width="500px">
</div>

<p align="justify">Akan muncul teks seperti pada gambar di atas jika ArrayList masih kosong.</p>

**2. Tampilan daftar pet jika memiliki data**
<div align="center">
  <img src="https://github.com/user-attachments/assets/dee21aad-ba92-4776-8112-85424dfece3e" alt="" width="500px">
</div>

</details>

<details>
<summary><h3>Memperbarui Data Pet</h3></summary>

**1. Validasi ID dan jika gagal**
<div align="center">
  <img src="https://github.com/user-attachments/assets/64e5fc8c-6b99-430b-80b2-d836fca3e4ca" alt="" width="500px">
</div>

<p align="justify">Jika pengguna memasukkan id yang tidak ada atau tidak cocok dengan yang ada pada ArrayList. Maka, akan muncul teks seperti pada gambar.</p>

**2. Tampilan pembaruan data pet jika berhasil**
<div align="center">
  <img src="https://github.com/user-attachments/assets/e7fa40c6-8ef8-467d-a361-3efef7c821ca" alt="" width="500px">
</div>

<p align="justify">Perlu diketahui, bahwa logika dan proses validasi input seperti batas karakter, rentang umur, dll. pada bagian update ini kurang lebih sama dengan yang ada pada proses penambahan data pet. Bedanya, hanya di cara penyimpanannya di ArrayList menggunakan variabel khusus untuk bagian update. Pada gambar di atas merupakan tampilan jika pembaruan data pet berhasil.</p>

</details>

<details>

<summary><h3>Menghapus Data Pet</h3></summary>

**1. Validasi ID dan jika gagal**
<div align="center">
  <img src="https://github.com/user-attachments/assets/ae6042d6-9e36-43b4-aec3-7a0077e32df5" alt="" width="500px">
</div>

<p align="justify">Sama seperti di bagian update, pengguna diminta memasukkan ID pet, dan jika proses validasi gagal. Maka akan diminta input ulang.</p>

**2. Jika data pet berhasil dihapus**
<div align="center">
  <img src="https://github.com/user-attachments/assets/2bfe34c2-344e-42b7-bf99-91809a0ea644" alt="" width="500px">
</div>

<p align="justify">Jika proses validasi berhasil (ID cocok dengan data dalam ArrayList). Maka, data berhasil dihapus.</p>

</details>

---

### Versi Post-Test 2

<details>
<summary><h3>Pilihan Pencarian Pada Menu Utama</h3></summary>
  
<div align="center">
  <img src="https://github.com/user-attachments/assets/5c00c6ec-5139-45fd-97c1-7bf9080f5abc" alt="" width="500px">
</div>

<p align="justify">Melanjutkan dari Post Test pertama, disini saya menambahkan fitur pencarian data pet sebagai opsi di menu utama.</p>

</details>

<details>
<summary><h3>Melakukan Pencarian</h3></summary>

**1. Jika keyword yang dimasukkan tidak ditemukan**
<div align="center">
  <img src="https://github.com/user-attachments/assets/79030d13-3b2c-4c88-a48c-23f6902309f9" alt="" width="500px">
</div>

<p align="justify">Untuk mencari data pet yang diinginkan, pengguna diminta memasukkan kata kunci yang berupa ID/nama/jenis/umur/pemilik dari pet. Jika setelah proses pencocokan keyword yang dimasukkan tidak terdapat pada daftar pet yang ada, maka pengguna diberikan teks yang memberitahukan bahwa keyword yang diinput tidak ditemukan.</p>

**2. Jika keyword berhasil ditemukan**
<div align="center">
  <img src="https://github.com/user-attachments/assets/285a1513-951f-4c3c-a991-9624a15a205b" alt="" width="500px">
</div>

<p align="justify">Gambar di atas dapat terlihat memanggil data pet yang ditemukan jika keyword yang dimasukkan pengguna cocok dengan daftar pet yang ada.</p>

</details>

---

### Versi Post-Test 3

<details>
<summary><h3>Perubahan Operasi Tambah Pet</h3></summary>

<div align="center">
  <img src="https://github.com/user-attachments/assets/49cb2f99-6edf-4dfc-9c86-306a45f0c8e7" alt="" width="500px">
</div>

<p align="justify">Pembaruan yang saya lakukan pada kali ini ada ketika pengguna menambahkan data pet, sekarang pengguna tidak perlu menginput jenis</p>

<div align="center">
  <img src="https://github.com/user-attachments/assets/4ce44180-2005-4eb2-a8a1-59088c6fb841" alt="" width="500px">
</div>

<p align="justify"></p>

</details>

<details>
<summary><h3>Perubahan Operasi Update Pet</h3></summary>
  
<div align="center">
  <img src="https://github.com/user-attachments/assets/101e4770-a8a0-44a6-852c-07546efdc3ae" alt="" width="500px">
</div>

<p align="justify"></p>

</details>


---
> [!NOTE]
> **🎉 Terimakasih! 🎉**
> Petit à petit, l'oiseau fait son nid 🙏

---
[⬆️ Kembali ke Atas](#top)
