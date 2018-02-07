package gov.cqaudit.finance.hibernate.entities;
// Generated 2018-2-2 15:03:25 by Hibernate Tools 5.2.3.Final

import java.math.BigDecimal;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * DataCorePrivateAccountTradeDetail generated by hbm2java
 */
@Entity
@Table(name = "data_core_private_account_trade_detail", schema = "public")
public class DataCorePrivateAccountTradeDetail implements java.io.Serializable {

	private DataCorePrivateAccountTradeDetailId id;
	private BigDecimal privateAmount;
	private String privateOpAccountId;
	private String privateOpBankId;
	private String privateOpBankName;
	private String privateOpAccountName;
	private String privateTradeCode;
	private String privateTradeName;
	private BigDecimal privateBalance;
	private String privateBankOrgId;
	private String privateBankOrgName;
	private String privateRemark;
	private String privateAccountName;

	public DataCorePrivateAccountTradeDetail() {
	}

	public DataCorePrivateAccountTradeDetail(DataCorePrivateAccountTradeDetailId id) {
		this.id = id;
	}

	public DataCorePrivateAccountTradeDetail(DataCorePrivateAccountTradeDetailId id, BigDecimal privateAmount,
			String privateOpAccountId, String privateOpBankId, String privateOpBankName, String privateOpAccountName,
			String privateTradeCode, String privateTradeName, BigDecimal privateBalance, String privateBankOrgId,
			String privateBankOrgName, String privateRemark, String privateAccountName) {
		this.id = id;
		this.privateAmount = privateAmount;
		this.privateOpAccountId = privateOpAccountId;
		this.privateOpBankId = privateOpBankId;
		this.privateOpBankName = privateOpBankName;
		this.privateOpAccountName = privateOpAccountName;
		this.privateTradeCode = privateTradeCode;
		this.privateTradeName = privateTradeName;
		this.privateBalance = privateBalance;
		this.privateBankOrgId = privateBankOrgId;
		this.privateBankOrgName = privateBankOrgName;
		this.privateRemark = privateRemark;
		this.privateAccountName = privateAccountName;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "bankCode", column = @Column(name = "bank_code", nullable = false, length = 4)),
			@AttributeOverride(name = "privateAccountId", column = @Column(name = "private_account_id", nullable = false, length = 128)),
			@AttributeOverride(name = "privateTradeSeq", column = @Column(name = "private_trade_seq", nullable = false, length = 128)),
			@AttributeOverride(name = "privateTradeDat", column = @Column(name = "private_trade_dat", nullable = false, length = 35)) })
	public DataCorePrivateAccountTradeDetailId getId() {
		return this.id;
	}

	public void setId(DataCorePrivateAccountTradeDetailId id) {
		this.id = id;
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

}
