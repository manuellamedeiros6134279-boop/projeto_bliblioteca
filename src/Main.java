import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Livro> livros = new ArrayList<>();
        ArrayList<Usuario> usuarios = new ArrayList<>();

        int op = 0;

        do {
            System.out.println("1-Livro");
            System.out.println("2-Listar");
            System.out.println("3-Usuario");
            System.out.println("4-Listar usuarios");
            System.out.println("5-Emprestar");
            System.out.println("6-Devolver");
            System.out.println("7-Sair");

            try {
                op = sc.nextInt();
                sc.nextLine();

                switch (op) {

                    case 1:
                        System.out.print("Titulo: ");
                        String t = sc.nextLine();
                        System.out.print("Autor: ");
                        String a = sc.nextLine();
                        System.out.print("Ano: ");
                        int ano = sc.nextInt();

                        livros.add(new Livro(t, a, ano));
                        break;

                    case 2:
                        for (Livro l : livros)
                            System.out.println(l.getTitulo());
                        break;

                    case 3:
                        System.out.print("Nome: ");
                        String n = sc.nextLine();
                        System.out.print("CPF: ");
                        String cpf = sc.nextLine();
                        System.out.print("Email: ");
                        String email = sc.nextLine();

                        System.out.print("1-Aluno 2-Funcionario: ");
                        int tipo = sc.nextInt();
                        sc.nextLine();

                        if (tipo == 1) {
                            System.out.print("Curso: ");
                            String curso = sc.nextLine();
                            System.out.print("Turma: ");
                            String turma = sc.nextLine();
                            usuarios.add(new Aluno(n, cpf, email, curso, turma));
                        } else {
                            System.out.print("Cargo: ");
                            String cargo = sc.nextLine();
                            usuarios.add(new Funcionario(n, cpf, email, cargo));
                        }
                        break;

                    case 4:
                        for (Usuario u : usuarios)
                            u.listarInformacoes();
                        break;

                    case 5:
                        int e = sc.nextInt() - 1;
                        if (e >= 0 && e < livros.size()
                                && livros.get(e).isDisponivel())
                            livros.get(e).emprestar();
                        break;

                    case 6:
                        int d = sc.nextInt() - 1;
                        if (d >= 0 && d < livros.size())
                            livros.get(d).devolver();
                        break;
                }

            } catch (Exception e) {
                sc.nextLine();
            }

        } while (op != 7);
    }
}