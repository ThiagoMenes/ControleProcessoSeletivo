package candidatura;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) throws Exception {
        System.out.println("Processo Seletivo");
        // analisarCandidato(1900.0);
        // analisarCandidato(2200.0);
        // analisarCandidato(2000.0);
        selecaoCandidatos();

        String [] candidatos = {"Felipe", "Marcia", "Julia", "Paulo","Augusto"};
        for(String candidato : candidatos){
            entrandoEmContato(candidato);
        }

    }

    static void entrandoEmContato(String candidato){
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;

        do{
            atendeu = atender();
            continuarTentando = !atendeu;

            if(continuarTentando){
                tentativasRealizadas++;
            }else{
                System.out.println("Contato Realizado com Sucesso");
            }
        }while(continuarTentando && tentativasRealizadas < 3);

        if  (atendeu){
            System.out.println("Conseguimos Contato com " + candidato + " Na " + tentativasRealizadas + "° Tentativa");
        }else{
            System.out.println("Não conseguimos contato com " + candidato + ", número máximo de tentativas realizadas");
        }
    }
    //método auxiliar
    static boolean atender(){
        return new Random().nextInt(3) == 1;
    }
    static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.0;
        if(salarioBase > salarioPretendido){
            System.out.println("Ligar para o Candidato");
        }else if(salarioBase == salarioPretendido){
            System.out.println("Ligar para o Candidato com uma Contra-Proposta");
        }else{
            System.out.println("Aguardando o Resultado dos demais Candidatos");
        }
    }

    static void imprimirSelecionados( String [] selecionados){
       int indice = 0;
        for (String s : selecionados){
             
             if(s != null){
                System.out.println("O Candidato n° " +(indice + 1) + " é " +  s);
             }else{
                System.out.println("Acabou a lista de Candidatos Aptos");
             }
             indice++;
        }
    }

    static void selecaoCandidatos(){
        //Array com lista de Candidatos
        String [] candidatos = {"Felipe", "Marcia", "Julia", "Paulo","Augusto","Monica","Fabricio","Mirela","Daniela","Jorge"};

        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        int candidatosControle = 0;
        String [] candidatosAptos = new String[5];
        double salarioBase = 2000.0;

        while(candidatosSelecionados < 5 && candidatosAtual < candidatos.length){
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O Candidado "+ candidato + " Solicitou este valor de salário " + salarioPretendido);
            if (salarioBase >= salarioPretendido) {
                System.out.println("O Candidato "+ candidato + " foi selecionado para a vaga");
                
                candidatosAptos[candidatosControle] = candidato;
                candidatosSelecionados++;
                candidatosControle++;
            }
            candidatosAtual++;
        }
        System.out.println("Candidatos selecionados total: " + candidatosSelecionados);
        imprimirSelecionados(candidatosAptos);
    }

    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800,2200);
    }
}
