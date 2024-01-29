package crud;

import java.sql.SQLException;
import java.sql.ResultSet;

public interface DatabaseActions {
        void simpanData(String id, String nama, String umur, String telepon, String alamat, String penyakit)
                        throws SQLException;

        void ubahData(String id, String nama, String umur, String telepon, String alamat, String penyakit)
                        throws SQLException;

        void hapusData(String id) throws SQLException;

        ResultSet tampilData() throws SQLException;

}
