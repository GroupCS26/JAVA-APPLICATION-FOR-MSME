# ✦ UMKM-Digital-Assistant

![Teks paragraf Anda](https://github.com/user-attachments/assets/5d2081ad-1720-4815-879a-021a8cd5817e)

- Abdurrahman Al Farisy
- ALVIONEJ RESNA LAWREND PANDIANGAN
- Muh Haikal Adis Yafiq
- Mohamad Ariel Saputra D Loi

# ➤ Libraries
Di Program Aplikasi kami memiliki beberapa libraries yaitu :

- mysql-connector-j-9.5.0
  
ni adalah library wajib kalau kalian mau aplikasi ini bisa menyimpan dan mengambil data!. Library ini berfungsi sebagai penghubung antara program Java kalian dengan database MySQL. Tanpa ini, data stok, transaksi, login akun, dan data pegawai kalian tidak akan tersimpan. Ini ibarat jembatan yang menghubungkan program kalian ke gudang data utama.
  
- slf4j-api-2.0.0-alpha7

Ini adalah Simple Logging Facade for Java. Ini bukan library untuk mencetak log (catatan) secara langsung, tapi lebih sebagai antarmuka atau perantara yang memungkinkan program kalian menggunakan berbagai sistem logging yang berbeda.Ini adalah library yang bertugas mencatat apa saja yang terjadi di belakang layar aplikasi. Kalau ada error atau sesuatu yang perlu dicatat buat debugging, dia yang mengurus agar catatan itu bisa dibaca developer.
  
- HikariCP-4.0.0

Ini adalah library untuk koneksi pooling database. Jadi, saat banyak bagian aplikasi butuh mengakses database dalam waktu bersamaan (misalnya saat kasir sibuk), HikariCP ini yang mengatur antrean koneksi datanya supaya cepat dan efisien.Kalau kalian mau aplikasi kalian anti-lemot saat transaksi lagi ramai, HikariCP ini penyelamatnya! Dia buat koneksi ke database jadi super cepat dan ringan.

- jcalendar-1.4

Sesuai namanya, library ini menyediakan komponen kalender yang mudah digunakan di Java. Komponen ini memungkinkan pengguna memilih tanggal dengan mudah, bukan mengetik manual.Kalian lihat di Menu Laporan ada kolom Dari Tanggal dan Sampai Tanggal. Nah, komponen tanggal yang muncul saat kalian klik tombol kalender itu dibuat pakai library
  
<img width="634" height="187" alt="image" src="https://github.com/user-attachments/assets/89d6e43d-7ad0-45ee-97d5-e909114aa876" />

# ➤ Deskripsi Aplikasi

UMKM Digital Assistant adalah sebuah platform digital yang dirancang untuk mendukung transformasi digital pelaku Usaha Mikro, Kecil, dan Menengah (UMKM) di Indonesia. Sebagai bagian dari upaya mewujudkan Sustainable Development Goals (SDG) nomor 8: Decent Work and Economic Growth, program ini bertujuan untuk meningkatkan efisiensi, produktivitas, dan daya saing UMKM di era ekonomi digital.

Platform ini hadir sebagai solusi bagi pelaku usaha yang masih beroperasi secara konvensional, dengan menyediakan sistem pencatatan dan pelaporan otomatis yang mudah digunakan tanpa memerlukan pengetahuan 
teknis atau akuntansi yang rumit. Melalui digitalisasi proses bisnis, UMKM Digital Assistant membantu pengguna menghemat waktu, meminimalkan kesalahan data, dan memperoleh informasi keuangan yang akurat untuk pengambilan keputusan strategis.

Lebih dari sekadar alat bantu, UMKM Digital Assistant menjadi sarana pemberdayaan ekonomi digital yang inklusif, membuka akses bagi pelaku UMKM untuk terhubung ke ekosistem bisnis modern, memperluas pasar, serta memperkuat kontribusi terhadap pertumbuhan ekonomi nasional.

# ➤ Struktur Aplikasi dan Struktur File

<img width="534" height="724" alt="image" src="https://github.com/user-attachments/assets/ff834b21-0e18-4b1a-869b-26c6aeb72802" />


<img width="1920" height="1403" alt="WKAW" src="https://github.com/user-attachments/assets/2c63aa41-1d19-403c-b070-3aefb196692c" />

# ➤ 5 Pilar Pemrograman Berorientasi Objek


## ╰┈➤ Encapsulation
Enkapsulasi adalah prinsip OOP untuk melindungi data internal sebuah objek dari akses yang tidak terkontrol dari luar. Ini dilakukan dengan menggabungkan data (fields) dan kode (methods) yang beroperasi pada data tersebut ke dalam satu unit (kelas) dan membatasi akses.

Implementasi: Dicapai dengan mendeklarasikan fields sebagai private dan menyediakan public methods (Getter dan Setter) untuk mengakses atau memodifikasi data tersebut secara terkontrol.

Contoh: Di kelas model/User, atribut seperti username dan password dideklarasikan secara privat, dan akses ke sana harus melalui method publik:
<img width="1101" height="522" alt="image" src="https://github.com/user-attachments/assets/914f3932-d2e2-420e-a898-a24f8d39b02e" />

## ╰┈➤ Abstraction
Abstraksi adalah konsep dalam OOP yang digunakan untuk menyembunyikan detail implementasi yang kompleks dan hanya menampilkan hal-hal penting yang relevan. Tujuannya agar program menjadi lebih sederhana, mudah dipahami, dan fokus pada apa yang dilakukan, bukan bagaimana dilakukan.


<img width="762" height="678" alt="image" src="https://github.com/user-attachments/assets/cc8b43c1-cdb2-499f-a3e9-f43bb6a4fb4a" />

Abstraksi diterapkan melalui class User yang bersifat abstrak dan menjadi cetak biru bagi setiap tipe pengguna dalam sistem (Pemilik dan Pegawai). Dengan cara ini, sistem dapat memperlakukan semua user secara seragam namun tetap mempertahankan identitas dan perilaku spesifik masing-masing melalui implementasi method abstrak getRoleName().


## ╰┈➤ Inheritance
Pewarisan memungkinkan sebuah kelas baru (subclass) untuk mewarisi field dan method dari kelas yang sudah ada (superclass), mempromosikan penggunaan ulang kode.

Implementasi: Menggunakan kata kunci extends.
Contoh (Model Peran): Implementasi model peran yang baru: Pegawai extends User dan Pemilik extends User.

<img width="830" height="575" alt="image" src="https://github.com/user-attachments/assets/387a500f-00e0-4b5a-bb45-b1a050c08530" />
<img width="808" height="495" alt="image" src="https://github.com/user-attachments/assets/ce7b6435-61e1-4da5-a7ff-90f06e8fd4a6" />


## ╰┈➤ Polymorphism
Polymorphism (Polimorfisme) adalah kemampuan objek untuk memiliki bentuk yang berbeda meskipun diakses melalui tipe referensi yang sama.

Dalam sistem UMKM ini, Polymorphism diterapkan pada class User yang bersifat abstrak. Class Pegawai dan Pemilik men-override method getRoleName(). Sehingga, saat program memanggil getRoleName() dari referensi User, outputnya akan berbeda sesuai objek yang login. Hal ini memungkinkan sistem mengenali akses halaman yang sesuai untuk Pegawai dan Pemilik tanpa membuat kode login terpisah.

<img width="467" height="119" alt="image" src="https://github.com/user-attachments/assets/ed89ffba-b8d9-4cb4-908f-117fe7f4b842" />

<img width="435" height="116" alt="image" src="https://github.com/user-attachments/assets/8772fc2f-14a2-48a9-9c60-4613581fc3db" />

## ╰┈➤ Interface
Interface adalah mekanisme dalam OOP yang digunakan untuk mendefinisikan kontrak perilaku berupa kumpulan method tanpa implementasi. Class yang mengimplementasikan interface wajib menyediakan isi atau logika dari method-method tersebut. Interface membantu menciptakan kode yang fleksibel, mudah dikembangkan, dan mendukung konsep Loose Coupling.

Peran Interface dalam Sistem:
Interface IUserdao berfungsi sebagai kontrak yang menentukan fungsi-fungsi dasar yang harus dimiliki oleh setiap implementasi pengelolaan data User dan UMKM. Dengan adanya interface, program menjadi lebih terstruktur, mudah diperluas, dan fleksibel, karena perubahan implementasi tidak mengubah logika pada bagian lain dari sistem.
<img width="698" height="627" alt="image" src="https://github.com/user-attachments/assets/d0a76760-7bf8-4d26-8919-f71ce3a74ee3" />

# ➤ Program Aplikasi UMKM Digital Assistant (GUI)

## ╰┈➤ Halaman Utama
dihalaman ini adalah tampilan jika kalian menggunakan aplikasi kami, disini tempat kalian buat memilih untuk memilih untuk masuk ke login jik sudah memiliki akun atau masuk ke menu daftar untuk mendaftarkan umkm kalian
Dihalaman ini terdapat beberapa tombol :
- Masuk (halaman untuk kalian yang sudah punya akun atau sudah mendaftarkan Umkm kalian)
- Daftar (halaman jika kalian belum mempunyai akun di aplikasi kami)
- Keluar (jika kalian ingin menghentikan atau keluar dari aplikasi kami)

<img width="1189" height="894" alt="Screenshot 2025-11-04 150129" src="https://github.com/user-attachments/assets/a5154c9f-c70c-4068-b93d-0405abc51d29" />

## ╰┈➤ Halaman Daftar
dihalaman ini kalian akan disambut dengan tulisan Selamat Bergabung. kalian akan diminta untuk mengisi beberapa data diri dan usaha, seperti Nama Lengkap, Username, Password, Kontak, Nama Usaha, dan Alamat Usaha. setelah semua terisi, kalian bisa menekan tombol Daftar untuk membuat akun.
<img width="1193" height="904" alt="Screenshot 2025-11-04 150257" src="https://github.com/user-attachments/assets/58852da1-0fbc-41ff-af5c-90fd5429e960" />

## ╰┈➤ Halaman Login
dihalaman ini kalian akan disambut dengan tulisan Masuk! untuk mengingatkan kalian agar segera mengelola usaha kalian bersama kami. kalian harus memasukkan Username dan Password kalian untuk bisa melanjutkan ke halaman utama aplikasi.
<img width="1186" height="901" alt="Screenshot 2025-11-04 150139" src="https://github.com/user-attachments/assets/4f538ffd-6157-4896-8987-5fd6c1075b0a" />

## ╰┈➤ ADMIN UMKM

### ╰┈┈┈┈➤ Home
dihalaman ini kalian akan disambut dengan tulisan Selamat Datang. Halaman ini berfungsi sebagai kartu nama digital untuk usaha kalian, menampilkan informasi penting seperti:

- Nama Usaha: Contohnya adalah Roti Manis Mulia.

- Alamat Usaha: Contohnya Jl. Pahlawan No. 12, Samarinda,....
  
- Kontak: Contohnya 081234567890.

<img width="1205" height="883" alt="Screenshot 2025-11-04 175719" src="https://github.com/user-attachments/assets/01b02b64-e5b9-4436-9736-80e85c1ae6b8" />

### ╰┈┈┈┈➤ Kasir
halaman ini kalian akan menemukan Menu Laporan. Tampilan ini sepertinya berfungsi untuk melihat ringkasan transaksi. Kalian bisa memfilter tampilan data transaksi berdasarkan Dari Tanggal dan Sampai Tanggal , serta ada kolom data seperti ID Transaksi, Tanggal, Total (Rp), Nama Produk, Jumlah, dan Subtotal., karena terdapat dua bagian:

- Tabel Transaksi
  
- Tabel Detail
   
![WhatsApp Image 2025-11-04 at 15 18 01_a28584bc](https://github.com/user-attachments/assets/70f5684e-38a9-4020-8f9e-ea66e6899903)

### ╰┈┈┈┈➤ Laooran
Dihalaman ini, kalian dapat melihat dan memfilter data transaksi untuk mendapatkan analisis yang lebih mendalam.

Fitur Input dan Filter Data:

- Pilihan Jenis Laporan (Filter Dropdown) : Kalian dapat memilih jenis laporan yang ingin ditampilkan, contoh yang terlihat adalah Analisis Produk Terlaris.

- Filter Tanggal :
  
  Dari Tanggal: Input untuk menentukan tanggal awal periode laporan.

  Sampai Tanggal: Input untuk menentukan tanggal akhir periode laporan.

  Terdapat tombol untuk memilih tanggal, misalnya tanggal 4 Mei 2020 terlihat sudah dipilih di salah satu gambar.
  
- Tombol Aksi: :

Cetak Laporan: Tombol untuk mencetak hasil laporan yang telah difilter.

<img width="1204" height="893" alt="Screenshot 2025-11-04 175712" src="https://github.com/user-attachments/assets/0756d0a7-4327-479c-a9e2-865ca159933d" />

### ╰┈┈┈┈➤ Stok
dihalaman ini kalian akan menemukan Menu Stok. Kalian bisa mengelola data produk dengan mengisi beberapa kolom input dan ada tabel data produk:

- Input Data Produk: ID Produk,Nama Produk,Kategori,Harga,Satuan, dan Keterangan

- Tombol Aksi yang Tersedia: Tambah,Hapus,Update, dan Clear

- Tabel Produk: Menampilkan data produk dengan kolom seperti ID P*, Nama, Harga, Stok, dan Keterangan.

<img width="1198" height="912" alt="Screenshot 2025-11-04 175726" src="https://github.com/user-attachments/assets/25772799-9e5a-416d-9fc0-6142c413152e" />

### ╰┈┈┈┈➤ Profile

#### ╰┈┈┈┈┈┈┈┈┈┈┈┈➤ Profile Pengaturan Toko
Tab ini difokuskan untuk mengatur informasi yang berkaitan dengan bisnis kalian secara umum. Ini adalah data yang akan ditampilkan ke pelanggan atau di halaman utama aplikasi.Kalian akan disambut dengan tulisan Selamat Datang di, ....


Input Data yang Harus Diisi:

- Nama Usaha: Nama yang akan muncul sebagai identitas toko kalian.

- Alamat Usaha: Detail lokasi toko kalian.

Terdapat tombol SAVE untuk menyimpan perubahan.

<img width="1033" height="658" alt="Screenshot 2025-11-04 185409" src="https://github.com/user-attachments/assets/1311488e-f854-45c1-92bf-5a95dd558a55" />

#### ╰┈┈┈┈┈┈┈┈┈┈┈┈➤ Profile Kelola Pegawai
Kalau kalian punya karyawan, di sinilah tempat kalian mengurus semua data mereka, termasuk ID Pegawai, Posisi, dan akun login mereka.Input Data Pegawai yang Harus Diisi:

- ID Pegawai: Nomor unik identitas pegawai.

- Nama: Nama lengkap pegawai.

- Username: Nama untuk login si pegawai.

- Password: Kata sandi akun pegawai.

- Kontak: Nomor kontak pegawai.

- Posisi: Jabatan si pegawai (misalnya, Kasir).


Tombol Aksi untuk Mengelola Data:

- Tambah (Hijau): Buat kalian yang baru merekrut karyawan baru.

- Update (Biru): Kalau ada data karyawan yang berubah, misalnya Posisi atau Kontak.

- Hapus (Merah): Jika ada pegawai yang sudah tidak bekerja lagi.

- Clear: Membersihkan semua kolom input.

<img width="1205" height="913" alt="Screenshot 2025-11-04 175736" src="https://github.com/user-attachments/assets/b0ac7d33-0d00-4031-a2cc-bcf4afdeebd9" />

#### ╰┈┈┈┈┈┈┈┈┈┈┈┈➤ Profile Pofile Admin
dihalaman ini, kalian fokus mengelola data akun kalian sendiri sebagai administrator atau pemilik usaha.Kalian Harus Mengisi dan Mengelola Data Ini:

- Nama: Nama lengkap kalian (Contoh: Rina Anggraini).

- Username: Nama yang kalian gunakan untuk masuk ke aplikasi.

- Password: Kata sandi akun kalian.

- Kontak: Nomor telepon yang bisa dihubungi (Contoh: 081234567890).

- Nama Usaha: Nama resmi UMKM kalian.

- Masa Jabatan: (Berdasarkan gambar terbaru) Ini mungkin kolom tambahan untuk mencatat periode tugas/jabatan kalian.

Tombol yang Tersedia:

SAVE: Kalau kalian sudah selesai mengubah data, klik ini biar perubahannya tersimpan.

Keluar: Tombol untuk log out dari akun kalian.

<img width="1210" height="921" alt="Screenshot 2025-11-04 175742" src="https://github.com/user-attachments/assets/afb6b669-35c3-411f-95a7-f5a69e32471e" />

## ╰┈➤ PEGAWAI UMKM

### ╰┈┈┈┈➤ Home
Dihalaman ini itu secara teknis sama saja dia itu menampilkan informasi dari yang punya akun, jadi di halaman ini ini ada tulisan selamat datang, (nama pegawai yang login)
lalu ada format date yang menampilkan hari dan jam sekarang. dan juga ada tombol untuk keluar dari menu Pegawai
<img width="1202" height="892" alt="Screenshot 2025-11-04 150325" src="https://github.com/user-attachments/assets/3bca6cb3-2fbf-4aab-885d-dea6634c4e03" />

### ╰┈┈┈┈➤ Kasir
jadi dihalaman kasir pegawai itu akan menampilkan produk dari umkm tersebut lalu kita bisa memasukan jumlah barang yang di beli lalu sistemnya akan membaca semua barang yang di masukan ke keranjang lalu ketika kita memencet simpan transaksi dia akan mengurangi jumlah stok dari barang yang di beli tadi. di halaman ini terdapat beberapa tombol :

- Tombol Tambah Keranjang ( Untuk menambah produk sesuai dengan jumlah yang dibeli)
- Tombol Simpan Transaksi ( Untuk Menyimpan Transaksi dan dia langsung melakukan proses penguranngan pada stok)
- Tombol Kemballi Ke Home (Untuk Kembali Ke Menu Home)
  
<img width="1398" height="847" alt="Screenshot 2025-11-04 150343" src="https://github.com/user-attachments/assets/70b8c2ec-09d7-462f-96e3-ccdc8351ee5c" />

### ╰┈┈┈┈➤ Stok
Dihalaman ini pegawai mengatur stok dari umkm mereka dan disini juga tempatnya buat manajemen stok, dengan beberapa tombol yaitu :

- Tambah Produk (untuk menambah produk baru ke ddalam list barang mereka)
- Ubah Stok (Untuk mengubah stok mereka tanpa lewat transaksi)
- TOmbol Kembali Ke Home ( Untuk Menu kembali ke home)
<img width="1173" height="731" alt="Screenshot 2025-11-04 150403" src="https://github.com/user-attachments/assets/ce3591d8-5899-4b08-b6f4-9d665f456085" />




