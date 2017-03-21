package io.maroni.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Vanderson Maroni on 21/03/2017.
 */
public class Grupo {

  public Set<Usuario> usuarios = new HashSet<>();

  public void add(Usuario usuario){
    this.usuarios.add(usuario);
  }

  public Set<Usuario> getUsuarios(){
    return Collections.unmodifiableSet(this.usuarios);
  }

}
