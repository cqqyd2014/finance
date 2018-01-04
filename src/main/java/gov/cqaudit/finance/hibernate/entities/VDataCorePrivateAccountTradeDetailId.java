package gov.cqaudit.finance.hibernate.entities;
// Generated 2018-1-5 1:05:23 by Hibernate Tools 5.2.3.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VDataCorePrivateAccountTradeDetailId generated by hbm2java
 */
@Embeddable
public class VDataCorePrivateAccountTradeDetailId implements java.io.Serializable {

	private String bankCode;
	private String bankCodeName;
	private String privateAccountId;
	private String privateTradeSeq;
	private BigDecimal privateAmount;
	private String privateOpAccountId;
	private String privateOpBankId;
	private String privateOpBankName;
	private String privateOpAccountName;
	private String privateTradeCode;
	private String privateTradeName;
	private Date privateTradeDat;
	private BigDecimal privateBalance;
	private String privateBankOrgId;
	private String privateBankOrgName;
	private String privateRemark;
	private String privateAccountName;

	public VDataCorePrivateAccountTradeDetailId() {
	}

	public VDataCorePrivateAccountTradeDetailId(String bankCode, String bankCodeName, String privateAccountId,
			String privateTradeSeq, BigDecimal privateAmount, String privateOpAccountId, String privateOpBankId,
			String privateOpBankName, String privateOpAccountName, String privateTradeCode, String privateTradeName,
			Date privateTradeDat, BigDecimal privateBalance, String privateBankOrgId, String privateBankOrgName,
			String privateRemark, String privateAccountName) {
		this.bankCode = bankCode;
		this.bankCodeName = bankCodeName;
		this.privateAccountId = privateAccountId;
		this.privateTradeSeq = privateTradeSeq;
		this.privateAmount = privateAmount;
		this.privateOpAccountId = privateOpAccountId;
		this.privateOpBankId = privateOpBankId;
		this.privateOpBankName = privateOpBankName;
		this.privateOpAccountName = privateOpAccountName;
		this.privateTradeCode = privateTradeCode;
		this.privateTradeName = privateTradeName;
		this.privateTradeDat = privateTradeDat;
		this.privateBalance = privateBalance;
		this.privateBankOrgId = privateBankOrgId;
		this.privateBankOrgName = privateBankOrgName;
		this.privateRemark = privateRemark;
		this.privateAccountName = privateAccountName;
	}

	@Column(name = "bank_code", length = 4)
	public String getBankCode() {
		return this.bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	@Column(name = "bank_code_name", length = 90)
	public String getBankCodeName() {
		return this.bankCodeName;
	}

	public void setBankCodeName(String bankCodeName) {
		this.bankCodeName = bankCodeName;
	}

	@Column(name = "private_account_id", length = 128)
	public String getPrivateAccountId() {
		return this.privateAccountId;
	}

	public void setPrivateAccountId(String privateAccountId) {
		this.privateAccountId = privateAccountId;
	}

	@Column(name = "private_trade_seq", length = 128)
	public String getPrivateTradeSeq() {
		return this.privateTradeSeq;
	}

	public void setPrivateTradeSeq(String privateTradeSeq) {
		this.privateTradeSeq = privateTradeSeq;
	}

	@Column(name = "private_amount", precision = 131089, scale = 0)
	public BigDecimal getPrivateAmount() {
		return this.privateAmount;
	}

	public void setPrivateAmount(BigDecimal privateAmount) {
		this.privateAmount = privateAmount;
	}

	@Column(name = "private_op_account_id", length = 128)
	public String getPrivateOpAccountId() {
		return this.privateOpAccountId;
	}

	public void setPrivateOpAccountId(String privateOpAccountId) {
		this.privateOpAccountId = privateOpAccountId;
	}

	@Column(name = "private_op_bank_id", length = 128)
	public String getPrivateOpBankId() {
		return this.privateOpBankId;
	}

	public void setPrivateOpBankId(String privateOpBankId) {
		this.privateOpBankId = privateOpBankId;
	}

	@Column(name = "private_op_bank_name", length = 256)
	public String getPrivateOpBankName() {
		return this.privateOpBankName;
	}

	public void setPrivateOpBankName(String privateOpBankName) {
		this.privateOpBankName = privateOpBankName;
	}

	@Column(name = "private_op_account_name", length = 256)
	public String getPrivateOpAccountName() {
		return this.privateOpAccountName;
	}

	public void setPrivateOpAccountName(String privateOpAccountName) {
		this.privateOpAccountName = privateOpAccountName;
	}

	@Column(name = "private_trade_code", length = 128)
	public String getPrivateTradeCode() {
		return this.privateTradeCode;
	}

	public void setPrivateTradeCode(String privateTradeCode) {
		this.privateTradeCode = privateTradeCode;
	}

	@Column(name = "private_trade_name", length = 256)
	public String getPrivateTradeName() {
		return this.privateTradeName;
	}

	public void setPrivateTradeName(String privateTradeName) {
		this.privateTradeName = privateTradeName;
	}

	@Column(name = "private_trade_dat", length = 35)
	public Date getPrivateTradeDat() {
		return this.privateTradeDat;
	}

	public void setPrivateTradeDat(Date privateTradeDat) {
		this.privateTradeDat = privateTradeDat;
	}

	@Column(name = "private_balance", precision = 131089, scale = 0)
	public BigDecimal getPrivateBalance() {
		return this.privateBalance;
	}

	public void setPrivateBalance(BigDecimal privateBalance) {
		this.privateBalance = privateBalance;
	}

	@Column(name = "private_bank_org_id", length = 64)
	public String getPrivateBankOrgId() {
		return this.privateBankOrgId;
	}

	public void setPrivateBankOrgId(String privateBankOrgId) {
		this.privateBankOrgId = privateBankOrgId;
	}

	@Column(name = "private_bank_org_name", length = 128)
	public String getPrivateBankOrgName() {
		return this.privateBankOrgName;
	}

	public void setPrivateBankOrgName(String privateBankOrgName) {
		this.privateBankOrgName = privateBankOrgName;
	}

	@Column(name = "private_remark", length = 2048)
	public String getPrivateRemark() {
		return this.privateRemark;
	}

	public void setPrivateRemark(String privateRemark) {
		this.privateRemark = privateRemark;
	}

	@Column(name = "private_account_name", length = 256)
	public String getPrivateAccountName() {
		return this.privateAccountName;
	}

	public void setPrivateAccountName(String privateAccountName) {
		this.privateAccountName = privateAccountName;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VDataCorePrivateAccountTradeDetailId))
			return false;
		VDataCorePrivateAccountTradeDetailId castOther = (VDataCorePrivateAccountTradeDetailId) other;

		return ((this.getBankCode() == castOther.getBankCode()) || (this.getBankCode() != null
				&& castOther.getBankCode() != null && this.getBankCode().equals(castOther.getBankCode())))
				&& ((this.getBankCodeName() == castOther.getBankCodeName())
						|| (this.getBankCodeName() != null && castOther.getBankCodeName() != null
								&& this.getBankCodeName().equals(castOther.getBankCodeName())))
				&& ((this.getPrivateAccountId() == castOther.getPrivateAccountId())
						|| (this.getPrivateAccountId() != null && castOther.getPrivateAccountId() != null
								&& this.getPrivateAccountId().equals(castOther.getPrivateAccountId())))
				&& ((this.getPrivateTradeSeq() == castOther.getPrivateTradeSeq())
						|| (this.getPrivateTradeSeq() != null && castOther.getPrivateTradeSeq() != null
								&& this.getPrivateTradeSeq().equals(castOther.getPrivateTradeSeq())))
				&& ((this.getPrivateAmount() == castOther.getPrivateAmount())
						|| (this.getPrivateAmount() != null && castOther.getPrivateAmount() != null
								&& this.getPrivateAmount().equals(castOther.getPrivateAmount())))
				&& ((this.getPrivateOpAccountId() == castOther.getPrivateOpAccountId())
						|| (this.getPrivateOpAccountId() != null && castOther.getPrivateOpAccountId() != null
								&& this.getPrivateOpAccountId().equals(castOther.getPrivateOpAccountId())))
				&& ((this.getPrivateOpBankId() == castOther.getPrivateOpBankId())
						|| (this.getPrivateOpBankId() != null && castOther.getPrivateOpBankId() != null
								&& this.getPrivateOpBankId().equals(castOther.getPrivateOpBankId())))
				&& ((this.getPrivateOpBankName() == castOther.getPrivateOpBankName())
						|| (this.getPrivateOpBankName() != null && castOther.getPrivateOpBankName() != null
								&& this.getPrivateOpBankName().equals(castOther.getPrivateOpBankName())))
				&& ((this.getPrivateOpAccountName() == castOther.getPrivateOpAccountName())
						|| (this.getPrivateOpAccountName() != null && castOther.getPrivateOpAccountName() != null
								&& this.getPrivateOpAccountName().equals(castOther.getPrivateOpAccountName())))
				&& ((this.getPrivateTradeCode() == castOther.getPrivateTradeCode())
						|| (this.getPrivateTradeCode() != null && castOther.getPrivateTradeCode() != null
								&& this.getPrivateTradeCode().equals(castOther.getPrivateTradeCode())))
				&& ((this.getPrivateTradeName() == castOther.getPrivateTradeName())
						|| (this.getPrivateTradeName() != null && castOther.getPrivateTradeName() != null
								&& this.getPrivateTradeName().equals(castOther.getPrivateTradeName())))
				&& ((this.getPrivateTradeDat() == castOther.getPrivateTradeDat())
						|| (this.getPrivateTradeDat() != null && castOther.getPrivateTradeDat() != null
								&& this.getPrivateTradeDat().equals(castOther.getPrivateTradeDat())))
				&& ((this.getPrivateBalance() == castOther.getPrivateBalance())
						|| (this.getPrivateBalance() != null && castOther.getPrivateBalance() != null
								&& this.getPrivateBalance().equals(castOther.getPrivateBalance())))
				&& ((this.getPrivateBankOrgId() == castOther.getPrivateBankOrgId())
						|| (this.getPrivateBankOrgId() != null && castOther.getPrivateBankOrgId() != null
								&& this.getPrivateBankOrgId().equals(castOther.getPrivateBankOrgId())))
				&& ((this.getPrivateBankOrgName() == castOther.getPrivateBankOrgName())
						|| (this.getPrivateBankOrgName() != null && castOther.getPrivateBankOrgName() != null
								&& this.getPrivateBankOrgName().equals(castOther.getPrivateBankOrgName())))
				&& ((this.getPrivateRemark() == castOther.getPrivateRemark())
						|| (this.getPrivateRemark() != null && castOther.getPrivateRemark() != null
								&& this.getPrivateRemark().equals(castOther.getPrivateRemark())))
				&& ((this.getPrivateAccountName() == castOther.getPrivateAccountName())
						|| (this.getPrivateAccountName() != null && castOther.getPrivateAccountName() != null
								&& this.getPrivateAccountName().equals(castOther.getPrivateAccountName())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getBankCode() == null ? 0 : this.getBankCode().hashCode());
		result = 37 * result + (getBankCodeName() == null ? 0 : this.getBankCodeName().hashCode());
		result = 37 * result + (getPrivateAccountId() == null ? 0 : this.getPrivateAccountId().hashCode());
		result = 37 * result + (getPrivateTradeSeq() == null ? 0 : this.getPrivateTradeSeq().hashCode());
		result = 37 * result + (getPrivateAmount() == null ? 0 : this.getPrivateAmount().hashCode());
		result = 37 * result + (getPrivateOpAccountId() == null ? 0 : this.getPrivateOpAccountId().hashCode());
		result = 37 * result + (getPrivateOpBankId() == null ? 0 : this.getPrivateOpBankId().hashCode());
		result = 37 * result + (getPrivateOpBankName() == null ? 0 : this.getPrivateOpBankName().hashCode());
		result = 37 * result + (getPrivateOpAccountName() == null ? 0 : this.getPrivateOpAccountName().hashCode());
		result = 37 * result + (getPrivateTradeCode() == null ? 0 : this.getPrivateTradeCode().hashCode());
		result = 37 * result + (getPrivateTradeName() == null ? 0 : this.getPrivateTradeName().hashCode());
		result = 37 * result + (getPrivateTradeDat() == null ? 0 : this.getPrivateTradeDat().hashCode());
		result = 37 * result + (getPrivateBalance() == null ? 0 : this.getPrivateBalance().hashCode());
		result = 37 * result + (getPrivateBankOrgId() == null ? 0 : this.getPrivateBankOrgId().hashCode());
		result = 37 * result + (getPrivateBankOrgName() == null ? 0 : this.getPrivateBankOrgName().hashCode());
		result = 37 * result + (getPrivateRemark() == null ? 0 : this.getPrivateRemark().hashCode());
		result = 37 * result + (getPrivateAccountName() == null ? 0 : this.getPrivateAccountName().hashCode());
		return result;
	}

}
