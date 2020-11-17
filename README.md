# sistemas-distribuidos
Contém as atividades práticas da disciplina de Sistemas Distribuídos do curso de tecnologia em análise e desenvolvimento de sistemas.

## Sockets de Rede
Tecnologia que permite a comunicação cliente/servidor por meio dos protocolos da camada de transporte TCP/UDP. O mesmo possibilita a
criação de um "tubo" virtual de mão dupla (full duplex), por onde tanto o cliente quanto o servidor poredão enviar ou receber dados.

### Cliente Telnet X Servidor Java
O cliente pode se comunicar com um servidor java usando o protocolo telnet. Para isso, basta usar a seguinte sintaxe:
<b> telnet ipdoservidor porta </b>

### Cliente Java X Servidor Java

<img src="https://github.com/MarcosJuunioor/sistemas-distribuidos/blob/master/comunicacao-via-sockets.png" />

## Servidor MultiThread (múltiplos clientes)
Para que um servidor java socket possa receber requisições de diversos clientes,  é necessário que o mesmo instancie uma thread para
cada um. O pacote "servidormultithread" possui um código de exemplo para tal situação.

## Serialização
Além de tipos primitivos, também se pode transmitir objetos entre clientes e servidores. Para que um objeto possa ser utilizado em um
fluxo de entrada ou saída, ele deve ser serializável:
- A classe deve ser pública
- Deve implementar a interface Serializable
- Deve ter o construtor padrão (sem argumentos)
Considerações:
- É enviada uma cópia do objeto (passagem por valor)
- Ambos os lados devem conhecer o objeto (ter a definição da classe)

## Sockets UDP
UDP: Unreliable Datagram Protocol
Envio rápido de informações pela rede através de pacotes datagramas.
Diferentemente do TCP:
- Não há garantia que eles cheguem ao destino
- Não há garantia da ordem de chegada dos pacotes
- Pacotes de até 1024 bytes

<b> Datagramas do lado do cliente: enviando datagramas</b>
- DatagramPacket: DatagramPacket(dado, tamanho, host, porta)
- DataGramSocket: DatagramSocket() send(pacote)
 
<b> Datagramas do lado do servidor: recebendo datagramas</b>
- DatagramPacket: DatagramPacket(dado, tamanho)
- DataGramSocket: DatagramSocket(porta) receive(pacote)
  
No pacote "enviarecebeudp" tem um exemplo de implementação.

## RMI - Remote Method Invocation
Uma tecnologia que estende o modelo de objetos utilizado por Java para a rede. 
Permite a passagem da referência de objetos pela rede (pode-se usar uma jvm remota).

