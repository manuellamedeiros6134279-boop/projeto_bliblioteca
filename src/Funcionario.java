public class Funcionario extends Usuario {

    private String cargo;

    public Funcionario(String nome, String cpf, String email, String cargo) {
        super(nome, cpf, email);
        this.cargo = cargo;
    }

    public String getCpf() {
        return super.getCpf();
    }

    public String getEmail() {
        return super.getEmail();
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void listarInformacoes() {
        System.out.println(
            getNome() + " - " +
            getCpf() + " - " +
            getEmail() + " - " +
            getCargo()
        );
    }
}

