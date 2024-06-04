import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AgendaTelefonica agendaTelefonica = new AgendaTelefonica();




        System.out.println("____________Lista_Telefonica______________");
        boolean sistema = true;

        while (sistema) {

            System.out.println("\n\n1-Incluir Contato\n2-Remover Contato\n3-Buscar Contato\n4-Atualizar Contato\n");
            int escolha = Integer.parseInt(scanner.nextLine());

            switch (escolha) {
                case 1:
                    System.out.println("______________Incluir_contato______________");
                    System.out.println("Digite um nome");
                    String nome = scanner.nextLine();

                    Contato contatoEncontrado = agendaTelefonica.buscarContato(nome);

                    if(contatoEncontrado != null){
                        System.out.printf("Já existe um contato com esse nome, porfavor acrecente ou mude de nome");
                    }else{
                        System.out.println("Digite o numero de telefone");
                        String numero = scanner.nextLine();
                        Contato novoContato = new Contato(nome,numero);
                        agendaTelefonica.adicionarContato(novoContato);
                    }
                    break;
                case 2:
                    System.out.println("______________Remover_contato______________");
                    System.out.println("Digite um nome");
                    nome = scanner.nextLine();
                    contatoEncontrado = agendaTelefonica.buscarContato(nome);

                    if(contatoEncontrado != null){
                        System.out.println("Tem certeza ques deseja remover o contato " + nome + "? S/N");
                        char resposta = scanner.nextLine().toUpperCase().charAt(0);
                        if (resposta == 'S'||resposta == 's') {
                            agendaTelefonica.removerContato(nome);
                        }
                    }
                    else {
                        System.out.printf("Não existe esse contato");
                    }
                    break;
                case 3:
                    System.out.println("______________Busca_de_contato______________");
                    System.out.println("Digite um nome");
                    nome = scanner.nextLine();

                     contatoEncontrado = agendaTelefonica.buscarContato(nome);

                    if(contatoEncontrado != null){
                        System.out.printf("Nome: "+ contatoEncontrado.nome+"\nTelefone: "+contatoEncontrado.numeroTelefone);
                    }
                    else{
                        System.out.println("Contato não encontrado");
                    }
                    break;
                case 4:
                    System.out.println("______________Atualiza_Contato______________");
                    System.out.println("Digite um nome");
                    nome = scanner.nextLine();
                    contatoEncontrado = agendaTelefonica.buscarContato(nome);

                    if(contatoEncontrado != null){
                        System.out.println("Digite o numero de telefone");
                        String numero = scanner.nextLine();
                        Contato contatoAtualizado = new Contato(nome,numero);
                        agendaTelefonica.atualizarContato(nome,contatoAtualizado);
                    }
                    else {
                        System.out.printf("Não existe esse contato");
                    }
                    break;
                default:
            }
        }
    }
}