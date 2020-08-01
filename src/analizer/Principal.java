package analizer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java_cup.internal_error;

public class Principal {

    public static void main(String[] args) throws internal_error, IOException, Exception {
        // TODO Auto-generated method stub
        String ruta1 = "D:/Unibe/6t0 Cuatrimestre/Teoria de compiladores/AnalizadorLexico/src/analizer/Lexer.flex";
        String ruta2 = "D:/Unibe/6t0 Cuatrimestre/Teoria de compiladores/AnalizadorLexico/src/analizer/LexerCup.flex";
        String[] rutaS = {"-parser", "Sintax", "D:/Unibe/6t0 Cuatrimestre/Teoria de compiladores/AnalizadorLexico/src/analizer/Sintax.cup"};
        generar(ruta1, ruta2, rutaS);
    }

    public static void generar(String ruta1, String ruta2, String[] rutaS) throws internal_error, IOException, Exception {
        File archivo;
        archivo = new File(ruta1);
        JFlex.Main.generate(archivo);
        archivo = new File(ruta2);
        JFlex.Main.generate(archivo);
        java_cup.Main.main(rutaS);

        /* Ruta a la tabla de simbolos generada por CUP */
        Path rutaSym = Paths.get("D:/Unibe/6t0 Cuatrimestre/Teoria de compiladores/AnalizadorLexico/src/analizer/sym.java");
        /* Borra el archivo si ya existe en el proyecto */
        if (Files.exists(rutaSym)) {
            Files.delete(rutaSym);
        }
        /* Mueve el archivo de simbolos generado por CUP al directorio del proyecto */
        Files.move(
            Paths.get("D:/Unibe/6t0 Cuatrimestre/Teoria de compiladores/AnalizadorLexico/sym.java"),
            rutaSym
        );

        /* Ruta al archivo de sintactica generada por CUP */
        Path rutaSintax = Paths.get("D:/Unibe/6t0 Cuatrimestre/Teoria de compiladores/AnalizadorLexico/src/analizer/Sintax.java");
        /* Borra el archivo si ya existe en el proyecto */
        if (Files.exists(rutaSintax)) {
            Files.delete(rutaSintax);
        }
        /* Mueve el archivo de sintactica generado por CUP al directorio del proyecto */
        Files.move(
            Paths.get("D:/Unibe/6t0 Cuatrimestre/Teoria de compiladores/AnalizadorLexico/Sintax.java"),
            rutaSintax
        );
    }
}
