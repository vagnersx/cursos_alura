package br.com.vagner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        var texto = "Hello World";
        
        Produto produto = new Produto("Vagner", 1.1);
        System.out.println( produto.getNome());
       
    }
}
