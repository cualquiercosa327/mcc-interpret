package minusk.interp.parse.tree.statements;

import minusk.interp.parse.tree.Serializable;
import minusk.interp.parse.tree.partial.Expression;
import minusk.interp.parse.tree.partial.FuncBody;
import minusk.interp.parse.tree.partial.TypeDef;

/**
 * Created by MinusKelvin on 12/5/15.
 */
public class Declaration extends Serializable {
	public String name;
	public Expression init;
	public TypeDef type;
	public FuncBody func;
	public boolean isConst;
	
	@Override
	public java.lang.String toString() {
		if (func != null)
			return "decl:{const:"+isConst+",type:"+type+",name:"+name+",funcValue:"+func+"}";
		return "decl:{const:"+isConst+",type:"+type+",name:"+name+",init:"+init+"}";
	}
	
	public java.lang.String serialize(java.lang.String indent) {
		if (func != null)
			return "decl:{\n"+
					indent+"\tconst:"+isConst+",\n" +
					indent+"\ttype:"+type.serialize(indent+"\t")+",\n" +
					indent+"\tname:"+name+",\n" +
					indent+"\tfuncValue:"+func.serialize(indent+"\t")+"\n"+
					indent+"}";
		return "decl:{\n"+
				indent+"\tconst:"+isConst+",\n" +
				indent+"\ttype:"+type.serialize(indent+"\t")+",\n" +
				indent+"\tname:"+name+",\n" +
				indent+"\tinit:"+serial(init,indent+"\t")+"\n"+
				indent+"}";
	}
}
