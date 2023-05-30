

package backenddm20231n.model.bean;

/**
 *
 * @author joão
 */


public class Studio {
        private int id;
    private String nome;
    private int idAlugador;
    private int idInstrumento;
    private int idEquipamento;
    private int idData;
    private String observacao;
    private Alugador alu;
    private Instrumento instru;
    private Equipamento equip;
    private Data dat;

    public Studio(int id) {
        this.id = id;
    }

    public Studio(String nome) {
        this.nome = nome;
    }

    public Studio(int id, String nome, int idAlugador, int idInstrumento, int idEquipamento, int idData, String observacao) {
        this.id = id;
        this.nome = nome;
        this.idAlugador = idAlugador;
        this.idInstrumento = idInstrumento;
        this.idEquipamento = idEquipamento;
        this.idData = idData;
        this.observacao = observacao;
    }

    public Studio(String nome, int idAlugador, int idInstrumento, int idEquipamento, int idData, String observacao) {
        this.nome = nome;
        this.idAlugador = idAlugador;
        this.idInstrumento = idInstrumento;
        this.idEquipamento = idEquipamento;
        this.idData = idData;
        this.observacao = observacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdAlugador() {
        return idAlugador;
    }

    public void setIdAlugador(int idAlugador) {
        this.idAlugador = idAlugador;
    }

    public int getIdInstrumento() {
        return idInstrumento;
    }

    public void setIdInstrumento(int idInstrumento) {
        this.idInstrumento = idInstrumento;
    }

    public int getIdEquipamento() {
        return idEquipamento;
    }

    public void setIdEquipamento(int idEquipamento) {
        this.idEquipamento = idEquipamento;
    }

    public int getIdData() {
        return idData;
    }

    public void setIdData(int idData) {
        this.idData = idData;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Alugador getAlu() {
        return alu;
    }

    public void setAlu(Alugador alu) {
        this.alu = alu;
    }

    public Instrumento getInstru() {
        return instru;
    }

    public void setInstru(Instrumento instru) {
        this.instru = instru;
    }

    public Equipamento getEquip() {
        return equip;
    }

    public void setEquip(Equipamento equip) {
        this.equip = equip;
    }

    public Data getDat() {
        return dat;
    }

    public void setDat(Data dat) {
        this.dat = dat;
    }

    @Override
    public String toString() {
        return "Studio{" + "id=" + id + ", nome=" + nome + ", idAlugador=" + idAlugador + ", idInstrumento=" + idInstrumento + ", idEquipamento=" + idEquipamento + ", idData=" + idData + ", observacao=" + observacao + '}';
    }
  
     
}