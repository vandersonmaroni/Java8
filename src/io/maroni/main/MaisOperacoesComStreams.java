package io.maroni.main;

import io.maroni.model.Usuario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by Vanderson Maroni on 16/03/2017.
 */
public class MaisOperacoesComStreams {
  public static void main(String[] args) {
    Usuario user = new Usuario("Vanderson", 160);
    Usuario user2 = new Usuario("João", 90);
    Usuario user3 = new Usuario("José", 10);
    Usuario user4 = new Usuario("Paulo", 120);
    List<Usuario> usuarios = Arrays.asList(user, user2, user3, user4);
    List<Usuario> usuariosNull = new ArrayList<>();
    System.out.println("================================================");
    System.out.println("Ordenando um clientes com dinheiro maior que 100 e ordenando por nome");
    System.out.println("================================================");

    List<Usuario> usuariosOrdenados = usuarios.stream()
            .filter(u -> u.getDinheiro() > 100)
            .sorted(Comparator.comparing(Usuario::getNome))
            .collect(toList());
    usuariosOrdenados.forEach(System.out::println);

    System.out.println("================================================");
    System.out.println("Pegando o primeiro usuário que possua mais de 100 reais");
    System.out.println("================================================");

    Usuario usuarioMaisDe100 = usuarios.stream()
            .filter(u -> u.getDinheiro() > 100)
            .findAny()
            .orElse(new Usuario("Teste"));
//    Usuario usuarioMaisDe100 = usuariosNull.stream().filter(u -> u.getDinheiro() > 100).findAny().orElse(new Usuario("Teste"));
    System.out.println(usuarioMaisDe100);

    System.out.println("================================================");
    System.out.println("Utilizando peek() para imprimir tipo forEach()");
    System.out.println("================================================");
    usuarios.stream()
            .sorted(Comparator.comparing(Usuario::getNome))
            .peek(System.out::println)
            .findFirst();

    System.out.println("================================================");
    System.out.println("Modificando valores do stream");
    System.out.println("================================================");
    usuarios.stream().filter(u -> u.getDinheiro() > 100).iterator().forEachRemaining(Usuario::tornarModerador);
    usuarios.forEach(System.out::println);

    System.out.println("================================================");
    System.out.println("Verificando se a lista possui algum moderador");
    System.out.println("================================================");
    boolean hasModerador = usuarios.stream()
            .anyMatch(Usuario::isModerador);
    System.out.println(hasModerador);


    System.out.println("================================================");
    System.out.println("Verificando se todos da lista são moderadores");
    System.out.println("================================================");
    boolean hasAllModeradors = usuarios.stream().allMatch(Usuario::isModerador);
    System.out.println(hasAllModeradors);

    System.out.println("================================================");
    System.out.println("Pulando os dois primeiros usuarios");
    System.out.println("================================================");
    List<Usuario> usuariosQueNaoForamPulados = usuarios.stream()
                                                .skip(2)
                                                .collect(toList());
    System.out.println(usuariosQueNaoForamPulados);

  }
}
