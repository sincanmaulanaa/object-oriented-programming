//setelah mendesain form menggunakan palette, Anda akan mendapat kode di tab "source"
//tambahkan kode-kode berikut pada tab "source" di file Form_Siswa.java

package crud; // sesuaikan dengan nama package masing-masing

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Form_Siswa extends javax.swing.JFrame {
    private DefaultTableModel tabmode; // TAMBAHAN
    private ResultSet hasil; // TAMBAHAN

    CRUD aa = new CRUD(); // TAMBAHAN

    public Form_Siswa() throws SQLException {
        initComponents();
        tampil_database(); // TAMBAHAN
    }

    public void tampil_database() {
        Object[] baris = { "ID", "Nama", "Umur", "Telepon", "Alamat", "Penyakit" };
        tabmode = new DefaultTableModel(null, baris);
        tabel_siswa.setModel(tabmode);
        try {
            hasil = aa.tampilData();
            while (hasil.next()) {
                aa.setID(hasil.getString("id"));
                aa.setNama(hasil.getString("nama"));
                aa.setUmur(hasil.getString("umur"));
                aa.setTelepon(hasil.getString("telepon"));
                aa.setAlamat(hasil.getString("alamat"));
                aa.setPenyakit(hasil.getString("penyakit"));
                String[] data = { aa.getID(), aa.getNama(), aa.getUmur(), aa.getTelepon(), aa.getAlamat(),
                        aa.getPenyakit() };
                tabmode.addRow(data);
            }
        } catch (Exception e) {
        }
    }

    public void reset_text() {
        txt_id.setText("");
        txt_nama.setText("");
        txt_umur.setText("");
        txt_telepon.setText("");
        txt_alamat.setText("");
        txt_penyakit.setText("");
    }

    // setting untuk btn_simpan
    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {

        if (txt_id.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Maaf, ID belum diisi !");
            txt_id.requestFocus();
        } else if (txt_nama.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Maaf, Nama belum diisi !");
            txt_nama.requestFocus();
        } else if (txt_umur.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Maaf, Umur belum diisi !");
            txt_umur.requestFocus();
        } else if (txt_telepon.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Maaf, Telepon belum diisi !");
            txt_telepon.requestFocus();
        } else if (txt_alamat.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Maaf, Alamat belum diisi !");
            txt_alamat.requestFocus();
        } else if (txt_penyakit.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Maaf, Penyakit belum diisi !");
            txt_penyakit.requestFocus();
        } else {
            try {
                aa.setID(txt_id.getText());
                aa.setNama(txt_nama.getText());
                aa.setUmur(txt_umur.getText());
                aa.setTelepon(txt_telepon.getText());
                aa.setAlamat(txt_alamat.getText());
                aa.setPenyakit(txt_penyakit.getText());
                aa.simpanData(aa.getID(), aa.getNama(), aa.getUmur(), aa.getTelepon(), aa.getAlamat(),
                        aa.getPenyakit());
                JOptionPane.showMessageDialog(null, "Data berhasil tersimpan", "Informasi",
                        JOptionPane.INFORMATION_MESSAGE);
                tampil_database();
                reset_text();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data gagal tersimpan", "Informasi",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    // setting untuk btn_ubah
    private void btn_ubahActionPerformed(java.awt.event.ActionEvent evt) {
        if (txt_id.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Maaf, ID belum diisi !");
            txt_id.requestFocus();
        } else if (txt_nama.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Maaf, Nama belum diisi !");
            txt_nama.requestFocus();
        } else if (txt_umur.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Maaf, Umur belum diisi !");
            txt_umur.requestFocus();
        } else if (txt_telepon.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Maaf, Telepon belum diisi !");
            txt_telepon.requestFocus();
        } else if (txt_alamat.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Maaf, Alamat belum diisi !");
            txt_alamat.requestFocus();
        } else if (txt_penyakit.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Maaf, Penyakit belum diisi !");
            txt_penyakit.requestFocus();
        } else {
            try {
                aa.setID(txt_id.getText());
                aa.setNama(txt_nama.getText());
                aa.setUmur(txt_umur.getText());
                aa.setTelepon(txt_telepon.getText());
                aa.setAlamat(txt_alamat.getText());
                aa.setPenyakit(txt_penyakit.getText());
                aa.ubahData(aa.getID(), aa.getNama(), aa.getUmur(), aa.getTelepon(), aa.getAlamat(), aa.getPenyakit());
                JOptionPane.showMessageDialog(null, "Data berhasil diubah", "Informasi",
                        JOptionPane.INFORMATION_MESSAGE);
                tampil_database();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data gagal diubah", "Informasi",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }

    // setting untuk btn_hapus
    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if (txt_id.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Maaf, ID belum diisi !");
            txt_id.requestFocus();
        } else {
            if (JOptionPane.showConfirmDialog(null, "Apakah Anda yakin akan menghapus data ini ?", "Warning",
                    2) == JOptionPane.YES_OPTION) {
                String id = "";
                try {
                    aa.setID(txt_id.getText());
                    aa.hapusData(aa.getID());
                    JOptionPane.showMessageDialog(null, "Data berhasil dihapus", "Informasi",
                            JOptionPane.INFORMATION_MESSAGE);
                    tampil_database();
                    reset_text();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Data gagal dihapus", "Informasi",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }

    }

    // setting untuk btn_keluar
    private void btn_keluarActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(null, "Apakah Anda yakin akan keluar ?", "Warning",
                2) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    // setting untuk btn_reset
    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        reset_text();
    }

    // setting untuk tabel_siswa
    private void tabel_siswaMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        try {
            int row = tabel_siswa.rowAtPoint(evt.getPoint());
            String id = tabel_siswa.getValueAt(row, 0).toString();
            String nama = tabel_siswa.getValueAt(row, 1).toString();
            String umur = tabel_siswa.getValueAt(row, 3).toString();
            String telepon = tabel_siswa.getValueAt(row, 4).toString();
            String alamat = tabel_siswa.getValueAt(row, 5).toString();
            String penyakit = tabel_siswa.getValueAt(row, 6).toString();
            txt_id.setText(String.valueOf(id));
            txt_nama.setText(String.valueOf(nama));
            txt_umur.setText(String.valueOf(umur));
            txt_telepon.setText(String.valueOf(telepon));
            txt_alamat.setText(String.valueOf(alamat));
            txt_penyakit.setText(String.valueOf(penyakit));
        } catch (Exception e) {
        }
    }

    // main class agar program dapat dijalankan

    public static void main(String args[]) {
        try {
            Form_Siswa form = new Form_Siswa();
            form.setVisible(true);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            // You need to create an instance of Form_Siswa here
            try {
                // Mencoba membuat instance Form_Siswa
                Form_Siswa form = new Form_Siswa();
                form.setVisible(true);
            } catch (SQLException ex) {
                // Menangkap SQLException jika terjadi kesalahan
                System.out.println(ex.toString());
            }
        });
    }
}
