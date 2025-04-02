package classe;

public class DataTeste {

    public static void main(String[] args) {

        Data d1 = new Data();
        d1.ano = 2021;

        var d2 = new Data(31, 12, 2020);

        String dataFormatada1 = d1.obterDataFormatada();

        System.out.println(dataFormatada1);
        System.out.println(d2.obterDataFormatada());

        d1.imprimirDataFormatada();
        d2.imprimirDataFormatada();
    }

    public class Data {

        int dia;
        int mes;
        int ano;

        Data() {
            // dia = 1;
            // mes = 1;
            // ano = 1970;
            this(1, 1, 1970);
        }

        Data(int dia, int mes, int ano) {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        }

        String obterDataFormatada() {
            final String formato = "%d/%d/%d";
            return String.format(formato, this.dia, mes, ano);
        }

        void imprimirDataFormatada() {
            System.out.println(this.obterDataFormatada());
        }

    }
}
