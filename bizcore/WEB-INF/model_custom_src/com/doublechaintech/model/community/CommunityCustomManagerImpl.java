

/*

SEARCH,VISIBLE_CHILD,ADD,USERSPACE,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT

这个类讲在第一次生成，此后这些文件不会被覆盖，如果名字发生了变更，则需要手动删除，修改本类来适应新的模型变更，
这个类已经被配置到了相应的Spring配置文件 WEB-INF/model_custom_src/META-INF/model_custom.xml 中，


这里面放置你需要定制的行为主要有两种：
1. 可以增加方法，调用父类和其他manager的资源
2. 也可以重写原来的方法


增加方法：
方法名字：方法明和和这个类的其他名字不要冲突，即使参数类型不同也不行
方法参数：第一个参数总是ModelUserContext userContext，这样能够引用到系统的所有资源，
        无需增加成员变量写注释导入，其他参数可以是基本类型和本项目通过模型定义的类型。
参数实例化的安全考虑：参数可以使用java定义的基本类型和URI，也可以使用通过模型定义的对象类型，或者自定义类型，在自定义类型
        的时候，一定要加上RemoteInitiable，每个这个声明，框架不会实例化这个对象

重载已经存在的方法：

加上@Override来保证声明的一致性，调用重载的方法在同名方法里面一定要使用super.methodName来调用，不然将会出现缓冲出溢出的问题Stack Overflow


满足新的需求，在定义的时候第一个参数加上 ModelUserContext userContext[1]





*/


package com.doublechaintech.model.community;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.script.*;

import cn.hutool.script.ScriptUtil;
import com.doublechaintech.model.ModelBaseUtils;
import com.doublechaintech.model.SmartList;
import com.doublechaintech.model.WebResponse;
import com.doublechaintech.model.expression.E;
import com.doublechaintech.model.family.Family;
import com.doublechaintech.model.kid.Kid;
import com.terapico.uccaf.BaseUserContext;
import com.doublechaintech.model.ModelUserContext;
import com.doublechaintech.model.search.*;
public class CommunityCustomManagerImpl extends CommunityManagerImpl{

    @Override
    public Object checkAccess(BaseUserContext baseUserContext, String methodName, Object[] parameters)
            throws IllegalAccessException {


        if(methodName.startsWith("hello")){
            return this.accessOK();
        }

        return super.checkAccess(baseUserContext,methodName,parameters);
    }


    /*
    *
    * f(x)=2x
    * */
    public Object f(ModelUserContext userContext,int x) throws Exception {
        return 2*x;
    }

    public Object hello(ModelUserContext userContext) throws Exception {

        //userContext.log("hello to " + userContext.getRemoteIP());
        return Q.community().executeForList(userContext);

    }
    public Object helloCommunity(ModelUserContext userContext) throws Exception {

        //userContext.log("hello to " + userContext.getRemoteIP());
        return Q.community().executeForList(userContext);

    }
    public Object helloCommunityWithFamilies(ModelUserContext userContext) throws Exception {

        //userContext.log("hello to " + userContext.getRemoteIP());

        return Q.community().selectFamilyList().executeForList(userContext);

    }

    public Object helloFamilyWithKids(ModelUserContext userContext) throws Exception {
        return Q.family().selectKidList().executeForList(userContext);
    }

    public Object helloKids(ModelUserContext userContext) throws Exception {

        return Q.kid().executeForList(userContext);

    }

    public Object helloMia001Family(ModelUserContext userContext) throws Exception {
        return Q.family().filterByName("Mia's Family0001").selectKidList(
                Q.kidWithIdField().selectName().selectAge().orderByAgeAscending()
                        .filterByName(QueryOperator.BEGIN_WITH,"T")
        ).executeForList(userContext);
    }
    public WebResponse helloMia001Family2(ModelUserContext userContext) throws Exception {
        return WebResponse.fromSmartList(Q.family().filterByName("Mia's Family0001").selectKidList(
                Q.kidWithIdField().selectName().selectAge().orderByAgeAscending()
                        .filterByName(QueryOperator.BEGIN_WITH,"T")).executeForList(userContext));

    }
    public WebResponse helloChangeKidAge(ModelUserContext userContext, String name, int newAge) throws Exception {


        Kid kid = Q.kid().filterByName(name).execute(userContext);

        if(E.kid(kid).eval()==null){
            return WebResponse.fail("could not found kid with name "+name);
        }
        kid.updateAge(newAge);
        ModelBaseUtils.saveItem(userContext,kid);


        return WebResponse.success();



    }
    public WebResponse helloMia001Family3(ModelUserContext userContext) throws Exception {
        SmartList<Family> familyList = Q.family()
                .filterByName("Mia's Family0001").selectKidList(
                    Q.kidWithIdField().selectName().selectAge().orderByAgeAscending()
                        //.filterByName(QueryOperator.BEGIN_WITH, "T")
                            )
                .executeForList(userContext);

        familyList.forEach(f->{
            f.getKidList().forEach(k->{
                k.setDynaProp("pass",true);
            });


        });
        return WebResponse.fromSmartList(familyList);

    }

    public Object helloScript(ModelUserContext userContext) throws Exception {

        ScriptEngineManager manager = new ScriptEngineManager();
        userContext.log("manager "+manager);
        ScriptEngine engine = manager.getEngineByName("JavaScript");

        // evaluate JavaScript code that defines an object with one method
        engine.eval("var obj = new Object()");
        engine.eval("obj.hello = function(name) { print('Hello, ' + name);return 'hello '+name; }");
        // expose object defined in the script to the Java application
        Object obj = engine.get("obj");
        // create an Invocable object by casting the script engine object
        Invocable inv = (Invocable) engine;

        // invoke the method named "hello" on the object defined in the script
        // with "Script Method!" as the argument
        return inv.invokeMethod(obj, "hello", "Script Method!");


        //return Q.family().filterByName("Mia's Family0001").selectKidList().executeForList(userContext);
    }

    public Object helloScriptHutool(ModelUserContext userContext) throws Exception {

        ScriptUtil.eval("print('Script test!');");

        Map<String,Object> p=new HashMap<>();
        p.put("p1",1);
        return ScriptUtil.invoke(
                "hello = function(name) { return name['p1']*0.008; }",
                "hello",p);


    }





}

/*


[1] ModelUserContext userContext 的用法：

通过这个类可以访问到这个应用程序的所有资源。


最常用的是加入检查权限方法

	@Override
	public Object checkAccess(BaseUserContext baseUserContext, String methodName, Object[] parameters)
			throws IllegalAccessException {


		if("hello".equals(methodName)){
			return this.accessOK();
		}

		return super.checkAccess(baseUserContext,methodName,parameters);
	}


尝试加入一个方法，hello

	public Object hello(ModelUserContext userContext) throws Exception {

		userContext.log("hello to " + userContext.getRemoteIP());
		return "hello world!";

	}


*/


