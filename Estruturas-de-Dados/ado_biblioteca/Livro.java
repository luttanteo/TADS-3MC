package ado_biblioteca;

public class Livro {
    private String titulo;
    private int anoLancamento;
    private int qtdPaginas;

    public Livro() {
    }

    public Livro(String titulo, int anoLancamento, int qtdPaginas) {
        this.titulo = titulo;
        this.anoLancamento = anoLancamento;
        this.qtdPaginas = qtdPaginas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public int getQtdPaginas() {
        return qtdPaginas;
    }

    public void setQtdPaginas(int qtdPaginas) {
        this.qtdPaginas = qtdPaginas;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "título: '" + titulo + '\'' +
                ", anoLancamento: " + anoLancamento +
                ", qtdPaginas: " + qtdPaginas +
                '}';
    }
}
