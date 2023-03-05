class SqueakyClean {
    static String clean(String identifier) {
        String res = identifier;

        char[] chars = res.toCharArray();
        for(int i=0; i<chars.length; i++){
            if(Character.isWhitespace(chars[i]) && !Character.isISOControl(chars[i])){
                String charstr = "" + chars[i];
                res = res.replace(charstr,"_");
            }
            }
        
        char[] chars2 = res.toCharArray();
        for(int i=0; i<chars2.length; i++){
            if(Character.isISOControl(chars2[i]) ){
                String charstr = "" + chars2[i];
                res = res.replace(charstr,"CTRL");
            }
            }

        if(res.contains("-")){
        String[] words = res.split("-");
        String camelCase= words[0];
        for(int i=1; i<words.length; i++){
        camelCase += words[i].substring(0,1).toUpperCase() + words[i].substring(1);
        }
        res = camelCase;
        }
        
        char[] chars3 = res.toCharArray();
        for(int i=0; i<chars3.length; i++){
            if(!Character.isLetter(chars3[i]) && chars3[i] != '_'){
                String charstr = "" + chars3[i];
                res = res.replace(charstr,"");
            }
            }

        
        res = res.replaceAll("[α-ω]","");

        return res;
    }  
}
