import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class AgendaTelefonica {
    List<Contato> listarContatos = new ArrayList<>();


    public void adicionarContato(Contato contato){
        listarContatos.add(contato);
    }

    public void removerContato(String nome){
        Iterator<Contato> iterator = listarContatos.iterator();
        while (iterator.hasNext()) {
            Contato contato = iterator.next();
            if(contato.nome.equals(nome)){
                iterator.remove();
                System.out.println(contato.nome +" foi removido da sua agenda.");
            }
        }
    }

    public Contato buscarContato(String nome){

        for (Contato contato : listarContatos) {
            if(contato.nome.equals(nome)){
                return contato;
            }
        }
        return null;
    }

    public void atualizarContato(String nome, Contato novoContato){

        Iterator<Contato> iterator = listarContatos.iterator();
        while (iterator.hasNext()) {
            Contato contato = iterator.next();
            if(contato.nome.equals(nome)){
                iterator.remove();
                System.out.println(contato.nome +" foi removido da sua agenda.");
            }
        }
        listarContatos.add(novoContato);
    }
}

