package io.maroni.main;

import io.maroni.model.Usuario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;

/**
 * Created by Vanderson Maroni on 14/03/2017.
 */
public class Streams {
  public static void main(String[] args) {
    Usuario user = new Usuario("Vanderson",160);
    Usuario user2 = new Usuario("João",90);
    Usuario user3 = new Usuario("José",10);
    List<Usuario> usuarios = Arrays.asList(user,user2,user3);

    usuarios.stream().filter(u -> u.getDinheiro() > 100).collect(toList());

    System.out.println("================================================");
    System.out.println("Extraindo somento os dinheiros dos usuarios com o Stream().map()");
    System.out.println("================================================");

    List<Integer> dinheiros = usuarios.stream().map(Usuario::getDinheiro).collect(toList());
    dinheiros.forEach(System.out::println);

    System.out.println("================================================");
    System.out.println("Evitando o autoboxing dos tipos primitivos e pegando a media de dinheiro entre os usuários");
    System.out.println("================================================");

    double mediaDinheiro = usuarios.stream().mapToInt(Usuario::getDinheiro).average().getAsDouble();
    System.out.println(mediaDinheiro);

    System.out.println("================================================");
    System.out.println("Tirando a média do dinheiro dos usuários e utilizando Optional para " +
                       "validar o NullPointerException");
    System.out.println("================================================");
    List<Usuario> usuarios2 = new ArrayList<>();
    double mediaDinheiroOptional = usuarios2.stream().mapToInt(Usuario::getDinheiro).average().orElse(0.0);
    System.out.println(mediaDinheiroOptional);
  }
}
