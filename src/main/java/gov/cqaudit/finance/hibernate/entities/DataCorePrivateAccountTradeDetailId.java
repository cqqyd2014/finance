package gov.cqaudit.finance.hibernate.entities;
// Generated 2018-1-2 21:10:43 by Hibernate Tools 5.2.3.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * DataCorePrivateAccountTradeDetailId generated by hbm2java
 */
@Embeddable
public class DataCorePrivateAccountTradeDetailId implements java.io.Serializable {

	private String bankCode;
	private String privateAccountId;
	private String privateTradeSeq;
	private Date privateTradeDat;

	public DataCorePrivateAccountTradeDetailId() {
	}

	public DataCorePrivateAccountTradeDetailId(String bankCode, String privateAccountId, String privateTradeSeq,
			Date privateTradeDat) {
		this.bankCode = bankCode;
		this.privateAccountId = privateAccountId;
		this.privateTradeSeq = privateTradeSeq;
		this.privateTradeDat = privateTradeDat;
	}

	@Column(name = "bank_code", nullable = false, length = 4)
	public String getBankCode() {
		return this.bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	@Column(name = "private_account_id", nullable = false, length = 128)
	public String getPrivateAccountId() {
		return this.privateAccountId;
	}

	public void setPrivateAccountId(String privateAccountId) {
		this.privateAccountId = privateAccountId;
	}

	@Column(name = "private_trade_seq", nullable = false, length = 128)
	public String getPrivateTradeSeq() {
		return this.privateTradeSeq;
	}

	public void setPrivateTradeSeq(String privateTradeSeq) {
		this.privateTradeSeq = privateTradeSeq;
	}

	@Column(name = "private_trade_dat", nullable = false, length = 35)
	public Date getPrivateTradeDat() {
		return this.privateTradeDat;
	}

	public void setPrivateTradeDat(Date privateTradeDat) {
		this.privateTradeDat = privateTradeDat;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DataCorePrivateAccountTradeDetailId))
			return false;
		DataCorePrivateAccountTradeDetailId castOther = (DataCorePrivateAccountTradeDetailId) other;

		return ((this.getBankCode() == castOther.getBankCode()) || (this.getBankCode() != null
				&& castOther.getBankCode() != null && this.getBankCode().equals(castOther.getBankCode())))
				&& ((this.getPrivateAccountId() == castOther.getPrivateAccountId())
						|| (this.getPrivateAccountId() != null && castOther.getPrivateAccountId() != null
								&& this.getPrivateAccountId().equals(castOther.getPrivateAccountId())))
				&& ((this.getPrivateTradeSeq() == castOther.getPrivateTradeSeq())
						|| (this.getPrivateTradeSeq() != null && castOther.getPrivateTradeSeq() != null
								&& this.getPrivateTradeSeq().equals(castOther.getPrivateTradeSeq())))
				&& ((this.getPrivateTradeDat() == castOther.getPrivateTradeDat())
						|| (this.getPrivateTradeDat() != null && castOther.getPrivateTradeDat() != null
								&& this.getPrivateTradeDat().equals(castOther.getPrivateTradeDat())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getBankCode() == null ? 0 : this.getBankCode().hashCode());
		result = 37 * result + (getPrivateAccountId() == null ? 0 : this.getPrivateAccountId().hashCode());
		result = 37 * result + (getPrivateTradeSeq() == null ? 0 : this.getPrivateTradeSeq().hashCode());
		result = 37 * result + (getPrivateTradeDat() == null ? 0 : this.getPrivateTradeDat().hashCode());
		return result;
	}

}