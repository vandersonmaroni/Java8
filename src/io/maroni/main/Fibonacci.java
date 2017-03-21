package io.maroni.main;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Vanderson Maroni on 21/03/2017.
 */
public class Fibonacci implements IntSupplier {
  private int anterior = 0;
  private int proximo = 1;

  @Override
  public int getAsInt() {
    proximo = proximo + anterior;
    anterior = proximo - anterior;
    return anterior;
  }
  static Stream<String> lines(Path path){
    try {
      return Files.lines(path);
    } catch (IOException e) {
      throw new UncheckedIOException(e);
    }
  }


  public static void main(String[] args) throws IOException {
    IntStream.generate(new Fibonacci()).limit(10).forEach(System.out::println);

    System.out.println("================================================");
    System.out.println("Filtrando o primeiro número Fibonacci maior que 100");
    System.out.println("================================================");
    int maiorQue100 = IntStream.generate(new Fibonacci())
            .filter(f -> f > 100)
            .findFirst().getAsInt();
    System.out.println(maiorQue100);

    System.out.println("================================================");
    System.out.println("listar todos os arquivos de um diretório. Exemplo: " +
            "C://Users/vgmaroni/git/Java8/src/io/maroni/main");
    System.out.println("================================================");
    String diretorio = "C://Users/vgmaroni/git/Java8/src/io/maroni/main";

    Files.list(Paths.get(diretorio)).forEach(System.out::println);

    System.out.println("================================================");
    System.out.println("listar todos os arquivos de um diretório com filtro. Exemplo: " +
            "C://Users/vgmaroni/git/Java8/src/io/maroni/main");
    System.out.println("================================================");

    Files.list(Paths.get(diretorio))
            .filter(path -> path.toString()
                    .endsWith("Streams.java"))
            .forEach(System.out::println);


    System.out.println("================================================");
    System.out.println("todo o conteúdo dos arquivos dos arquivos nos filtros.");
    System.out.println("================================================");
    Files.list(Paths.get(diretorio))
            .filter(path -> path.toString()
                    .endsWith("Streams.java"))
            .map(path -> lines(path))
            .forEach(System.out::println);

    System.out.println("================================================");
    System.out.println("Utilizando flatmap.");
    System.out.println("================================================");
    Files.list(Paths.get(diretorio))
            .filter(path -> path.toString()
                    .endsWith("Streams.java"))
            .flatMap(path -> lines(path))
            .forEach(System.out::println);

    System.out.println("================================================");
    System.out.println("Pegando valores de arquivos csv.");
    System.out.println("================================================");
    Files.list(Paths.get("C:/Users/vgmaroni/Downloads"))
            .filter(path -> path.toString()
                    .endsWith("USUARIO.csv"))
            .flatMap(path -> lines(path))
            .forEach(System.out::println);
  }
}
