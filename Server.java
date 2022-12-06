import java.io.*;
import java.net.*;
import java.util.Random;
  
class Server {
  
    public static void main(String args[])
        throws Exception
    {
  
        // ServerSocket criado
        ServerSocket serverSocket = new ServerSocket(888);
  
        // Conexão com o cliente
        Socket client = serverSocket.accept();
        System.out.println("Connection established");
  
        // Enviar dados para o cliente
        PrintStream send
            = new PrintStream(client.getOutputStream());
  
        // Ler dados vindos do cliente
        BufferedReader read
            = new BufferedReader(
                new InputStreamReader(
                    client.getInputStream()));
  
        // Ler dados do teclado
        BufferedReader keyboard
            = new BufferedReader(
                new InputStreamReader(System.in));
  
        // Execução do server
        while (true) {
  
            String msg;
  
  
            // Lido do cliente
            while ((msg = read.readLine()) != "exit") {
                System.out.println(msg);
                Random random = new Random();
                int numero = random.nextInt(100+1);

                //fazedo a conferência se o resultado é impar ou par
                if(numero % 2 == 0){
                    //envia caso seja par
                    send.println("Resultado: " + numero + " /Par venceu");
                }else{
                    //envia caso seja impar
                    send.println("Resultado" + numero + " /Impar venceu");
                }
            
  
            }
  
            // Fechar conexões
            send.close();
            read.close();
            keyboard.close();
            serverSocket.close();
            client.close();
  
            // fim da aplicação
            System.exit(0);
  
        } // fim do while
    }
}