import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int continua = 1;

        System.out.println("Informe o limite do cartão: ");
        double limite = sc.nextDouble();

        CartaoDeCredito cartao = new CartaoDeCredito(limite);



        while (continua == 1) {
            System.out.println("Informe o produto que deseja comprar: ");
            String produto = sc.next();

            System.out.println("Informe o valor do produto: ");
            double valor = sc.nextDouble();

            sc.nextLine();

            Compra compra = new Compra(produto, valor);
            boolean compraAprovada = cartao.validaCompra(compra);

            if (compraAprovada) {
                System.out.println("Compra aprovada!");
                System.out.println("Digite 1 para continuar comprando ou 0 para sair");
                continua = sc.nextInt();
            } else {
                System.out.println("Saldo insuficiente");
                System.out.println("Digite 1 para continuar comprando ou 0 para sair");
                continua = sc.nextInt();
            }
        }

        Collections.sort(cartao.getCompras());

        System.out.println("*********************************************");
        System.out.println("Compras\n");

        for (Compra compra : cartao.getCompras()) {
            System.out.println("Item - " + compra.getProduto() + " valor - " + compra.getValor());
        }

        System.out.println(cartao.getCompras());
    }
}