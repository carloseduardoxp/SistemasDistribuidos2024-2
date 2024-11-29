package br.edu.iftm.cliente;

import br.edu.iftm.tspi.sd.ClienteServiceGrpc;
import br.edu.iftm.tspi.sd.ClienteServiceOuterClass.ClientePorNomeRequest;
import br.edu.iftm.tspi.sd.ClienteServiceOuterClass.ClienteRequest;
import br.edu.iftm.tspi.sd.ClienteServiceOuterClass.ClienteResponse;
import br.edu.iftm.tspi.sd.ClienteServiceOuterClass.ListaClientesResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext() 
                .build();

        ClienteServiceGrpc.ClienteServiceBlockingStub clienteStub = ClienteServiceGrpc.newBlockingStub(channel);

        ClienteRequest clienteRequest = ClienteRequest.newBuilder().setId(1).build();
        ClienteResponse clienteResponse = clienteStub.buscarClientePorId(clienteRequest);
        System.out.println("Cliente encontrado: " + clienteResponse.getCliente().getNome());

        ClientePorNomeRequest nomeRequest = ClientePorNomeRequest.newBuilder().setNome("Cliente").build();
        ListaClientesResponse listaClientesResponse = clienteStub.buscarClientesPorNome(nomeRequest);
        listaClientesResponse.getClientesList().forEach(cliente ->
                System.out.println("Cliente encontrado: " + cliente.getNome())
        );
        
        channel.shutdown();
    }
}
