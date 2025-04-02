package classe;

public class ValorVsReferencia {

    public static void main(String[] args) {

        double a = 2;
        double b = a; // atribuição por valor (Tipo primitivo)

        a++;
        b--;

        System.out.println(a + " " + b);

        Data d1 = new Data(1, 6, 2022);
        Data d2 = d1; // atribuição por referência (Objeto)

        d1.dia = 31;
        d2.mes = 12;

        d1.ano = 2025;

        System.out.println(d1.obterDataFormatada());
        System.out.println(d2.obterDataFormatada());

        voltarDataParaValorPadrao(d1);

        System.out.println(d1.obterDataFormatada());
        System.out.println(d2.obterDataFormatada());

        int c = 5;
        alterarPrimitivo(c);
        System.out.println(c);
    }

    static void voltarDataParaValorPadrao(Data d) {
        d.dia = 1;
        d.mes = 1;
        d.ano = 1970;
    }

    static void alterarPrimitivo(int c) {
        c++;
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
