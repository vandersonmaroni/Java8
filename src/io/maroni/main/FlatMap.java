package io.maroni.main;

import io.maroni.model.Grupo;
import io.maroni.model.Usuario;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Vanderson on 21/03/2017.
 */
public class FlatMap {
  public static void main(String[] args) {
    Usuario user1 = new Usuario("Vanderson",100);
    Usuario user2 = new Usuario("João",200);
    Usuario user3 = new Usuario("José",300);

    Grupo englishSpeakers = new Grupo();
    englishSpeakers.add(user1);
    englishSpeakers.add(user2);

    Grupo spanishSpeakers = new Grupo();
    spanishSpeakers.add(user2);
    spanishSpeakers.add(user3);

    List<Grupo> grupos = Arrays.asList(englishSpeakers,spanishSpeakers);

    grupos.stream().flatMap(g -> g.getUsuarios().stream()).distinct().forEach(System.out::println);
  }
}
