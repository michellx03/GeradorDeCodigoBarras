package entities;

public class Produtos{
    Long id_produto;
    String produto;
    String tipo;
    Integer codigo_convenio;
    Integer codigo_barras;
    
    private byte[] imagem;

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public Long getId_produto() {
        return id_produto;
    }

    public void setId_produto(Long id_produto) {
        this.id_produto = id_produto;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getCodigo_convenio() {
        return codigo_convenio;
    }

    public void setCodigo_convenio(Integer codigo_convenio) {
        this.codigo_convenio = codigo_convenio;
    }

    public Integer getCodigo_barras() {
        return codigo_barras;
    }

    public void setCodigo_barras(Integer codigo_barras) {
        this.codigo_barras = codigo_barras;
    }
    
    
}
