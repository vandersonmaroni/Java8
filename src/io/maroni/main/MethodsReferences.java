package io.maroni.main;

import io.maroni.model.Usuario;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by Vanderson Maroni on 10/03/2017.
 */
public class MethodsReferences {
  public static void main(String[] args) {
    Usuario user1 = new Usuario("Vanderson Maroni", 190);
    Usuario user2= new Usuario("João da Silva", 180);
    Usuario user3= new Usuario("José Pereira", 160);
    List<Usuario> usuarios = Arrays.asList(user1,user2,user3);

    System.out.println("================================================");
    System.out.println("Imprimindo os usuarios com foreach e reference methods");
    System.out.println("================================================");
    usuarios.forEach(System.out::println);

    System.out.println("================================================");
    System.out.println("Tornando todos os usuarios Morderadores e imprimindo eles");
    System.out.println("================================================");
    usuarios.forEach(u -> u.tornarModerador());
    usuarios.forEach(System.out::println);
//    Consumer<Usuario> tornarModerador = Usuario::tornarModerador;
//    usuarios.forEach(tornarModerador);

    System.out.println("================================================");
    System.out.println("Instânciando novas classes com reference methods");
    System.out.println("================================================");
    System.out.println("Instânciando com um parâmetro");
    System.out.println("================================================");

    Function<String, Usuario> criandoUsuariosFunction = Usuario::new;
    Usuario userF1 = criandoUsuariosFunction.apply("Vanderson");
    Usuario userF2 = criandoUsuariosFunction.apply("João");
    Usuario userF3 = criandoUsuariosFunction.apply("José");
    System.out.println(userF1);
    System.out.println(userF2);
    System.out.println(userF3);

    System.out.println("================================================");
    System.out.println("Instânciando com dois parâmetro");
    System.out.println("================================================");

    BiFunction<String,Integer,Usuario> cirandoUsuarioBiFunction = Usuario::new;
    Usuario userBF1 = cirandoUsuarioBiFunction.apply("Vanderson",190);
    Usuario userBF2 = cirandoUsuarioBiFunction.apply("João da Silva", 180);
    Usuario userBF3 = cirandoUsuarioBiFunction.apply("José Pereira", 160);
    System.out.println(userBF1);
    System.out.println(userBF2);
    System.out.println(userBF3);
  }
}
