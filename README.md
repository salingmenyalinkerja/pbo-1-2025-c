# Tugas Akhir PBO I Kelas C, Tahun 2025

## Struktur Repository
```
pbo-1-2025-c
├── src/
│   ├── docurepo/
│   │   ├── controller/
│   │   ├── model/
│   │   └── view/
│   └── main/
├── docs/
│   └── UML_Diagram.png
├── .gitignore
└── README.md
```

## Fitur Aplikasi
- Program memiliki fungsi login, dimana pengguna perlu memasukkan nama dan password untuk menggunakan aplikasi.
- Program dapat menerima dokumen yang di-upload pengguna menggunakan url.
- Program hanya dapat menerima berkas .docx dan .pdf.
- Program akan memperbaharui dokumen miliknya bila nama berkas yang ingin di-upload sama dengan dokumen tersebut.
- Program mampu mengubah dokumen yang ada menjadi versi terdahulu dokumen tersebut.
- Program dapat menghapus dokumen yang dimilikinya.
- Program dapat memperlihatkan berkas-berkas dokumen yang dimilikinya.
- Program dapat mencarikan dokumen dengan kata kunci yang dimasukkan pengguna.

## Pembagian Tugas

- DocumentListingController
    - 021220125	MARIA GORETI HOKON
    - 021220128	VULGENSIUS GAKA NAGA
- DocumentSearchController
    - 021220067	GABRIEL NOVI ELIAS FERNANDES
    - 021240103	OKTAVIANUS RIANO LABA
- DocumentStorageController
    - 021220171	MARSELINUS GOLENG PAYONG
    - 021240110	PAULINUS ALDOVAN ERIC MBOMBA
- DocumentVersioningController
    - 021240083	MARIA SERAFIN PAGANG
    - 021220161	ADAM SIPRIANTO SOGEN
- Document
    - 021240007	AMBROSIUS JUWANDY SAKUNAB
- DOCXDocument
    - 021240031	DEWI ANGGRENI SITE
- PDFDocument
    - 021240107	PASKALIS GERIANSA WADU
- SearchKeyword
    - 021240027	CYNDI SILVINA MARIA WISANG
- DocumentViewer
    - 021240085	MARIO BERNADUS ADRIZAL
    - 021240101	NIKODEMUS GEDOFRIDUS FREDERICO LINA RATO
- SearchDocumentViewer
    - 021240002	AGUSTHO TRENDZ MITANG

## Berkas Utilitas

### src/build.ps1
- Menghapus semua hasil *compile java* dan menjalankan kembali *compile java*
- Dipakai dengan menjalankan `powershell -ExecutionPolicy Bypass -File build.ps1`

### src/clean.ps1
- Menghapus semua hasil *compile java*
- Dipakai dengan menjalankan `powershell -ExecutionPolicy Bypass -File clean.ps1`