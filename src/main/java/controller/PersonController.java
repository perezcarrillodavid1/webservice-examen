package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bean.Respuesta;
import bean.Usuario;
import dao.UsuarioDao;
import dao.UsuarioDaoImpl;

@Controller
public class PersonController {
	private UsuarioDaoImpl usuarioDao;
	public UsuarioDaoImpl getUsuarioDao() {
		return usuarioDao;
	}
	@Autowired
	public void setUsuarioDao(UsuarioDaoImpl usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
	@RequestMapping(value="login",method=RequestMethod.POST)
	public @ResponseBody Respuesta Login(@RequestBody Usuario person) { //@ResponseBody indica que se devolverá un objeto JSON
		return new Respuesta(usuarioDao.buscarUsuPass(person.getEmail(), person.getPassword()));
	}
	@RequestMapping(value="inicio",method=RequestMethod.POST)
	public @ResponseBody Usuario DatosInicio(@RequestBody Usuario person) { //@ResponseBody indica que se devolverá un objeto JSON
		return usuarioDao.datosUsuario(person.getEmail());		
	}
}
