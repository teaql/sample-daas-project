/*

SEARCH,VISIBLE_CHILD,ADD,SEARCHABLE,UPDATE,SAMPLE_DATA,DELETE,PERSISTENCE,VIEWDETAIL,CUSTOM_MANAGER,ACTION,EXCEL_VIEW,ADMINUI,VISIBLE_PARENT

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

package com.doublechaintech.model.secuser;

import java.util.Date;
import com.terapico.uccaf.BaseUserContext;
import com.doublechaintech.model.ModelUserContext;

public class SecUserCustomManagerImpl extends CustomSecUserManagerImpl {}

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
