package cn.springmvc.model;

import java.io.Serializable;

import cn.springmvc.listener.ObjectCache;

public class TestCase implements Serializable {
    private String uuid;

    private String run;

    private String system;

    private String casename;

    private String url;

    private String params;

    private String type;

    private String header;

    private String checkpoint;

    private String correlation;

    private String beforefunc;

    private String dbchecksql;

    private String dbexpected;

    private String testresult;
    
    private String systemname;

    public String getSystemname() {
       	return ObjectCache.getSystemName(this.system);
   }

    private static final long serialVersionUID = 1L;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getRun() {
        return run;
    }

    public void setRun(String run) {
        this.run = run == null ? null : run.trim();
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system == null ? null : system.trim();
    }

    public String getCasename() {
        return casename;
    }

    public void setCasename(String casename) {
        this.casename = casename == null ? null : casename.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params == null ? null : params.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header == null ? null : header.trim();
    }

    public String getCheckpoint() {
        return checkpoint;
    }

    public void setCheckpoint(String checkpoint) {
        this.checkpoint = checkpoint == null ? null : checkpoint.trim();
    }

    public String getCorrelation() {
        return correlation;
    }

    public void setCorrelation(String correlation) {
        this.correlation = correlation == null ? null : correlation.trim();
    }

    public String getBeforefunc() {
        return beforefunc;
    }

    public void setBeforefunc(String beforefunc) {
        this.beforefunc = beforefunc == null ? null : beforefunc.trim();
    }

    public String getDbchecksql() {
        return dbchecksql;
    }

    public void setDbchecksql(String dbchecksql) {
        this.dbchecksql = dbchecksql == null ? null : dbchecksql.trim();
    }

    public String getDbexpected() {
        return dbexpected;
    }

    public void setDbexpected(String dbexpected) {
        this.dbexpected = dbexpected == null ? null : dbexpected.trim();
    }

    public String getTestresult() {
        return testresult;
    }

    public void setTestresult(String testresult) {
        this.testresult = testresult == null ? null : testresult.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uuid=").append(uuid);
        sb.append(", run=").append(run);
        sb.append(", system=").append(system);
        sb.append(", casename=").append(casename);
        sb.append(", url=").append(url);
        sb.append(", params=").append(params);
        sb.append(", type=").append(type);
        sb.append(", header=").append(header);
        sb.append(", checkpoint=").append(checkpoint);
        sb.append(", correlation=").append(correlation);
        sb.append(", beforefunc=").append(beforefunc);
        sb.append(", dbchecksql=").append(dbchecksql);
        sb.append(", dbexpected=").append(dbexpected);
        sb.append(", testresult=").append(testresult);
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
        TestCase other = (TestCase) that;
        return (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
            && (this.getRun() == null ? other.getRun() == null : this.getRun().equals(other.getRun()))
            && (this.getSystem() == null ? other.getSystem() == null : this.getSystem().equals(other.getSystem()))
            && (this.getCasename() == null ? other.getCasename() == null : this.getCasename().equals(other.getCasename()))
            && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
            && (this.getParams() == null ? other.getParams() == null : this.getParams().equals(other.getParams()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getHeader() == null ? other.getHeader() == null : this.getHeader().equals(other.getHeader()))
            && (this.getCheckpoint() == null ? other.getCheckpoint() == null : this.getCheckpoint().equals(other.getCheckpoint()))
            && (this.getCorrelation() == null ? other.getCorrelation() == null : this.getCorrelation().equals(other.getCorrelation()))
            && (this.getBeforefunc() == null ? other.getBeforefunc() == null : this.getBeforefunc().equals(other.getBeforefunc()))
            && (this.getDbchecksql() == null ? other.getDbchecksql() == null : this.getDbchecksql().equals(other.getDbchecksql()))
            && (this.getDbexpected() == null ? other.getDbexpected() == null : this.getDbexpected().equals(other.getDbexpected()))
            && (this.getTestresult() == null ? other.getTestresult() == null : this.getTestresult().equals(other.getTestresult()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
        result = prime * result + ((getRun() == null) ? 0 : getRun().hashCode());
        result = prime * result + ((getSystem() == null) ? 0 : getSystem().hashCode());
        result = prime * result + ((getCasename() == null) ? 0 : getCasename().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        result = prime * result + ((getParams() == null) ? 0 : getParams().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getHeader() == null) ? 0 : getHeader().hashCode());
        result = prime * result + ((getCheckpoint() == null) ? 0 : getCheckpoint().hashCode());
        result = prime * result + ((getCorrelation() == null) ? 0 : getCorrelation().hashCode());
        result = prime * result + ((getBeforefunc() == null) ? 0 : getBeforefunc().hashCode());
        result = prime * result + ((getDbchecksql() == null) ? 0 : getDbchecksql().hashCode());
        result = prime * result + ((getDbexpected() == null) ? 0 : getDbexpected().hashCode());
        result = prime * result + ((getTestresult() == null) ? 0 : getTestresult().hashCode());
        return result;
    }
}