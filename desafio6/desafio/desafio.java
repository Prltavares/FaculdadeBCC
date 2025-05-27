    import java.util.Scanner;


    public class desafio {

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            int[] Matriculas = new int[20];
            double[] notas = new double[20];
            int[] frequencia = new int[20];

            int totalAlunos = 0;
            int opcao = 0;

        do { 
            System.out.println("=======SISTEMAS DE ANALISE DE NOTAS=======");
            System.out.println("1.Cadastrar aluno");
            System.out.println("2.Exibir dados de todos alunos");
            System.out.println("3.calcular estatísticas da turma");
            System.out.println("4.Verificar situação de um aluno especifico");
            System.out.println("5.Sair");
            System.out.println("Escolha uma opção:");  
                opcao = sc.nextInt();

        switch (opcao) {
                case 1:
                if (totalAlunos >= 20) { 
                    System.out.println("Limite de alunos atingido. Não é possível cadastrar mais.");
                } else {
                    System.out.print("Digite a matrícula do aluno: ");
                    int matricula = sc.nextInt();
        
                boolean matriculaExiste = false;
                for (int i = 0; i < totalAlunos; i++){
                    if (Matriculas[i] == matricula){
                        matriculaExiste = true;
                        break;
                    }    
            }
                if (matriculaExiste){
                    System.out.println("matricula já cadastrada");
                
                }else{
                    System.out.println("digite a nota do aluno(0 a 10): ");
                    double nota = sc.nextDouble();
                    System.out.println("digite a frequencia do aluno (0 a 20):");
                    int frequenciaAluno = sc.nextInt();

                    if (nota <0  || nota > 10) {
                        System.out.println("nota invalida! a nota deve estar entre 0 a 10!");
                        
                        }else if (frequenciaAluno < 0 || frequenciaAluno > 20) {
                            System.out.println("Frequencia invalida! a frequencia deve estar entre 0 a 20. ");

                        }else {
                            Matriculas[totalAlunos] = matricula;
                            notas [totalAlunos] = nota;
                            frequencia[totalAlunos] = frequenciaAluno;
                            totalAlunos++;
                            System.out.println("Aluno cadastrado com sucesso!");
                        
                        }
            
                }
        

                }
                break;
                

            case 2:

            if (totalAlunos == 0) {
                    System.out.println("nenhum aluno cadastrado ainda!");
            } else { 
                for (int i = 0; i  < totalAlunos; i++) {
                    System.out.println("aluno" + (i + 1));
                    System.out.println("Matricula:" + Matriculas[i]);
                    System.out.println("nota:" + notas[i]);
                    System.out.println("Frequencia:" + frequencia[i]);

                    if (frequencia[i] < 15) {
                        System.out.println("situação: reprovado por frequencia!");
                    } else if (notas[i] > 7.0 ) {
                        System.out.println("situação: aprovado!");
                    } else if (notas[i] >= 5) {
                        System.out.println("situação: recuperação");
                    } else {
                        System.out.println("Situação: reprovado por nota");   
                    }

                    System.out.println("----------------------------------------");
                        
                    }
                        
                    }
                break;
            case 3:
            if (totalAlunos == 0){
                System.out.println("nenhum aluno cadastrado para calcular estatisticas");
            } else {
                    double maiorNota = notas[0];
                    double menornota = notas[0];
                    double somaNotas = 0;
            
                    int qtdAprovados = 0;
                    int qtdRecuperacao = 0;
                    int qtdReprovadosNota = 0;
                    int qtdReprovadosFrequencia = 0;

                    for (int i = 0; i < totalAlunos; i++) {
                        double nota = notas[i];
                        int freq = frequencia[i];
                if (nota > maiorNota){
                    maiorNota = nota;

                }
                if (nota < menornota){
                    menornota = nota;
                }

                somaNotas += nota;

                    if (freq < 15){
                        qtdReprovadosFrequencia++;
                        }else if (nota >= 7.0){
                        qtdAprovados++;
                    }else if (nota >= 5.0){
                        qtdRecuperacao++;
                    }else {
                        qtdReprovadosNota++;
                    }
                }   

                double mediaNotas = somaNotas / totalAlunos;
                double percentualAprovados = (qtdAprovados *100.0) / totalAlunos;


                System.out.println("maior nota:" + maiorNota);
                System.out.println("menor nota" + menornota);
                System.out.println("media dos alunos:" + mediaNotas);
                System.out.println("quantidade de alunos aprovados:" + qtdAprovados);
                System.out.println("quantidade de alunos em recuperação:"+ qtdRecuperacao);
                System.out.println("quantidde de alunos reprovados por notas"+ qtdReprovadosNota);
                System.out.println("quantidade de alunos reprovados por frequencia"+ qtdReprovadosFrequencia);
                System.out.printf ("Percentual de aprovação: %.2f%%\n", percentualAprovados);
                        
                    } 
                    break;
                    case 4:
                        
                        if (totalAlunos == 0) {
                            System.out.println("nenhum aluno cadastrado");
                        } else {
                            System.out.println("Digite a matricula do aluno que quer consultar");
                            int buscaMatricula = sc.nextInt();
                            boolean encontrado = false;
                            
                            for (int i = 0; i < totalAlunos; i++){
                                if (Matriculas[i] == buscaMatricula){
                                    System.out.println("Matricula:" + Matriculas[i]);
                                    System.out.println("nota:"+ notas[i]);
                                    System.out.println("frequencia:"+ frequencia[i]);
                                if (frequencia[i] < 15) {
                        System.out.println("situação: reprovado por frequencia!");
                    } else if (notas[i] > 7.0 ) {
                        System.out.println("situação: aprovado!");
                    } else if (notas[i] >= 5) {
                        System.out.println("situação: recuperação");
                    } else {
                        System.out.println("Situação: reprovado por nota");   
                    }
                        encontrado = true;
                        break;
                    }

                        }
                if (!encontrado) {
                System.out.println("Matrícula não encontrada.");
            }
                }
                break;
                case 5:
                 System.out.println("Encerrando o progama...");
                 break;
                 default:
                 System.out.println("opção invalida.");

        }

        }while (opcao!=5);
        sc.close();
    }   
}
