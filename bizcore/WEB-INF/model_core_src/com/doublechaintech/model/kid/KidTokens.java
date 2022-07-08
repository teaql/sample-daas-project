
package com.doublechaintech.model.kid;
import com.doublechaintech.model.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.model.family.FamilyTokens;





public class KidTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="kid";

	public static boolean checkOptions(Map<String,Object> options, String optionToCheck){

		if(options==null){
 			return false; //completely no option here
 		}
 		if(options.containsKey(ALL)){
 			//danger, debug only, might load the entire database!, really terrible
 			return true;
 		}
		String ownerKey = getOwnerObjectKey();
		Object ownerObject =(String) options.get(ownerKey);
		if(ownerObject ==  null){
			return false;
		}
		if(!ownerObject.equals(OWNER_OBJECT_NAME)){ //is the owner?
			return false;
		}

 		if(options.containsKey(optionToCheck)){
 			//options.remove(optionToCheck);
 			//consume the key, can not use any more to extract the data with the same token.
 			return true;
 		}

 		return false;

	}
	protected KidTokens(){
		//ensure not initialized outside the class
	}
	public  static  KidTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		KidTokens tokens = new KidTokens(options);
		return tokens;

	}
	protected KidTokens(Map<String,Object> options){
		this.options = options;
	}

	public KidTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}

	public static KidTokens mergeAll(String [] tokens){

		return allTokens().merge(tokens);
	}

	protected KidTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}




	public static KidTokens start(){
		return new KidTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}

	public KidTokens withTokenFromListName(String listName){
		addSimpleOptions(listName);
		return this;
	}

  public static KidTokens loadGroupTokens(String... groupNames){
    KidTokens tokens = start();
    if (groupNames == null || groupNames.length == 0){
      return allTokens();
    }
    addToken(tokens, FAMILY, groupNames, new String[]{"default"});

  
    return tokens;
  }

  private static void addToken(KidTokens pTokens, String pTokenName, String[] pGroupNames, String[] fieldGroups) {
    if (pGroupNames == null || fieldGroups == null){
      return;
    }

    for (String groupName: pGroupNames){
      for(String g: fieldGroups){
        if( Objects.equals(groupName, g)){
          pTokens.addSimpleOptions(pTokenName);
          break;
        }
      }
    }
  }

	public static KidTokens filterWithTokenViewGroups(String []viewGroups){

		return start()
			.withFamily();

	}

	public static KidTokens allTokens(){

		return start()
			.withFamily();

	}
	public static KidTokens withoutListsTokens(){

		return start()
			.withFamily();

	}

	public static Map <String,Object> all(){
		return allTokens().done();
	}
	public static Map <String,Object> withoutLists(){
		return withoutListsTokens().done();
	}
	public static Map <String,Object> empty(){
		return start().done();
	}

	public KidTokens analyzeAllLists(){
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String FAMILY = "family";
	public String getFamily(){
		return FAMILY;
	}
	//
	public KidTokens withFamily(){
		addSimpleOptions(FAMILY);
		return this;
	}

	public FamilyTokens withFamilyTokens(){
		//addSimpleOptions(FAMILY);
		return FamilyTokens.start();
	}

	

	public  KidTokens searchEntireObjectText(String verb, String value){
	
		return this;
	}
}

