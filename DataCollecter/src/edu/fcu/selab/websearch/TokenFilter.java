package edu.fcu.selab.websearch;



public class TokenFilter {
	static final String SymbolSet = "~!@#$%^&*()_+{}|:<>?/.,';[]-`=\"\\";
	static final String NumberSet = "0123456789";
	static final String AlphabetSet = "abcdefghijklmnopqrstuvwxyz";
	
	protected static boolean containsSymbol(String token){
		for(int i=0; i< SymbolSet.length(); i++){
			for(int j=0; j< token.length(); j++){
				if(SymbolSet.regionMatches(i, token, j, 1)){
					return true;
				}
			}
		}
		return false;
	}
	
	protected static boolean containsNumber(String token){
		for(int i=0; i< NumberSet.length(); i++){
			for(int j=0; j< token.length(); j++){
				if(NumberSet.regionMatches(i, token, j, 1)){
					return true;
				}
			}
		}
		return false;		
	}
	
	protected static boolean isAnEnglishWord(String token){
		boolean illegal;
		for(int i=0; i< token.length(); i++){
			illegal = true;
			for(int j=0; j< AlphabetSet.length(); j++){
				if(token.regionMatches(i, AlphabetSet, j, 1)){
					illegal = false;
					break;
				}		
			}
			if(illegal) return false;
		}
		return true;		
	}
	
//	public static void main(String[] args){
//		System.out.println(TokenFilter.isAnEnglishWord("iadfggh"));
//		
//	}
}
