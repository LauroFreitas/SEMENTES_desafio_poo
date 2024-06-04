import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Produtos> carrinho = new ArrayList<>();

        boolean ativoSistema = true;

        System.out.println("::::....MERCADINHO...::::");

        while (ativoSistema) {
            System.out.println("Selecione o produto");
            System.out.println("[Café 1kg][1] [Sabão em pó][2] [Caixa de Leite][3] [Refrigerate][4] [Fechar carrinho][5]");

            int escolha = Integer.parseInt(scanner.nextLine());

            switch (escolha) {
                case 1:
                    adicionarProduto("Café 1kg", 1, 1, carrinho);
                    break;
                case 2:
                    adicionarProduto("Sabão em pó", 36f, 2, carrinho);
                    break;
                case 3:
                    adicionarProduto("Caixa de Leite", 82f, 3, carrinho);
                    break;
                case 4:
                    adicionarProduto("Refrigerate", 8.50f, 4, carrinho);
                    break;
                case 5:
                    ativoSistema = false;
                    escolherPagamento(carrinho);
                    break;
                default:
                    System.out.println("ERRO: Opção inválida.");
            }
        }
    }

    public static void adicionarProduto(String nome, float preco, int id, List<Produtos> carrinho) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Comprar " + nome + "? S/N");
        char resposta = scanner.nextLine().toUpperCase().charAt(0);
        if (resposta == 'S') {
            Produtos produto = new Produtos(nome, preco, id);
            carrinho.add(produto);

            if (!carrinho.isEmpty()) {
                int[] contagens = new int[5];
                for (Produtos item : carrinho) {
                    contagens[item.id - 1]++;
                }

                for (int i = 0; i < contagens.length; i++) {
                    if (contagens[i] > 0) {
                        System.out.println((i + 1) + "," + contagens[i] + " itens");
                    }
                }
            }
        }
    }

    public static void escolherPagamento(List<Produtos> carrinho) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Qual a forma de pagamento?");
        System.out.println("1-Dinheiro\n2-Crédito\n3-Débito");
        int escolha = Integer.parseInt(scanner.nextLine());

        CaixaDoAtacado caixa = new CaixaDoAtacado();
        float totalComDesconto = caixa.computarCompra(carrinho);
        System.out.println("Total com desconto: R$" + totalComDesconto + "| Quantidade de itens: " + carrinho.size());
        System.out.println("_________________________________________________");

        switch (escolha) {
            case 1:
                System.out.println("Dinheiro");
                break;
            case 2:
                System.out.println("Crédito");
                break;
            case 3:
                System.out.println("Débito");
                break;
            default:
                System.out.println("Opção de pagamento inválida.");
                break;
        }

        int contador = 1;
        for (Produtos produto : carrinho) {
            System.out.println(contador + "|" + produto.nome + "|R$ " + produto.preco);
            contador++;
        }
    }
}
