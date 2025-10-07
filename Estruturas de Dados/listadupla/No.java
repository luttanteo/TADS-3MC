package listadupla;

public class No<Tipo> {
    private No<Tipo> anterior;
    private Tipo elemento;
    private No<Tipo> proximo;

    public No(Tipo elemento) {
        this.elemento = elemento;
        this.proximo = null;
        this.anterior = null;
    }

    public No(Tipo elemento, No<Tipo> proximo, No<Tipo> anterior) {
        this.elemento = elemento;
        this.proximo = proximo;
        this.anterior = anterior;
    }

    public Tipo getElemento() {
        return elemento;
    }

    public void setElemento(Tipo elemento) {
        this.elemento = elemento;
    }

    public No<Tipo> getProximo() {
        return proximo;
    }

    public void setProximo(No<Tipo> proximo) {
        this.proximo = proximo;
    }

    public No<Tipo> getAnterior() {
        return anterior;
    }

    public void setAnterior(No<Tipo> anterior) {
        this.anterior = anterior;
    }

    @Override
    public String toString() {
        return "No{" +
                "anterior=" + (anterior != null ? anterior.getElemento() : null) +
                ", elemento=" + elemento +
                ", proximo=" + proximo +
                '}';
    }
}
