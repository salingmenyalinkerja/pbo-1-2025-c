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
    - A
    - B
- DocumentSearchController
    - A
    - B
- DocumentStorageController
    - A
    - B
- DocumentVersioningController
    - A
    - B
- Document
    - A
    - B
- DOCXDocument
    - A
    - B
- PDFDocument
    - A
    - B
- SearchKeyword
    - A
    - B
- DocumentViewer
    - A
    - B
- SearchDocumentViewer
    - A
    - B

## Berkas Utilitas

### src/build.ps1
- Menghapus semua hasil *compile java* dan menjalankan kembali *compile java*
- Dipakai dengan menjalankan `powershell -ExecutionPolicy Bypass -File build.ps1`