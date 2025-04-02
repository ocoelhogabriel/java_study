package classe;

public class Equals {

    public static void main(String[] args) {

        Usuario u1 = new Usuario();
        u1.nome = "Pedro Silva";
        u1.email = "pedro.silva@ezemail.com.br";

        Usuario u2 = new Usuario();
        u2.nome = "Pedro Silva";
        u2.email = "pedro.silva@ezemail.com.br";

        System.out.println(u1 == u2);
        System.out.println(u1.equals(u2));
        System.out.println(u2.equals(u1));

        // System.out.println(u2.equals(new Date()));
    }

    public class Usuario {

        String nome;
        String email;

        public boolean equals(Object objeto) {

            if (objeto instanceof Usuario) {
                Usuario outro = (Usuario) objeto;

                boolean nomeIgual = outro.nome.equals(this.nome);
                boolean emailIgual = outro.email.equals(this.email);

                return nomeIgual && emailIgual;
            } else {
                return false;
            }
        }

        // O hascode será abordado em outra aula!
        public int hashCode() {
            return 0;
        }
    }

}
