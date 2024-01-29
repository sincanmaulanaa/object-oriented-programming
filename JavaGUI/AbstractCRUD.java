package crud;

public abstract class AbstractCRUD {
    protected String id, nama, umur, telepon, alamat, penyakit;

    public abstract void setID(String id);

    public abstract String getID();

    public abstract void setNama(String nama);

    public abstract String getNama();

    public abstract void setUmur(String umur);

    public abstract String getUmur();

    public abstract void setTelepon(String telepon);

    public abstract String getTelepon();

    public abstract void setAlamat(String alamat);

    public abstract String getAlamat();

    public abstract void setPenyakit(String penyakit);

    public abstract String getPenyakit();
}
