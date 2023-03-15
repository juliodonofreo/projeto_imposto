package entidades;

public class PessoaFisica extends Contribuinte{
    private Double gastosSaude;

    public PessoaFisica() {
        super();
    }

    public PessoaFisica(String nome, Double rendaAnual, Double gastosSaude) {
        super(nome, rendaAnual);
        this.gastosSaude = gastosSaude;
    }

    public Double getGastosSaude() {
        return gastosSaude;
    }

    public void setGastosSaude(Double gastosSaude) {
        this.gastosSaude = gastosSaude;
    }

    @Override
    public double imposto() {
        final double ABATIMENTO_IMPOSTOS = gastosSaude * 0.5;

        if(rendaAnual < 20000.00){
            if(gastosSaude == 0) {
                return rendaAnual * 0.15;
            }
            else{
                return rendaAnual * 0.15 - ABATIMENTO_IMPOSTOS;
            }
        }
        else {
            if(gastosSaude == 0) {
                return rendaAnual * 0.25;
            }
            else {
                return rendaAnual * 0.25 - ABATIMENTO_IMPOSTOS;
            }
        }

    }
}
