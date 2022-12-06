import java.io.*;
import java.net.*;
import java.util.Random;
  
class Server {
  
    public static void main(String args[])
        throws Exception
    {
  
        // ServerSocket criado
        ServerSocket ss = new ServerSocket(888);
  
        // Conexão com o cliente
        Socket s = ss.accept();
        System.out.println("Connection established");
  
        // Enviar dados para o cliente
        PrintStream ps
            = new PrintStream(s.getOutputStream());
  
        // Ler dados vindos do cliente
        BufferedReader br
            = new BufferedReader(
                new InputStreamReader(
                    s.getInputStream()));
  
        // Ler dados do teclado
        BufferedReader kb
            = new BufferedReader(
                new InputStreamReader(System.in));
  
        // Execução do server
        while (true) {
  
            String str;
  
  
            // Lido do cliente
            while ((str = br.readLine()) != null) {
                System.out.println(str);
                Random random = new Random();
                int numero = random.nextInt(100+1);

                //fazedo a conferência se o resultado é impar ou par
                if(numero % 2 == 0){
                    //envia caso seja par
                    ps.println("Resultado: " + numero + " /Par venceu");
                }else{
                    //envia caso seja impar
                    ps.println("Resultado" + numero + " /Impar venceu");
                }
            
  
              //ps.println(numero);
            }
  
            // close connection
            ps.close();
            br.close();
            kb.close();
            ss.close();
            s.close();
  
            // fim da aplicação
            System.exit(0);
  
        } // fim do while
    }
}