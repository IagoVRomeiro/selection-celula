import java.io.PrintStream;
import java.util.*;

class Celula {
    int valor;
    Celula prox;

    Celula() {
        this(0);
    }

    Celula(int valor) {
        this.valor = valor;
        this.prox = null;
    }
}

class Lista {

    public Celula prim, ult;
    private int tamanho;

    Lista() {
        prim = new Celula();// sentinela
        ult = prim;
        tamanho = 0;
    }

    Lista cloneLista() {
        Lista novaLista = new Lista();

        for (Celula i = prim.prox; i != null; i = i.prox) {
            Celula celulaNova = new Celula();
            celulaNova.valor = i.valor;
            novaLista.ult.prox = celulaNova;
            novaLista.ult = celulaNova;
        }
        return novaLista;
    }

    public void ListaSelectionSort() {

        for (Celula i = prim.prox; i != null; i = i.prox) {
            Celula CelulaMin = i;
            for (Celula j = i.prox; j != null; j = j.prox) {
                if (j.valor < CelulaMin.valor) {
                    CelulaMin = j;
                }
            }
            if (CelulaMin.valor != i.valor) {
                int tmp = i.valor;
                i.valor = CelulaMin.valor;
                CelulaMin.valor = tmp;
            }
        }
    }

    public void ImprimirRecursivo(Celula x) {
        if (x != null) {
            MyIO.print(x.valor + " ");
            ImprimirRecursivo(x.prox);
        }
    }

    public void mostrarIndice() {
        for (Celula i = prim.prox; i != null; i = i.prox.prox) {
            MyIO.print(i.valor + " ");
        }

    }

    public void inserirFim(int x) {
        Celula novaCelula = new Celula(x);
        ult.prox = novaCelula;
        ult = novaCelula;
    }

    public boolean vazia() {
        if (prim == ult) {
            return true;
        }
        return false;
    }

    public void mostrar() {
        if (!vazia()) {
            for (Celula i = prim.prox; i != null; i = i.prox) {
                MyIO.print(i.valor + " ");
            }
        } else {
            MyIO.println("Lista vazia! Nada a mostrar ou a remover.");
        }
    }

}

public class prova {
    public static void main(String[] args) throws Exception {
        Lista lista = new Lista();
        lista.inserirFim(4);
        lista.inserirFim(3);
        lista.inserirFim(1);
        lista.inserirFim(6);
        lista.inserirFim(9);
        lista.inserirFim(2);
        lista.inserirFim(3);
        lista.inserirFim(7);
        lista.inserirFim(8);
        lista.inserirFim(0);

        System.out.println("Mostrando a lista recursivamente");
        lista.ImprimirRecursivo(lista.prim.prox);

        System.out.println("\nMostrando a lista ordenada por Selection sort");
        lista.ListaSelectionSort();
        lista.mostrar();

        System.out.println("\nClonando a lista");
        Lista clonada = lista.cloneLista();

        System.out.println("\nMostrando a lista clonada");
        clonada.mostrar();

        System.out.println("\nMostrando elementos dos 'índices' pares da lista ");
        lista.mostrarIndice();
    }

}