package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUD extends AbstractCRUD implements DatabaseActions {
	private String id, nama, umur, telepon, alamat, penyakit;
	private Connection CRUDkoneksi;
	private PreparedStatement CRUDpsmt;
	private Statement CRUDstat;
	private ResultSet CRUDhasil;
	private String CRUDquery;

	public CRUD() {
		try {
			KoneksiMysql connection = new KoneksiMysql();
			CRUDkoneksi = connection.getKoneksi();
		} catch (SQLException ex) {
			System.out.println(ex);
		}
	}

	@Override
	public void setID(String id) {
		this.id = id;
	}

	@Override
	public String getID() {
		return id;
	}

	@Override
	public void setNama(String nama) {
		this.nama = nama;
	}

	@Override
	public String getNama() {
		return nama;
	}

	@Override
	public void setUmur(String umur) {
		this.umur = umur;
	}

	@Override
	public String getUmur() {
		return umur;
	}

	@Override
	public void setTelepon(String telepon) {
		this.telepon = telepon;
	}

	@Override
	public String getTelepon() {
		return telepon;
	}

	@Override
	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	@Override
	public String getAlamat() {
		return alamat;
	}

	@Override
	public void setPenyakit(String penyakit) {
		this.penyakit = penyakit;
	}

	@Override
	public String getPenyakit() {
		return penyakit;
	}

	@Override
	public ResultSet tampilData() {
		CRUDquery = "select * from pasien";
		try {
			CRUDstat = CRUDkoneksi.createStatement();
			CRUDhasil = CRUDstat.executeQuery(CRUDquery);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return CRUDhasil;
	}

	@Override
	public void simpanData(String id, String nama, String umur, String telepon, String alamat, String penyakit) {
		CRUDquery = "insert into pasien values(?,?,?)";
		try {
			CRUDpsmt = CRUDkoneksi.prepareStatement(CRUDquery);
			CRUDpsmt.setString(1, id);
			CRUDpsmt.setString(2, nama);
			CRUDpsmt.setString(3, umur);
			CRUDpsmt.setString(4, telepon);
			CRUDpsmt.setString(5, alamat);
			CRUDpsmt.setString(6, penyakit);
			CRUDpsmt.executeUpdate();
			CRUDpsmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void ubahData(String id, String nama, String umur, String telepon, String alamat, String penyakit) {
		CRUDquery = "update pasien set nama=?, umur=?, telepon=?, alamat=?, penyakit=? where id=?";
		try {
			CRUDpsmt = CRUDkoneksi.prepareStatement(CRUDquery);
			CRUDpsmt.setString(1, nama);
			CRUDpsmt.setString(2, umur);
			CRUDpsmt.setString(3, telepon);
			CRUDpsmt.setString(5, alamat);
			CRUDpsmt.setString(6, penyakit);
			CRUDpsmt.setString(7, id);
			CRUDpsmt.executeUpdate();
			CRUDpsmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void hapusData(String id) {
		CRUDquery = "delete from pasien where id=?";
		try {
			CRUDpsmt = CRUDkoneksi.prepareStatement(CRUDquery);
			CRUDpsmt.setString(1, id);
			CRUDpsmt.executeUpdate();
			CRUDpsmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
