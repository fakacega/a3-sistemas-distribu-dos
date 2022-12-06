import java.io.*;
import java.net.*;
  
class Cliente {
  
    public static void main(String args[])
        throws Exception
    {
  
        // Criação do cliente socket
        Socket s = new Socket("localhost", 888);
  
        // Mandar msg pro servidor
        DataOutputStream dos
            = new DataOutputStream(
                s.getOutputStream());
  
        // Ler msg vindo do servidor
        BufferedReader read
            = new BufferedReader(
                new InputStreamReader(
                    s.getInputStream()));
  
        // Ler dados do teclado
        BufferedReader keyboard
            = new BufferedReader(
                new InputStreamReader(System.in));
        String str, str1;
  

        // Comunicação continua até que retorne um exit
        while (!(str = keyboard.readLine()).equals("exit")) {
  
            // Enviar para o server
            dos.writeBytes(str + "\n");
  
            // Recebe do server
            str1 = read.readLine();
            if(str1 != null){
                System.out.println(str1);
            }
        }
  
        // Fechar conexões
        dos.close();
        read.close();
        keyboard.close();
        s.close();
    }
}