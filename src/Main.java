import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Livro> livros = new ArrayList<>();
        ArrayList<Usuario> usuarios = new ArrayList<>();

        int op = 0;

        do {
            System.out.println("\n===== BIBLIOTECA =====");
            System.out.println("1 - Cadastrar Livro");
            System.out.println("2 - Listar Livro");
            System.out.println("3 - Cadastrar Usuario");
            System.out.println("4 - Listar Usuarios");
            System.out.println("5 - Efetuar Emprestimo");
            System.out.println("6 - Efetuar Devolucao");
            System.out.println("7 - Sair");
            System.out.print("Digite uma opcao: ");

            try {
                op = sc.nextInt();
                sc.nextLine();

                switch (op) {

                    case 1:
                        System.out.println("\n--- CADASTRAR LIVRO ---");

                        System.out.print("Titulo: ");
                        String titulo = sc.nextLine();

                        System.out.print("Autor: ");
                        String autor = sc.nextLine();

                        int ano = 0;

                        try {
                            System.out.print("Ano de publicacao: ");
                            ano = sc.nextInt();
                            sc.nextLine();
                        } catch (Exception e) {
                            System.out.println("Erro ao ler o ano. O livro sera registrado com ano 0.");
                            sc.nextLine();
                        }

                        livros.add(new Livro(titulo, autor, ano));

                        System.out.println("usuario cadastrado! Livro cadastrado com sucesso!");
                        break;

                    case 2:
                        System.out.println("\n--- LISTAR LIVROS ---");

                        if (livros.isEmpty()) {
                            System.out.println("Nenhum livro cadastrado.");
                        } else {
                            for (Livro l : livros) {
                                System.out.println(
                                    "Titulo: " + l.getTitulo() +
                                    " | Autor: " + l.getAutor() +
                                    " | Ano: " + l.getAno() +
                                    " | Disponivel: " + l.isDisponivel()
                                );
                            }
                        }
                        break;

                    case 3:
                        System.out.println("\n--- CADASTRAR USUARIO ---");

                        System.out.print("Nome: ");
                        String nome = sc.nextLine();

                        System.out.print("CPF: ");
                        String cpf = sc.nextLine();

                        System.out.print("Email: ");
                        String email = sc.nextLine();

                        System.out.println("1 - Aluno");
                        System.out.println("2 - Funcionario");
                        System.out.print("Digite o tipo de usuario: ");

                        int tipo = sc.nextInt();
                        sc.nextLine();

                        if (tipo == 1) {

                            System.out.print("Curso: ");
                            String curso = sc.nextLine();

                            System.out.print("Turma: ");
                            String turma = sc.nextLine();

                            usuarios.add(
                                new Aluno(nome, cpf, email, curso, turma)
                            );

                            System.out.println("usuario cadastrado!");

                        } else if (tipo == 2) {

                            System.out.print("Cargo: ");
                            String cargo = sc.nextLine();

                            usuarios.add(
                                new Funcionario(nome, cpf, email, cargo)
                            );

                            System.out.println("usuario cadastrado!");

                        } else {
                            System.out.println("Tipo de usuario invalido.");
                        }

                        break;

                    case 4:
                        System.out.println("\n--- LISTAR USUARIOS ---");

                        if (usuarios.isEmpty()) {
                            System.out.println("Nenhum usuario cadastrado.");
                        } else {
                            for (Usuario u : usuarios) {
                                u.listarInformacoes();
                            }
                        }

                        break;

                    case 5:
                        System.out.println("\n--- EFETUAR EMPRESTIMO ---");

                        if (livros.isEmpty()) {
                            System.out.println("Nenhum livro cadastrado.");
                            break;
                        }

                        for (int i = 0; i < livros.size(); i++) {
                            System.out.println(
                                (i + 1) + " - " +
                                livros.get(i).getTitulo()
                            );
                        }

                        System.out.print("Digite o numero do livro: ");
                        int emprestimo = sc.nextInt() - 1;
                        sc.nextLine();

                        if (emprestimo >= 0 && emprestimo < livros.size()) {

                            Livro l = livros.get(emprestimo);

                            if (l.isDisponivel()) {
                                l.emprestar();
                                System.out.println("empréstimo realizado!");
                            } else {
                                System.out.println("Livro ja esta emprestado.");
                            }

                        } else {
                            System.out.println("Livro invalido.");
                        }

                        break;

                    case 6:
                        System.out.println("\n--- EFETUAR DEVOLUCAO ---");

                        if (livros.isEmpty()) {
                            System.out.println("Nenhum livro cadastrado.");
                            break;
                        }

                        for (int i = 0; i < livros.size(); i++) {
                            System.out.println(
                                (i + 1) + " - " +
                                livros.get(i).getTitulo()
                            );
                        }

                        System.out.print("Digite o numero do livro: ");
                        int devolucao = sc.nextInt() - 1;
                        sc.nextLine();

                        if (devolucao >= 0 && devolucao < livros.size()) {

                            Livro l = livros.get(devolucao);

                            if (!l.isDisponivel()) {
                                l.devolver();
                                System.out.println("devolução realizada!");
                            } else {
                                System.out.println("Livro ja esta disponivel.");
                            }

                        } else {
                            System.out.println("Livro invalido.");
                        }

                        break;

                    case 7:
                        System.out.println("Sistema encerrado!");
                        break;

                    default:
                        System.out.println("Opcao invalida.");

                }

            } catch (Exception e) {
                System.out.println("Erro: Digite somente numeros.");
                sc.nextLine();
            }

        } while (op != 7);

        sc.close();
    }
}

