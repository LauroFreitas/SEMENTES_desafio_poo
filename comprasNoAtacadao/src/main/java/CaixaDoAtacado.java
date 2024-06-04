import java.util.List;


public class CaixaDoAtacado {

    public float computarCompra(List<Produtos> carrinho){

        System.out.println("Fechamento do carrinho\n ");

        float desconto = 0;

        if (  carrinho.size() > 5 &&   carrinho.size() <= 15) {
            desconto = 0.1f;
        } else if (  carrinho.size() > 15 &&   carrinho.size() <= 25) {
            desconto = 0.2f;
        } else if (  carrinho.size() > 25) {
            desconto = 0.25f;
        }

        float total = 0;
        for (Produtos produto : carrinho) {
            total += produto.preco;
        }

        float valorDesconto = total * desconto;
        float totalComDesconto = total - valorDesconto;

        return totalComDesconto;
    }
}
