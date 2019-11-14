package cn.springmvc.model;

import java.io.Serializable;
import java.util.Date;

public class TestResultDetail implements Serializable {
    private String resultDetailId;

    private String resultId;

    private Date runtime;

    private String caseId;

    private String caseDesc;

    private String checkResult;

    private Long taketime;

    private String system;

    private String flag;

    private static final long serialVersionUID = 1L;

    public String getResultDetailId() {
        return resultDetailId;
    }

    public void setResultDetailId(String resultDetailId) {
        this.resultDetailId = resultDetailId == null ? null : resultDetailId.trim();
    }

    public String getResultId() {
        return resultId;
    }

    public void setResultId(String resultId) {
        this.resultId = resultId == null ? null : resultId.trim();
    }

    public Date getRuntime() {
        return runtime;
    }

    public void setRuntime(Date runtime) {
        this.runtime = runtime;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId == null ? null : caseId.trim();
    }

    public String getCaseDesc() {
        return caseDesc;
    }

    public void setCaseDesc(String caseDesc) {
        this.caseDesc = caseDesc == null ? null : caseDesc.trim();
    }

    public String getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult == null ? null : checkResult.trim();
    }

    public Long getTaketime() {
        return taketime;
    }

    public void setTaketime(Long taketime) {
        this.taketime = taketime;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system == null ? null : system.trim();
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", resultDetailId=").append(resultDetailId);
        sb.append(", resultId=").append(resultId);
        sb.append(", runtime=").append(runtime);
        sb.append(", caseId=").append(caseId);
        sb.append(", caseDesc=").append(caseDesc);
        sb.append(", checkResult=").append(checkResult);
        sb.append(", taketime=").append(taketime);
        sb.append(", system=").append(system);
        sb.append(", flag=").append(flag);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TestResultDetail other = (TestResultDetail) that;
        return (this.getResultDetailId() == null ? other.getResultDetailId() == null : this.getResultDetailId().equals(other.getResultDetailId()))
            && (this.getResultId() == null ? other.getResultId() == null : this.getResultId().equals(other.getResultId()))
            && (this.getRuntime() == null ? other.getRuntime() == null : this.getRuntime().equals(other.getRuntime()))
            && (this.getCaseId() == null ? other.getCaseId() == null : this.getCaseId().equals(other.getCaseId()))
            && (this.getCaseDesc() == null ? other.getCaseDesc() == null : this.getCaseDesc().equals(other.getCaseDesc()))
            && (this.getCheckResult() == null ? other.getCheckResult() == null : this.getCheckResult().equals(other.getCheckResult()))
            && (this.getTaketime() == null ? other.getTaketime() == null : this.getTaketime().equals(other.getTaketime()))
            && (this.getSystem() == null ? other.getSystem() == null : this.getSystem().equals(other.getSystem()))
            && (this.getFlag() == null ? other.getFlag() == null : this.getFlag().equals(other.getFlag()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getResultDetailId() == null) ? 0 : getResultDetailId().hashCode());
        result = prime * result + ((getResultId() == null) ? 0 : getResultId().hashCode());
        result = prime * result + ((getRuntime() == null) ? 0 : getRuntime().hashCode());
        result = prime * result + ((getCaseId() == null) ? 0 : getCaseId().hashCode());
        result = prime * result + ((getCaseDesc() == null) ? 0 : getCaseDesc().hashCode());
        result = prime * result + ((getCheckResult() == null) ? 0 : getCheckResult().hashCode());
        result = prime * result + ((getTaketime() == null) ? 0 : getTaketime().hashCode());
        result = prime * result + ((getSystem() == null) ? 0 : getSystem().hashCode());
        result = prime * result + ((getFlag() == null) ? 0 : getFlag().hashCode());
        return result;
    }
}