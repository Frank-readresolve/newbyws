package fr.formation.newbyws;

public class Facture {

    private Long id;

    private String numero;

    private Double montant;

    public Facture() {
	// Empty constructor
    }

    public Facture(String number, Double amount) {
	setNumero(number);
	setMontant(amount);
    }

    public Long getId() {
	return id;
    }

    void setId(Long id) {
	this.id = id;
    }

    public String getNumero() {
	return numero;
    }

    public void setNumero(String numero) {
	this.numero = numero;
    }

    public Double getMontant() {
	return montant;
    }

    public void setMontant(Double montant) {
	this.montant = montant;
    }

    @Override
    public String toString() {
	StringBuilder sb = new StringBuilder("id=");
	sb.append(id);
	sb.append(", numero=");
	sb.append(numero);
	sb.append(", montant=");
	sb.append(montant);
	return sb.toString();
    }
}
