package br.com.ebac.servico_memes.entity;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
public class Meme {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_meme")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "meme_url", nullable = false)
    private String memeUrl;

    @Column(name = "data_cadastro", nullable = false)
    private Date dataCadastro;

    @Column(name = "categoria_meme_id", nullable = false)
    private Long categoriaMemeId;

    @Column(name = "usuario_id", nullable = false)
    private Long usuarioId;

    public Meme() {}

    public Meme(Long id, String nome, String descricao, String memeUrl, Date dataCadastro, Long categoriaMemeId, Long usuarioId) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.memeUrl = memeUrl;
        this.dataCadastro = dataCadastro;
        this.categoriaMemeId = categoriaMemeId;
        this.usuarioId = usuarioId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getCategoriaMemeId() {
        return categoriaMemeId;
    }

    public void setCategoriaMemeId(Long categoriaMemeId) { this.categoriaMemeId = categoriaMemeId; }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMemeUrl() {
        return memeUrl;
    }

    public void setMemeUrl(String memeUrl) {
        this.memeUrl = memeUrl;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
