import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.util.ArrayList;

private ArrayList<ConexaoHospedeiro> Connections;
private ServerSocket server;
private boolean ok;
private ExecutorService pool; //thread pool,colecao de thread em fila para executar lista de tarefa

public Server (){
    Connections=new ArrayList<>();
    ok=false;
}

//public class Server implements Runnable{

    @override
    public void run() {
        try{
            Server = new ServerSocket(9999); //socket de servidor para o servidor
           pool=Executos.newcahedThreadpool();
            while(!ok){ //enquanto nao estiver concluido ok acitar conexao
                socket cliente=server.accept(); // retorna um soquete do cliente e tornar aceitavel, uma thread   
                ConexaoHospedeiro hospedeiro= new ConexaoHospedeiro(cliente); 
                ConnectException. add(hospedeiro);
                 pool.execute(hospedeiro);                           //cada vez que adicionar uma conexao
           }
           
        } catch(IOException e){
            desligar();


        }
}
//funçao de transmissão
public void broadcast(String message){
    //condiçao
    for(ConexaoHospedeiro ch:Connections){
        if(ch!=null){
            ch.sendMessage(message);
        }

    }
}


public Void desligar(){
    try{
    ok=true;
    if (!Server.isClosed()){
    server.close();
}
for (ConexaoHospedeiro ch: Connection){
    ch.desligar();
    } catch (IOException e){   
    }
}

class ConexaoHospedeiro implements Runnable{
     
        //construtor para manipular a conexão
        //o socket cliente privado
        //buffer sera responsavel para o fluxo do soquete
       
        private Socket cliente;
        private BufferReader in;
        private PrintWriter out;
        private String nome;

        public ConexaoHospedeiro(Socket cliente){
            this.cliente=cliente;
        }
       @Override
     public void run() {
        //iniciar fluxos de entrada e saida
        try{
            out=new PrintWriter(client.getOutputStream(),true);
            in=new BufferedReader(new InputStreamReader(cliente,getInputStream()));
            out.println("Ola!\n Entre com o seu Nome/Nickname: ");
            //para identificar os clientes no chat, vou pedir que o nome ou nickname
            nome= in.redLine(); 
            System.out.println(nome+"aderiu.");
            broadcast(nome+"Entrou no grupo!");
            //implementar algumas regras para chat
            // /nome sigifica que o usuario pretende alterar o seu nickname
            // se o usuario quiser sair da conversa so tera de fazer o comando /sair
            // e caso nao houver comando ou comando nao existente para o sistema
            String mensage;
            while((mensage=in.redLine()))!=null){
                if (message.startswith("/nome") ){
                    String[] messageSplit = mensage.split("", 2);
                    if(mensageSplit.length==2){
                        broadcast(name + "nickname alterado para"+ messageSplit[1]);
                        System.out.println(nome+"nickname alterado para"+ messageSplit[1]);
                                          
                        name= messageSplit[1];
                        out.println("nickname alterado com sucesso!"+nome);
                    }else{
                        out.println("Sem nome!Por favor insire um!"+nome);
                    }
                }else if(message.startswith("/sair")){
                       broadcast (name + "Saiu do chat!");
                        desligar();  //cliente sai do servidor

                    }else{
                        broadcast(nome+ ":" +message);               }
                }
            }

       }catch(IOException e){
        desligar();

        }



    }

    public void EnvioMensage(String mensage){
        out.println(mensage);
    }
    public void 
}

public void desligar(){
    try{
in.close();
out.close();
if(!cliente.isClosed()){
    cliente.close();
    }
} catch(Exception e ){
}
}
}
   public static void main(string[] args){
    Server server= new Server();
    server.run();
   }
}