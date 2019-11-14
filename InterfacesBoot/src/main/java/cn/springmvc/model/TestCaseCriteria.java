package cn.springmvc.model;

import java.util.ArrayList;
import java.util.List;

public class TestCaseCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TestCaseCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andUuidIsNull() {
            addCriterion("uuid is null");
            return (Criteria) this;
        }

        public Criteria andUuidIsNotNull() {
            addCriterion("uuid is not null");
            return (Criteria) this;
        }

        public Criteria andUuidEqualTo(String value) {
            addCriterion("uuid =", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotEqualTo(String value) {
            addCriterion("uuid <>", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThan(String value) {
            addCriterion("uuid >", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThanOrEqualTo(String value) {
            addCriterion("uuid >=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThan(String value) {
            addCriterion("uuid <", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThanOrEqualTo(String value) {
            addCriterion("uuid <=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLike(String value) {
            addCriterion("uuid like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotLike(String value) {
            addCriterion("uuid not like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidIn(List<String> values) {
            addCriterion("uuid in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotIn(List<String> values) {
            addCriterion("uuid not in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidBetween(String value1, String value2) {
            addCriterion("uuid between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotBetween(String value1, String value2) {
            addCriterion("uuid not between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andRunIsNull() {
            addCriterion("run is null");
            return (Criteria) this;
        }

        public Criteria andRunIsNotNull() {
            addCriterion("run is not null");
            return (Criteria) this;
        }

        public Criteria andRunEqualTo(String value) {
            addCriterion("run =", value, "run");
            return (Criteria) this;
        }

        public Criteria andRunNotEqualTo(String value) {
            addCriterion("run <>", value, "run");
            return (Criteria) this;
        }

        public Criteria andRunGreaterThan(String value) {
            addCriterion("run >", value, "run");
            return (Criteria) this;
        }

        public Criteria andRunGreaterThanOrEqualTo(String value) {
            addCriterion("run >=", value, "run");
            return (Criteria) this;
        }

        public Criteria andRunLessThan(String value) {
            addCriterion("run <", value, "run");
            return (Criteria) this;
        }

        public Criteria andRunLessThanOrEqualTo(String value) {
            addCriterion("run <=", value, "run");
            return (Criteria) this;
        }

        public Criteria andRunLike(String value) {
            addCriterion("run like", value, "run");
            return (Criteria) this;
        }

        public Criteria andRunNotLike(String value) {
            addCriterion("run not like", value, "run");
            return (Criteria) this;
        }

        public Criteria andRunIn(List<String> values) {
            addCriterion("run in", values, "run");
            return (Criteria) this;
        }

        public Criteria andRunNotIn(List<String> values) {
            addCriterion("run not in", values, "run");
            return (Criteria) this;
        }

        public Criteria andRunBetween(String value1, String value2) {
            addCriterion("run between", value1, value2, "run");
            return (Criteria) this;
        }

        public Criteria andRunNotBetween(String value1, String value2) {
            addCriterion("run not between", value1, value2, "run");
            return (Criteria) this;
        }

        public Criteria andSystemIsNull() {
            addCriterion("system is null");
            return (Criteria) this;
        }

        public Criteria andSystemIsNotNull() {
            addCriterion("system is not null");
            return (Criteria) this;
        }

        public Criteria andSystemEqualTo(String value) {
            addCriterion("system =", value, "system");
            return (Criteria) this;
        }

        public Criteria andSystemNotEqualTo(String value) {
            addCriterion("system <>", value, "system");
            return (Criteria) this;
        }

        public Criteria andSystemGreaterThan(String value) {
            addCriterion("system >", value, "system");
            return (Criteria) this;
        }

        public Criteria andSystemGreaterThanOrEqualTo(String value) {
            addCriterion("system >=", value, "system");
            return (Criteria) this;
        }

        public Criteria andSystemLessThan(String value) {
            addCriterion("system <", value, "system");
            return (Criteria) this;
        }

        public Criteria andSystemLessThanOrEqualTo(String value) {
            addCriterion("system <=", value, "system");
            return (Criteria) this;
        }

        public Criteria andSystemLike(String value) {
            addCriterion("system like", value, "system");
            return (Criteria) this;
        }

        public Criteria andSystemNotLike(String value) {
            addCriterion("system not like", value, "system");
            return (Criteria) this;
        }

        public Criteria andSystemIn(List<String> values) {
            addCriterion("system in", values, "system");
            return (Criteria) this;
        }

        public Criteria andSystemNotIn(List<String> values) {
            addCriterion("system not in", values, "system");
            return (Criteria) this;
        }

        public Criteria andSystemBetween(String value1, String value2) {
            addCriterion("system between", value1, value2, "system");
            return (Criteria) this;
        }

        public Criteria andSystemNotBetween(String value1, String value2) {
            addCriterion("system not between", value1, value2, "system");
            return (Criteria) this;
        }

        public Criteria andCasenameIsNull() {
            addCriterion("caseName is null");
            return (Criteria) this;
        }

        public Criteria andCasenameIsNotNull() {
            addCriterion("caseName is not null");
            return (Criteria) this;
        }

        public Criteria andCasenameEqualTo(String value) {
            addCriterion("caseName =", value, "casename");
            return (Criteria) this;
        }

        public Criteria andCasenameNotEqualTo(String value) {
            addCriterion("caseName <>", value, "casename");
            return (Criteria) this;
        }

        public Criteria andCasenameGreaterThan(String value) {
            addCriterion("caseName >", value, "casename");
            return (Criteria) this;
        }

        public Criteria andCasenameGreaterThanOrEqualTo(String value) {
            addCriterion("caseName >=", value, "casename");
            return (Criteria) this;
        }

        public Criteria andCasenameLessThan(String value) {
            addCriterion("caseName <", value, "casename");
            return (Criteria) this;
        }

        public Criteria andCasenameLessThanOrEqualTo(String value) {
            addCriterion("caseName <=", value, "casename");
            return (Criteria) this;
        }

        public Criteria andCasenameLike(String value) {
            addCriterion("caseName like", value, "casename");
            return (Criteria) this;
        }

        public Criteria andCasenameNotLike(String value) {
            addCriterion("caseName not like", value, "casename");
            return (Criteria) this;
        }

        public Criteria andCasenameIn(List<String> values) {
            addCriterion("caseName in", values, "casename");
            return (Criteria) this;
        }

        public Criteria andCasenameNotIn(List<String> values) {
            addCriterion("caseName not in", values, "casename");
            return (Criteria) this;
        }

        public Criteria andCasenameBetween(String value1, String value2) {
            addCriterion("caseName between", value1, value2, "casename");
            return (Criteria) this;
        }

        public Criteria andCasenameNotBetween(String value1, String value2) {
            addCriterion("caseName not between", value1, value2, "casename");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andParamsIsNull() {
            addCriterion("params is null");
            return (Criteria) this;
        }

        public Criteria andParamsIsNotNull() {
            addCriterion("params is not null");
            return (Criteria) this;
        }

        public Criteria andParamsEqualTo(String value) {
            addCriterion("params =", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsNotEqualTo(String value) {
            addCriterion("params <>", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsGreaterThan(String value) {
            addCriterion("params >", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsGreaterThanOrEqualTo(String value) {
            addCriterion("params >=", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsLessThan(String value) {
            addCriterion("params <", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsLessThanOrEqualTo(String value) {
            addCriterion("params <=", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsLike(String value) {
            addCriterion("params like", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsNotLike(String value) {
            addCriterion("params not like", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsIn(List<String> values) {
            addCriterion("params in", values, "params");
            return (Criteria) this;
        }

        public Criteria andParamsNotIn(List<String> values) {
            addCriterion("params not in", values, "params");
            return (Criteria) this;
        }

        public Criteria andParamsBetween(String value1, String value2) {
            addCriterion("params between", value1, value2, "params");
            return (Criteria) this;
        }

        public Criteria andParamsNotBetween(String value1, String value2) {
            addCriterion("params not between", value1, value2, "params");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andHeaderIsNull() {
            addCriterion("header is null");
            return (Criteria) this;
        }

        public Criteria andHeaderIsNotNull() {
            addCriterion("header is not null");
            return (Criteria) this;
        }

        public Criteria andHeaderEqualTo(String value) {
            addCriterion("header =", value, "header");
            return (Criteria) this;
        }

        public Criteria andHeaderNotEqualTo(String value) {
            addCriterion("header <>", value, "header");
            return (Criteria) this;
        }

        public Criteria andHeaderGreaterThan(String value) {
            addCriterion("header >", value, "header");
            return (Criteria) this;
        }

        public Criteria andHeaderGreaterThanOrEqualTo(String value) {
            addCriterion("header >=", value, "header");
            return (Criteria) this;
        }

        public Criteria andHeaderLessThan(String value) {
            addCriterion("header <", value, "header");
            return (Criteria) this;
        }

        public Criteria andHeaderLessThanOrEqualTo(String value) {
            addCriterion("header <=", value, "header");
            return (Criteria) this;
        }

        public Criteria andHeaderLike(String value) {
            addCriterion("header like", value, "header");
            return (Criteria) this;
        }

        public Criteria andHeaderNotLike(String value) {
            addCriterion("header not like", value, "header");
            return (Criteria) this;
        }

        public Criteria andHeaderIn(List<String> values) {
            addCriterion("header in", values, "header");
            return (Criteria) this;
        }

        public Criteria andHeaderNotIn(List<String> values) {
            addCriterion("header not in", values, "header");
            return (Criteria) this;
        }

        public Criteria andHeaderBetween(String value1, String value2) {
            addCriterion("header between", value1, value2, "header");
            return (Criteria) this;
        }

        public Criteria andHeaderNotBetween(String value1, String value2) {
            addCriterion("header not between", value1, value2, "header");
            return (Criteria) this;
        }

        public Criteria andCheckpointIsNull() {
            addCriterion("checkpoint is null");
            return (Criteria) this;
        }

        public Criteria andCheckpointIsNotNull() {
            addCriterion("checkpoint is not null");
            return (Criteria) this;
        }

        public Criteria andCheckpointEqualTo(String value) {
            addCriterion("checkpoint =", value, "checkpoint");
            return (Criteria) this;
        }

        public Criteria andCheckpointNotEqualTo(String value) {
            addCriterion("checkpoint <>", value, "checkpoint");
            return (Criteria) this;
        }

        public Criteria andCheckpointGreaterThan(String value) {
            addCriterion("checkpoint >", value, "checkpoint");
            return (Criteria) this;
        }

        public Criteria andCheckpointGreaterThanOrEqualTo(String value) {
            addCriterion("checkpoint >=", value, "checkpoint");
            return (Criteria) this;
        }

        public Criteria andCheckpointLessThan(String value) {
            addCriterion("checkpoint <", value, "checkpoint");
            return (Criteria) this;
        }

        public Criteria andCheckpointLessThanOrEqualTo(String value) {
            addCriterion("checkpoint <=", value, "checkpoint");
            return (Criteria) this;
        }

        public Criteria andCheckpointLike(String value) {
            addCriterion("checkpoint like", value, "checkpoint");
            return (Criteria) this;
        }

        public Criteria andCheckpointNotLike(String value) {
            addCriterion("checkpoint not like", value, "checkpoint");
            return (Criteria) this;
        }

        public Criteria andCheckpointIn(List<String> values) {
            addCriterion("checkpoint in", values, "checkpoint");
            return (Criteria) this;
        }

        public Criteria andCheckpointNotIn(List<String> values) {
            addCriterion("checkpoint not in", values, "checkpoint");
            return (Criteria) this;
        }

        public Criteria andCheckpointBetween(String value1, String value2) {
            addCriterion("checkpoint between", value1, value2, "checkpoint");
            return (Criteria) this;
        }

        public Criteria andCheckpointNotBetween(String value1, String value2) {
            addCriterion("checkpoint not between", value1, value2, "checkpoint");
            return (Criteria) this;
        }

        public Criteria andCorrelationIsNull() {
            addCriterion("correlation is null");
            return (Criteria) this;
        }

        public Criteria andCorrelationIsNotNull() {
            addCriterion("correlation is not null");
            return (Criteria) this;
        }

        public Criteria andCorrelationEqualTo(String value) {
            addCriterion("correlation =", value, "correlation");
            return (Criteria) this;
        }

        public Criteria andCorrelationNotEqualTo(String value) {
            addCriterion("correlation <>", value, "correlation");
            return (Criteria) this;
        }

        public Criteria andCorrelationGreaterThan(String value) {
            addCriterion("correlation >", value, "correlation");
            return (Criteria) this;
        }

        public Criteria andCorrelationGreaterThanOrEqualTo(String value) {
            addCriterion("correlation >=", value, "correlation");
            return (Criteria) this;
        }

        public Criteria andCorrelationLessThan(String value) {
            addCriterion("correlation <", value, "correlation");
            return (Criteria) this;
        }

        public Criteria andCorrelationLessThanOrEqualTo(String value) {
            addCriterion("correlation <=", value, "correlation");
            return (Criteria) this;
        }

        public Criteria andCorrelationLike(String value) {
            addCriterion("correlation like", value, "correlation");
            return (Criteria) this;
        }

        public Criteria andCorrelationNotLike(String value) {
            addCriterion("correlation not like", value, "correlation");
            return (Criteria) this;
        }

        public Criteria andCorrelationIn(List<String> values) {
            addCriterion("correlation in", values, "correlation");
            return (Criteria) this;
        }

        public Criteria andCorrelationNotIn(List<String> values) {
            addCriterion("correlation not in", values, "correlation");
            return (Criteria) this;
        }

        public Criteria andCorrelationBetween(String value1, String value2) {
            addCriterion("correlation between", value1, value2, "correlation");
            return (Criteria) this;
        }

        public Criteria andCorrelationNotBetween(String value1, String value2) {
            addCriterion("correlation not between", value1, value2, "correlation");
            return (Criteria) this;
        }

        public Criteria andBeforefuncIsNull() {
            addCriterion("beforefunc is null");
            return (Criteria) this;
        }

        public Criteria andBeforefuncIsNotNull() {
            addCriterion("beforefunc is not null");
            return (Criteria) this;
        }

        public Criteria andBeforefuncEqualTo(String value) {
            addCriterion("beforefunc =", value, "beforefunc");
            return (Criteria) this;
        }

        public Criteria andBeforefuncNotEqualTo(String value) {
            addCriterion("beforefunc <>", value, "beforefunc");
            return (Criteria) this;
        }

        public Criteria andBeforefuncGreaterThan(String value) {
            addCriterion("beforefunc >", value, "beforefunc");
            return (Criteria) this;
        }

        public Criteria andBeforefuncGreaterThanOrEqualTo(String value) {
            addCriterion("beforefunc >=", value, "beforefunc");
            return (Criteria) this;
        }

        public Criteria andBeforefuncLessThan(String value) {
            addCriterion("beforefunc <", value, "beforefunc");
            return (Criteria) this;
        }

        public Criteria andBeforefuncLessThanOrEqualTo(String value) {
            addCriterion("beforefunc <=", value, "beforefunc");
            return (Criteria) this;
        }

        public Criteria andBeforefuncLike(String value) {
            addCriterion("beforefunc like", value, "beforefunc");
            return (Criteria) this;
        }

        public Criteria andBeforefuncNotLike(String value) {
            addCriterion("beforefunc not like", value, "beforefunc");
            return (Criteria) this;
        }

        public Criteria andBeforefuncIn(List<String> values) {
            addCriterion("beforefunc in", values, "beforefunc");
            return (Criteria) this;
        }

        public Criteria andBeforefuncNotIn(List<String> values) {
            addCriterion("beforefunc not in", values, "beforefunc");
            return (Criteria) this;
        }

        public Criteria andBeforefuncBetween(String value1, String value2) {
            addCriterion("beforefunc between", value1, value2, "beforefunc");
            return (Criteria) this;
        }

        public Criteria andBeforefuncNotBetween(String value1, String value2) {
            addCriterion("beforefunc not between", value1, value2, "beforefunc");
            return (Criteria) this;
        }

        public Criteria andDbchecksqlIsNull() {
            addCriterion("dbchecksql is null");
            return (Criteria) this;
        }

        public Criteria andDbchecksqlIsNotNull() {
            addCriterion("dbchecksql is not null");
            return (Criteria) this;
        }

        public Criteria andDbchecksqlEqualTo(String value) {
            addCriterion("dbchecksql =", value, "dbchecksql");
            return (Criteria) this;
        }

        public Criteria andDbchecksqlNotEqualTo(String value) {
            addCriterion("dbchecksql <>", value, "dbchecksql");
            return (Criteria) this;
        }

        public Criteria andDbchecksqlGreaterThan(String value) {
            addCriterion("dbchecksql >", value, "dbchecksql");
            return (Criteria) this;
        }

        public Criteria andDbchecksqlGreaterThanOrEqualTo(String value) {
            addCriterion("dbchecksql >=", value, "dbchecksql");
            return (Criteria) this;
        }

        public Criteria andDbchecksqlLessThan(String value) {
            addCriterion("dbchecksql <", value, "dbchecksql");
            return (Criteria) this;
        }

        public Criteria andDbchecksqlLessThanOrEqualTo(String value) {
            addCriterion("dbchecksql <=", value, "dbchecksql");
            return (Criteria) this;
        }

        public Criteria andDbchecksqlLike(String value) {
            addCriterion("dbchecksql like", value, "dbchecksql");
            return (Criteria) this;
        }

        public Criteria andDbchecksqlNotLike(String value) {
            addCriterion("dbchecksql not like", value, "dbchecksql");
            return (Criteria) this;
        }

        public Criteria andDbchecksqlIn(List<String> values) {
            addCriterion("dbchecksql in", values, "dbchecksql");
            return (Criteria) this;
        }

        public Criteria andDbchecksqlNotIn(List<String> values) {
            addCriterion("dbchecksql not in", values, "dbchecksql");
            return (Criteria) this;
        }

        public Criteria andDbchecksqlBetween(String value1, String value2) {
            addCriterion("dbchecksql between", value1, value2, "dbchecksql");
            return (Criteria) this;
        }

        public Criteria andDbchecksqlNotBetween(String value1, String value2) {
            addCriterion("dbchecksql not between", value1, value2, "dbchecksql");
            return (Criteria) this;
        }

        public Criteria andDbexpectedIsNull() {
            addCriterion("dbexpected is null");
            return (Criteria) this;
        }

        public Criteria andDbexpectedIsNotNull() {
            addCriterion("dbexpected is not null");
            return (Criteria) this;
        }

        public Criteria andDbexpectedEqualTo(String value) {
            addCriterion("dbexpected =", value, "dbexpected");
            return (Criteria) this;
        }

        public Criteria andDbexpectedNotEqualTo(String value) {
            addCriterion("dbexpected <>", value, "dbexpected");
            return (Criteria) this;
        }

        public Criteria andDbexpectedGreaterThan(String value) {
            addCriterion("dbexpected >", value, "dbexpected");
            return (Criteria) this;
        }

        public Criteria andDbexpectedGreaterThanOrEqualTo(String value) {
            addCriterion("dbexpected >=", value, "dbexpected");
            return (Criteria) this;
        }

        public Criteria andDbexpectedLessThan(String value) {
            addCriterion("dbexpected <", value, "dbexpected");
            return (Criteria) this;
        }

        public Criteria andDbexpectedLessThanOrEqualTo(String value) {
            addCriterion("dbexpected <=", value, "dbexpected");
            return (Criteria) this;
        }

        public Criteria andDbexpectedLike(String value) {
            addCriterion("dbexpected like", value, "dbexpected");
            return (Criteria) this;
        }

        public Criteria andDbexpectedNotLike(String value) {
            addCriterion("dbexpected not like", value, "dbexpected");
            return (Criteria) this;
        }

        public Criteria andDbexpectedIn(List<String> values) {
            addCriterion("dbexpected in", values, "dbexpected");
            return (Criteria) this;
        }

        public Criteria andDbexpectedNotIn(List<String> values) {
            addCriterion("dbexpected not in", values, "dbexpected");
            return (Criteria) this;
        }

        public Criteria andDbexpectedBetween(String value1, String value2) {
            addCriterion("dbexpected between", value1, value2, "dbexpected");
            return (Criteria) this;
        }

        public Criteria andDbexpectedNotBetween(String value1, String value2) {
            addCriterion("dbexpected not between", value1, value2, "dbexpected");
            return (Criteria) this;
        }

        public Criteria andTestresultIsNull() {
            addCriterion("testResult is null");
            return (Criteria) this;
        }

        public Criteria andTestresultIsNotNull() {
            addCriterion("testResult is not null");
            return (Criteria) this;
        }

        public Criteria andTestresultEqualTo(String value) {
            addCriterion("testResult =", value, "testresult");
            return (Criteria) this;
        }

        public Criteria andTestresultNotEqualTo(String value) {
            addCriterion("testResult <>", value, "testresult");
            return (Criteria) this;
        }

        public Criteria andTestresultGreaterThan(String value) {
            addCriterion("testResult >", value, "testresult");
            return (Criteria) this;
        }

        public Criteria andTestresultGreaterThanOrEqualTo(String value) {
            addCriterion("testResult >=", value, "testresult");
            return (Criteria) this;
        }

        public Criteria andTestresultLessThan(String value) {
            addCriterion("testResult <", value, "testresult");
            return (Criteria) this;
        }

        public Criteria andTestresultLessThanOrEqualTo(String value) {
            addCriterion("testResult <=", value, "testresult");
            return (Criteria) this;
        }

        public Criteria andTestresultLike(String value) {
            addCriterion("testResult like", value, "testresult");
            return (Criteria) this;
        }

        public Criteria andTestresultNotLike(String value) {
            addCriterion("testResult not like", value, "testresult");
            return (Criteria) this;
        }

        public Criteria andTestresultIn(List<String> values) {
            addCriterion("testResult in", values, "testresult");
            return (Criteria) this;
        }

        public Criteria andTestresultNotIn(List<String> values) {
            addCriterion("testResult not in", values, "testresult");
            return (Criteria) this;
        }

        public Criteria andTestresultBetween(String value1, String value2) {
            addCriterion("testResult between", value1, value2, "testresult");
            return (Criteria) this;
        }

        public Criteria andTestresultNotBetween(String value1, String value2) {
            addCriterion("testResult not between", value1, value2, "testresult");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}