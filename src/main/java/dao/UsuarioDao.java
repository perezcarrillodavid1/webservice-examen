package dao;

import bean.Usuario;

public interface UsuarioDao {
	public boolean buscarUsuPass(String usu,String pass);
	public Usuario datosUsuario(String email);
}
