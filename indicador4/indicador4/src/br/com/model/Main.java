

package br.com.model;

        import java.sql.SQLOutput;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Produto chocolateAoLeite = new Produto("Chocolate ao Leite", "Barra de 215 gr", 19.99, 123);
        Produto chocolateBranco = new Produto("Chocolate Branco", "Barra de 215 gr", 19.99, 456);
        Produto chocolateRuby = new Produto("Chocolate Ruby", "Barra de 215 gr", 19.99, 789);
        Produto chocolateAmargo = new Produto("Chocolate Amargo", "Barra de 215 gr 70%", 19.99, 987);
        Produto chocolateMeioAmargo = new Produto("Chocolate Meio Amargo", "Barra de 215 gr 40%", 19.99, 654);
        Produto chocolateComNozes = new Produto("Chocolate com Nozes", "Trufa de 120 gr", 4.80, 321);
        Produto chocolateComCookies = new Produto("Chocolate com Cookies", "Trufa de 120 gr", 4.80, 147);
        Produto chocolateComPistache = new Produto("Chocolate com Pistache", "Barra de 215 gr", 29.00, 369);


        Catalago catalogo = new Catalago();
        List<Produto> produtos = new ArrayList<>();
        produtos.add(chocolateAoLeite);
        produtos.add(chocolateBranco);
        produtos.add(chocolateRuby);
        produtos.add(chocolateAmargo);
        produtos.add(chocolateMeioAmargo);
        produtos.add(chocolateComNozes);
        produtos.add(chocolateComCookies);
        produtos.add(chocolateComPistache);


        catalogo.setProdutos(produtos);
        catalogo.setTitulo("Bem vindo ao catalago");

        System.out.println("Bem vindo a Chocolateria Matterhorn, faça o seu pedido!");
        System.out.println("Digite seu nome:");
        String nomeCliente = scanner.nextLine();
        System.out.println( "Olá "+ nomeCliente + " Agora digite seu CPF/CNPJ (somente numeros)");
        String cpfOuCnpj = scanner.nextLine();
        Cliente cliente;
        if (cpfOuCnpj.length() <= 11) {
            PessoaFisica pessoaFisica = new PessoaFisica();
            pessoaFisica.setNome(nomeCliente);
            pessoaFisica.setCpf(cpfOuCnpj);
            cliente = pessoaFisica;
        } else {
            PessoaJuridica pessoaJuridica = new PessoaJuridica();
            pessoaJuridica.setNome(nomeCliente);
            pessoaJuridica.setCnpj(cpfOuCnpj);
            cliente = pessoaJuridica;
        }

        Carrinho carrinho = new Carrinho();
        carrinho.setCliente(cliente);
        System.out.println("Agora "+nomeCliente+ "! Vamos as compras? Digite sim ou nao)");
        String resposta = scanner.nextLine();
        while (resposta.equals("sim")) {
            Menu(catalogo);
            MostrarCarrinho(carrinho);

                System.out.println("Digite o código do produto que deseja adicionar:");
                int cod = scanner.nextInt();
                for (Produto produto : catalogo.getProdutos()) {
                    if (produto.getCodigo() == cod) {
                        System.out.println("Digite a quantidade do produto");
                        int qtd = scanner.nextInt();
                        carrinho.adicionar(produto, qtd);
                        break;
                    }
                }
            System.out.println("O que deseja fazer agora, " + nomeCliente + "?\n" +
                    "(1) ADICIONAR + CHOCOLATES :P 'Ai que delícia o verão...'\n" +
                    "(2) REMOVER ITENS :/ 'Devia ter complicado menos, trabalhado menos...'\n" +
                    "(3) EXCLUIR COMPRA :( 'Nada do que foi será, de novo do jeito que já foi um dia...' ");

            int escolha = scanner.nextInt();

            if (escolha == 1) {
            } else if (escolha == 2) {
                System.out.println("Digite o código do produto que deseja remover:");
                int codRemover = scanner.nextInt();
                for (Produto produto : catalogo.getProdutos()) {
                    if (produto.getCodigo() == codRemover) {
                        System.out.println("Digite a quantidade que deseja remover:");
                        int quantidade = scanner.nextInt();
                        carrinho.remover(produto, quantidade);
                        break;
                    }
                }


            } else if (escolha == 3) {
                System.out.println("Digite o código do produto que desejas eliminar da sua lista:");
                int eliminar = scanner.nextInt();
                for (Produto produto : catalogo.getProdutos()) {
                    if (produto.getCodigo() == eliminar) {
                        carrinho.eliminar(produto);
                        break;
                    }
                }


            }

            System.out.println("Deseja realizar mais operações? (sim/não)");
            scanner.nextLine();
            resposta = scanner.nextLine();

        }
        MostrarCarrinho(carrinho);


    }
    static void Menu (Catalago catalogo){
        System.out.println("===============================");
        System.out.println(catalogo.getTitulo());
        System.out.println("===============================");
        for (Produto produto : catalogo.getProdutos()) {
            System.out.println("Nome:" + produto.getNome());
            System.out.println("Descrição:" + produto.getDescricao());
            System.out.println("Preço:" + produto.getPreco());
            System.out.println("Código:" + produto.getCodigo());
            System.out.println("....................");
        }
    }
    static void MostrarCarrinho(Carrinho carrinho){
        System.out.println("Carrinho de "+ carrinho.getCliente().getNome());
        for (ItemDeCompra item: carrinho.getItens()){
            System.out.println("Nome:" + item.getProduto().getNome()+" |Valor:"+item.getProduto().getPreco()+" |Codigo:"+item.getProduto().getCodigo()+" |Quantidade:"+ item.getQuantidade());
        }
        System.out.println("Total: "+carrinho.calcularTotal());
    }
}

