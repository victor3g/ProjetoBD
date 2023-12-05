
package classe;

public class pessoa {
    private int idpessoa;
    private String nome;
    private String cpd;
    private String contato;

    public pessoa(int idpessoa, String nome, String cpd, String contato) {
        this.idpessoa = idpessoa;
        this.nome = nome;
        this.cpd = cpd;
        this.contato = contato;
    }

    public pessoa(int idpessoa) {
        this.idpessoa = idpessoa;
    }

    public pessoa(String nome, String cpd, String contato) {
        this.nome = nome;
        this.cpd = cpd;
        this.contato = contato;
    }

    public pessoa() {
    }

    public int getIdpessoa() {
        return idpessoa;
    }

    public void setIdpessoa(int idpessoa) {
        this.idpessoa = idpessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpd() {
        return cpd;
    }

    public void setCpd(String cpd) {
        this.cpd = cpd;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }
    
    
}
