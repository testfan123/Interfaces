package cn.springmvc.service.impl;
 
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.MethodUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.springmvc.apitest.SpringContextUtils;

 
/**
 * mybatis 通用service
 * @param <T>
 */
public abstract class BaseService<T>{
 

	private Class<T> argumentClazz=null;
	
	//对应mapperclass, 由于通过spring管理，具体对象从spring中获取
    private Class mapperClass=null;
    
    //条件
    private Object criteria=null;
       
    
 
	public Map<String, Object> list(Integer pag, Integer pagesize) {
		if(pag==null){
			pag=1;
		}
		if(pagesize==null||pagesize==0){
			pagesize=10;
		}
		Map<String, Object> data=new HashMap<String, Object>();
	    PageHelper.startPage(pag, pagesize);
	    Object bean = SpringContextUtils.getBean(getMapperType());
		try {
			List<T> list= (List<T>) MethodUtils.invokeMethod(bean, "selectByExample", getCriteriaObject());
		    PageInfo<T> pageInfo = new PageInfo<T>(list);
			data.put("objs", pageInfo.getList());
			data.put("pag", pageInfo.getPageNum());
			data.put("total", pageInfo.getPages());
			data.put("pagesize", pageInfo.getPageSize());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	
	
	public Map<String, Object> list(Integer pag, Integer pagesize, Object o) {
    	if(pag==null){
			pag=1;
		}
		if(pagesize==null||pagesize==0){
			pagesize=10;
		}
		if(getCriteriaObject().getClass().isInstance(o)) {
			return null;
		}
		Map<String, Object> data=new HashMap<String, Object>();
	    PageHelper.startPage(pag, pagesize);
		//获取mapper spring 管理
	    Object bean = SpringContextUtils.getBean(getMapperType());
		try {
			List<T> list= (List<T>) MethodUtils.invokeMethod(bean, "selectByExample", o);
		    PageInfo<T> pageInfo = new PageInfo<T>(list);
			data.put("objs", pageInfo.getList());
			data.put("pag", pageInfo.getPageNum());
			data.put("total", pageInfo.getPages());
			data.put("pagesize", pageInfo.getPageSize());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
    }
    
    
    public T getById(Object id){
        Object bean = SpringContextUtils.getBean(getMapperType());
        T t = null;
        try {
           t= (T) MethodUtils.invokeMethod(bean,"selectByPrimaryKey",id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }
    
    
    /**
     * 添加
     * @param t
     * @return
     */
    public T add(T t){
        Object bean = SpringContextUtils.getBean(getMapperType());
        try {
        	MethodUtils.invokeMethod(bean,"insertSelective",t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }
 
    /**
     * 删除
     * @param id
     */
    public void delete(Object id){
        Object bean = SpringContextUtils.getBean(getMapperType());
        try {
            MethodUtils.invokeMethod(bean,"deleteByPrimaryKey", id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    /**
     * 更新
     * @param t
     * @return
     */
    public T update(T t){
        Object bean = SpringContextUtils.getBean(getMapperType());
        try {
            MethodUtils.invokeMethod(bean,"updateByPrimaryKeySelective", t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }
 
 
 

 
    /**
     * 返回类泛型参数类型
     * @return
     */
    private Class<T> getTypeArguement(){
        if(null==argumentClazz){
          this.argumentClazz = (Class<T>)((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        }
        return  argumentClazz;
    }
 
    /**
     * 获取子类Mapper Class
     * @return
     */
    private Object getCriteriaObject()  {
        if(null==criteria){
            String mapperClassName = getTypeArguement().getTypeName();
            mapperClassName=mapperClassName+"Criteria";
            try {
            	criteria=Class.forName(mapperClassName).newInstance();
                return criteria;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            return criteria;
        }
        return null;
    }
    
    private Class getMapperType()  {
        if(null==mapperClass){
            String mapperClassName = getTypeArguement().getTypeName();
            mapperClassName = mapperClassName.replace("model", "dao");
            mapperClassName=mapperClassName+"Mapper";
            try {
                this.mapperClass=Class.forName(mapperClassName);
                return mapperClass;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }else{
            return mapperClass;
        }
        return null;
    }
 
}
