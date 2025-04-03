package classe;

public class ProdutoTeste {

    public static void main(String[] args) {

        Produto p1 = new Produto("Notebook", 4356.89);

        var p2 = new Produto();
        p2.nome = "Caneta Preta";
        p2.preco = 12.56;

        Produto.desconto = 0.50;

        System.out.println(p1.nome + " " + p1.precoComDesconto());
        System.out.println(p2.nome + " " + p2.precoComDesconto());

        double precoFinal1 = p1.precoComDesconto();
        double precoFinal2 = p2.precoComDesconto(0.1);
        double mediaCarrinho = (precoFinal1 + precoFinal2) / 2;

        System.out.printf("Média do carrinho = R$%.2f.", mediaCarrinho);
    }

    public class Produto {

        String nome;
        double preco;
        static double desconto = 0.25;

        Produto() {

        }

        Produto(String nomeInicial, double precoInicial) {
            nome = nomeInicial;
            preco = precoInicial;
        }

        double precoComDesconto() {
            return preco * (1 - desconto);
        }

        double precoComDesconto(double descontoDoGerente) {
            return preco * (1 - desconto + descontoDoGerente);
        }
    }

}
