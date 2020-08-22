package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.stereotype.Component;

import bean.Usuario;

@Component
public class UsuarioDaoImpl implements UsuarioDao{
	private DataSource dataSource;
	public DataSource getDataSource() {
		return dataSource;
	}
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}	
	public boolean buscarUsuPass(String usu,String pass) {
		String sql = "SELECT * FROM usuario where email = ? and password = ?";
		Connection conn = null;
		boolean respuesta=false;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, usu);
			ps.setString(2, pass);
			System.out.println(usu+" "+pass);
			ResultSet rs = ps.executeQuery();
			int i=0;
			if (rs.next()) {				
				respuesta=true;
			}
			rs.close();
			ps.close();			
		} catch (SQLException e) {
			e.printStackTrace();			
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		return respuesta;
	}
	public Usuario datosUsuario(String email) {
		String sql = "SELECT * FROM usuario where email = ? ";
		Connection conn = null;
		Usuario usu=null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);			
			ResultSet rs = ps.executeQuery();
			int i=0;
			if (rs.next()) {				
				usu=new Usuario();
				usu.setEmail(email);
				usu.setFirst_name(rs.getString("first_name"));
				usu.setLast_name(rs.getString("last_name"));
				usu.setPhone(rs.getString("phone"));
				usu.setFax(rs.getString("fax"));
			}
			rs.close();
			ps.close();			
		} catch (SQLException e) {
			e.printStackTrace();			
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		return usu;
	}
}
