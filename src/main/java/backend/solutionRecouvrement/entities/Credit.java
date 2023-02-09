package backend.solutionRecouvrement.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(
        name = "Engagement"
)
public class Credit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column(
            nullable = true,
            name = "FACILITY_ID"
    )
    private Boolean facilityId;
    @Column(
            nullable = true,
            name = "TYPE_ENGAGEMENT"
    )
    private String facilityType;
    @Column(
            nullable = true,
            name = "NUMERO_COMPTE"
    )
    private String accountNumber;
    @Column(
            nullable = true,
            name = "MAIN_PROD_DESC"
    )
    private String mainProductDesc;
    @Column(
            nullable = true,
            name = "PRODUCT_DESCRIPTION"
    )
    private String productDescription;
    @Column(
            nullable = true,
            name = "PRODUCT_CODE"
    )
    private String producCode;
    @Column(
            nullable = true,
            name = "NOMINAL_EXPOSURE"
    )
    private Double nominalExposure;
    @Column(
            nullable = true,
            name = "PROVISIONS"
    )
    private Double effectiveProvAmt;
    @Column(
            nullable = true,
            name = "INT_RESERVES"
    )
    private Double intResv;
    @Column(
            nullable = true,
            name = "INT_A_PERC_CREDIT_AMORTISSABLES"
    )
    private Double pca;
    @Column(
            nullable = true,
            name = "INT_A_PERC_CREDIT_FINANCEMENT"
    )
    private Double part_20700_20710;
    @Column(
            nullable = true,
            name = "MARGE_ISLAMIQUE"
    )
    private Double islamic;
    @Column(
            nullable = true,
            name = "MARGE_LEASING"
    )
    private Double leasing;
    @Column(
            nullable = true,
            name = "DATE_MATURITE"
    )
    private LocalDate maturityDate;
    @Column(
            nullable = true,
            name = "JOURS_MATURITE"
    )
    private Double maturityDays;
    @Column(
            nullable = true,
            name = "NUMERO_LC"
    )
    private String lcNumber;
    @Column(
            nullable = true,
            name = "IFRS_BALANCE"
    )
    private Double ifrsBalance;
    @Column(
            nullable = true,
            name = "CYCLE_DE_PAYEMENT"
    )
    private String installmentPayementCycle;
    @Column(
            nullable = true,
            name = "ISO_CUR_CODE"
    )
    private String isoCurCode;
    @Column(
            nullable = true,
            name = "DUREE_ENGAGEMENT"
    )
    private Float ageOfLoan;
    @Column(
            nullable = true,
            name = "DATE_1ER_ECHEANCE"
    )
    private LocalDate firstInstal;
    @Column(
            nullable = true,
            name = "LOAN_CURRENCY"
    )
    private String loanCurrency;
    @Column(
            nullable = true,
            name = "NOMINAL_INTEREST_RATE"
    )
    private Double nominalInterestRate;
    @Column(
            nullable = true,
            name = "LIMITE"
    )
    private Double limite;
    @Column(
            nullable = true,
            name = "GL_SUBHEAD"
    )
    private String glSubhead;
    @Column(
            nullable = true,
            name = "GL_DESCRIPTION"
    )
    private String glDescription;
    @Column(
            nullable = true,
            name = "IMPAYES"
    )
    private Double impaye;
    @Column(
            nullable = true
    )
    private LocalDate defaultDate;
    @Column(
            nullable = true,
            name = "DPD"
    )
    private Double dpd;
    @Column(
            nullable = true
    )
    private LocalDate restructuredDate;
    @Column(
            nullable = true
    )
    private String reasonForNpa;
    @Column(
            nullable = true
    )
    private String reasonForNpaDesc;
    @Column(
            nullable = true,
            name = "VALEUR_HYPOTHEQUE"
    )
    private Double realEstateColValue;
    @Column(
            nullable = true,
            name = "DEVISE_HYPOTHEQUE"
    )
    private String currencyRealEstateColValue;
    @Column(
            nullable = true,
            name = "VALEUR_BIEN"
    )
    private Double valeurexpertise;
    @Column(
            nullable = true,
            name = "DEVISE_BIEN"
    )
    private String currencyValeur_expertise;
    @Column(
            nullable = true,
            name = "VALEUR_CASH"
    )
    private Double cashColValue;
    @Column(
            nullable = true,
            name = "DEVISE"
    )
    private String currencyCashColValue;
    @Column(
            nullable = true,
            name = "DEPOT_DENIARS"
    )
    private Double depbdzd;
    @Column(
            nullable = true,
            name = "DEPOT_DEVISE"
    )
    private Double depbdevise;
    @Column(
            nullable = true,
            name = "DEVISE_DEPOTDEVISE"
    )
    private String currencyDepbDevise;
    @Column(
            nullable = true,
            name = "DEPOTCONF"
    )
    private Double depconf;
    @Column(
            nullable = true
    )
    private String shareColValue;
    @Column(
            nullable = true,
            name = "VEICLES"
    )
    private Double veicleColValue;
    @Column(
            nullable = true,
            name = "CURRENY_VEILCLE_COL_VALUE"
    )
    private String currencyVehicleColValue;
    @Column(
            nullable = true,
            name = "VALEUR_VEHICULE"
    )
    private Double valeurVehicule;
    @Column(
            nullable = true,
            name = "CURRENCY_VALEUR_VEHICULE"
    )
    private String currencyValeurVehicule;
    @Column(
            nullable = true,
            name = "GARANTIES_BANQUES"
    )
    private Double bankingLgColValue;
    @Column(
            nullable = true,
            name = "DEVISE_GARANTIES_BANQUES"
    )
    private String currencyBankingLgColValue;
    @ManyToOne
    @JoinColumns({@JoinColumn(
            name = "client_ID_CLIENT",
            foreignKey = @ForeignKey(
                    name = "FK_ID_CLIENT"
            ),
            referencedColumnName = "ID_CLIENT"
    ), @JoinColumn(
            name = "client_reportingDate",
            foreignKey = @ForeignKey(
                    name = "FK_reportingDate"
            ),
            referencedColumnName = "reportingDate"
    )})
    @JsonBackReference
    private Client client;

    public Credit(Long id, Boolean facilityId, String facilityType, String accountNumber, String mainProductDesc, String productDescription, String producCode, Double nominalExposure, Double effectiveProvAmt, Double intResv, Double pca, Double part_20700_20710, Double islamic, Double leasing, LocalDate maturityDate, Double maturityDays, String lcNumber, Double ifrsBalance, String installmentPayementCycle, String isoCurCode, Float ageOfLoan, LocalDate firstInstal, String loanCurrency, Double nominalInterestRate, Double limite, String glSubhead, String glDescription, Double impaye, LocalDate defaultDate, Double dpd, LocalDate restructuredDate, String reasonForNpa, String reasonForNpaDesc, Double realEstateColValue, String currencyRealEstateColValue, Double valeurexpertise, String currencyValeur_expertise, Double cashColValue, String currencyCashColValue, Double depbdzd, Double depbdevise, String currencyDepbDevise, Double depconf, String shareColValue, Double veicleColValue, String currencyVehicleColValue, Double valeurVehicule, String currencyValeurVehicule, Double bankingLgColValue, String currencyBankingLgColValue, Client client) {
        this.id = id;
        this.facilityId = facilityId;
        this.facilityType = facilityType;
        this.accountNumber = accountNumber;
        this.mainProductDesc = mainProductDesc;
        this.productDescription = productDescription;
        this.producCode = producCode;
        this.nominalExposure = nominalExposure;
        this.effectiveProvAmt = effectiveProvAmt;
        this.intResv = intResv;
        this.pca = pca;
        this.part_20700_20710 = part_20700_20710;
        this.islamic = islamic;
        this.leasing = leasing;
        this.maturityDate = maturityDate;
        this.maturityDays = maturityDays;
        this.lcNumber = lcNumber;
        this.ifrsBalance = ifrsBalance;
        this.installmentPayementCycle = installmentPayementCycle;
        this.isoCurCode = isoCurCode;
        this.ageOfLoan = ageOfLoan;
        this.firstInstal = firstInstal;
        this.loanCurrency = loanCurrency;
        this.nominalInterestRate = nominalInterestRate;
        this.limite = limite;
        this.glSubhead = glSubhead;
        this.glDescription = glDescription;
        this.impaye = impaye;
        this.defaultDate = defaultDate;
        this.dpd = dpd;
        this.restructuredDate = restructuredDate;
        this.reasonForNpa = reasonForNpa;
        this.reasonForNpaDesc = reasonForNpaDesc;
        this.realEstateColValue = realEstateColValue;
        this.currencyRealEstateColValue = currencyRealEstateColValue;
        this.valeurexpertise = valeurexpertise;
        this.currencyValeur_expertise = currencyValeur_expertise;
        this.cashColValue = cashColValue;
        this.currencyCashColValue = currencyCashColValue;
        this.depbdzd = depbdzd;
        this.depbdevise = depbdevise;
        this.currencyDepbDevise = currencyDepbDevise;
        this.depconf = depconf;
        this.shareColValue = shareColValue;
        this.veicleColValue = veicleColValue;
        this.currencyVehicleColValue = currencyVehicleColValue;
        this.valeurVehicule = valeurVehicule;
        this.currencyValeurVehicule = currencyValeurVehicule;
        this.bankingLgColValue = bankingLgColValue;
        this.currencyBankingLgColValue = currencyBankingLgColValue;
        this.client = client;
    }

    public Credit() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getFacilityId() {
        return this.facilityId;
    }

    public void setFacilityId(Boolean facilityId) {
        this.facilityId = facilityId;
    }

    public String getFacilityType() {
        return this.facilityType;
    }

    public void setFacilityType(String facilityType) {
        this.facilityType = facilityType;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getMainProductDesc() {
        return this.mainProductDesc;
    }

    public void setMainProductDesc(String mainProductDesc) {
        this.mainProductDesc = mainProductDesc;
    }

    public String getProductDescription() {
        return this.productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProducCode() {
        return this.producCode;
    }

    public void setProducCode(String producCode) {
        this.producCode = producCode;
    }

    public Double getNominalExposure() {
        return this.nominalExposure;
    }

    public void setNominalExposure(Double nominalExposure) {
        this.nominalExposure = nominalExposure;
    }

    public Double getEffectiveProvAmt() {
        return this.effectiveProvAmt;
    }

    public void setEffectiveProvAmt(Double effectiveProvAmt) {
        this.effectiveProvAmt = effectiveProvAmt;
    }

    public Double getIntResv() {
        return this.intResv;
    }

    public void setIntResv(Double intResv) {
        this.intResv = intResv;
    }

    public Double getPca() {
        return this.pca;
    }

    public void setPca(Double pca) {
        this.pca = pca;
    }

    public Double getPart_20700_20710() {
        return this.part_20700_20710;
    }

    public void setPart_20700_20710(Double part_20700_20710) {
        this.part_20700_20710 = part_20700_20710;
    }

    public Double getIslamic() {
        return this.islamic;
    }

    public void setIslamic(Double islamic) {
        this.islamic = islamic;
    }

    public Double getLeasing() {
        return this.leasing;
    }

    public void setLeasing(Double leasing) {
        this.leasing = leasing;
    }

    public LocalDate getMaturityDate() {
        return this.maturityDate;
    }

    public void setMaturityDate(LocalDate maturityDate) {
        this.maturityDate = maturityDate;
    }

    public Double getMaturityDays() {
        return this.maturityDays;
    }

    public void setMaturityDays(Double maturityDays) {
        this.maturityDays = maturityDays;
    }

    public String getLcNumber() {
        return this.lcNumber;
    }

    public void setLcNumber(String lcNumber) {
        this.lcNumber = lcNumber;
    }

    public Double getIfrsBalance() {
        return this.ifrsBalance;
    }

    public void setIfrsBalance(Double ifrsBalance) {
        this.ifrsBalance = ifrsBalance;
    }

    public String getInstallmentPayementCycle() {
        return this.installmentPayementCycle;
    }

    public void setInstallmentPayementCycle(String installmentPayementCycle) {
        this.installmentPayementCycle = installmentPayementCycle;
    }

    public String getIsoCurCode() {
        return this.isoCurCode;
    }

    public void setIsoCurCode(String isoCurCode) {
        this.isoCurCode = isoCurCode;
    }

    public Float getAgeOfLoan() {
        return this.ageOfLoan;
    }

    public void setAgeOfLoan(Float ageOfLoan) {
        this.ageOfLoan = ageOfLoan;
    }

    public LocalDate getFirstInstal() {
        return this.firstInstal;
    }

    public void setFirstInstal(LocalDate firstInstal) {
        this.firstInstal = firstInstal;
    }

    public String getLoanCurrency() {
        return this.loanCurrency;
    }

    public void setLoanCurrency(String loanCurrency) {
        this.loanCurrency = loanCurrency;
    }

    public Double getNominalInterestRate() {
        return this.nominalInterestRate;
    }

    public void setNominalInterestRate(Double nominalInterestRate) {
        this.nominalInterestRate = nominalInterestRate;
    }

    public Double getLimite() {
        return this.limite;
    }

    public void setLimite(Double limite) {
        this.limite = limite;
    }

    public String getGlSubhead() {
        return this.glSubhead;
    }

    public void setGlSubhead(String glSubhead) {
        this.glSubhead = glSubhead;
    }

    public String getGlDescription() {
        return this.glDescription;
    }

    public void setGlDescription(String glDescription) {
        this.glDescription = glDescription;
    }

    public Double getImpaye() {
        return this.impaye;
    }

    public void setImpaye(Double impaye) {
        this.impaye = impaye;
    }

    public LocalDate getDefaultDate() {
        return this.defaultDate;
    }

    public void setDefaultDate(LocalDate defaultDate) {
        this.defaultDate = defaultDate;
    }

    public Double getDpd() {
        return this.dpd;
    }

    public void setDpd(Double dpd) {
        this.dpd = dpd;
    }

    public LocalDate getRestructuredDate() {
        return this.restructuredDate;
    }

    public void setRestructuredDate(LocalDate restructuredDate) {
        this.restructuredDate = restructuredDate;
    }

    public String getReasonForNpa() {
        return this.reasonForNpa;
    }

    public void setReasonForNpa(String reasonForNpa) {
        this.reasonForNpa = reasonForNpa;
    }

    public String getReasonForNpaDesc() {
        return this.reasonForNpaDesc;
    }

    public void setReasonForNpaDesc(String reasonForNpaDesc) {
        this.reasonForNpaDesc = reasonForNpaDesc;
    }

    public Double getRealEstateColValue() {
        return this.realEstateColValue;
    }

    public void setRealEstateColValue(Double realEstateColValue) {
        this.realEstateColValue = realEstateColValue;
    }

    public String getCurrencyRealEstateColValue() {
        return this.currencyRealEstateColValue;
    }

    public void setCurrencyRealEstateColValue(String currencyRealEstateColValue) {
        this.currencyRealEstateColValue = currencyRealEstateColValue;
    }

    public Double getValeurexpertise() {
        return this.valeurexpertise;
    }

    public void setValeurexpertise(Double valeurexpertise) {
        this.valeurexpertise = valeurexpertise;
    }

    public String getCurrencyValeur_expertise() {
        return this.currencyValeur_expertise;
    }

    public void setCurrencyValeur_expertise(String currencyValeur_expertise) {
        this.currencyValeur_expertise = currencyValeur_expertise;
    }

    public Double getCashColValue() {
        return this.cashColValue;
    }

    public void setCashColValue(Double cashColValue) {
        this.cashColValue = cashColValue;
    }

    public String getCurrencyCashColValue() {
        return this.currencyCashColValue;
    }

    public void setCurrencyCashColValue(String currencyCashColValue) {
        this.currencyCashColValue = currencyCashColValue;
    }

    public Double getDepbdzd() {
        return this.depbdzd;
    }

    public void setDepbdzd(Double depbdzd) {
        this.depbdzd = depbdzd;
    }

    public Double getDepbdevise() {
        return this.depbdevise;
    }

    public void setDepbdevise(Double depbdevise) {
        this.depbdevise = depbdevise;
    }

    public String getCurrencyDepbDevise() {
        return this.currencyDepbDevise;
    }

    public void setCurrencyDepbDevise(String currencyDepbDevise) {
        this.currencyDepbDevise = currencyDepbDevise;
    }

    public Double getDepconf() {
        return this.depconf;
    }

    public void setDepconf(Double depconf) {
        this.depconf = depconf;
    }

    public String getShareColValue() {
        return this.shareColValue;
    }

    public void setShareColValue(String shareColValue) {
        this.shareColValue = shareColValue;
    }

    public Double getVeicleColValue() {
        return this.veicleColValue;
    }

    public void setVeicleColValue(Double veicleColValue) {
        this.veicleColValue = veicleColValue;
    }

    public String getCurrencyVehicleColValue() {
        return this.currencyVehicleColValue;
    }

    public void setCurrencyVehicleColValue(String currencyVehicleColValue) {
        this.currencyVehicleColValue = currencyVehicleColValue;
    }

    public Double getValeurVehicule() {
        return this.valeurVehicule;
    }

    public void setValeurVehicule(Double valeurVehicule) {
        this.valeurVehicule = valeurVehicule;
    }

    public String getCurrencyValeurVehicule() {
        return this.currencyValeurVehicule;
    }

    public void setCurrencyValeurVehicule(String currencyValeurVehicule) {
        this.currencyValeurVehicule = currencyValeurVehicule;
    }

    public Double getBankingLgColValue() {
        return this.bankingLgColValue;
    }

    public void setBankingLgColValue(Double bankingLgColValue) {
        this.bankingLgColValue = bankingLgColValue;
    }

    public String getCurrencyBankingLgColValue() {
        return this.currencyBankingLgColValue;
    }

    public void setCurrencyBankingLgColValue(String currencyBankingLgColValue) {
        this.currencyBankingLgColValue = currencyBankingLgColValue;
    }

    public Client getClient() {
        return this.client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
