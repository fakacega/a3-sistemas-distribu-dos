import java.io.*;
import java.net.*;
  
class Client2 {
  
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
        BufferedReader br
            = new BufferedReader(
                new InputStreamReader(
                    s.getInputStream()));
  
        // Ler dados do teclado
        BufferedReader kb
            = new BufferedReader(
                new InputStreamReader(System.in));
        String str, str1;
  

        // Comunicação continua até que retorne um exit
        while (!(str = kb.readLine()).equals("exit")) {
  
            // Enviar para o server
            dos.writeBytes(str + "\n");
  
            // Recebe do server
            str1 = br.readLine();
            if(str1 != null){
                System.out.println(str1);
            
            }
        }
  
        // Fechar conexões
        dos.close();
        br.close();
        kb.close();
        s.close();
    }
}