package br.com.model;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {



   private List<ItemDeCompra> itens =  new ArrayList<>();

   public void setItens(List<ItemDeCompra> itens) {
      this.itens = itens;
   }

   public List<ItemDeCompra> getItens() {
      return itens;
   }

   public Cliente getCliente() {
      return cliente;
   }

   public void setCliente(Cliente cliente) {
      this.cliente = cliente;
   }

   private Cliente cliente;


   public void adicionar(Produto produto, int quantidade) {
      ItemDeCompra itemExistente = buscaItem(produto);

      if (itemExistente != null) {
         itemExistente.setQuantidade(itemExistente.getQuantidade() + quantidade);
         System.out.println("Quantidade atualizada no carrinho." );
      } else {
         ItemDeCompra novoItem = new ItemDeCompra();
         novoItem.setProduto(produto);
         novoItem.setQuantidade(quantidade);
         itens.add(novoItem);
         System.out.println("Produto adicionado no carrinho.");
      }
   }



   public void remover(Produto produto, int quantidade) {
      ItemDeCompra itemExistente = buscaItem(produto);

      if (itemExistente != null) {
         int novaQuantidade = itemExistente.getQuantidade() - quantidade;

         if (novaQuantidade > 0) {
            itemExistente.setQuantidade(novaQuantidade);
            System.out.println("Quantidade atualizada para " + novaQuantidade +" "+produto.getNome());
         } else {
            itens.remove(itemExistente);
            System.out.println("Produto removido do carrinho.");
         }
      } else {
         System.out.println("Produto não está no carrinho");
      }
   }



   public void eliminar(Produto produto) {
      ItemDeCompra itemTemporario = buscaItem(produto);

      if (itens.contains(itemTemporario)) {
         System.out.println("Item encontrado. Removendo do carrinho.");
         itens.remove(itemTemporario);
      } else {
         System.out.println("Item não encontrado no carrinho.");
      }
   }

   public Double calcularTotal(){
      double total = 0;
      for (ItemDeCompra item:itens){
         total += item.getProduto().getPreco() * item.getQuantidade();
      }
      return total;
   }

   public ItemDeCompra buscaItem(Produto produto){
      for (ItemDeCompra item : itens) {
         if (item.getProduto().equals(produto)) {
            return item;

         }
      }
      return null;
   }


}






